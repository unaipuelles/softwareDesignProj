package decorator;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */
public abstract class Decorator implements MessageDecoratorAttack{
    
    protected MessageDecoratorAttack mda;
    
    public Decorator(MessageDecoratorAttack mda) {
        this.mda = mda;
    }
    
    @Override
    public String getName() {
        return mda.getName();
    }
    
    @Override
    public String getAttackMessage() {
        return mda.getAttackMessage();
    } 
}
