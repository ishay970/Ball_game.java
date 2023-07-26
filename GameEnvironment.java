//208306233 ishay eldar

import java.util.ArrayList;
import java.util.List;

/**
 * class GameEnvironment.
 */
public class GameEnvironment  {
    private List<Collidable> collidableList;

    /**
     * constructor.
     */
    public GameEnvironment() {
        this.collidableList = new ArrayList<>();
    }

    /**
     *
     * @param c
     */
    public void addCollidable(Collidable c) {
        collidableList.add(c);
    }


    /**
     *
     * @param trajectory
     * @return CollisionInfo
     */
    public CollisionInfo getClosestCollision(Line trajectory) {

        double minLen = -1;
        CollisionInfo minColInfo = null;
        for (int i = 0; i < collidableList.size(); i++) {
            Point p = trajectory.closestIntersectionToStartOfLine(collidableList.get(i).getCollisionRectangle());
            if (p != null) {
                if (minLen == -1 || minLen > p.distance(trajectory.start())) {
                    minLen = p.distance(trajectory.start());
                    minColInfo = new CollisionInfo(p, collidableList.get(i));
                }
            }
        }
        return minColInfo;
    }

    /**
     *
     * @param c
     */
    public void removeCollidable(Collidable c) {
        if (this.collidableList.contains(c)) {
            this.collidableList.remove(c);
        }
    }
}
