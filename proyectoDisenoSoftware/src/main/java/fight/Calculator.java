package fight;

import State.Status;
import java.util.List;
import model.Attack;
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
    
   private Calculator(List<Attribute> attackerAtribb,List<Attribute> defenderAttrib,Status attackerStatus,Status defenderStatus,Attack attack) {
   this.attackerAtribb=attackerAtribb;
   this.defenderAttrib=defenderAttrib;
   this.attackerStatus=attackerStatus;
   this.defenderStatus=defenderStatus;
   this.attack=attack;
       
   } 
   
   public static Calculator getInstance(List<Attribute> attackerAtribb,List<Attribute> defenderAttrib,Status attackerStatus,Status defenderStatus,Attack attack) {
       if(instance == null)
           instance = new Calculator(attackerAtribb,defenderAttrib,attackerStatus,defenderStatus,attack);
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
   
}
