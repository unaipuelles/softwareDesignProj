package State;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

public class StandardStatus extends StatusType{
    
    public StandardStatus(Status status) {
        super (status);
        this.effect='N';
        this.name="normal";
        this.duration=-1;
       
    }

}