package assignment.resource;

import assignment.request.RobotMovementRequest;
import assignment.service.RobotService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/locations")
public class RobotResource {

    private final RobotService robotService;

    public RobotResource(RobotService robotService) {
        this.robotService = robotService;
    }

    @PostMapping("") // This is the endpoint for the robot movement request
    public void moveRobot(
            @RequestBody RobotMovementRequest robotMovementRequest) {
             robotService.moveRobot(robotMovementRequest.direction(), robotMovementRequest.steps());
    }
}
