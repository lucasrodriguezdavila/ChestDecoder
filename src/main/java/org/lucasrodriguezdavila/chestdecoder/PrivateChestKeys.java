package org.lucasrodriguezdavila.chestdecoder;

public enum PrivateChestKeys {
    // add keys with different values
    CODE("code"),
    PLAYERS("players_ids");

    public static final String code = "chestdecoder_code";
    public static final String players_ids = "chestdecoder_players_ids";

    PrivateChestKeys(String code) {
    }

    @Override
    public String toString() {
        return this.name();
    }
}
