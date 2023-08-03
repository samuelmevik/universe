package controller;

import model.CelestialBody;
import model.Moon;
import model.Orbital;
import model.Planet;
import model.Star;
import model.Universe;
import view.View;

/**
 * The controller is the glue between the model and the view.
 */
public class Controller {
  private final Universe universe;
  private final View view;

  /**
   * Creates a new controller.
   * 
   * @param universe the universe
   * @param view     the view
   */
  public Controller(Universe universe, View view) {
    this.universe = universe;
    this.view = view;
  }

  private <T extends CelestialBody> T pick(T[] celestialBodies) {
    view.list(celestialBodies);
    return view.pickCelestialBody(celestialBodies);
  }

  private <T extends CelestialBody> void create(Orbital<T> orbital, T child) {
    orbital.addChild(child, universe.getRules());
  }

  public void showMainMenu() {
    boolean exit = false;
    while (!exit) {
      try {
        switch (view.showMainMenu()) {
          case ADD -> create(universe, view.getStar());
          case QUIT -> exit = true;
          case LIST -> view.list(universe.getChildren());
          case SELECT -> showStarMenu(pick(universe.getChildren()));
          case SORT -> view.pickSortingStrategy();
          default -> throw new IllegalArgumentException("Unknown star event");
        }
      } catch (Exception e) {
        view.showError(e.getMessage());
      }
    }
  }

  private void showStarMenu(Star.Mutable star) {
    if (star == null) {
      return;
    }
    boolean exit = false;
    while (!exit) {
      try {
        switch (view.showStarMenu(star)) {
          case ADD -> create(star, view.getPlanet());
          case BACK -> exit = true;
          case LIST -> view.list(star.getChildren());
          case SELECT -> showPlanetMenu(pick(star.getChildren()));
          case SORT -> view.pickSortingStrategy();
          default ->
            throw new IllegalArgumentException("Unknown star event");
        }
      } catch (Exception e) {
        view.showError(e.getMessage());
      }
    }
  }

  private void showPlanetMenu(Planet.Mutable planet) {
    if (planet == null) {
      return;
    }
    boolean exit = false;
    while (!exit) {
      try {
        switch (view.showPlanetMenu(planet)) {
          case ADD:
            create(planet, view.getMoon());
            break;
          case BACK:
            exit = true;
            break;
          case LIST:
            view.list(planet.getChildren());
            break;
          case SELECT:
            showMoonMenu(pick(planet.getChildren()));
            break;
          case SORT:
            view.pickSortingStrategy();
            break;
          default:
            throw new IllegalArgumentException("Unknown planet event");
        }
      } catch (Exception e) {
        view.showError(e.getMessage());
      }
    }
  }

  private void showMoonMenu(Moon.Mutable moon) {
    if (moon == null) {
      return;
    }
    boolean exit = false;
    while (!exit) {
      try {
        switch (view.showMoonMenu(moon)) {
          case BACK:
            break;
          default:
            throw new IllegalArgumentException("Unknown star event");
        }
      } catch (Exception e) {
        view.showError(e.getMessage());
      }
    }
  }

}
