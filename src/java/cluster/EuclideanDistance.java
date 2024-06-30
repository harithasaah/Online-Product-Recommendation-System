/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluster;

import java.util.Map;

/**
 *
 * @author user
 */
public class EuclideanDistance implements Distance  {
    
      @Override
    public double calculate(Map<String, Double> f1, Map<String, Double> f2) {
        if (f1 == null || f2 == null) {
            throw new IllegalArgumentException("Feature vectors can't be null");
        }

        double sum = 0;
        for (String key : f1.keySet()) {
            Double v1 = f1.get(key);
            Double v2 = f2.get(key);

            if (v1 != null && v2 != null) sum += Math.pow(v1 - v2, 2);
        }

        return Math.sqrt(sum);
    }

    
}
