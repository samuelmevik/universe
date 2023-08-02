package model;

public class DefaultUniverseRules implements UniverseRules {

  @Override
  public void validate(Star star, Universe universe) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'validate'");
  }

  @Override
  public void validate(Planet planet, Star star) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'validate'");
  }

  @Override
  public void validate(Moon moon, Planet planet) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'validate'");
  }
  
}
