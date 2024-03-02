package assignment.resource.request;

import assignment.resource.commons.Direction;

import javax.validation.constraints.Min;

public record RobotMovesRequest(
        Direction direction,
        @Min(1)
        int steps
) {

}
