package model;

import model.observer.CelestialSubject;

public interface CelestialRules extends CelestialSubject {
  public void onCreation(Star star, Universe universe);

  public void onCreation(Planet planet, Star star);

  public void onCreation(Moon moon, Planet planet);
}
