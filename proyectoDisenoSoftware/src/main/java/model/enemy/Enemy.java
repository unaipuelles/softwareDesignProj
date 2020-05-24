package model.enemy;
/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

import java.util.ArrayList;
import java.util.List;
import model.Attribute;
import model.Status;

public abstract class Enemy {
    protected String name;
    protected List<Attribute> attributes;
    protected Status status;
    //protected Strategy strategy;
    
    public List<Attribute> getAllAttributesDefault(int fuerza, int resistencia, int agilidad, int salud, int defensa, int ataque){
        List<Attribute> atributos = new ArrayList();
        atributos.add(new Attribute(Attribute.FUERZA, fuerza));
        atributos.add(new Attribute(Attribute.RESISTENCIA, resistencia));
        atributos.add(new Attribute(Attribute.AGILIDAD, agilidad));
        atributos.add(new Attribute(Attribute.SALUD, salud));
        atributos.add(new Attribute(Attribute.DEFENSA, defensa));
        atributos.add(new Attribute(Attribute.ATAQUE, ataque));
        return atributos;
    }
}
