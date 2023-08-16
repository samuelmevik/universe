package model;

import java.util.HashSet;
import java.util.Set;
import model.observer.CelestialObserver;

/**
 * A class that manages the rules for creating celestial bodies.
 */
public class CelestialBodyManager implements CelestialRules {

  private Set<CelestialObserver> observers = new HashSet<>();
  private static final int STAR_MIN_RADIUS = 20000;

  private static final int PLANET_MIN_RADIUS = 1000;
  private static final int PLANET_RADIUS_FACTOR = 10;
  private static final int PLANET_ORBIT_RADIUS_FACTOR = 10;

  private static final int MOON_MIN_RADIUS = 10;
  private static final int MOON_RADIUS_FACTOR = 17;
  private static final int MOON_ORBIT_RADIUS_FACTOR = 5;

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
    if (star.getRadius() < STAR_MIN_RADIUS) {
      throw new IllegalArgumentException("Star radius must be larger than " + STAR_MIN_RADIUS + "km.");
    }
    notifyObservers("Created", star);
  }

  @Override
  public void onCreation(Planet planet, Star star) {
    defaults(planet);
    uniqueName(star, star.getChildren());
    if (planet.getRadius() < PLANET_MIN_RADIUS) {
      throw new IllegalArgumentException("Planet radius must be larger than " + PLANET_MIN_RADIUS + "km.");
    }

    if (planet.getRadius() > star.getRadius() / PLANET_RADIUS_FACTOR) {
      throw new IllegalArgumentException(
          "Planet radius must be smaller than " + PLANET_RADIUS_FACTOR + "x the star radius.");
    }

    if (planet.getOrbitRadius() < star.getRadius() * PLANET_ORBIT_RADIUS_FACTOR) {
      throw new IllegalArgumentException(
          "Planet orbit radius must be larger than " + PLANET_ORBIT_RADIUS_FACTOR + "x the star radius.");
    }
    notifyObservers("Created", planet);
  }

  @Override
  public void onCreation(Moon moon, Planet planet) {
    defaults(moon);
    uniqueName(moon, planet.getChildren());
    if (moon.getRadius() < MOON_MIN_RADIUS) {
      throw new IllegalArgumentException("Moon radius must be larger than " + MOON_MIN_RADIUS + "km.");
    }

    if (moon.getRadius() > planet.getRadius() / MOON_RADIUS_FACTOR) {
      throw new IllegalArgumentException(
          "Moon radius must be smaller than " + MOON_RADIUS_FACTOR + "x the planet radius.");
    }

    if (moon.getOrbitRadius() < planet.getRadius() * MOON_ORBIT_RADIUS_FACTOR) {
      throw new IllegalArgumentException(
          "Moon orbit radius must be larger than " + MOON_RADIUS_FACTOR + "x the planet radius.");
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
