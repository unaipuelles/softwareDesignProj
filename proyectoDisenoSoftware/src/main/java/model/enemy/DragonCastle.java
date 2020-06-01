package model.enemy;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

public class DragonCastle extends Dragon{
    
    public DragonCastle () {       
        super(null);
        enviroment = "Castle";
        attributes = getAllAttributesDefault(6, 2, 2, 3, 2, 3);
    }
    
}
