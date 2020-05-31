package State;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

public class BurnedStatus extends StatusType {
    
    public BurnedStatus(Status status) {
        super (status);
        this.effect='D';
        this.name="quemado";
        this.duration=5;
    }
    
}