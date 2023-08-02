package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The universe is a collection of stars and their children.
 */
public final class Universe {
  private List<Star.Mutable> stars = new ArrayList<>();
  private UniverseRules rules;
  /**
   * Creates a new universe.
   */
  public Universe(UniverseRules rules) {
    this.rules = rules;
  }

  public void addStar(Star star, UniverseRules rules) {
    rules.validate(star, this);
    stars.add(new Star.Mutable(star, this));
  }

  protected void removeStar(Star.Mutable star) {
    stars.remove(star);
  }

  public UniverseRules getRules() {
    return rules;
  }
}
