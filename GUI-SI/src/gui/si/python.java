
package gui.si;
import java.io.IOException;
/**
 *
 * @author ALEX
 */
public class python {
    public void hablar(String texto) throws IOException{
        String direc = "cmd /c python C:\\Users\\LENOVO\\Documents\\hablar.py \""+texto+"\"";
        try {
            Runtime.getRuntime().exec(direc, null);
        } catch (IOException e) {
            System.err.println("Se frego en: "+e);
        }
    }
    
}
