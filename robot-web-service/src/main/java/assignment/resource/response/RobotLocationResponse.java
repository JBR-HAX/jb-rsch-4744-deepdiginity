package assignment.resource.response;

public class RobotLocationResponse {

    private int x;
    private int y;

    public RobotLocationResponse(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static RobotLocationResponse startingPoint() {
        return new RobotLocationResponse(0, 0);
    }

    public static RobotLocationResponse startingPoint(int x, int y) {
        return new RobotLocationResponse(x, y);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
