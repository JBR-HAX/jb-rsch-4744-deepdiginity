package assignment.request;

//[{"direction":"EAST","steps":1},{"direction":"NORTH","steps":3},{"direction":"EAST","steps":3},
//        {"direction":"SOUTH","steps":5},{"direction":"WEST","steps":2}]
import javax.validation.constraints.Min;
public record RobotMovementRequest(
        Direction direction,
        @Min(1)
        int steps
) {
}
