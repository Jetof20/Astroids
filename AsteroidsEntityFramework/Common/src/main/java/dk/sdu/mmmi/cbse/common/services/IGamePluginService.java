package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IGamePluginService {
    /**
     * this method will be called when the game starts, put code here reliant on startup
     * @param gameData The gamedata
     * @param world The worlddata
     */
    void start(GameData gameData, World world);

    /**
     * this method is called when the game is stopped
     * @param gameData The gamedata
     * @param world The worlddata
     */
    void stop(GameData gameData, World world);
}
