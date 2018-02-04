package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.leanpoker.player.models.Card;
import org.leanpoker.player.models.Game;
import org.leanpoker.player.models.PokerPlayer;
import org.leanpoker.player.rainman.RainmanResponse;
import org.leanpoker.player.rainman.RainmanUtils;

import java.util.LinkedList;

import static org.leanpoker.player.PokerUtils.*;

public class Player {

    static final String VERSION = "v 0.4";

    public static int betRequest(JsonElement request) {
        final Game game = new Gson().fromJson(request, Game.class);

        final int communityCardsCount = game.getCommunityCards().size();
        if (communityCardsCount == 0) {
            return preFlopStrategy(game);
        }
        if (communityCardsCount == 3) {
            final LinkedList<Card> cards = new LinkedList<>();
            cards.addAll(game.getCommunityCards());
            final PokerPlayer me = getMe(game);
            cards.addAll(me.getHoleCards());
            final RainmanResponse rank = RainmanUtils.getRank(cards);
            if (rank.getRank() >= 4) {
                final int halfOfBank = me.getStack() / 2;
                if (raise(game) > halfOfBank)
                    return raise(game);
                if (call(game)< halfOfBank)
                    return halfOfBank;
                 return call(game);
            }
        }

        return oldStrategy(game);
        // return preFlopStrategy(game);
    }

    private static int preFlopStrategy(Game game) {
        final PokerPlayer me = getMe(game);

        final float preFlopProbability = getPreFlopProbability(game);

        if (preFlopProbability > 60)
            return allIn(game);

        if (preFlopProbability > 50)
            return raise(game, preFlopProbability);

        if (preFlopProbability > 40) {
            final int call = call(game);
            if (call / me.getStack() < 0.5)
                return call;
        }

        return 0;
    }

    private static int oldStrategy(Game game) {
        final PokerPlayer me = getMe(game);

        final int currentPot = game.getPot();
        final int ourBank = me.getStack();

        final Card hc1 = me.getHoleCards().get(0);
        final Card hc2 = me.getHoleCards().get(1);

        final boolean suited = hc1.getSuit().equals(hc2.getSuit());
        final boolean pair = hc1.getRank().equals(hc2.getRank());

        if (game.getCurrentBuyIn() > (0.7 * ourBank)) {
            return 0;
        }

        return call(game);
    }

    public static void showdown(JsonElement game) {
    }


}
