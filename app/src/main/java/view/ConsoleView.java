package view;

import java.util.Scanner;
import model.CelestialBody;
import model.Moon;
import model.Orbits;
import model.Planet;
import model.Star;
import view.events.MainEvent;
import view.events.MoonEvent;
import view.events.PlanetEvent;
import view.events.StarEvent;
import view.sorting.Sort;

/**
 * The console view.
 */
public class ConsoleView implements View {

  private final Scanner sc;

  private static final String add = "add";
  private static final String back = "b";
  private static  final String list = "lm";
  private static final String select = "sel";
  private static final String sort = "s";
  private static final String quit = "q";

  private Sort[] sortingStrategies;
  private Sort currentSortingStrategy;

  /**
   * Creates a new view.
   */
  public ConsoleView(Scanner sc, Sort[] sortingStrategies) {
    this.sc = sc;
    this.sortingStrategies = sortingStrategies;
    this.currentSortingStrategy = sortingStrategies[0];
  }

  @Override
  public void list(CelestialBody[] celestialObjects) {
    if (celestialObjects.length == 0) {
      System.out.println("No celestial objects found");
      return;
    }
    CelestialBody[] sortedObjects = currentSortingStrategy.sort(celestialObjects);
    for (int i = 0; i < sortedObjects.length; i++) {
      System.out.print((i + 1) + ". ");
      show(sortedObjects[i]);
    }
  }

  @Override
  public void show(CelestialBody celestial) {
    String orbitRadius = celestial instanceof Orbits ? " Orbit: " + ((Orbits) celestial).getOrbitRadius() : "";
    System.out
        .println(celestial.getType() + ": " + celestial.getName() + " Radius: " + celestial.getRadius() + orbitRadius);
  }

  @Override
  public <T extends CelestialBody> T pickCelestialBody(T[] celestialBodies) {
    if (celestialBodies.length == 0) {
      System.out.println("No celestial bodies found");
      return null;
    }
    T[] sortedObjects = currentSortingStrategy.sort(celestialBodies);
    System.out.println("Select a celestial body: ");
    return sortedObjects[Integer.parseInt(sc.nextLine()) - 1];
  }

  @Override
  public Star getStar() {
    return new Star(askForName(), askForRadius());
  }

  @Override
  public Planet getPlanet() {
    return new Planet(askForName(), askForRadius(), askForOrbitRadius());
  }

  @Override
  public Moon getMoon() {
    return new Moon(askForName(), askForRadius(), askForOrbitRadius());
  }

  private String askForName() {
    System.out.println("Name: ");
    return sc.nextLine();
  }

  private double askForRadius() {
    System.out.println("Radius: ");
    return Double.parseDouble(sc.nextLine());
  }

  private double askForOrbitRadius() {
    System.out.println("Orbit radius: ");
    return Double.parseDouble(sc.nextLine());
  }

  @Override
  public void showError(String message) {
    System.out.println("Error: " + message);
  }

  @Override
  public void pickSortingStrategy() {
    System.out.println("Choose a sorting strategy:");
    for (int i = 0; i < sortingStrategies.length; i++) {
      System.out.println((i + 1) + " " + sortingStrategies[i].getName());
    }
    currentSortingStrategy = sortingStrategies[Integer.parseInt(sc.nextLine()) - 1];
  }

  @Override
  public MainEvent showMainMenu() {
    System.out.println("******************************************************");
    System.out.println("Main Menu");
    System.out.println("******************************************************");
    System.out.println(" " + list + " - List stars");
    System.out.println(" " + add + " - Add a star");
    System.out.println(" " + select + " - Select a star");
    System.out.println(" " + sort + " - Set sorting strategy");
    System.out.println(" " + quit + " - Quit the application");

    String choice = sc.nextLine().toLowerCase();

    return switch (choice) {
      case add -> MainEvent.ADD;
      case list -> MainEvent.LIST;
      case select -> MainEvent.SELECT;
      case sort -> MainEvent.SORT;
      case quit -> MainEvent.QUIT;
      default -> throw new IllegalArgumentException("Unexpected value: " + choice);
    };
  }

  @Override
  public StarEvent showStarMenu(Star star) {
    System.out.println("******************************************************");
    System.out.println("Star Menu");
    System.out.println("******************************************************");
    show(star);
    System.out.println(" " + add + " - Add a Planet");
    System.out.println(" " + list + " - List planets");
    System.out.println(" " + select + " - Select a child");
    System.out.println(" " + sort + " - Set sorting strategy");
    System.out.println(" " + back + " - Back");
    String choice = sc.nextLine().toLowerCase();

    return switch (choice) {
      case add -> StarEvent.ADD;
      case list -> StarEvent.LIST;
      case select -> StarEvent.SELECT;
      case sort -> StarEvent.SORT;
      case back -> StarEvent.BACK;
      default -> throw new IllegalArgumentException("Unexpected value: " + choice);
    };
  }

  @Override
  public PlanetEvent showPlanetMenu(Planet planet) {
    System.out.println("******************************************************");
    System.out.println("Planet Menu");
    System.out.println("******************************************************");
    show(planet);
    System.out.println(" " + add + " - Add a Moon");
    System.out.println(" " + list + " - List moons");
    System.out.println(" " + select + " - Select a child");
    System.out.println(" " + sort + " - Set sorting strategy");
    System.out.println(" " + back + " - Back");

    String choice = sc.nextLine().toLowerCase();

    return switch (choice) {
      case add -> PlanetEvent.ADD;
      case list -> PlanetEvent.LIST;
      case select -> PlanetEvent.SELECT;
      case sort -> PlanetEvent.SORT;
      case back -> PlanetEvent.BACK;
      default -> throw new IllegalArgumentException("Unexpected value: " + choice);
    };
  }

  @Override
  public MoonEvent showMoonMenu(Moon moon) {
    System.out.println("******************************************************");
    System.out.println("Moon Menu");
    System.out.println("******************************************************");
    show(moon);
    System.out.println(" " + back + " - Back");

    String choice = sc.nextLine().toLowerCase();

    return switch (choice) {
      case back -> MoonEvent.BACK;
      default -> throw new IllegalArgumentException("Unexpected value: " + choice);
    };
  }

  @Override
  public void update(String method, CelestialBody body) {
    System.out.println(method + " " + body.getName());
  }

}
