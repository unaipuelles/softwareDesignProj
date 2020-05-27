package fight;

import java.util.List;
import model.Attack;
import model.Attribute;
import model.Status;

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
       return 0;
   }
   
}
