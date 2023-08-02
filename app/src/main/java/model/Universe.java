package model;

import java.util.ArrayList;
import java.util.List;

import model.celestials.Star;

/**
 * The universe is a collection of stars and their children.
 */
public final class Universe {
  private List<Star.Mutable> stars = new ArrayList<>();
  /**
   * Creates a new universe.
   */
  public Universe() {
  }

  public void addStar(Star star) {
    // TODO: Validate star
    stars.add(new Star.Mutable(star, this));
  }

  public void removeStar(Star.Mutable star) {
    stars.remove(star);
  }
}
