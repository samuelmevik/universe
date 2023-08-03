package model;

import java.util.ArrayList;
import java.util.List;

/**
 * A planet is a type of celestial body that may have moons orbiting it.
 */
public class Planet extends CelestialBody implements Orbits {
  protected final List<Moon.Mutable> children = new ArrayList<>();
  protected double orbitRadius;

  /**
   * Creates a new planet.
   *
   * @param name   The name of the planet.
   * @param radius The radius of the planet.
   */
  public Planet(String name, double radius, double orbitRadius) {
    super("Planet", name, radius);
    this.orbitRadius = orbitRadius;
  }

  @Override
  public double getOrbitRadius() {
    return orbitRadius;
  }

  public Moon[] getChildren() {
    return children.toArray(new Moon[children.size()]);
  }

  /**
   * A mutable version of the Planet class.
   */
  public static final class Mutable extends Planet implements Orbital<Moon> {

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

    protected void removeChild(Moon.Mutable child) {
      children.remove(child);
    }

    protected Planet toPlanet() {
      return this;
    }

    @Override
    public void addChild(Moon child, CelestialRules rules) {
      rules.onCreation(child, this);
      children.add(new Moon.Mutable(child));
    }

    @Override
    public Moon.Mutable[] getChildren() {
      return children.toArray(new Moon.Mutable[children.size()]);
    }
  }

}
