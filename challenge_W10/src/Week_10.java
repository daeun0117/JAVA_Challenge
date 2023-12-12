import java.awt.*;
import javax.swing.*;

public class Week_10 extends JFrame {
    //private ImageIcon icon = new ImageIcon("산리오.jpg");

    public Week_10() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 450);
        setTitle("그래픽 이미지 연습");
        setLayout(new BorderLayout());

        MyPanel imagePanel = new MyPanel();
        add(imagePanel, BorderLayout.CENTER);

        TitlePanel titlePanel = new TitlePanel();
        add(titlePanel, BorderLayout.SOUTH);

        JLabel under = new JLabel("SANRIO CHARACTER", SwingConstants.CENTER);
        under.setForeground(Color.PINK);
        add(under, BorderLayout.SOUTH);

        setVisible(true);
    }

    class MyPanel extends JPanel {
        private ImageIcon icon = new ImageIcon("C:\\Users\\user\\source\\사진\\스크린샷\\스크린샷 2023-06-10 204426.png");


        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            int imageWidth = icon.getIconWidth() / 4;
            int imageHeight = icon.getIconHeight() / 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    int x = j * imageWidth;
                    int y = i * imageHeight;
                    g.drawImage(icon.getImage(), x, y, imageWidth, imageHeight, this);
                }
            }
        }
    }

    private class TitlePanel extends JPanel {
        public TitlePanel() {
            JLabel titleLabel = new JLabel("Image Grid");
            add(titleLabel);
        }
    }

    public static void main(String[] args) {
        new Week_10();
    }
}
