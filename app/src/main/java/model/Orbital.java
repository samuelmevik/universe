package model;

public interface Orbital<T extends CelestialBody> {
  public void addChild(T child, UniverseRules rules);

  public T[] getChildren();
}
