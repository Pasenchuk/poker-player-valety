package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.leanpoker.player.models.Game;
import org.leanpoker.player.models.HoleCard;
import org.leanpoker.player.models.PokerPlayer;

public class Player {

    static final String VERSION = "v 0.1";

    public static int betRequest(JsonElement request) {
        final Game game = new Gson().fromJson(request, Game.class);

        final PokerPlayer me = getMe(game);

        final HoleCard hc1 = me.getHoleCards().get(0);
        final HoleCard hc2 = me.getHoleCards().get(1);

        final int currentPot = game.getPot();
        final int ourBank = me.getStack();

        if (hc1.getSuit().equals(hc2.getSuit())) {
            return (int) (ourBank * 0.5);
        } else {
            if (hc1.getRank().equals(hc2.getRank())) {
                return (int) (ourBank * 0.3);
            }
        }

        return game.getSmallBlind();

//        return call(game);
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
