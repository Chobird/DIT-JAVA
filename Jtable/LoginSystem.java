import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class LoginSystem {
    public static void main(String[] args) {
        // 데이터베이스 연결 정보
        String url = "jdbc:mysql://localhost:3306/db";
        String user = "root";
        String password = "1234";

        // JTable 생성
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("아이디");
        model.addColumn("비밀번호");
        model.addColumn("이름");
        JTable table = new JTable(model);

        // 데이터베이스에서 데이터 가져와 JTable에 채우기
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // SQL 구문 수정 (users 테이블에서 usersname, password, name 컬럼 선택)
            String sql = "SELECT usersname, password, name FROM users";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String usersname = rs.getString("usersname");
                String dbPassword = rs.getString("password");
                String name = rs.getString("name");
                model.addRow(new Object[]{usersname, dbPassword, name});
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // JFrame 생성 및 설정
        JFrame frame = new JFrame("계정 정보");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}