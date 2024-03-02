package assignment.resource;

import assignment.resource.request.RobotMovesRequest;
import assignment.resource.request.RobotLocationsRequest;
import assignment.resource.response.RobotLocationResponse;
import assignment.resource.response.RobotMovesResponse;
import assignment.service.RobotService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class RobotResource {

    private final RobotService robotService;

    public RobotResource(RobotService robotService) {
        this.robotService = robotService;
    }

    @PostMapping("/locations") // This is the endpoint for the robot movement request
    public List<RobotLocationResponse> movesToLocations(
            @RequestBody List<RobotMovesRequest> requests) {
             return robotService.movesToLocations(requests);
    }

    @PostMapping("/moves")
    public List<RobotMovesResponse> locationsToMoves(
            @RequestBody List<RobotLocationsRequest> requests) {
             return robotService.locationsToMoves(requests);
    }
}
