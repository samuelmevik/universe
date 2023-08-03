package model.observer;

import model.CelestialBody;

public interface CelestialSubject {
  public void register(CelestialObserver o);

  public void unregister(CelestialObserver o);

  public void notifyObservers(String method, CelestialBody body);
}
