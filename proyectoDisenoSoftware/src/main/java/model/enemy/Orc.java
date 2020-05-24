package model.enemy;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

import model.enemy.Enemy;
import java.util.List;
import model.Attribute;

public abstract class Orc extends Enemy{

    public Orc(List<Attribute> attributes) {
        this.name = "Orco";
        this.attributes = attributes;
    }
    
}
