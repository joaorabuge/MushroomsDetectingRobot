# Artificial Intelligence – 2nd Project

## Fuzzy Systems / Decision Trees / Neural Networks | 2nd Semester 2021/22

### Project Overview

This project aims to implement a system that controls a mushroom-detecting robot in an agricultural field. The robot should be able to identify edible mushrooms and avoid poisonous ones. The robot will receive information from sensors and use supervised learning algorithms (decision trees or neural networks) to decide whether to pick up or destroy the detected mushrooms.


### Problem Description

The robot detects mushrooms using three sensors: one central, one on the left, and one on the right. Each sensor has a range of 10 meters and covers a 60-degree angle. The robot receives information about the distance of detected mushrooms and their attributes (odor, spore-print color, cap shape, and class).

#### Sensor Configuration

- **Sensors**: Left, Center, Right (each with a 60-degree angle and a range of 10m)
- **Fuzzy Sets for Distance**: `near`, `medium`, `far` (range: 0 to 10 meters)
- **Fuzzy Sets for Robot Speed**: `slow`, `medium`, `fast`
- **Fuzzy Sets for Mushroom Classification**: `poisonous`, `none`, `edible`
- **Fuzzy Sets for Wheel Angle**: `strong-left`, `left`, `center`, `right`, `strong-right` (range: -45° to 45°)
- **Fuzzy Sets for Actions**: `no_action`, `destroy`, `pick-up`

### Implementation Steps

1. **Fuzzy Logic System**:
    - Use the jFuzzyLogic API to create a `.fcl` file that represents the fuzzy system.
    - Define the rules required to control the robot based on sensor inputs and mushroom classification.

2. **Java Class Implementation**:
    - Develop the necessary Java classes to implement the fuzzy logic system.
    - Implement classifiers using either decision trees (J48) or neural networks (MLP).
    - Train classifiers using the provided dataset `mushrooms.arff`, which includes attributes like odor, spore-print color, cap shape, and class (edible or poisonous).
    - Use the trained classifier to classify new instances of mushrooms and decide the robot's action (pick-up, destroy, no_action).

3. **Integration with Simulator**:
    - Use the provided `Simulator.java` class to simulate the robot's actions.
    - Use `Mushroom.java`, `NewInstances.java`, and `Visualizer.java` classes to handle mushroom attributes and visualization.
    - Implement the required methods to set the robot's speed, angle, and action using the `Simulator` class methods (e.g., `setRobotSpeed`, `setRobotAngle`, `setAction`).

4. **Scoring System**:
    - Picking up a poisonous mushroom results in a loss of 10 points.
    - Destroying a poisonous mushroom results in a gain of 1 point.
    - Picking up an edible mushroom results in a gain of 1 point.
    - Destroying an edible mushroom results in a loss of 5 points.

### Testing and Evaluation

- Test the fuzzy logic system and classifier integration using different mushroom instances.
- Use the `Simulator` to observe the robot's behavior and ensure that the robot performs actions based on the classifier's decision.
- Monitor the robot's actions and current score using the simulator GUI.

### Method Details

- **Setting Robot Angle**: `setRobotAngle(double angle)` – Sets the wheels' angle.
- **Setting Robot Action**: `setAction(simulator.Action action)` – Specifies the robot's action (DESTROY, NO_ACTION, PICK_UP).
- **Getting Sensor Distances**: Use `getDistanceC()`, `getDistanceL()`, and `getDistanceR()` to get the distance from the central, left, and right sensors, respectively.
- **Step Simulation**: Use `step()` to move the simulation forward and update the environment's state.

