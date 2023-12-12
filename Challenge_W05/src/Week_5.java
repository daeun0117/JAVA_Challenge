import java.util.Random;

public class Week_5 {
    private char[][] map = new char[10][20];
    private PacMan pacman;
    private Cookies[] cookies = new Cookies[5];
    private int numberOfCookies;
    private int cookiesEaten = 0;

    public static void main(String[] args) {
        Week_5 game = new Week_5();
        game.run();
    }

    public void run() {
        pacman = new PacMan(0, 0, 0);
        numberOfCookies = 0;
        generateCookies();
        System.out.println("**PacMan 게임에 오신 것을 환영합니다**");
        drawMap();

        while (cookiesEaten < numberOfCookies) {
            pacman.move();
            moveCookies();
            drawMap();
        }
        System.out.println("Clear! 모든 쿠키를 먹었습니다!");
    }

    private void generateCookies() {
        for (int i = 0; i < 5; i++) {
            if ((int) (Math.random() * 10) / 2 == 1) continue;

            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 20);

            if ((x == 0 && y == 0) || (map[x][y] == '●')) {
                i--;
                continue;
            }
            cookies[i] = new Cookies(x, y, x + 10 * y);
            numberOfCookies++;
        }
        if (numberOfCookies == 0) generateCookies();
    }

    private void moveCookies() {
        for (Cookies cookie : cookies) {
            if (cookie != null) {
                cookie.move();
                if (cookie.collide(pacman)) {
                    cookiesEaten++;
                    cookie = null;
                    System.out.printf("쿠키 먹기 성공! 남은 쿠키 : %d\n", numberOfCookies - cookiesEaten);
                }
            }
        }
    }

    public void drawMap() {
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 20; k++) {
                map[i][k] = '-';
            }
        }

        map[pacman.getX()][pacman.getY()] = pacman.getShape();
        for (Cookies cookie : cookies) {
            if (cookie != null) {
                int cookieX = cookie.getX();
                int cookieY = cookie.getY();

                if (cookieX >= 0 && cookieX < 20 && cookieY >= 0 && cookieY < 10) {
                    map[cookieX][cookieY] = cookie.getShape();
                } else {
                    //System.out.println("Cookie 좌표가 범위를 벗어났습니다: (" + cookieX + ", " + cookieY + ")");
                }
            } else {
                //dSystem.out.println("Null인 Cookie가 감지되었습니다.");
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 20; k++) {
                System.out.print(map[i][k]);
            }
            System.out.println();
        }
    }
}
