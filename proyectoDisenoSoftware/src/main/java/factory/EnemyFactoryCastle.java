package factory;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

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
