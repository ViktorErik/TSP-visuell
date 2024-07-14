import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;

class Window extends JFrame {
    static int WIDTH = 600;
    static int HEIGHT = 600;
    Window() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new DimensionUIResource(WIDTH, HEIGHT));

        this.setLocationRelativeTo(null);
        this.setVisible(true);
     }
}
