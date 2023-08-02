package model.celestials.policies;

import model.celestials.CelestialBody;

public interface ChildPolicy<T extends CelestialBody> {
  public void addChild(T child);
  public void removeChild(T child);
}