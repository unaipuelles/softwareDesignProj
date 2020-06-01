package decorator;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */
public class ColaDecorator extends Decorator{
    
    public ColaDecorator(MessageDecoratorAttack mda) {
        super(mda);
    }
    
    protected String conPinchos() {
        return " y pincharle con ella";
    }
    
    @Override
    public String getName() {
        return mda.getName();
    }
    
    @Override
    public String getAttackMessage() {
        return getName() + conPinchos();
    } 
}
