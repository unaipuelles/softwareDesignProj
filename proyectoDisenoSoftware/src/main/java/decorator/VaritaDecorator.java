package decorator;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */
public class VaritaDecorator extends Decorator{
    
    public VaritaDecorator(MessageDecoratorAttack mda) {
        super(mda);
    }
    
    protected String conOjo() {
        return " y clavarsela en el ojo";
    }
    
    @Override
    public String getName() {
        return mda.getName();
    }
    
    @Override
    public String getAttackMessage() {
        return getName() + conOjo();
    } 
}
