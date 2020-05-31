package State;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

public abstract class StatusType {
    protected Status status;
    protected char effect; //N->None / D->Damage / M->Movement
    protected String name;
    protected int duration;
    
    public StatusType(Status status) {
        this.status=status;
    }
    
    public String getName() {
        return name;
        
    }
    
    public char getEffect() {
        return effect;
        
    }
    
}
