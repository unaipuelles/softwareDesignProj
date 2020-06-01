package fight;

import State.Status;
import java.util.List;
import decorator.Attack;
import java.util.concurrent.ThreadLocalRandom;
import model.Attribute;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */
public class Calculator {

    private List<Attribute> attackerAtrib;
    private Status attackerStatus;
    private Status defenderStatus;
    private Attack attack;

    private static Calculator instance = null;

    private Calculator() {
    }

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        } else {
            System.out.println("Error, ya existe un objeto de tipo Calculator");
        }

        return instance;
    }

    public int calculateAttack() {

        int damage = 0;

        if (attackerStatus.getStatus() == 'M') {
            System.out.println("El atacante esta paralizado, no se puede mover.");
            return damage;
        } else {
            //Calcular aleatoriamente mediante atributos si el ataque falla
            if (getAttackProbability()) {
                //Sumar a damage el daño que hace el atacante segun sus atributos
                damage += attack.getDamage();
                //Sumar a damage el daño del estado del enemigo si esta quemado/corona
                if (defenderStatus.getStatus() == 'D') {
                    damage += 10; //Sumarle el daño comun a todos los efectos de daño
                    System.out.println("El enemigo está " + defenderStatus.getName() + ", recibirá un extra de daño.");
                }
                    
            }
            return damage;
        }
    }

    public int regenerate() {

        int regen = 0;

        if (attackerStatus.getStatus() == 'M') {
            System.out.println("El atacante esta paralizado, no se puede mover.");
            return regen;
        } else {
            
            //Calcular aleatoriamente mediante atributos si la regeneración falla
            if (getHealProbability()) {
                
                //Calcular la vida que se va a regenerar
                int rnd = randomNum(1, 10);
               
                if(rnd <= 6)
                    regen += 5;
                else if (rnd <= 9)
                    regen += 10;
                else if(rnd == 10)
                    regen += 20;
                
            }
            return regen;
        }

    }

    @Override
    public Calculator clone() {
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException ex) {
            System.out.println("[ERROR] No se puede clonar una clase Calculator");
        }
        return null;
    }

    public void setAttackerAtribb(List<Attribute> attackerAtrib) {
        this.attackerAtrib = attackerAtrib;
    }

    public void setAttackerStatus(Status attackerStatus) {
        this.attackerStatus = attackerStatus;
    }

    public void setDefenderStatus(Status defenderStatus) {
        this.defenderStatus = defenderStatus;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public static void setInstance(Calculator instance) {
        Calculator.instance = instance;
    }

    public void setAllToCalculate(Attack attack, List<Attribute> attackerAtrib, Status attackerStatus, List<Attribute> defenderAttrib, Status defenderStatus) {
        this.attack = attack;
        this.attackerStatus = attackerStatus;
        this.attackerAtrib = attackerAtrib;
        this.defenderStatus = defenderStatus;
    }
    
    public void setAllToHeal(List<Attribute> attackerAtrib, Status attackerStatus, List<Attribute> defenderAttrib, Status defenderStatus) {
        this.attackerStatus = attackerStatus;
        this.attackerAtrib = attackerAtrib;
        this.defenderStatus = defenderStatus;
    }    

    private boolean getAttackProbability() {
        int totalPoints = 0;
        boolean attackOk = false;
        totalPoints += findAttribute(Attribute.FUERZA).getValor() * 2;
        totalPoints += findAttribute(Attribute.AGILIDAD).getValor() * 3;
        totalPoints += findAttribute(Attribute.ATAQUE).getValor() * 4;
        if (totalPoints <= randomNum(0, 100)) {
            attackOk = true;
        }

        return attackOk;
    }
    
    private boolean getHealProbability() {
        
        int totalPoints=0;
        boolean healOk=false;
        
        totalPoints += findAttribute(Attribute.DEFENSA).getValor() * 2;
        totalPoints += findAttribute(Attribute.RESISTENCIA).getValor() * 3;
        totalPoints += findAttribute(Attribute.SALUD).getValor() * 4;
        
        if(totalPoints <= randomNum(0, 100))
            healOk=true;
        
        return healOk;
        
    }

    public Attribute findAttribute(int type) {
        boolean encontrado = false;
        Attribute atributo = null;
        for (int x = 0; x < attackerAtrib.size() && encontrado == false; x++) {
            Attribute tmp = attackerAtrib.get(x);
            if (tmp.equals(type)) {
                atributo = tmp;
                encontrado = true;
            }
        }
        return atributo;
    }

    public static int randomNum(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }

}
