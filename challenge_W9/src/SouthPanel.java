import javax.swing.*;
import java.awt.*;

public class SouthPanel extends JPanel {
    private JLabel output;
    private JTextField under;
    public SouthPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        output = new JLabel("결과 출력");
        output.setHorizontalAlignment(SwingConstants.LEFT);
        output.setForeground(Color.WHITE);
        add(output, BorderLayout.WEST);

        under = new JTextField(20);
        under.setEditable(false);
        under.setBackground(Color.WHITE);
        add(under, BorderLayout.CENTER);
    }

}
