package controller.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.CelestialBody;
import model.search.CelestialBodyStrategy;

/**
 * This class is used to search for celestial bodies based on a strategy.
 */
public class CelestialBodyContext {
  private CelestialBodyStrategy strategy = null;

  public void setStrategy(CelestialBodyStrategy strategy) {
    this.strategy = strategy;
  }

  private boolean includeCelestialBody(CelestialBody body) {
    return strategy.shouldInclude(body);
  }

  /**
   * Searches for celestial bodies based on a strategy.
   *
   * @param bodies the celestial bodies to search through
   * @param <T>    the type of celestial body
   * @return the celestial bodies that match the strategy
   */
  public <T extends CelestialBody> T[] search(T[] bodies) {
    if (strategy == null) {
      return bodies;
    }
    List<T> list = new ArrayList<T>();
    for (T body : bodies) {
      if (includeCelestialBody(body)) {
        list.add(body);
      }
    }
    T[] filteredBodies = Arrays.copyOf(bodies, list.size());
    list.toArray(filteredBodies);

    return filteredBodies;
  }
}