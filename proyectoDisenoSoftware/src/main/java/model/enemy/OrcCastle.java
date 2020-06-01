package model.enemy;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

public class OrcCastle extends Orc{
    
    public OrcCastle () {       
        super(null);
        enviroment = "Castle";
        attributes = getAllAttributesDefault(3, 3, 3, 2, 1, 3);
    }
}
