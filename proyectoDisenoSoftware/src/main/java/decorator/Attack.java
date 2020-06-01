package decorator;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */
public class Attack implements MessageDecoratorAttack{
    private final String name;
    private String decoratedName;
    private int damage;

    public Attack(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    public void setDecoratedName(String decoratedName) {
        this.decoratedName = decoratedName;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getAttackMessage() {
        String message;
        if(decoratedName != null)
            message = decoratedName;
        else
            message = name;
        return message;
    }
}
