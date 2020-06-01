package decorator;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */
public class DedoDecorator extends Decorator{
    
    public DedoDecorator(MessageDecoratorAttack mda) {
        super(mda);
    }
    
    protected String conFuerza() {
        return " con fuerza";
    }
    
    @Override
    public String getName() {
        return mda.getName();
    }
    
    @Override
    public String getAttackMessage() {
        return getName() + conFuerza();
    } 
}