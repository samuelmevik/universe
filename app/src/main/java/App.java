import controller.Controller;
import java.util.Scanner;
import model.CelestialBodyManager;
import model.CelestialRules;
import model.Moon;
import model.Planet;
import model.Star;
import model.Universe;
import view.ConsoleView;
import view.View;

/**
 * The main class of the application.
 */
public class App {
  /**
   * The entry point of the application.
   *
   * @param args The command-line arguments.
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in, "UTF-8");
    View view = new ConsoleView(sc);
    CelestialRules rules = new CelestialBodyManager();
    rules.register(view);
    Universe universe = new Universe(rules);

    // Dummy data
    Star.Mutable star = new Star.Mutable(new Star("Sun", 50000));
    Planet.Mutable planet = new Planet.Mutable(new Planet("Earth", 1000, 500000));
    Moon.Mutable moon = new Moon.Mutable(new Moon("Moon", 10, 17000));
    universe.addChild(star, rules);
    universe.getChildren()[0].addChild(planet, rules);
    universe.getChildren()[0].getChildren()[0].addChild(moon, rules);

    Controller controller = new Controller(universe, view);
    controller.showMainMenu();
    sc.close();
  }
}