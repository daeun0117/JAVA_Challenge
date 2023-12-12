import java.util.Scanner;

public class PacMan extends GameObject{
    private Scanner scan = new Scanner(System.in);

    public PacMan(int startX, int startY, int distance) {
        super(startX, startY, distance);
    }

    @Override
    protected void move() {
        System.out.print("왼쪽(a),위(w),아래(s),오른쪽(d) >> ");
        String direction = scan.next();

        switch (direction) {
            case "a":
                if (y > 0)
                    y--;
                break;
            case "w":
                if (x > 0)
                    x--;
                break;
            case "s":
                if (x < 9)
                    x++;
                break;
            case "d":
                if (y < 19)
                    y++;
                break;
            default:
                System.out.println("값을 다시 입력해 주세요");
                break;
        }distance = x + 10*y; //일단 작성
    }

    @Override
    protected char getShape() {
        return 'C';
    }
}
