package model.observer;

import model.CelestialBody;

public interface CelestialObserver {
  public void update(String method, CelestialBody body);
}
