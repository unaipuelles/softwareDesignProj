package fight;

import State.Status;
import java.util.List;
import decorator.Attack;
import model.Attribute;


/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

public class Calculator {
   private List<Attribute> attackerAtribb;
   private List<Attribute> defenderAttrib;
   private Status attackerStatus;
  private Status defenderStatus;
   private Attack attack;
   
   private static Calculator instance = null;
    
   private Calculator() {    
   } 
   
   public static Calculator getInstance() {
       if(instance == null)
           instance = new Calculator();
       else
           System.out.println("Error, ya existe un objeto de tipo Calculator");
       
       return instance;
   }
   
   public int calculate() {
       
       int damage =0;
       
       if(attackerStatus.getStatus()=='M')
       {  
           System.out.println("El atacante esta paralizado, no se puede mover.");
           return damage;
       }
       else
       { 
           //Sumar a damage el daño que hace el atacante segun sus atributos
           //...
           
           //Sumar a damage el daño del estado del enemigo si esta quemado/corona
           if(defenderStatus.getStatus()=='D')
           {
               damage+=50; //Sumarle el daño comun a todos los efectos de daño
               System.out.println("El enemigo está " + defenderStatus.getName() + ", recibirá un extra de daño.");         
           }
           return damage;
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

    public void setAttackerAtribb(List<Attribute> attackerAtribb) {
        this.attackerAtribb = attackerAtribb;
    }

    public void setDefenderAttrib(List<Attribute> defenderAttrib) {
        this.defenderAttrib = defenderAttrib;
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
}
