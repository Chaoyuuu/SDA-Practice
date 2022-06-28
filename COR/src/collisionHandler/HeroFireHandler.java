package collisionHandler;

import sprites.Fire;
import sprites.Hero;
import sprites.Sprite;

public class HeroFireHandler extends CollisionHandler {
    public HeroFireHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    protected boolean match(Sprite s1, Sprite s2) {
        return (s1 instanceof Fire && s2 instanceof Hero) || (s1 instanceof Hero && s2 instanceof Fire);
    }

    @Override
    protected void handleCollision(Sprite s1, Sprite s2) {
        Fire fire = getFire(s1, s2);
        Hero hero = getHero(s1, s2);
        hero.move(fire.getLocation());
        hero.minusHP(10);
        fire.dead();
    }

    private Fire getFire(Sprite s1, Sprite s2) {
        if (s1 instanceof Fire) {
            return (Fire) s1;
        } else {
            return (Fire) s2;
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
