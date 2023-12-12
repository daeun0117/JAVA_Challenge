import java.io.*;
import java.util.*;

public class Week_13 {
    private String fileName = "C:\\Temp\\phone.txt";
    private HashMap<String, String> phoneMap = new HashMap<String, String>();

    public Week_13() {}

    private void readPhoneFile() {
        try {
            Scanner fileScanner = new Scanner(new FileReader(new File(fileName)));
            while (fileScanner.hasNextLine()) {
                String nextLine = fileScanner.nextLine();
                String[] split = nextLine.split("\\s+", 2);
                if (split.length >= 2) {
                    String name = split[0];
                    String number = split[1];
                    phoneMap.put(name, number);
                }
            }
            fileScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("총 " + phoneMap.size() + "개의 전화번호를 읽었습니다.");
    }

    private void processQuery() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("이름>>");
            String name = scanner.nextLine();

            if (name.equals("그만")) {
                break;
            }

            String phoneNumber = phoneMap.get(name);

            if (phoneNumber != null) {
                System.out.println(phoneNumber);
            } else {
                System.out.println("찾는 이름이 없습니다.");
            }
        }
    }

    public void run() {
        readPhoneFile();
        processQuery();
    }
    public static void main(String[] args) {
        Week_13 phoneExplorer = new Week_13();
        phoneExplorer.run();
    }
}