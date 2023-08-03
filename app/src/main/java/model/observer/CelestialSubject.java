package model.observer;

import model.CelestialBody;

/**
 * Subject interface for celestial bodies.
 */
public interface CelestialSubject {
  public void register(CelestialObserver o);

  public void unregister(CelestialObserver o);

  public void notifyObservers(String method, CelestialBody body);
}
