package factory;

import factory.Dragon;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */

public class DragonMeadow extends Dragon{
    
    public DragonMeadow () {       
        super(null);
        enviroment = "Meadow";
        attributes = getAllAttributesDefault(3, 2, 2, 3, 1, 2);
    }
}
