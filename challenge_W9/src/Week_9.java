import javax.swing.*;
import java.awt.*;


public class Week_9 extends JFrame {
    public Week_9() {
        setTitle("계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        add(new NorthPanel(), BorderLayout.NORTH);
        add(new CenterPanel(), BorderLayout.CENTER);
        add(new SouthPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Week_9();
    }
}


