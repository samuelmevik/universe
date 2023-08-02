package model.celestials;

import java.util.ArrayList;
import java.util.List;

import model.celestials.policies.ChildPolicy;

/**
 * A star is a type of celestial body that may have planet orbiting it.
 */
public class Star extends CelestialBody {

  public Star(String name, double radius) {
    super(name, radius);
  }

  /**
   * A mutable version of the Star class.
   */
  public static final class Mutable extends Star implements ChildPolicy<Planet> {
    private final List<Planet.Mutable> children = new ArrayList<>();

    public Mutable(Star star) {
      super(star.getName(), star.getRadius());
    }

    protected void setName(String name) {
      this.name = name;
    }

    protected void setRadius(double radius) {
      this.radius = radius;
    }

    protected Star toStar() {
      return this;
    }

    @Override
    public void addChild(Planet child) {
      // TODO: Validate child
      children.add(new Planet.Mutable(child));
    }

    @Override
    public void removeChild(Planet child) {
      children.remove(child);
    }
  }

}
