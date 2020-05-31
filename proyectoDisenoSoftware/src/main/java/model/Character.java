package model;

import State.Status;
import decorator.Attack;
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
    private List<Attack> attacks;
    private Status status; //Hay que inicializarlo
    private final int type;
    private int hp = 100;

    public Character(int type) {
        this.type = type;
        setNameAndDefaultAttributes();
    }
    
    public String getName() {
        return name;
    }
    
    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
    
    public List<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

    public int getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }
    
    public void setHp(int hp) {
        this.hp = hp;
    }

    private void setNameAndDefaultAttributes() {
        switch(type){
            case GUERRERO:
                name = SGUERRERO;
                attributes = getAllAttributesDefault(3,2,1,1,0,3);
                attacks = getAllAttacksGuerrero();
            break;
            case MAGO:
                name = SMAGO;
                attributes = getAllAttributesDefault(1,3,2,2,1,1);
                attacks = getAllAttacksMago();
            break;
            case GIGANTE:
                name = SGIGANTE;
                attributes = getAllAttributesDefault(4,0,0,2,4,0);
                attacks = getAllAttacksGigante();
            break;
        }
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
    
    private List<Attack> getAllAttacksGuerrero() {
        List<Attack> ataques = new ArrayList();
        ataques.add(new Attack("Ataque espada", 15));
        ataques.add(new Attack("Golpe con mango", 8));
        ataques.add(new Attack("Puñetazo", 6));
        ataques.add(new Attack("Patada", 4));
        
        return ataques;
    }
    
    private List<Attack> getAllAttacksMago() {
        List<Attack> ataques = new ArrayList();
        ataques.add(new Attack("Bola de magia", 18));
        ataques.add(new Attack("Tornado", 10));
        ataques.add(new Attack("Bofetada", 3));
        ataques.add(new Attack("Golpear con la varita", 1));
        
        return ataques;
    }
    
    private List<Attack> getAllAttacksGigante() {
        List<Attack> ataques = new ArrayList();
        ataques.add(new Attack("Aplastar con el pie", 25));
        ataques.add(new Attack("Pandereta", 8));
        ataques.add(new Attack("Golpear con el dedo", 5));
        ataques.add(new Attack("Escupitajo", 2));
        
        return ataques;
    }
}
