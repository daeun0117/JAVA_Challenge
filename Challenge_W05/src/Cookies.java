import java.util.Random;

public class Cookies extends GameObject {
    private int moveCount = 0;

    public Cookies(int startX, int startY, int distance) {

        super(startX, startY, distance);
    }

    @Override
    protected void move() {
        moveCount++;
        // 입력 횟수가 3의 배수인 경우 쿠키 랜덤으로 1칸 이동
        if (moveCount == 3) {
            while (true) {
                int direction = (int) (Math.random() * 4);
                int check = 0;

                switch (direction) {
                    case 0:
                        if (x - 1 > 0) {
                            x--;
                            check = 1;
                        }
                        break;
                    case 1:
                        if (y - 1 > 0) {
                            y--;
                            check = 1;
                        }
                        break;
                    case 2:
                        if (x + 1 < 9) {
                            x++;
                            check = 1;
                        }
                        break;
                    case 3:
                        if (y + 1 < 19) {
                            y++;
                            check = 1;
                        }
                        break;
                    default:
                        break;
                }
                if (check == 1) break;
            }
            distance = x + 10 * y;
            moveCount = 0;
        }
    }

    @Override
    protected char getShape() {
        return '●';
    }
}
