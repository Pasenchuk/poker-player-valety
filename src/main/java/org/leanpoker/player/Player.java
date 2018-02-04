package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.leanpoker.player.models.Game;
import org.leanpoker.player.models.PokerPlayer;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        final Game game = new Gson().fromJson(request, Game.class);
        final PokerPlayer me = getMe(game);
        
        return 1000;
    }

    private static PokerPlayer getMe(Game game) {
        for (PokerPlayer pokerPlayer : game.getPlayers()) {
            if ("valEty".equals(pokerPlayer.getName()))
                return pokerPlayer;
        }
        return null;
    }

    public static void showdown(JsonElement game) {
    }
}
