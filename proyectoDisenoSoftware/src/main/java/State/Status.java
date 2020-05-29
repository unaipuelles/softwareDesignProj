package State;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

public class Status {
   protected int turns;
   protected StatusType type;
    
    public Status() {
        type = new StandardStatus(this);
        
    }
}
