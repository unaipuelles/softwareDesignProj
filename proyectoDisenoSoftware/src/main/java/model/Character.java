package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */
public class Character {
    public static final int GUERRERO = 1;
    private static final String SGUERRERO = "Guerrero";
    public static final int MAGO = 2;
    private static final String SMAGO = "Mago";
    public static final int GIGANTE = 3;
    private static final String SGIGANTE = "Gigante";
    private String name;
    private List<Attribute> attributes;
    private Status status;
    private int type;

    public Character(int type) {
        this.type = type;
        setNameAndDefaultAttributes();
    }
    
    public String getName() {
        return name;
    }

    private void setNameAndDefaultAttributes() {
        switch(type){
            case GUERRERO:
                name = SGUERRERO;
                attributes = getAllAttributesDefault(3,2,1,1,0,3);
            break;
            case MAGO:
                name = SMAGO;
                attributes = getAllAttributesDefault(1,3,2,2,1,1);
            break;
            case GIGANTE:
                name = SGIGANTE;
                attributes = getAllAttributesDefault(4,0,0,2,4,0);
            break;
        }
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    private List<Attribute> getAllAttributesDefault(int fuerza, int resistencia, int agilidad, int salud, int defensa, int ataque){
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
