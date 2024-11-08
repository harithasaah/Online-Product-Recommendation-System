/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluster;

import java.util.Map;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Record {
     private final String description;

    /**
     * Encapsulates all attributes and their corresponding values, i.e. features.
     */
    private final Map<String, Double> features;

    public Record(String description, Map<String, Double> features) {
        this.description = description;
        this.features = features;
    }

    public Record(Map<String, Double> features) {
        this("", features);
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Double> getFeatures() {
        return features;
    }

    @Override
    public String toString() {
        String prefix = description == null || description
          .trim()
          .isEmpty() ? "Record" : description;

        return prefix + ": " + features;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Record record = (Record) o;
        return Objects.equals(getDescription(), record.getDescription()) && Objects.equals(getFeatures(), record.getFeatures());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getFeatures());
    }
}
