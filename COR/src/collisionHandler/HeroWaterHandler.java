package collisionHandler;

import sprites.Hero;
import sprites.Sprite;
import sprites.Water;

public class HeroWaterHandler extends CollisionHandler {
    public HeroWaterHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    protected boolean match(Sprite s1, Sprite s2) {
        return (s1 instanceof Water && s2 instanceof Hero) || (s1 instanceof Hero && s2 instanceof Water);
    }

    @Override
    protected void handleCollision(Sprite s1, Sprite s2) {
        Water water = getWater(s1, s2);
        Hero hero = getHero(s1, s2);
        hero.move(water.getLocation());
        hero.addHP(10);
        water.dead();
    }

    private Water getWater(Sprite s1, Sprite s2) {
        if (s1 instanceof Water) {
            return (Water) s1;
        } else {
            return (Water) s2;
        }
    }

    private Hero getHero(Sprite s1, Sprite s2) {
        if (s1 instanceof Hero) {
            return (Hero) s1;
        } else {
            return (Hero) s2;
        }
    }

}
