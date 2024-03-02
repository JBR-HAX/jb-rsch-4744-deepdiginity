package assignment.model;

import assignment.resource.request.RobotMovesRequest;
import assignment.resource.request.RobotLocationsRequest;
import assignment.resource.response.RobotLocationResponse;
import assignment.resource.response.RobotMovesResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "robot_movement")
public class RobotMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "json_request_data", columnDefinition = "TEXT")
    private String jsonRequestData;

    @Column(name = "json_response_data", columnDefinition = "TEXT")
    private String jsonResponseData;

    public void setJsonRequestData1(List<RobotMovesRequest> data) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.jsonRequestData = objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error setting JSON request data", e);
        }
    }

    public void setJsonRequestData2(List<RobotLocationsRequest> requests) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.jsonRequestData = objectMapper.writeValueAsString(requests);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error setting JSON request data", e);
        }
    }

    public void setJsonResponseData1(List<RobotLocationResponse> data) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.jsonResponseData = objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error setting JSON response data", e);
        }
    }

    public void setJsonResponseData2(List<RobotMovesResponse> data) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.jsonResponseData = objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error setting JSON response data", e);
        }
    }

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}