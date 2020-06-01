package model.enemy;

import java.util.ArrayList;
import java.util.List;

import State.Status;
import model.Attribute;
import decorator.Attack;
import strategy.ValuesStrategy;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */
public abstract class Enemy {
    protected String name;
    protected List<Attribute> attributes;
    protected Status status; //Hay que inicializarlo
    protected List<Attack> attacks;
    protected ValuesStrategy strategy;
    protected String enviroment;
    protected int hp = 100;
    
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

    public void setStrategy(ValuesStrategy strategy) {
        this.strategy = strategy;
    }

    public String getName() {
        return name;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public ValuesStrategy getStrategy() {
        return strategy;
    }

    public String getEnviroment() {
        return enviroment;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
