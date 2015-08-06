package ladaspacequest.ladaspacequest;

import javax.swing.SwingUtilities;
import kuviot.Lada;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }

}
