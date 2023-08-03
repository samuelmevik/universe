package model;

public interface Orbital<T extends CelestialBody> {
  public void addChild(T child, CelestialRules rules);

  public T[] getChildren();
}
