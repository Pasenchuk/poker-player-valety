package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.leanpoker.player.models.Game;
import org.leanpoker.player.models.PokerPlayer;

public class Player {

    static final String VERSION = "v 0.1";

    public static int betRequest(JsonElement request) {
        final Game game = new Gson().fromJson(request, Game.class);

        final PokerPlayer me = getMe(game);
        final HoleCard hc1 = me.getHoleCards()[0];
        final HoleCard hc2 = me.getHoleCards()[1];

        final int currentPot = game.getPot();
        final int ourBank = me.getStack();

        if (hc1.getSuit() == hc2.getSuit()){
          return (int)(OurBank*0.5);
        } else {
          if (hc1.getRank() == hc2.getRank()) {
            return (int)(OurBank*0.3);
          }
        }

        return 10;
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
