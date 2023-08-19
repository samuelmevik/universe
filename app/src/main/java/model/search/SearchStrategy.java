package model.search;

import model.CelestialBody;

/**
 * A strategy for determining whether a celestial body should be included in a
 * search.
 */
public interface SearchStrategy {
  /**
   * Determines whether a celestial body should be included in a search.
   *
   * @param body The celestial body to check.
   * @return True if the celestial body should be included in the search, false
   *         otherwise.
   */
  boolean shouldInclude(CelestialBody body);
}