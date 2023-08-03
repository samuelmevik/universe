package model;

/**
 * A moon is a type of celestial body that doesn't have children.
 */
public class Moon extends CelestialBody implements Orbits {
  protected double orbitRadius;

  public Moon(String name, double radius, double orbitRadius) {
    super("Moon", name, radius);
    this.orbitRadius = orbitRadius;
  }

  @Override
  public double getOrbitRadius() {
    return orbitRadius;
  }

  /**
   * A mutable version of the Moon class.
   */
  public static final class Mutable extends Moon {

    public Mutable(Moon moon) {
      super(moon.getName(), moon.getRadius(), moon.getOrbitRadius());
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

    protected Moon toMoon() {
      return this;
    }
  }

}
