package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The universe is a collection of stars and their children.
 */
public final class Universe implements Orbital<Star> {
  private List<Star.Mutable> stars = new ArrayList<>();
  private UniverseRules rules;
  /**
   * Creates a new universe.
   */
  public Universe(UniverseRules rules) {
    this.rules = rules;
  }

  protected void removeStar(Star.Mutable star) {
    stars.remove(star);
  }

  public UniverseRules getRules() {
    return rules;
  }

  @Override
  public void addChild(Star star, UniverseRules rules) {
    rules.onCreation(star, this);
    stars.add(new Star.Mutable(star, this));
  }

  @Override
  public Star.Mutable[] getChildren() {
    return stars.toArray(new Star.Mutable[stars.size()]);
  }
}
