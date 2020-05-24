package model.enemy;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

import java.util.List;
import model.Attribute;

public abstract class Dragon extends Enemy{

    public Dragon(List<Attribute> attributes) {
        this.name = "Dragon";
        this.attributes = attributes;
    }
    
}
