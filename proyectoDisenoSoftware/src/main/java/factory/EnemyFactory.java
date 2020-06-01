package factory;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

import java.util.List;

import model.Attribute;

public interface EnemyFactory {
    
    Dragon createDragon();
    
    Orc createOrc();
}
