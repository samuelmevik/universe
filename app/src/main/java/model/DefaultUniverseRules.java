package model;

public class DefaultUniverseRules implements UniverseRules {

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
  public void validate(Star star, Universe universe) {
    defaults(star);
    uniqueName(star, universe.getChildren());
    if (star.getRadius() < 20000) {
      throw new IllegalArgumentException("Star radius must be larger than 20000km.");
    }
  }

  @Override
  public void validate(Planet planet, Star.Mutable star) {
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
  }

  @Override
  public void validate(Moon moon, Planet.Mutable planet) {
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
  }

}
