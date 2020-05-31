package strategy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author unaipuelles
 * @author daviddominguez
 */
public class Strategy {
    
    protected int doAtack;
    protected int defend;

    public Strategy() {
        doAtack = 50;
        defend = 50;
    }
    
    public List<Integer> getStrategyValues() {
        List<Integer> values = new ArrayList();
        values.add(doAtack);
        values.add(defend);
        
        return values;
    }
}
