package world;

import collisionHandler.CollisionHandler;
import collisionHandler.CollisionHandler.DummyHandler;
import collisionHandler.HeroFireHandler;
import collisionHandler.HeroWaterHandler;
import collisionHandler.WaterFireHandler;
import sprites.Fire;
import sprites.Hero;
import sprites.Sprite;
import sprites.Water;

import java.util.*;

public class World {
    private final int mapSize;
    private final List<Sprite> sprites = new ArrayList<>();
    private final CollisionHandler handler = new HeroFireHandler(new HeroWaterHandler(new WaterFireHandler(new DummyHandler())));

    public World(int mapSize) {
        this.mapSize = mapSize;
        init();
    }

    public void move(int from, int to) {
        handler.collide(sprites.get(from), sprites.get(to));
    }

    private void init() {
        for (int i = 0; i < 3; i++) {
            sprites.add(new Fire(i));
        }
        for (int i = 3; i < 7; i++) {
            sprites.add(new Water(i));
        }
        for (int i = 7; i < 10; i++) {
            sprites.add(new Hero(i));
        }
        for (int i = 10; i < mapSize; i++) {
            sprites.add(null);
        }
        Collections.shuffle(sprites);
    }

    private void printMap() {
        sprites.stream().filter(s -> s != null && s.isAlive())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        int mapSize = 30;
        Random random = new Random();
        World world = new World(mapSize);
        world.printMap();

        for (int i = 0; i < 5; i++) {
            world.move(random.nextInt(mapSize), random.nextInt(mapSize));
            world.printMap();
        }
    }
}
