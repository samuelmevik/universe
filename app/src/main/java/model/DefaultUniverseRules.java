package model;

import java.util.HashSet;
import java.util.Set;

import model.observer.CelestialObserver;

public class DefaultUniverseRules implements UniverseRules {

  private Set<CelestialObserver> observers = new HashSet<>();

  private void uniqueName(CelestialBody body, CelestialBody[] children) {
    for (CelestialBody child : children) {
      if (child.getName().equals(body.getName())) {
        throw new IllegalArgumentException("Name must be unique");
      }
    }
  }

  private void defaults(CelestialBody body) {
    if (body.getRadius() <= 0) {
      throw new IllegalArgumentException("Celestial body radius cannot be negative.");
    }

    if (body.getName() == null || body.getName().isEmpty()) {
      throw new IllegalArgumentException("Celestial body name cannot be null or empty.");
    }
  }

  @Override
  public void onCreation(Star star, Universe universe) {
    defaults(star);
    uniqueName(star, universe.getChildren());
    if (star.getRadius() < 20000) {
      throw new IllegalArgumentException("Star radius must be larger than 20000km.");
    }
    notifyObservers("Created", star);
  }

  @Override
  public void onCreation(Planet planet, Star.Mutable star) {
    defaults(planet);
    uniqueName(star, star.getChildren());
    if (planet.getRadius() < 1000) {
      throw new IllegalArgumentException("Planet radius must be larger than 1000km.");
    }

    if (planet.getRadius() > star.getRadius() / 10) {
      throw new IllegalArgumentException("Planet radius must be smaller than 10x the star radius.");
    }

    if (planet.getOrbitRadius() < star.getRadius() * 10) {
      throw new IllegalArgumentException("Planet orbit radius must be larger than 10x the star radius.");
    }
    notifyObservers("Created", planet);
  }

  @Override
  public void onCreation(Moon moon, Planet.Mutable planet) {
    defaults(moon);
    if (moon.getRadius() < 10) {
      throw new IllegalArgumentException("Moon radius must be larger than 10km.");
    }

    if (moon.getRadius() > planet.getRadius() / 17) {
      throw new IllegalArgumentException("Moon radius must be smaller than 17x the planet radius.");
    }

    if (moon.getOrbitRadius() < planet.getRadius() * 5) {
      throw new IllegalArgumentException("Moon orbit radius must be larger than 5x the planet radius.");
    }
    notifyObservers("Created", moon);
  }

  @Override
  public void register(CelestialObserver o) {
    observers.add(o);
  }

  @Override
  public void unregister(CelestialObserver o) {
    observers.remove(o);
  }

  @Override
  public void notifyObservers(String method, CelestialBody body) {
    for (CelestialObserver o : observers) {
      o.update(method, body);
    }
  }

}
