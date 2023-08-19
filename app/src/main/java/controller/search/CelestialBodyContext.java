package controller.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.CelestialBody;
import model.search.SearchStrategy;

/**
 * This class is used to search for celestial bodies based on a strategy.
 */
public class CelestialBodyContext {
  private SearchStrategy strategy = null;

  public void setStrategy(SearchStrategy strategy) {
    this.strategy = strategy;
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
      if (strategy.shouldInclude(body)) {
        list.add(body);
      }
    }
    T[] filteredBodies = Arrays.copyOf(bodies, list.size());
    list.toArray(filteredBodies);

    return filteredBodies;
  }
}