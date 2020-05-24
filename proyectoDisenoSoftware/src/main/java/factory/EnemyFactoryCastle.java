package factory;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

import model.enemy.Dragon;
import model.enemy.DragonCastle;
import model.enemy.Orc;
import model.enemy.OrcCastle;

public class EnemyFactoryCastle implements EnemyFactory{
    
    @Override
    public Dragon createDragon() {
        return new DragonCastle();
    }
    
    @Override
    public Orc createOrc() {
        return new OrcCastle();
    }
}
