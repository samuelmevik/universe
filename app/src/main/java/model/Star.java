package model;

import java.util.ArrayList;
import java.util.List;

/**
 * A star is a type of celestial body that may have planet orbiting it.
 */
public class Star extends CelestialBody {
  protected final List<Planet.Mutable> children = new ArrayList<>();

  public Star(String name, double radius) {
    super("Star", name, radius);
  }

  public Planet[] getChildren() {
    return children.toArray(new Planet[children.size()]);
  }

  /**
   * A mutable version of the Star class.
   */
  public static final class Mutable extends Star implements Orbital<Planet> {

    public Mutable(Star star) {
      super(star.getName(), star.getRadius());
    }

    protected void setName(String name) {
      this.name = name;
    }

    protected void setRadius(double radius) {
      this.radius = radius;
    }

    protected void removeChild(Planet.Mutable child) {
      children.remove(child);
    }

    protected Star toStar() {
      return this;
    }

    @Override
    public void addChild(Planet child, CelestialRules rules) {
      rules.onCreation(child, this);
      children.add(new Planet.Mutable(child));
    }

    @Override
    public Planet.Mutable[] getChildren() {
      return children.toArray(new Planet.Mutable[children.size()]);
    }
  }

}
