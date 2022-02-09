package dk.sdu.mmmi.cbse.common.data.entityparts;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class FloatingPart implements EntityPart {

    private float speed, rotationSpeed, driftRadians;

    public FloatingPart(float speed, float rotationSpeed,float driftRadians) {
        this.speed = speed;
        this.rotationSpeed = rotationSpeed;
        this.driftRadians = driftRadians;
    }

    @Override
    public void process(GameData gameData, Entity entity) {
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();
        float dt = gameData.getDelta();

        // handle static rotation
        radians += rotationSpeed * dt;

        // move astroid in direction
        x += cos(driftRadians) * speed * dt;
        y += sin(driftRadians) * speed * dt;

        if (x > gameData.getDisplayWidth()) {
            x = 0;
        }
        else if (x < 0) {
            x = gameData.getDisplayWidth();
        }
        if (y > gameData.getDisplayHeight()) {
            y = 0;
        }
        else if (y < 0) {
            y = gameData.getDisplayHeight();
        }


        positionPart.setX(x);
        positionPart.setY(y);
        positionPart.setRadians(radians);
    }
}
