package decorator;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */
public class MangoDecorator extends Decorator{
    
    public MangoDecorator(MessageDecoratorAttack mda) {
        super(mda);
    }
    
    protected String conMangoDeOro() {
        return " de oro";
    }
    
    @Override
    public String getName() {
        return mda.getName();
    }
    
    @Override
    public String getAttackMessage() {
        return getName() + conMangoDeOro();
    } 
}
