package com.paratussoftware.apollo.views;

import javax.swing.*;
import java.awt.*;

public class ApolloMainView extends JFrame {

    private final FrequencyPanel frequencyPanel;

    public ApolloMainView() {
        super("Apollo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1024, 500));
        setLayout(new FlowLayout());
        this.frequencyPanel = new FrequencyPanel();
        add(this.frequencyPanel);
    }

    public void drawPitch(final int pitch) {
        this.frequencyPanel.drawFrequency(pitch);
    }

    private class FrequencyPanel extends JPanel {
        FrequencyPanel() {
            this.setPreferredSize(new Dimension(1000, 400));
        }

        public void drawFrequency(final int pitch) {
            final Graphics graphics = this.getGraphics();
            this.paint(graphics);
            graphics.setColor(Color.MAGENTA);
            graphics.drawLine(pitch, 0, pitch, this.getHeight());
        }

        @Override
        public void paint(final Graphics g) {
            g.setColor(Color.WHITE);
            final int height = this.getHeight() - 1;
            final int width = this.getWidth() - 1;
            g.fillRect(0, 0, width, height);
            g.setColor(Color.BLACK);
            g.drawRect(0, 0, width, height);
            drawLines(g);
        }

        private void drawLines(final Graphics g) {
            g.setColor(Color.RED);
            for (int x = 0; x < 1000; x += 100) {
                if (x % 100 == 0) {
                    g.drawLine(x, 0, x, this.getHeight());
                    g.drawString(Integer.toString(x), x + 2, 15);
                }
            }
        }
    }
}
