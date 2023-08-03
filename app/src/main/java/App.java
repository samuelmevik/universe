import java.util.Scanner;

import controller.Controller;
import model.DefaultUniverseRules;
import model.Universe;
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
    Universe universe = new Universe(new DefaultUniverseRules());
    Controller controller = new Controller(universe, view);
    controller.showMainMenu();
    sc.close();
  }
}
