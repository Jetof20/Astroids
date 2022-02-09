package dk.sdu.mmmi.cbse.astroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.AsteroidPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.FloatingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class AsteroidControlSystem implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        for (Entity aste : world.getEntities(Asteroid.class)) {

            FloatingPart floatingPart = aste.getPart(FloatingPart.class);
            PositionPart positionPart = aste.getPart(PositionPart.class);
            AsteroidPart asteroidPart = aste.getPart(AsteroidPart.class);

            positionPart.process(gameData, aste);
            floatingPart.process(gameData, aste);
            asteroidPart.process(gameData, aste);

            updateShape(aste,asteroidPart);
        }
    }

    private void updateShape(Entity entity, AsteroidPart apart) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * apart.getVert(0));
        shapey[0] = (float) (y + Math.sin(radians) * apart.getVert(0));

        shapex[1] = (float) (x + Math.cos(radians + 3.1415f * 1/(apart.vertLength()*0.5)) * apart.getVert(1));
        shapey[1] = (float) (y + Math.sin(radians + 3.1415f * 1/(apart.vertLength()*0.5)) * apart.getVert(1));

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f * 2/(apart.vertLength()*0.5)) * apart.getVert(2));
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f * 2/(apart.vertLength()*0.5)) * apart.getVert(2));

        shapex[3] = (float) (x + Math.cos(radians + 3.1415f * 3/(apart.vertLength()*0.5)) * apart.getVert(3));
        shapey[3] = (float) (y + Math.sin(radians + 3.1415f * 3/(apart.vertLength()*0.5)) * apart.getVert(3));

        shapex[4] = (float) (x + Math.cos(radians + 3.1415f * 4/(apart.vertLength()*0.5)) * apart.getVert(4));
        shapey[4] = (float) (y + Math.sin(radians + 3.1415f * 4/(apart.vertLength()*0.5)) * apart.getVert(4));

        shapex[5] = (float) (x + Math.cos(radians + 3.1415f * 5/(apart.vertLength()*0.5)) * apart.getVert(5));
        shapey[5] = (float) (y + Math.sin(radians + 3.1415f * 5/(apart.vertLength()*0.5)) * apart.getVert(5));


        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }
}
