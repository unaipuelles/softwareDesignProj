package model;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

public class Attack {
    private String name;
    private int damage;

    public Attack(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
