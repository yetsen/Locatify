package tr.com.locatify.model;

/**
 * Created by Yunus on 01-Apr-16.
 */
public class GetNewMessagesRequest {
    private Point point;
    private int lastId;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getLastId() {
        return lastId;
    }

    public void setLastId(int lastId) {
        this.lastId = lastId;
    }
}
