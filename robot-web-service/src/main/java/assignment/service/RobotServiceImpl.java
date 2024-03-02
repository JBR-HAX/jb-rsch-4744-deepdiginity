package assignment.service;

import assignment.model.RobotMovement;
import assignment.repository.RobotMovementRepository;
import assignment.resource.commons.Direction;
import assignment.resource.request.RobotMovesRequest;
import assignment.resource.request.RobotLocationsRequest;
import assignment.resource.response.RobotLocationResponse;
import assignment.resource.response.RobotMovesResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RobotServiceImpl implements RobotService {

    private final RobotMovementRepository robotMovementRepository;

    public RobotServiceImpl(RobotMovementRepository robotMovementRepository) {
        this.robotMovementRepository = robotMovementRepository;
    }

    @Override
    public List<RobotLocationResponse> movesToLocations(List<RobotMovesRequest> requests) {
        RobotMovement robotMovement = new RobotMovement();
        robotMovement.setJsonRequestData1(requests);

        List<RobotLocationResponse> robotLocationRespons = new ArrayList<>(List.of(RobotLocationResponse.startingPoint()));
        for (int i = 0; i < requests.size(); i++) {
            robotLocationRespons.add(moveToCoordinate(requests.get(i), robotLocationRespons.get(i)));
        }

        robotMovement.setJsonResponseData1(robotLocationRespons);
        robotMovementRepository.save(robotMovement);

        return robotLocationRespons;
    }

    @Override
    public List<RobotMovesResponse> locationsToMoves(List<RobotLocationsRequest> requests) {
        RobotMovement robotMovement = new RobotMovement();
        robotMovement.setJsonRequestData2(requests);

        List<RobotMovesResponse> movesResponses = new ArrayList<>();
        if (requests.size() > 1) {
            for (int i = 1; i < requests.size(); i++) {
                movesResponses.add(coordinateToResponse(requests.get(i - 1), requests.get(i)));
            }
        }
        robotMovement.setJsonResponseData2(movesResponses);
        robotMovementRepository.save(robotMovement);

        return movesResponses;
    }

    public RobotLocationResponse moveToCoordinate(RobotMovesRequest move, RobotLocationResponse robotLocationResponse) {
        RobotLocationResponse newRobotLocationResponse = RobotLocationResponse.startingPoint(robotLocationResponse.getX(), robotLocationResponse.getY());
        switch (move.direction().name()) {
            case "NORTH":
                newRobotLocationResponse.setY(newRobotLocationResponse.getY() + move.steps());
                break;
            case "SOUTH":
                newRobotLocationResponse.setY(newRobotLocationResponse.getY() - move.steps());
                break;
            case "EAST":
                newRobotLocationResponse.setX(newRobotLocationResponse.getX() + move.steps());
                break;
            case "WEST":
                newRobotLocationResponse.setX(newRobotLocationResponse.getX() - move.steps());
                break;
        }
        return newRobotLocationResponse;
    }

    public RobotMovesResponse coordinateToResponse(RobotLocationsRequest oldLocation, RobotLocationsRequest newLocation) {
        RobotMovesResponse robotMovesResponse = new RobotMovesResponse();

        int x = newLocation.x() - oldLocation.x();
        int y = newLocation.y() - oldLocation.y();

        if (x > 0) {
            robotMovesResponse.addMove(x, Direction.EAST);
            return robotMovesResponse;
        } else if (x < 0) {
            robotMovesResponse.addMove(-x, Direction.WEST);
            return robotMovesResponse;
        }
        if (y > 0) {
            robotMovesResponse.addMove(y, Direction.NORTH);
            return robotMovesResponse;
        } else if (y < 0) {
            robotMovesResponse.addMove(-y, Direction.SOUTH);
            return robotMovesResponse;
        }
        return robotMovesResponse;
    }
}
