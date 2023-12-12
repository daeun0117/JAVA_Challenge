import javax.swing.*;
import java.awt.*;

public class NorthPanel extends JPanel {
    private JTextField text;
    public NorthPanel() {
        setLayout(new BorderLayout());

        JLabel inputLabel = new JLabel("수식 입력", SwingConstants.LEFT);
        add(inputLabel, BorderLayout.WEST);

        text = new JTextField(20);
        text.setEditable(false);
        text.setBackground(Color.WHITE); // Set background color to white
        add(text, BorderLayout.CENTER);
    }
}
