package org.lucasrodriguezdavila.chestdecoder.models;

import java.io.Serializable;
import java.util.ArrayList;

public class PrivateChestInformation implements Serializable {
    private static final long serialVersionUID = 1L;
    private String playerID;
    private String code;
    private final ArrayList<String> playerIDs;

    public PrivateChestInformation(String playerID, String code) {
        this.playerID = playerID;
        this.code = code;
        playerIDs = new ArrayList<>();
    }

    public void addPlayerID(String playerID) {
        playerIDs.add(playerID);
    }

    public boolean hasPlayerID(String playerID) {
        return playerIDs.contains(playerID);
    }

    public boolean isCode(String code) {
        return this.code.equals(code);
    }

    public void removePlayerID(String playerID) {
        playerIDs.remove(playerID);
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }
}
