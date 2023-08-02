package model;

import java.util.ArrayList;
import java.util.List;

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
  public static final class Mutable extends Star {
    private Universe universe;
    private final List<Planet.Mutable> children = new ArrayList<>();

    public Mutable(Star star, Universe universe) {
      super(star.getName(), star.getRadius());
      this.universe = universe;
    }

    protected void setName(String name) {
      this.name = name;
    }

    protected void setRadius(double radius) {
      this.radius = radius;
    }



    public void remove() {
      universe.removeStar(this);
    }

    public void addChild(Planet child, UniverseRules rules) {
      rules.validate(child, this);
      children.add(new Planet.Mutable(child, this));
    }

    protected void removeChild(Planet.Mutable child) {
      children.remove(child);
    }    
    
    protected Star toStar() {
      return this;
    }
  }

}
