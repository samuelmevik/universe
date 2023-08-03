package model;

import model.observer.CelestialSubject;

/**
 * An interface that manages the rules for creating celestial bodies.
 */
public interface CelestialRules extends CelestialSubject {
  public void onCreation(Star star, Universe universe);

  public void onCreation(Planet planet, Star star);

  public void onCreation(Moon moon, Planet planet);
}
