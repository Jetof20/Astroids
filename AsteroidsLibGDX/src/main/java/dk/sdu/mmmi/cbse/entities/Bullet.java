package dk.sdu.mmmi.cbse.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.mmmi.cbse.main.Game;

public class Bullet extends SpaceObject{

    public Bullet() {
        x = Game.WIDTH / 2;
        y = Game.HEIGHT / 2;
        radians = 0;

        shapex = new float[4];
        shapey = new float[4];

        radians = 3.1415f / 2;
    }

    public void update(float dt) {

    }

    private void setShape() {
        shapex[0] = x;
        shapey[0] = y;
    }

    public void draw(ShapeRenderer sr) {

    }
}
