package com.georgiancollege.ryanclements.comp3026.lesson1.ex1;

import javax.swing.*;
import java.awt.*;

public class JPanelSurface extends JPanel {
    private FlawedFence flawedFence;

    JPanelSurface(FlawedFence flawedFence) {
        this.flawedFence = flawedFence;
    }
    private void drawFence(Graphics g)
    {
        int start_x = 25;
        int start_y = 25;
        int x = start_x;
        int y = start_y;
        int legend_ref_x = 150;
        int legend_ref_y = 90;

        int fenceSectionReferenceNumber;

        Graphics2D g2d = (Graphics2D) g;
        // Draw the fence posts
        for (int i=0;i<=flawedFence.fencePosts.length-1;i++) {
            FencePost fp = flawedFence.fencePosts[i];
            if (fp == null)
                continue;
            g2d.setPaint(fp.getColor());
            g2d.fillOval(x, y, fp.getRadius(), fp.getRadius());
            g2d.setColor(Color.BLACK);
            g2d.drawString("" + (i+1), x + fp.getRadius()/2-4, y + fp.getRadius()/2+3);
            if (i>=flawedFence.fenceSections.length) {
                fenceSectionReferenceNumber = flawedFence.fenceSections.length-1;
            }
            else {
                fenceSectionReferenceNumber = i;
            }
            x += fp.getRadius() + flawedFence.fenceSections[fenceSectionReferenceNumber].getWidth();
        }
        x = start_x + flawedFence.fencePosts[0].getRadius();
        y = start_y + flawedFence.fencePosts[0].getRadius()/2;

        // Draw the fence sections (between posts)
        for (int i=0;i<=flawedFence.fenceSections.length-1;i++) {
            FenceSection fs = flawedFence.fenceSections[i];
            if (fs == null)
                continue;
            g2d.setPaint(fs.getColor());
            g2d.fillRect(x, y - flawedFence.fenceSections[0].getHeight()/2, fs.getWidth(), fs.getHeight());
            x += fs.getWidth() + flawedFence.fencePosts[i].getRadius();
        }

        // Use the first post and first section as the legend's object to draw
        FenceSection firstSection = flawedFence.fenceSections[0];
        FencePost firstPost = flawedFence.fencePosts[0];

        // Draw the legend
        g2d.setColor(firstSection.getColor());
        g2d.fillRect(legend_ref_x - firstSection.getWidth(), legend_ref_y, firstSection.getWidth(), firstSection.getHeight());
        g2d.setColor(Color.BLACK);
        g2d.drawString("= Fence Section", legend_ref_x + 20, legend_ref_y + firstSection.getHeight());

        g2d.setColor(firstPost.getColor());
        g2d.fillOval(legend_ref_x - firstPost.getRadius(), legend_ref_y + firstSection.getHeight()*2, firstPost.getRadius(), firstPost.getRadius());
        g2d.setColor(Color.BLACK);
        g2d.drawString("= Fence Post", legend_ref_x + 20, legend_ref_y + firstSection.getHeight()*2 + firstPost.getRadius()/2);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFence(g);
    }
}
