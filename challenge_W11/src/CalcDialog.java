import javax.swing.*;
import java.awt.*;

public class CalcDialog extends JDialog{
    private int sum= 0;
    private boolean valid=false;
    private JTextField a = new JTextField(10);
    private JTextField b = new JTextField(10);
    private JButton mulBtn = new JButton("Multiply");

    public CalcDialog(JFrame f) {
        super(f, "Calculation Dialog", true);
        setLayout(new BorderLayout());

        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JLabel sub_title=new JLabel("두 수를 곱합니다.", SwingConstants.CENTER);
        panel.add(sub_title);

        JPanel number1=new JPanel(new FlowLayout(FlowLayout.CENTER));
        number1.add(a);
        panel.add(number1);

        JPanel number2=new JPanel(new FlowLayout(FlowLayout.CENTER));
        number2.add(b);
        panel.add(number2);

        JPanel sub_button = new JPanel(new FlowLayout(FlowLayout.CENTER));
        sub_button.add(mulBtn);
        panel.add(sub_button);

        add(panel, BorderLayout.CENTER);
        add(sub_title, BorderLayout.NORTH);

        mulBtn.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(a.getText());
                int num2 = Integer.parseInt(b.getText());
                sum = num1 * num2;
                valid = true;
            } catch (Exception ex) {
                valid = false;
            }
            setVisible(false);
        });
            setSize(200, 200);
        }
        public boolean isValid() {
            return valid;
        }
        public int getResult() {
            return sum;
        }

    public static void main(String[] arg) {
        new Week_11();
    }
}
