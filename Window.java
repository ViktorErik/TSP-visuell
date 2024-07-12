import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;

class Window extends JFrame {
    static int WIDTH = 600;
    static int HEIGHT = 600;
    Window() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new DimensionUIResource(WIDTH, HEIGHT));

        // this.getContentPane().setBackground(new Color(0, 0, 0, 255)); // rgba
        // draw = new Draw();
        // this.add(draw);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
     }
}
