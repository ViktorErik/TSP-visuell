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

        if (Main.attemptedPath[Main.attemptedPath.length-1] == null || Main.bestPath[Main.bestPath.length-1] == null) return;

        g2d.setColor(Color.RED);
        for (int i = 0; i < Main.NUMOFNODES - 1; i++) {
            
            g2d.drawLine(
                Main.attemptedPath[i].x + NODERADIUS, Main.attemptedPath[i].y + NODERADIUS, 
                Main.attemptedPath[i+1].x + NODERADIUS, Main.attemptedPath[i+1].y + NODERADIUS
            ); 
             
        }

        g2d.setColor(Color.GREEN);
        for (int i = 0; i < Main.NUMOFNODES - 1; i++) {
            g2d.drawLine(
                Main.bestPath[i].x + NODERADIUS, Main.bestPath[i].y + NODERADIUS, 
                Main.bestPath[i+1].x + NODERADIUS, Main.bestPath[i+1].y + NODERADIUS
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
         
        /* 
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        */
    }
} 