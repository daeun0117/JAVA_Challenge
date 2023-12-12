import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    private JButton[] btn;
    public CenterPanel() {
        setLayout(new GridLayout(4, 4));

        String[] btn_la = {
                "0", "1", "2", "3",
                "4", "5", "6", "7",
                "8", "9", "CE", "계산",
                "+", "-", "x", "/"
        };

        btn = new JButton[16];
        for (int i = 0; i < 16; i++) {
            btn[i] = new JButton(btn_la[i]);
            add(btn[i]);

            if (i >= 12) {
                btn[i].setBackground(Color.YELLOW);
            }
        }
    }
}
