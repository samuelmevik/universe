package model.celestials.policies;

import model.celestials.CelestialBody;

/**
 * A child policy is a policy that allows a celestial body to have children.
 *
 * @param <T> The type of celestial body that can be a child.
 */
public interface ChildPolicy<T extends CelestialBody> {
  public void addChild(T child);

  public void removeChild(T child);
}