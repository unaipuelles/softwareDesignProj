package src.java.proyectodisenosoftware;


import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import model.Attribute;
import model.Character;
import factory.*;
import model.enemy.Dragon;
import model.enemy.Enemy;
import model.enemy.Orc;
import fight.Combat;
import decorator.Attack;
import decorator.ColaDecorator;
import decorator.DedoDecorator;
import decorator.MangoDecorator;
import decorator.PiedraDecorator;
import decorator.VaritaDecorator;
import strategy.GetStrategyValuesAttacker;
import strategy.GetStrategyValuesDefender;
import strategy.ValuesStrategy;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */
public class main {
    
    public static final int ATRIBUTOSCUSTOM = 8;
    public static int combatNum = 1;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) { 
        Character personaje = characterSelection();
        personaje = personalizeAttributes(personaje);
        personaje = decorateCharacter(personaje);
        startGame(personaje);
    }
    /**
     * 
     * @return 
     */
    public static Character characterSelection(){
        boolean error = false;
        Character personaje = null;
        do{
            System.out.println("----Seleccion del personaje----\n");
            System.out.println("1.- Guerrero\n2.-Mago\n3.-Gigante");
            Scanner scanner = new Scanner(System.in);
            int characterNum = scanner.nextInt();
           
            switch(characterNum){
                case 1:
                    personaje = new Character(Character.GUERRERO);
                break;
                case 2:
                    personaje = new Character(Character.MAGO);
                break;
                case 3:
                    personaje = new Character(Character.GIGANTE);
                break;
                default:
                    showErrorMessage("El valor introducido no corresponde con ningún personaje");
                    error = true;
                break;    
            } 
        }while(error == true);
    
        return personaje;
    }
    
    /**
     * Personaliza los atrtibutos de un personaje
     * @param personaje Objeto que queremos personalizar
     * @return Personaje personalizado
     */
    public static Character personalizeAttributes(Character personaje) {
        boolean error = false;
        int puntos = ATRIBUTOSCUSTOM;
        List<Attribute> atributos = personaje.getAttributes();
        do{
            showAllAttributes(atributos);
            System.out.println(puntos + " puntos restantes");
            
            System.out.println("\nIntroduce la habilidad a la que quieres sumarle un punto: ");
            Scanner scanner = new Scanner(System.in);
            int characterNum = scanner.nextInt();
            
            Attribute atributo = null;
            switch(characterNum){
                case 1:
                    atributo = findAttribute(Attribute.FUERZA, atributos);    
                break;
                case 2:
                    atributo = findAttribute(Attribute.RESISTENCIA, atributos); 
                break;
                case 3:
                    atributo = findAttribute(Attribute.AGILIDAD, atributos); 
                break;
                case 4:
                    atributo = findAttribute(Attribute.SALUD, atributos); 
                break;
                case 5:
                    atributo = findAttribute(Attribute.DEFENSA, atributos); 
                break;
                case 6:
                    atributo = findAttribute(Attribute.ATAQUE, atributos); 
                break;
                default:
                    showErrorMessage("El valor introducido no corresponde con ningún atributo");
                    error = true;
                break;    
            }
            if(error != true && atributo != null) {
                atributo.setValor(atributo.getValor()+1);
                puntos--;
            }
            
        }while(error == false && puntos > 0);
        
        return personaje;
    }
    
    public static void showErrorMessage(String message){
        System.out.println("[ERROR] "+message);
    }
    
    public static void showAllAttributes(List<Attribute> atributos) {
        int cont = 1;
        for(Attribute atributo : atributos){
            System.out.println(cont + ".- " + atributo.getName() + ": " + atributo.getValor() + "\n");
            cont++;
        }
    }
    
    public static Character decorateCharacter(Character character){
        switch(character.getType()) {
            case Character.GUERRERO:
                character.setAttacks(decorateGuerrero(character.getAttacks(), character.getAttributes()));
            break;  
            case Character.MAGO:
                character.setAttacks(decorateMago(character.getAttacks(), character.getAttributes()));
            break;
            case Character.GIGANTE:
                character.setAttacks(decorateGigante(character.getAttacks(), character.getAttributes()));
            break; 
        }
        return character;
    }
    
    public static List<Attack> decorateGuerrero(List<Attack> attacks, List<Attribute> attributes) {
        boolean changed = false;
        Attribute agility = findAttribute(Attribute.AGILIDAD, attributes); //Recogemos varios atributos por los que basarnos
        Attribute strength = findAttribute(Attribute.FUERZA, attributes);
        if(agility.getValor() > 2 && strength.getValor() > 5) {  //Miramos si la agilidad es mayor que 2 y la fuerza mayor que 5
            for(int x = 0; x < attacks.size() && !changed; x++) {
                Attack tmp = attacks.get(x);
                if(tmp.getName().toLowerCase().equals("golpe con mango")) {
                    MangoDecorator md = new MangoDecorator(tmp); //Decoramos el ataque con el patron decorator
                    tmp.setDecoratedName(md.getAttackMessage());  
                    tmp.setDamage(tmp.getDamage()+5);
                }
            }      
        }
        return attacks;
    }

    public static List<Attack> decorateMago(List<Attack> attacks, List<Attribute> attributes) {
        boolean changed = false;
        Attribute resistencia = findAttribute(Attribute.RESISTENCIA, attributes); //Recogemos varios atributos por los que basarnos
        Attribute strength = findAttribute(Attribute.FUERZA, attributes);
        if(resistencia.getValor() > 6 && strength.getValor() > 4) {  //Miramos si la resistencia es mayor que 6 y la fuerza mayor que 4
            for(int x = 0; x < attacks.size() && !changed; x++) {
                Attack tmp = attacks.get(x);
                if(tmp.getName().toLowerCase().equals("golpear con la varita")) {
                    VaritaDecorator md = new VaritaDecorator(tmp); //Decoramos el ataque con el patron decorator
                    tmp.setDecoratedName(md.getAttackMessage());  
                    tmp.setDamage(tmp.getDamage()+4);
                }
            }      
        }
        return attacks;
    }
    
    public static List<Attack> decorateGigante(List<Attack> attacks, List<Attribute> attributes) {
        boolean changed = false;
        Attribute attack = findAttribute(Attribute.ATAQUE, attributes); //Recogemos varios atributos por los que basarnos
        Attribute agility = findAttribute(Attribute.AGILIDAD, attributes);
        if(attack.getValor() > 3 && agility.getValor() > 3) {  //Miramos si el ataque es mayor que 3 y la agilidad mayor que 3
            for(int x = 0; x < attacks.size() && !changed; x++) {
                Attack tmp = attacks.get(x);
                if(tmp.getName().toLowerCase().equals("golpear con el dedo")) {
                    DedoDecorator md = new DedoDecorator(tmp); //Decoramos el ataque con el patron decorator
                    tmp.setDecoratedName(md.getAttackMessage());  
                    tmp.setDamage(tmp.getDamage()+2);
                }
            }      
        }
        return attacks;
    }
    
    public static Attribute findAttribute(int type, List<Attribute> atributos) {
        boolean encontrado = false;
        Attribute atributo = null;
        for(int x = 0; x < atributos.size() && encontrado == false; x++){
            Attribute tmp = atributos.get(x);
            if(tmp.equals(type)) {
                atributo = tmp;
                encontrado = true;
            }
        }
        return atributo;
    }
    
    public static int randomNum(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }
    
    public static void startGame(Character character) {
        Enemy enemy;
        Combat combat;
        enemy = (Enemy) firstMap();
        enemy = decorateEnemy(enemy);
        combat = new Combat(enemy, character, combatNum);
    }
    
    public static Dragon firstMap() {
        EnemyFactory enemyFactory = new EnemyFactoryCastle();
        Dragon dragonCastle = enemyFactory.createDragon();
        ValuesStrategy valuesStrategy = null;
        valuesStrategy = getRandomStrategy(valuesStrategy);
        dragonCastle.setStrategy(valuesStrategy);
        return dragonCastle;
    }
    
    public static ValuesStrategy getRandomStrategy(ValuesStrategy valuesStrategy) {
        int rand = randomNum(0, 1);
        if(rand == 0) {
            valuesStrategy = new ValuesStrategy(new GetStrategyValuesAttacker());
        }
        else{
            valuesStrategy = new ValuesStrategy(new GetStrategyValuesDefender());
        }
        return valuesStrategy;
    }
    
    public static Enemy decorateEnemy(Enemy enemy){
        switch(enemy.getName().toLowerCase()) {
            case "dragon":
                enemy.setAttacks(decorateDragon(enemy.getAttacks(), enemy.getAttributes()));
            break;  
            case "orco":
                enemy.setAttacks(decorateOrco(enemy.getAttacks(), enemy.getAttributes()));
            break;
        }
        return enemy;
    }
    
    public static List<Attack> decorateDragon(List<Attack> attacks, List<Attribute> attributes) {
        boolean changed = false;
        Attribute strength = findAttribute(Attribute.FUERZA, attributes); //Recogemos el atributo fuerza
        if(strength.getValor() > 3) {  //Miramos si la fuerza mayor que 3
            for(int x = 0; x < attacks.size() && !changed; x++) {
                Attack tmp = attacks.get(x);
                if(tmp.getName().toLowerCase().equals("golpear con la cola")) {
                    ColaDecorator md = new ColaDecorator(tmp); //Decoramos el ataque con el patron decorator
                    tmp.setDecoratedName(md.getAttackMessage());  
                    tmp.setDamage(tmp.getDamage()+4);
                }
            }      
        }
        return attacks;
    }
    
    public static List<Attack> decorateOrco(List<Attack> attacks, List<Attribute> attributes) {
        boolean changed = false;
        Attribute agility = findAttribute(Attribute.AGILIDAD, attributes); //Recogemos el atributo agilidad
        if(agility.getValor() > 3) {  //Miramos si la agilidad mayor que 3
            for(int x = 0; x < attacks.size() && !changed; x++) {
                Attack tmp = attacks.get(x);
                if(tmp.getName().toLowerCase().equals("tirar piedra")) {
                    PiedraDecorator md = new PiedraDecorator(tmp); //Decoramos el ataque con el patron decorator
                    tmp.setDecoratedName(md.getAttackMessage());  
                    tmp.setDamage(tmp.getDamage()+3);
                }
            }      
        }
        return attacks;
    }
}
