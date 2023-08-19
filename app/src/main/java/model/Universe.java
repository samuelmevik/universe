package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The universe is a collection of stars and their children.
 */
public final class Universe implements Orbital<Star> {
  private List<Star.Mutable> stars = new ArrayList<>();
  private CelestialRules rules;
  
  /**
   * Creates a new universe.
   */
  public Universe(CelestialRules rules) {
    this.rules = rules;
  }

  protected void removeStar(Star.Mutable star) {
    stars.remove(star);
  }

  public CelestialRules getRules() {
    return rules;
  }

  @Override
  public void addChild(Star star, CelestialRules rules) {
    rules.onCreation(star, this);
    stars.add(new Star.Mutable(star));
  }

  @Override
  public Star.Mutable[] getChildren() {
    return stars.toArray(new Star.Mutable[stars.size()]);
  }
}
