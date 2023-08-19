package view;

import model.CelestialBody;
import model.Moon;
import model.Planet;
import model.Star;
import model.observer.CelestialObserver;
import view.events.MainEvent;
import view.events.MoonEvent;
import view.events.PlanetEvent;
import view.events.SearchEvent;
import view.events.StarEvent;

/**
 * Interface for the view.
 */
public interface View extends CelestialObserver {
  public void list(CelestialBody[] celestialObjects);

  public void show(CelestialBody celestial);

  public <T extends CelestialBody> T pickCelestialBody(T[] celestialBodies);

  public Star getStar();

  public Planet getPlanet();

  public Moon getMoon();

  public String askForName();

  public double askForRadius();

  public double askForOrbitRadius();

  public void showError(String message);
  
  public SearchEvent showSearchMenu();

  public MainEvent showMainMenu();

  public StarEvent showStarMenu(Star star);

  public PlanetEvent showPlanetMenu(Planet planet);

  public MoonEvent showMoonMenu(Moon moon);

  
}
