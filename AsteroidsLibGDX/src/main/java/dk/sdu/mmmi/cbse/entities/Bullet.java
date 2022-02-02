package dk.sdu.mmmi.cbse.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class Bullet extends SpaceObject{
    protected int tick = 0;
    public Bullet(float x,float y,float radian) {
        radians = radian;
        this.x = x + MathUtils.cos(radians) * 10;
        this.y = y + MathUtils.sin(radians) * 10;

        shapex = new float[4];
        shapey = new float[4];
    }

    public void update(float dt) {
        x = x + MathUtils.cos(radians) * dt * 100;
        y = y + MathUtils.sin(radians) * dt * 100;
        tick++;
        setShape();
        wrap();
    }

    private void setShape() {
        shapex[0] = x + 3;
        shapey[0] = y;

        shapex[1] = x;
        shapey[1] = y + 3;

        shapex[2] = x - 3;
        shapey[2] = y;

        shapex[3] = x;
        shapey[3] = y - 3;
    }

    public void draw(ShapeRenderer sr) {
        sr.setColor(0, 1, 0, 1);

        sr.begin(ShapeRenderer.ShapeType.Line);

        for (int i = 0, j = shapex.length - 1;
             i < shapex.length;
             j = i++) {

            sr.line(shapex[i], shapey[i], shapex[j], shapey[j]);

        }

        sr.end();
    }

    public int getTick() {return tick;}
}
