package view.search;

import model.CelestialBody;
import model.search.CelestialBodyStrategy;

/**
 * A strategy that determines whether a celestial body's radius is greater than a given value.
 */
public class RadiusGreaterThanStrategy implements CelestialBodyStrategy {
  private double minRadius;

  /**
   * Constructs a new RadiusGreaterThanStrategy with the given minimum radius.
   *
   * @param minRadius the minimum radius
   * @throws IllegalArgumentException if the radius is not positive
   */
  public RadiusGreaterThanStrategy(double minRadius) {
    if (minRadius <= 0) {
      throw new IllegalArgumentException("Radius must be positive");
    }
    this.minRadius = minRadius;
  }

  @Override
  public boolean shouldInclude(CelestialBody body) {
    return body.getRadius() >= minRadius;
  }
}