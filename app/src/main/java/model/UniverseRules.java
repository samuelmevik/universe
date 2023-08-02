package model;

public interface UniverseRules {
  public void validate(Star star, Universe universe);

  public void validate(Planet planet, Star star);

  public void validate(Moon moon, Planet planet);
}
