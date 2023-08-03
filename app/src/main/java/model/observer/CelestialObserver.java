package model.observer;

import model.CelestialBody;

/**
 * Observer interface for celestial bodies.
 */
public interface CelestialObserver {
  public void update(String method, CelestialBody body);
}
