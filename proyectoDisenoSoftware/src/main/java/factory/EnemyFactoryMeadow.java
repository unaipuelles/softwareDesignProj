package factory;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

import model.enemy.Dragon;
import model.enemy.DragonMeadow;
import model.enemy.Orc;
import model.enemy.OrcMeadow;

public class EnemyFactoryMeadow implements EnemyFactory{
    
    @Override
    public Dragon createDragon() {
        return new DragonMeadow();
    }
    
    @Override
    public Orc createOrc() {
        return new OrcMeadow();
    }
}
