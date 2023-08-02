package model.celestials;

/**
 * A planet is a type of celestial body that may have moons orbiting it.
 */
public class Planet extends CelestialBody {
  protected double orbitRadius;

  /**
   * Creates a new planet.
   *
   * @param name   The name of the planet.
   * @param radius The radius of the planet.
   */
  public Planet(String name, double radius, double orbitRadius) {
    super(name, radius);
    this.orbitRadius = orbitRadius;
  }

  public double getOrbitRadius() {
    return orbitRadius;
  }

  /**
   * A mutable version of the Planet class.
   */
  public static final class Mutable extends Planet {

    public Mutable(Planet planet) {
      super(planet.getName(), planet.getRadius(), planet.getOrbitRadius());
    }

    protected void setName(String name) {
      this.name = name;
    }

    protected void setRadius(double radius) {
      this.radius = radius;
    }

    protected void setOrbitRadius(double orbitRadius) {
      this.orbitRadius = orbitRadius;
    }

    protected Planet toPlanet() {
      return this;
    }
  }

}