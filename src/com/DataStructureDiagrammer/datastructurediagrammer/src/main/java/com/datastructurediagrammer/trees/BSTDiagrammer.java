package com.datastructurediagrammer.trees;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BSTDiagrammer {
    public static <T extends Comparable<T>> void draw(Graphics2D graphics, BSTNode<T> node, int x, int y, int increment) { 
        if (node == null) { 
            return;
        } else {
            draw(graphics, node.left, x - increment, y + increment, increment);
            if (node.left != null ) { 
                graphics.drawLine(x, y, x - increment, y + increment);
            }
            if (node.right != null) { 
                graphics.drawLine(x, y, x + increment, y + increment);
            }
            // draw current bst node
            graphics.setColor(Color.BLACK);
            graphics.drawOval(x, y, increment, increment);
            graphics.drawString(node.getData().toString(), x + increment / 2, y + increment / 2);;
            draw(graphics, node.right, x + increment, y + increment, increment);
        }
    }
    public static <T extends Comparable<T>> void renderDiagram(BinarySearchTree<T> bst, String filepath) { 
        int nodeSquare = 40;
        int imageWidth = (int) Math.pow((double)2, (double)bst.getHeight()); // Width should be proportional to 2^H
            imageWidth *= nodeSquare;

        int imageHeight = bst.getHeight() * nodeSquare; 

        BufferedImage bufferedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
    
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();

        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, imageWidth, imageHeight);

        // recursive draw method called on root
        draw(graphics, bst.root, imageWidth / 2, 0, nodeSquare);

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
