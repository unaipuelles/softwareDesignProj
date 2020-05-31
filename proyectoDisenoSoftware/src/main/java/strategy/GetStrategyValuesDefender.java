package strategy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */
public class GetStrategyValuesDefender implements GetStrategyValues{
    
    @Override
    public List<Integer> getStrategyValues(Strategy strategy) {
        List<Integer> values = new ArrayList();
        strategy.doAtack = 30;
        strategy.defend = 70;
        values.add(strategy.doAtack);
        values.add(strategy.defend);
        
        return values;
    }
}
