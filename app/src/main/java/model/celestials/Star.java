package model.celestials;

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
  }

}
