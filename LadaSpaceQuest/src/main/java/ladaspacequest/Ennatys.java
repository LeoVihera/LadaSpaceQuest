

package ladaspacequest;

/**
 * Luokka jota käytetään ennätys-luvun säilyttämiseen
 * @author Leo
 */
public class Ennatys {
    private int ennatys;
    
    public Ennatys(int ennatys){
        this.ennatys = ennatys;
    }
    
    public int getEnnatys(){
        return this.ennatys;
    }
    
    public void setEnnatys(int uusi){
        this.ennatys = uusi;
    }
}
