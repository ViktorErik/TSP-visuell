import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

class Draw extends JPanel {
    static int NODERADIUS = 5;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2d = (Graphics2D) g;

        setBackground(Color.BLACK);
        g2d.setColor(Color.WHITE);

        for (int i = 0; i < Main.NUMOFNODES; i++) {
            if (i == 0) {
                g2d.setColor(Color.green);
            }
            else {
                g2d.setColor(Color.WHITE);      
            }
            g2d.fillOval(Main.nodes[i].x, Main.nodes[i].y, NODERADIUS*2, NODERADIUS*2);
        }

        g2d.setColor(Color.RED);
        for (int i = 0; i < Main.NUMOFNODES - 1; i++) {
            
                g2d.drawLine(
                    Main.nodes[i].x + NODERADIUS, Main.nodes[i].y + NODERADIUS, 
                    Main.nodes[i+1].x + NODERADIUS, Main.nodes[i+1].y + NODERADIUS
                );       

        }
        
        // g2d.fillOval(10, 10, NODERADIUS * 2, NODERADIUS * 2);  
    }
} 