package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.leanpoker.player.models.Game;
import org.leanpoker.player.models.PokerPlayer;

public class Player {

    static final String VERSION = "v0.2 calling";

    public static int betRequest(JsonElement request) {
        final Game game = new Gson().fromJson(request, Game.class);
        final PokerPlayer me = getMe(game);

        return call(game);
    }

    public static void showdown(JsonElement game) {
    }

    private static PokerPlayer getMe(Game game) {
        return game.getPlayers().get(game.getInAction());
    }

    private static int call(Game game) {
        final PokerPlayer me = getMe(game);
        return game.getCurrentBuyIn() - me.getBet();
    }

    private static int raise(Game game) {
        final PokerPlayer me = getMe(game);
        return game.getCurrentBuyIn() - me.getBet() + game.getMinimumRaise();
    }
}
