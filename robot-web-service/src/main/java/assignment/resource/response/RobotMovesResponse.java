package assignment.resource.response;

import assignment.resource.commons.Direction;

public class RobotMovesResponse {

    private Direction direction;
    private int steps;

    public Direction getDirection() {
        return direction;
    }

    public int getSteps() {
        return steps;
    }

    public void addMove(int i, Direction direction) {
        this.direction = direction;
        this.steps = i;
    }
}
