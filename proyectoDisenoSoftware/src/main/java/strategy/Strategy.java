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
    protected int heal;

    public Strategy() {
        doAtack = 50;
        heal = 50;
    }
    
    public List<Integer> getStrategyValues() {
        List<Integer> values = new ArrayList();
        values.add(doAtack);
        values.add(heal);
        
        return values;
    }
}
