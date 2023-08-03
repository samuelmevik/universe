package view.sorting;

import java.util.Arrays;
import java.util.Comparator;

import model.CelestialBody;

public class SortByRadius extends Sort {
  public SortByRadius() {
    super("Size");
  }

  /**
   * Sorts an array of CelestialBody objects based on their radius using
   * Arrays.sort() method.
   *
   * @param celestialBodies the array of CelestialBody objects to be sorted
   * @return a sorted array of CelestialBody objects based on their radius
   */
  @Override
  public <T extends CelestialBody> T[] sort(T[] celestialBodies) {
    var sortedBodies = Arrays.copyOf(celestialBodies, celestialBodies.length);
    Arrays.sort(sortedBodies, Comparator.comparing(CelestialBody::getRadius));
    return sortedBodies;
  }
}
