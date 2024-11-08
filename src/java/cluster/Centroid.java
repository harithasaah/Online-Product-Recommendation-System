/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluster;

/**
 *
 * @author user
 */

import java.util.Map;
import java.util.Objects;

public class Centroid {
    
     private final Map<String, Double> coordinates;

    public Centroid(Map<String, Double> coordinates) {
        this.coordinates = coordinates;
    }

    public Map<String, Double> getCoordinates() {
        return coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Centroid centroid = (Centroid) o;
        return Objects.equals(getCoordinates(), centroid.getCoordinates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoordinates());
    }

    @Override
    public String toString() {
        return "Centroid " + coordinates;
    }
    
}
