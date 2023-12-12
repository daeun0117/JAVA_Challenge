    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.*;

public class Week_11 extends JFrame {
    private JLabel resultLabel = new JLabel("계산 결과 출력");
    public Week_11() {
        super("다이얼로그 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        c.setLayout(new FlowLayout());
        JButton btn = new JButton("calculate");
        btn.addActionListener(new MyActionListener());
        c.add(btn);

        resultLabel.setOpaque(true);
        resultLabel.setBackground(Color.WHITE);
        c.add(resultLabel);

        setSize(250, 200);
        setVisible(true);
    }
    class MyActionListener implements ActionListener {
        private CalcDialog calc;
        public MyActionListener() {

            calc = new CalcDialog(Week_11.this);
        }

        public void actionPerformed(ActionEvent e) {
            calc.setVisible(true);
            if (calc.isValid()) {
                resultLabel.setText(Integer.toString(calc.getResult()));
            } else {
                resultLabel.setText("옳바르지 않은 형식입니다.");
            }
        }
    }
}

