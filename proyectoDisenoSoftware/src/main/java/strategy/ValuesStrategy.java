package strategy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */
public class ValuesStrategy {
    protected GetStrategyValues getStrategyValues; 
    protected Strategy strategy;

    public ValuesStrategy(GetStrategyValues getStrategyValues) {
        this.getStrategyValues = getStrategyValues;
        this.strategy = new Strategy();
    }

    public List<Integer> getStrategyValues() {
        return getStrategyValues.getStrategyValues(strategy);
    }
}
