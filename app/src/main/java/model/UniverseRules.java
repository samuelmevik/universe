package model;

import model.observer.CelestialSubject;

public interface UniverseRules extends CelestialSubject {
  public void onCreation(Star star, Universe universe);

  public void onCreation(Planet planet, Star.Mutable star);

  public void onCreation(Moon moon, Planet.Mutable planet);
}
