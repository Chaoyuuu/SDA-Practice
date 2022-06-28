package sprites;

public class Hero extends Sprite {
    private int hp = 30;

    public Hero(int location) {
        super(location, 'H');
    }

    public void addHP(int hp) {
        this.hp += hp;
    }

    public void minusHP(int hp) {
        this.hp -= hp;
        if (this.hp < 0) {
            this.dead();
        }
    }
}
