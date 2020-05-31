package State;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

public class CoronavirusStatus extends StatusType {
   
    
    public CoronavirusStatus(Status status) {
        super (status);
        this.effect='D';
        this.name="infectado por coronavirus";
        this.duration=100;
    }
    
}
