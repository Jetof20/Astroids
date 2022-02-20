package dk.sdu.mmmi.cbse.common.data.entityparts;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

public class DespawnPart implements EntityPart{
    private int DespawnTime;

    public DespawnPart(int DespawnTime) {
        this.DespawnTime = DespawnTime;
    }
    @Override
    public void process(GameData gameData, Entity entity) {
        DespawnTime--;
    }

    public int getDespawnTime() {
        return DespawnTime;
    }
}
