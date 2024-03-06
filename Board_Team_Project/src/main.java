import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        Board_impl boardImpl = new Board_impl();
        boardImpl.list();

    }

}
