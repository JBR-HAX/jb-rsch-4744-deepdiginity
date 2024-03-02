package assignment.service;

import assignment.request.Direction;

public interface RobotService {
    void moveRobot(Direction direction, int steps);
}
