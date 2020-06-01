package strategy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */
public class GetStrategyValuesAttacker implements GetStrategyValues{
    
    @Override
    public List<Integer> getStrategyValues(Strategy strategy) {
        List<Integer> values = new ArrayList();
        strategy.doAtack = 70;
        strategy.heal = 30;
        values.add(strategy.doAtack);
        values.add(strategy.heal);
        
        return values;
    }
    
}
