package model;

/**
 * An interface for celestial bodies that can have children.
 */
public interface Orbital<T extends CelestialBody> {
  public void addChild(T child, CelestialRules rules);

  public T[] getChildren();
}
