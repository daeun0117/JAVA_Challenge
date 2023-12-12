import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class week_6 extends JFrame implements ActionListener {

    private JTextField inputField;
    private JButton[] buttons;
    private JLabel resultLabel;
    private JTextField outputField;

    public week_6() {
        setTitle("계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        // Panel for "수식입력" label and input field (top)
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        JLabel inputLabel= new JLabel("수식 입력", SwingConstants.LEFT);
        topPanel.add(inputLabel, BorderLayout.WEST);

        inputField = new JTextField(20);
        inputField.setEditable(false);
        inputField.setBackground(Color.WHITE); // Set background color to white
        topPanel.add(inputField, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        // Panel for buttons (center)
        JPanel buttonPanel=new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4)); // 5 rows for buttons

        String[] buttonLabels= {
                "0", "1", "2", "3",
                "4", "5", "6", "7",
                "8", "9", "CE", "계산",
                "+", "-", "x", "/"
        };

        buttons = new JButton[16];

        for(int i= 0; i< 16; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttonPanel.add(buttons[i]);

            // Change background color for +, -, x, /
            if(i>= 12) {
                buttons[i].setBackground(Color.YELLOW);
            }
        }

        add(buttonPanel, BorderLayout.CENTER);

        // Panel for "결과출력" label and output field (bottom)
        JPanel bottomPanel=new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBackground(Color.BLACK); // Set background color to black

        resultLabel=new JLabel("결과 출력");
        resultLabel.setHorizontalAlignment(SwingConstants.LEFT);
        resultLabel.setForeground(Color.WHITE); // Set text color to white
        bottomPanel.add(resultLabel, BorderLayout.WEST);

        outputField=new JTextField(20);
        outputField.setEditable(false);
        outputField.setBackground(Color.WHITE); // Set background color to white
        bottomPanel.add(outputField, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // You can remove the actionPerformed logic entirely
        // as we are not performing any calculations or actions on button clicks in this version
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new week_6());
    }
}