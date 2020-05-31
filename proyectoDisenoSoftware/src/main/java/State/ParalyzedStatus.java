package State;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

public class ParalyzedStatus extends StatusType{
    
    public ParalyzedStatus(Status status) {
        super (status);
        this.effect='M';
        this.name="paralizado";
        this.duration=3;
       
    }    
    
}
