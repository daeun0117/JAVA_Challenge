import java.sql.*;

public class Week_14 {
    public static void main(String[] args) {
        Connection conn;
        Statement stmt = null;

        try {
            // MySQL 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            // JDBC 연결
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daeun", "root", "7441");
            System.out.println("DB 연결 완료");
            stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성

            //테이블이 없는 경우 테이블 생성을 위한 SQL 명령어
            String createTableSQL = "CREATE TABLE IF NOT EXISTS book ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "title VARCHAR(255) NOT NULL,"
                    + "publisher VARCHAR(255) NOT NULL,"
                    + "author VARCHAR(255) NOT NULL)";
            stmt.executeUpdate(createTableSQL);

            // 데이터 삽입
            //stmt.executeUpdate("DELETE FROM book;"); // 코드 제대로 들어가지 않은 경우 삭제하고 다시 데이터 넣기 위한 명령어
            stmt.executeUpdate("INSERT INTO book(id,title, publisher, author) values (1, 'Harry Potter', 'Bloomsbury', 'J.K. Rowling');");
            stmt.executeUpdate("INSERT INTO book(id,title, publisher, author) values (2, 'The Lord of the Rings', 'Allen & Unwin', 'J. R. R. Tolkien');");
            stmt.executeUpdate("INSERT INTO book(id,title, publisher, author) values (3, 'Pride and Prejudice', 'T.Egerton kingdom', 'Jane Austen');");
            //'Pride & Prejudice' 가 제목인 책의 update 구문
            stmt.executeUpdate("UPDATE book\n"
                    + "SET title = 'Pride & Prejudice', author = '제인 오스틴'\n"
                    + "WHERE title = 'Pride and Prejudice';");


            printTable(stmt);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 에러");
        } catch (SQLException e) {
            //실행 중 오류가 나서 무엇이 잘못되었는지 확인을 위해 e.getMessage()를 넣음.
            System.out.println("SQL 실행 에러" + e.getMessage() );
        }
    }

    // 레코드의 각 열의 값 화면에 출력
    private static void printTable(Statement stmt) {
        ResultSet srs;
        System.out.printf("%4s|%-30s|%-30s|%-10s\n", "id", "title", "publisher", "author");
        try {
            srs = stmt.executeQuery("SELECT * FROM book");
            while (srs.next()) {
                System.out.printf("%4s|%-30s|%-30s|%-10s\n", srs.getString("id"), srs.getString("title"), srs.getString("publisher"), srs.getString("author"));
            }
        } catch (SQLException e) {
            System.out.println("SQL 실행 에러");
        }
    }
}