package collisionHandler;

import sprites.Sprite;

public abstract class CollisionHandler {
    protected CollisionHandler next;

    public CollisionHandler(CollisionHandler next) {
        this.next = next;
    }

    public void collide(Sprite s1, Sprite s2) {
        if (match(s1, s2)) {
            handleCollision(s1, s2);
        } else {
            next.collide(s1, s2);
        }
    }

    protected abstract boolean match(Sprite s1, Sprite s2);

    protected abstract void handleCollision(Sprite s1, Sprite s2);

    public static class DummyHandler extends CollisionHandler {
        public DummyHandler() {
            super(null);
        }

        @Override
        protected boolean match(Sprite s1, Sprite s2) {
            return true;
        }

        @Override
        protected void handleCollision(Sprite s1, Sprite s2) {

        }
    }
}
