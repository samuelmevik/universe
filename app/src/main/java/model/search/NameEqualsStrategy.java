package model.search;

import model.CelestialBody;

/**
 * A strategy that returns true if the name of the body contains the target
 * name.
 *
 * @see SearchStrategy
 * @see CelestialBody
 */
public class NameEqualsStrategy implements SearchStrategy {
  private String targetName = "";

  /**
   * Creates a new NameEqualsStrategy with the given target name.
   *
   * @param targetName the target name to search for
   */
  public NameEqualsStrategy(String targetName) {
    this.targetName = targetName;
  }

  @Override
  public boolean shouldInclude(CelestialBody body) {
    return body.getName().toLowerCase().contains(targetName.toLowerCase());
  }

}
