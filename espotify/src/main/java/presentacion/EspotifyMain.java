package presentacion;

import com.jtattoo.plaf.smart.SmartLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class EspotifyMain {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new SmartLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(EspotifyMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        FormPrin fp = new FormPrin();
        fp.setVisible(true);
    }
}
