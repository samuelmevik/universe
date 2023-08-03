import java.util.Scanner;

import controller.Controller;
import model.CelestialBodyManager;
import model.Universe;
import model.CelestialRules;
import view.View;
import view.sorting.Sort;
import view.sorting.SortByName;
import view.sorting.SortByRadius;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in, "UTF-8");
    View view = new View(sc, new Sort[] {
        new SortByName(),
        new SortByRadius()
    });
    CelestialRules rules = new CelestialBodyManager();
    rules.register(view);
    Universe universe = new Universe(rules);
    Controller controller = new Controller(universe, view);
    controller.showMainMenu();
    sc.close();
  }
}
