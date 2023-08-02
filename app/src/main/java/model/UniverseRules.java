package model;

public interface UniverseRules {
  public void validate(Star star, Universe universe);

  public void validate(Planet planet, Star.Mutable star);

  public void validate(Moon moon, Planet.Mutable planet);
}
