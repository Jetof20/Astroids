package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import org.junit.Test;

import static org.junit.Assert.*;

public class AsteroidPluginTest {

    @Test
    public void demoInstantiation() {
        IGamePluginService astPlugin = new AsteroidPlugin();
        World w = new World();
        GameData g = new GameData();
        astPlugin.start(g,w);
        System.out.println(w.getEntities());
        assertFalse(w.getEntities().isEmpty());

        for (Entity e : w.getEntities()) {
            if (e.getClass() == Asteroid.class) {
                Asteroid ast = (Asteroid) e;
                // Check asteroid contains correct parts
                assertNotNull(ast.getSize());
                assertNotNull(ast.getRadius());
                assertNotNull(ast.getShapeX());
                assertNotNull(ast.getShapeY());
                assertNotNull(ast.getPart(MovingPart.class));
                assertNotNull(ast.getPart(PositionPart.class));
                assertNotNull(ast.getPart(LifePart.class));
            } else {
                fail();
            }
        }
    }

}