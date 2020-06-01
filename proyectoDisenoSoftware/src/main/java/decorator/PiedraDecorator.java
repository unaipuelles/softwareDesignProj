package decorator;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */
public class PiedraDecorator extends Decorator{
    
    public PiedraDecorator(MessageDecoratorAttack mda) {
        super(mda);
    }
    
    protected String grande() {
        return " bastante grande";
    }
    
    @Override
    public String getName() {
        return mda.getName();
    }
    
    @Override
    public String getAttackMessage() {
        return getName() + grande();
    } 
}
