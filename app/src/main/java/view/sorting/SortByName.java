package view.sorting;

import model.CelestialBody;

/**
 * A sorting strategy that sorts an array of CelestialBody objects based on
 * their name.
 */
public class SortByName extends Sort {
  public SortByName() {
    super("Name");
  }

  /**
   * Sorts an array of CelestialBody objects based on their name using
   * Arrays.sort() method.
   *
   * @param celestialBodies the array of CelestialBody objects to be sorted
   * @return a sorted array of CelestialBody objects based on their name
   */
  @Override
  public <T extends CelestialBody> T[] sort(T[] celestialBodies) {
    var sortedBodies = celestialBodies.clone();
    java.util.Arrays.sort(sortedBodies, java.util.Comparator.comparing(CelestialBody::getName));
    return sortedBodies;
  }
}