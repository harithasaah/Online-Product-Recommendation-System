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
public interface Distance {
     /**
     * Calculates the distance between two feature vectors.
     *
     * @param f1 The first set of features.
     * @param f2 The second set of features.
     * @return Calculated distance.
     * @throws IllegalArgumentException If the given feature vectors are invalid.
     */
    double calculate(Map<String, Double> f1, Map<String, Double> f2);
}
