package com.datastructurediagrammer.trees;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BSTDiagrammer {
    public static <T extends Comparable<T>> void draw(Graphics2D graphics, BSTNode<T> node, int x, int y, int increment, int level) { 
        //increment *= 2;
        if (node == null) { 
            return;
        } else {
            draw(graphics, node.left, x - increment - (increment * level), y + (2 * increment), increment, level + 1); // test: replace 2 * increment with increment to reverse
            if (node.left != null ) { 
                //graphics.drawLine(x, y + increment / 2, x - increment / 2 - (increment * level), y + increment);
                graphics.drawLine(x, y + increment / 2, x - increment / 2 - (increment * level), y + (2 * increment));
            }
           
            // draw current bst node
            graphics.setColor(Color.BLACK);
            graphics.drawOval(x, y, increment, increment);
            //graphics.drawRect(x, y, 2, 2);
            graphics.drawString(node.getData().toString(), x + increment / 2, y + increment / 2);;
            
            draw(graphics, node.right, x + increment + (increment * level), y + (2 * increment), increment, level + 1);
            if (node.right != null) { 
                //graphics.drawLine(x + increment, y + increment / 2, x + increment + increment / 2 + (increment * level), y + increment);
                graphics.drawLine(x + increment, y + increment / 2, x + increment + increment / 2 + (increment * level), y + (2 * increment));
            }
        }
    }
    public static <T extends Comparable<T>> void renderDiagram(BinarySearchTree<T> bst, String filepath) { 
        int nodeSquare = 40;
        int imageWidth = (int) Math.pow(2, bst.getHeight()); // Width should be proportional to 2^H
            imageWidth *= nodeSquare;

        int imageHeight = bst.getHeight() * (nodeSquare * 2); 

        BufferedImage bufferedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
    
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();

        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, imageWidth, imageHeight);

        // recursive draw method called on root
        draw(graphics, bst.root, imageWidth / 2, 0, nodeSquare, 0);

        // close graphics object
        graphics.dispose();

        File returnFile = new File(filepath);

        try { 
            ImageIO.write(bufferedImage, "PNG", returnFile);
        } catch (IOException e) { 
            System.out.println("Had an issue writing bufferedImage to file");
            e.printStackTrace();
        }
    }
}
