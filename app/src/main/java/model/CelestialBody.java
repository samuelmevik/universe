package model;

/**
 * A celestial body represents a body residing in space.
 */
public abstract class CelestialBody {
  private final String type;
  protected String name;
  protected double radius;
  

  /**
   * Creates a new celestial body.
   *
   * @param name  The name of the celestial body.
   * @param radius The radius of the celestial body.
   */
  public CelestialBody(String type, String name, double radius) {
    this.type = type;
    this.name = name;
    this.radius = radius;
  }

  public String getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public double getRadius() {
    return radius;
  }
}
