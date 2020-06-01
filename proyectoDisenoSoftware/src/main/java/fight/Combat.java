package fight;

import java.util.Scanner;

import model.enemy.Enemy;
import model.Character;
import decorator.Attack;
import java.util.List;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

public class Combat {
    private int round = 0;
    private final int combatNum;
    private final Enemy enemy;
    private final Character character;
    private final Calculator calculator;
    private boolean characterWin = false;

    public Combat(Enemy enemy, Character character, int combatNum) {
        this.enemy = enemy;
        this.character = character;
        this.calculator = Calculator.getInstance();
        this.combatNum = combatNum;
        startCombat();
    }

    public boolean isCharacterWin() {
        return characterWin;
    }
    
    /**
     * Funcionalidad de combate
     */
    private void startCombat() {
        showCombatStartInfo(); //Mostrar informacion del combate
        do{
            round++;
            showRoundInfo(); //Informacion de la ronda
            int action = requestCharacterAction(); //Pedir al usuario lo que quiere hacer
            executeCharacterAction(action); //Ejecutar la accion
            //Accion del enemigo template method
            
        }while(enemy.getHp() > 0 && character.getHp() > 0); //Mirar si algun pesonaje ha muerti
        
        if(character.getHp() > 0) {
            showGameWin(); //Mostrar el logo de ganador
            characterWin = true;
        }
        else{
            showGameOver(); //Mostrar logo de perdedor
        }
    }
    
    /**
     * Muestra la informacion al inicio del combate
     */
    private void showCombatStartInfo() {
        StringBuilder strBuilder = new  StringBuilder();
        strBuilder.append("######COMBATE ");
        strBuilder.append(combatNum);
        strBuilder.append("######");
        strBuilder.append("\n-Enemigo: ");
        strBuilder.append(enemy.getName());
        strBuilder.append("\n-Mapa: ");
        strBuilder.append(enemy.getEnviroment());
        System.out.println(strBuilder.toString());
    }
     /**
      * Muestra la informacion de la ronda
      */
    private void showRoundInfo() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("\n\n**** Ronda ");
        strBuilder.append(round);
        strBuilder.append(" ****\n");
        strBuilder.append("Tú:                                        Enemigo:\n");
        strBuilder.append("-Nombre: ");
        strBuilder.append(character.getName());
        strBuilder.append("                    -Nombre: ");
        strBuilder.append(enemy.getName());
        strBuilder.append("\n-Vida: ");
        strBuilder.append(character.getHp());
        strBuilder.append("                    -Vida: ");
        strBuilder.append(enemy.getHp());
        System.out.println(strBuilder.toString());
    }
    
    /**
     * Pide al usuario la accion a realizar
     * @return retorna el numero de accion
     */
    private int requestCharacterAction() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("\n---- Acción ---\n");
        strBuilder.append("1.- Atacar\n2.- Recuperar salud");
        System.out.println(strBuilder.toString());
        Scanner scanner = new Scanner(System.in);
        int actionNum = scanner.nextInt();
        return actionNum;
    }
    
    /**
     * Ejecuta la accion del personaje
     * @param actionNum numero de accion a realizar
     */
    private void executeCharacterAction(int actionNum) {
        switch(actionNum) {
            case 1: //Atacar
                Attack cAttack = requestCharacterAttack();
                calculator.setAllToCalculate(cAttack, character.getAttributes(), character.getStatus(), enemy.getAttributes(), enemy.getStatus()); //Establecemos los parametros al calculador
                int damage = calculator.calculateAttack(); //El calculador nos devuelve el daño realizado
                if(damage > 0) { //Miramos si el ataque ha sido fallido o no
                    character.decreaseHp(damage);
                    showAttackResult(cAttack, damage); 
                }
                else {
                    showFailedAttack();
                }
                
            break;
            case 2: //Recuperar vida
                //calculator.regenerate();
            break;   
        }
    }
    
    /**
     * Para pedir al usuario el ataque que quiere realizar
     * @return {Attack} Ataque a realizar
     */
    private Attack requestCharacterAttack() {
        showAllAttacks();
        List<Attack> attacks = character.getAttacks();
        int actionNum;
        Attack attack = null;
        do{
            System.out.println("\nIntroduce el ataque a realizar: ");
            Scanner scanner = new Scanner(System.in);
            actionNum = scanner.nextInt();
            if(actionNum > 0 && actionNum <= attacks.size()) {
                attack = attacks.get(actionNum-1);
            }
        }while (actionNum >= attacks.size());
        
        return attack;
    }
    
    /**
     * Muestra todos los ataques del personaje
     */
    private void showAllAttacks() {
        int count = 0;
        System.out.println("\n---- Ataques ----\n");
        for(Attack a : character.getAttacks()) {
            count++;
            System.out.println(count + ".- " + a.getAttackMessage() + "\n");
        }
    }
    
    /**
     * Muestra el resultado del ataque
     * @param attack Ataque realizado
     * @param damage Daño realizado
     */
    private void showAttackResult(Attack attack, int damage) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("\n");
        strBuilder.append(attack.getAttackMessage());
        strBuilder.append(" realizado con exito, le has quitado ");
        strBuilder.append(damage);
        strBuilder.append(" al enemigo\n");
        System.out.println(strBuilder.toString());
    }
    
    /**
     * Mostrar ataque fallido
     */
    private void showFailedAttack() {
        System.out.println("\nAtaque fallido...\n");
    }
    
    /**
     * Mostrar que se ha ganado el combate
     */
    private void showGameWin() {
        System.out.println("#### Enhorabuena has derrotado al " + enemy.getName() + " en " + enemy.getEnviroment() + " ####");
    }
    
    /**
     * Mostrar que se ha perdido el combate
     */
    private void showGameOver() {
        System.out.println("#### GAME OVER: " + enemy.getName() + " te ha derrotado en " + enemy.getEnviroment() + " ####");
    }
}
