package dk.sdu.mmmi.cbse.common.data.entityparts;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

public class AsteroidPart implements EntityPart {

    private float[] vertexdistfromcenter;

    public AsteroidPart(float[] vertexdistfromcenter) {
        this.vertexdistfromcenter = vertexdistfromcenter;
    }
    public float[] getVerts() {
        return vertexdistfromcenter;
    }
    public float getVert(int id) {
        return vertexdistfromcenter[id];
    }
    public float vertLength() {
        return vertexdistfromcenter.length;
    }

    @Override
    public void process(GameData gameData, Entity entity) {

    }

}
