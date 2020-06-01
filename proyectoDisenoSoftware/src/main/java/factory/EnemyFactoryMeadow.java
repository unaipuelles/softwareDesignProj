package factory;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

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
