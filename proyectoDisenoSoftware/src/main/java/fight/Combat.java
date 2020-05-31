package fight;

import java.util.List;

import model.enemy.Enemy;
import model.Character;
import decorator.Attack;

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

    public Combat(Enemy enemy, Character character, int combatNum) {
        this.enemy = enemy;
        this.character = character;
        this.calculator = Calculator.getInstance();
        this.combatNum = combatNum;
        startCombat();
    }
    
    private void startCombat() {
        showCombatStartInfo();
        do{
            round++;
            showRoundInfo();
            
        }while(enemy.getHp() > 0 && character.getHp() > 0);
    }
    
    public void showCombatStartInfo() {
        StringBuilder strBuilder = new  StringBuilder();
        strBuilder.append("######COMBATE ");
        strBuilder.append(combatNum);
        strBuilder.append("######");
        strBuilder.append("\n-Enemigo: ");
        strBuilder.append(enemy.getName());
        strBuilder.append("\n-Mapa: ");
        strBuilder.append(enemy.getEnviroment());
    }
    
    public void showRoundInfo() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("\n\n* Ronda ");
        strBuilder.append(round);
        strBuilder.append(" *\n");
        strBuilder.append("Tú:                                        Enemigo:\n");
        strBuilder.append("-Nombre: ");
        strBuilder.append(character.getName());
        strBuilder.append("                    -Nombre: ");
        strBuilder.append(enemy.getName());
        strBuilder.append("-Vida: ");
        strBuilder.append(character.getHp());
        strBuilder.append("                    -Vida: ");
        strBuilder.append(enemy.getHp());
        
    }
    
    public void requestCharacterAttack() {
        
    }
    
    public void showAllAttacks() {
        
    }
}
