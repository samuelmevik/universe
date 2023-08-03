
import controller.Controller;
import java.util.Scanner;
import model.CelestialBodyManager;
import model.CelestialRules;
import model.Universe;
import view.ConsoleView;
import view.View;
import view.sorting.Sort;
import view.sorting.SortByName;
import view.sorting.SortByRadius;

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
    View view = new ConsoleView(sc, new Sort[] { new SortByName(), new SortByRadius() });
    CelestialRules rules = new CelestialBodyManager();
    rules.register(view);
    Universe universe = new Universe(rules);
    Controller controller = new Controller(universe, view);
    controller.showMainMenu();
    sc.close();
  }
}