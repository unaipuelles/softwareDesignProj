package factory;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

import java.util.ArrayList;
import java.util.List;

import decorator.Attack;
import model.Attribute;

public abstract class Dragon extends Enemy{

    public Dragon(List<Attribute> attributes) {
        this.name = "Dragon";
        this.attributes = attributes;
        this.attacks = getAttacksDefault();
    }
    
    public List<Attack> getAttacksDefault() {
        List<Attack> ataques = new ArrayList();
        ataques.add(new Attack("Esupir fuego", 20));
        ataques.add(new Attack("Zarpazo", 10));
        ataques.add(new Attack("Golpear con la cola", 4));
        ataques.add(new Attack("Batir las alas", 2));
        
        return ataques;
    }
}
