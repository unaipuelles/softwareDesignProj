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
        turns=0;
        
    }
    
    public void newStatus() {
        
        // Si el estado es el standard y se dan las posibilidades
        // Cambiar de estado
        
    }
    
    public char getStatus() {
        
        if(getEffect()=='N' || turns<=type.duration)
        {
            
            incTurn();
            return getEffect();
            
        }
        else
        {
            
            type=new StandardStatus(this);
            return getEffect();
            
        }
        
    }
    
    protected void incTurn() {
        turns++;
    }
    
    public String getName() {
        return type.getName();
       
    }
    
    protected char getEffect() {
        return type.getEffect();
        
    }
    
}
