package com.datastructurediagrammer.linkedlists;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import java.awt.Color;

public class DoublyLinkedListDiagrammer extends SinglyLinkedListDiagrammer {

    private static <T extends Comparable<T>> void drawPreviousPointer(Graphics2D graphics,
            int imageWidth, int i, int nodeHeight, int margin) {

        graphics.setColor(Color.BLUE);

        int x1, x2, y1, y2;

        x1 = (imageWidth / 4) * 3;
        x2 = x1;

        y1 = ((i - 1) * nodeHeight + margin) + graphics.getFontMetrics().getHeight();
        y2 = y1 + 13;

        graphics.drawLine(x1, y1, x2, y2);

        // Puts the arrow on the other vertical end when drawing prev ptr
        int[] arrowXPoints = { x1 - 2, x1, x1 + 2 };
        int[] arrowYPoints = { y1 + 2, y1, y1 + 2 };
        graphics.drawPolygon(arrowXPoints, arrowYPoints, 3);

    }

    public static <T extends Comparable<T>> void renderDiagram(DoublyLinkedList<T> list, String filepath) {
        final int imageWidth = 90;
        final int nodeHeight = 30;
        int imageHeight = list.getLength() * nodeHeight;

        BufferedImage bufferedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);

        // Graphics object could be thought of as our pen.
        // the BufferedImage has a getGraphics() method returning a Graphics object, we
        // cast it to be a Graphics2D object.
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();

        // Set color to white, and fill the image background.
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, imageWidth, imageHeight);

        // Margin is used between different things. eg. there is a margin
        // between the text and the top and bottom of the rectangle
        int margin = 2;

        // Width of a digit - varies wildly, but we will use a wider digit for this
        // purpose.
        int digitWidth = graphics.getFontMetrics().charWidth('0');

        int stringWidth;

        DLLNode<T> currentNode = list.head;

        for (int i = 0; i < list.getLength(); ++i) {
            graphics.setColor(Color.black);

            String dataString = currentNode.getData().toString();// listArr.get(i).toString();

            stringWidth = dataString.length();

            graphics.drawRect(imageWidth / 5, i * nodeHeight + margin, (imageWidth / 5) * 3,
                    graphics.getFontMetrics().getHeight() + 2 * margin);
            graphics.drawString(dataString, imageWidth / 2 - stringWidth * digitWidth / 2,
                    (nodeHeight * i) + graphics.getFontMetrics().getHeight());

            if (currentNode.next != null) {
                drawNextPointer(graphics, imageWidth, i, nodeHeight, margin);
            }
            
            if (currentNode.previous != null) {
                drawPreviousPointer(graphics, imageWidth, i, nodeHeight, margin);
            }
            // Continue traversal, to next node which needs to be drawn.
            currentNode = currentNode.next;
        }

        // Close graphics object, similar to closing a scanner
        graphics.dispose();

        // Construct the file object
        File returnFile = new File(filepath);

        try {
            // ImageIO has a write() method to write a BufferedImage to png format
            ImageIO.write(bufferedImage, "png", returnFile);
        } catch (IOException e) {
            System.out.println("Had an issue writing buffered image to file!");
            e.printStackTrace();
        }
    }

}
