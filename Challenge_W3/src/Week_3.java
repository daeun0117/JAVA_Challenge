import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Week_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 로또 번호 입력 받기
        int[] userNumbers = getUserPicks(scanner);
        Arrays.sort(userNumbers);

        // 랜덤으로 로또 당첨 번호 생성
        int[] winningNumbers = generateLottoNumbers();
        Arrays.sort(winningNumbers);

        // 당첨 여부 확인
        int matchedCount = countMatchedNumbers(userNumbers, winningNumbers);
        displayResult(userNumbers, winningNumbers, matchedCount);

        scanner.close();
    }

    // 사용자로부터 로또 번호 입력 받는 메소드
    public static int[] getUserPicks(Scanner scanner) {
        int[] userPicks = new int[6];

        for (int i = 0; i < 6; i++) {
            System.out.print("로또 번호 6개를 입력하세요 (1부터 45 사이의 숫자, 중복 없이):");
            int pick = scanner.nextInt();

            // 중복 체크 및 유효성 검사
            if (isInvalidPick(pick) || containsNumber(userPicks, pick)) {
                System.out.println("이미 입력한 번호입니다. 중복 없이 입력하세요");
                i--;
                continue;
            }

            userPicks[i] = pick;
        }

        return userPicks;
    }

    // 로또 당첨 번호를 랜덤으로 생성하는 메소드
    public static int[] generateLottoNumbers() {
        int[] numbers = new int[6];
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int num;
            do {
                num = random.nextInt(45) + 1;
            } while (containsNumber(numbers, num));

            numbers[i] = num;
        }

        return numbers;
    }

    // 로또 번호의 유효성을 검사하는 메소드
    public static boolean isInvalidPick(int pick) {
        return pick < 1 || pick > 45;
    }

    // 배열에 특정 숫자가 포함되어 있는지 확인하는 메소드
    public static boolean containsNumber(int[] array, int number) {
        for (int num : array) {
            if (num == number) {
                return true;
            }
        }

        return false;
    }

    // 당첨 번호와 사용자 번호를 비교하여 일치하는 숫자 개수를 반환하는 메소드
    public static int countMatchedNumbers(int[] userPicks, int[] winningNumbers) {
        int count = 0;

        for (int userPick : userPicks) {
            for (int winningNumber : winningNumbers) {
                if (userPick == winningNumber) {
                    count++;
                }
            }
        }

        return count;
    }

    // 결과를 출력하는 메소드
    public static void displayResult(int[] userPicks, int[] winningNumbers, int matchedCount) {
        System.out.println("당첨 번호: " + Arrays.toString(winningNumbers));
        System.out.println("사용자 번호: " + Arrays.toString(userPicks));

        // 당첨 등수에 따라 메시지 출력
        switch (matchedCount) {
            case 6:
                System.out.println("축하합니다! 1등입니다!");
                break;
            case 5:
                System.out.println("축하합니다! 2등입니다!");
                break;
            case 4:
                System.out.println("축하합니다! 3등입니다!");
                break;
            case 3:
                System.out.println("축하합니다! 4등입니다!");
                break;
            default:
                System.out.println("아쉽지만 꽝입니다. 맞춘 번호의 개수: " + matchedCount);
        }
    }
}
