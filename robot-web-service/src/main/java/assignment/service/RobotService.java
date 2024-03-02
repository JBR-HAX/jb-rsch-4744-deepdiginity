package assignment.service;

import assignment.resource.request.RobotMovesRequest;
import assignment.resource.request.RobotLocationsRequest;
import assignment.resource.response.RobotLocationResponse;
import assignment.resource.response.RobotMovesResponse;

import java.util.List;

public interface RobotService {
    List<RobotLocationResponse> movesToLocations(List<RobotMovesRequest> requests);

    List<RobotMovesResponse> locationsToMoves(List<RobotLocationsRequest> requests);
}
