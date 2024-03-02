package assignment.repository;

import assignment.model.RobotMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RobotMovementRepository extends JpaRepository<RobotMovement, Integer> {
}