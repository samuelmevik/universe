package view.sorting;

import model.CelestialBody;

public abstract class Sort {
  private final String name;

  /**
   * Creates a new Sort object.
   *
   * @param name the name of the sorting strategy
   */
  public Sort(String name) {
    this.name = name;
  }

  /**
   * Sorts an array of CelestialBody objects using a specific sorting strategy.
   *
   * @param celestialBodies the array of CelestialBody objects to be sorted
   * @param <T>             the type of CelestialBody objects in the array
   * @return the sorted array of CelestialBody objects
   */
  public abstract <T extends CelestialBody> T[] sort(T[] celestialBodies);

  /**
   * Returns the name of the sorting strategy.
   *
   * @return the name of the sorting strategy
   */
  public String getName() {
    return name;
  }
}
