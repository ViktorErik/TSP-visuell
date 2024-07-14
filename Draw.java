import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

class Draw extends JPanel {
    static int NODERADIUS = 5;
    static String curPath;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2d = (Graphics2D) g;

        setBackground(Color.BLACK);

        g2d.setColor(Color.RED);
        for (int i = 0; i < Main.NUMOFNODES - 1; i++) {
            
                g2d.drawLine(
                    TSP.attemptedPath[i].x + NODERADIUS, TSP.attemptedPath[i].y + NODERADIUS, 
                    TSP.attemptedPath[i+1].x + NODERADIUS, TSP.attemptedPath[i+1].y + NODERADIUS
                );  
        }

        g2d.setColor(Color.GREEN);
        for (int i = 0; i < Main.NUMOFNODES - 1; i++) {
            
                g2d.drawLine(
                    TSP.bestPath[i].x + NODERADIUS, TSP.bestPath[i].y + NODERADIUS, 
                    TSP.bestPath[i+1].x + NODERADIUS, TSP.bestPath[i+1].y + NODERADIUS
                );  
        }
                
        
        g2d.setColor(Color.WHITE);
        for (int i = 0; i < Main.NUMOFNODES; i++) {
            if (i == 0) {
                g2d.setColor(Color.BLUE);
            }
            else {
                g2d.setColor(Color.WHITE);      
            }
            g2d.fillOval(Main.nodes[i].x, Main.nodes[i].y, NODERADIUS*2, NODERADIUS*2);
        
        }
        Main.window.revalidate();
        Main.window.repaint();      
    }
} 