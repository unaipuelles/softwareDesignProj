package model.enemy;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

public class OrcMeadow extends Orc{
    
    public OrcMeadow () {       
        super(null);
        attributes = getAllAttributesDefault(4, 4, 4, 2, 1, 3);
    }
}
