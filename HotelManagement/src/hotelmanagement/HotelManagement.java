package hotelmanagement;
import java.sql.SQLException;
import javax.swing.SwingUtilities;
import ui.Main;

public class HotelManagement {

public static void main(String[] args) throws SQLException {
    SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    
    
    }
    
}
