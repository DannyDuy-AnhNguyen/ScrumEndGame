import java.sql.*;

public class Delete {
    public static void main(String[] args) {
        String url = "jdbc:mysql://schoolopd.duckdns.org:3308/scrum_escape_game?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "1234";

        System.out.println("🗑️ Verbinding maken om data te verwijderen...");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ Verbonden met de database!");

            try (Statement tableStmt = conn.createStatement();
                 ResultSet tables = tableStmt.executeQuery("SHOW TABLES")) {

                while (tables.next()) {
                    String tableName = tables.getString(1);

                    try (Statement deleteStmt = conn.createStatement()) {
                        int deleted = deleteStmt.executeUpdate("DELETE FROM " + tableName);
                        System.out.println("🗑️  Verwijderd uit " + tableName + ": " + deleted + " rijen.");
                    } catch (SQLException ex) {
                        System.out.println("⚠️  Fout bij verwijderen uit " + tableName);
                        ex.printStackTrace();
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("❌ Verbinden mislukt:");
            e.printStackTrace();
        }
    }
}
