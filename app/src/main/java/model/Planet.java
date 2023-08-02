package model;

import java.util.ArrayList;
import java.util.List;

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
    private Star.Mutable parent;
    private final List<Moon.Mutable> children = new ArrayList<>();

    public Mutable(Planet planet, Star.Mutable parent) {
      super(planet.getName(), planet.getRadius(), planet.getOrbitRadius());
      this.parent = parent;
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

    public void remove() {
      parent.removeChild(this);
    }

    public void addChild(Moon child, UniverseRules rules) {
      rules.validate(child, this);
      children.add(new Moon.Mutable(child));
    }

    protected void removeChild(Moon.Mutable child) {
      children.remove(child);
    }    
    
    protected Planet toPlanet() {
      return this;
    }
  }

}