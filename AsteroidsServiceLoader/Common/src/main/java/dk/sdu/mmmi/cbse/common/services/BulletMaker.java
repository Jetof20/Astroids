package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

public interface BulletMaker {
    Entity createBullet(Entity shooter, GameData gameData);
}
