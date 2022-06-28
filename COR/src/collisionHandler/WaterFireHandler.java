package collisionHandler;

import sprites.Fire;
import sprites.Sprite;
import sprites.Water;

public class WaterFireHandler extends CollisionHandler {
    public WaterFireHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    protected boolean match(Sprite s1, Sprite s2) {
        return (s1 instanceof Water && s2 instanceof Fire) || (s1 instanceof Fire && s2 instanceof Water);
    }

    @Override
    protected void handleCollision(Sprite s1, Sprite s2) {
        s1.dead();
        s2.dead();
    }
}
