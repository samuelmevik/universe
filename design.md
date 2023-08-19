# Boatclub OO-Design
This document describes the design according to the requirements presented in assignment 2.

## Architectural Overview
The application uses the model-view-controller (MVC) architectural pattern. The view is passive and gets called from the controller. The view may only read information from the model, not directly change it.

![class diagram](img/package_diagram.jpg)

## Detailed Design
### Class Diagram
![application diagram](img/crude_class_diagram.png)

I decided to not include the observer and CelestialRules.

### Sequence Diagram
Please provide at least one sequence diagram according to the assignment requirments.