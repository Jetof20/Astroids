package dk.sdu.mmmi.cbse.astroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.AsteroidPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.FloatingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class AsteroidPlugin implements IGamePluginService {

    private Entity asteroid;

    public AsteroidPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }

    private Entity createAsteroid(GameData gameData) {

        float speed = 10;
        float rotationSpeed = 2;
        float x = gameData.getDisplayWidth() * (float)Math.random();
        float y = gameData.getDisplayHeight() * (float)Math.random();
        float radians = 3.1415f / 2;

        Entity asteroid = new Asteroid(6);
        asteroid.add(new FloatingPart(speed,rotationSpeed,2));
        asteroid.add(new PositionPart(x, y, radians));
        asteroid.add(new AsteroidPart(new float[]{
                (float)Math.random()*12+4,
                (float)Math.random()*12+4,
                (float)Math.random()*12+4,
                (float)Math.random()*12+4,
                (float)Math.random()*12+4,
                (float)Math.random()*12+4
        }));

        return asteroid;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(asteroid);
    }
}
