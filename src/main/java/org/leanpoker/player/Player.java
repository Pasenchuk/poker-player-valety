package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.leanpoker.player.models.Game;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        final Game game = new Gson().fromJson(request, Game.class);
        return 1000;
    }

    public static void showdown(JsonElement game) {
    }
}
