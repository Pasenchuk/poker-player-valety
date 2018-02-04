package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.leanpoker.player.models.Game;
import org.leanpoker.player.models.HoleCard;
import org.leanpoker.player.models.PokerPlayer;

import java.util.Random;

import static org.leanpoker.player.PokerUtils.*;

public class Player {

    static final String VERSION = "v 0.4";

    public static int betRequest(JsonElement request) {
        final Game game = new Gson().fromJson(request, Game.class);

        final boolean preflopGaming = game.getCommunityCards().size() > 0 ? false : true;
        if (preflopGaming) {
          return preFlopStrategy(game);
        } else {
          return oldStrategy(game);
        }
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
            if (call < me.getStack())
                return call;
        }

        return 0;

    }

    private static int oldStrategy(Game game) {
        final PokerPlayer me = getMe(game);

        final HoleCard hc1 = me.getHoleCards().get(0);
        final HoleCard hc2 = me.getHoleCards().get(1);

        final int currentPot = game.getPot();
        final int ourBank = me.getStack();

        final boolean suited = hc1.getSuit().equals(hc2.getSuit());
        final boolean pair = hc1.getRank().equals(hc2.getRank());

//         final boolean preflopGaming = game.getCommunityCards().size() > 0 ? false : true;
//
// //        if (suited && pair)
// //            return raise(game);
//         if (preflopGaming) {
//             // PREFLOP only 2 cards on hands
//
//             int r1 = getValueRank(hc1);
//             int r2 = getValueRank(hc2);
//
//             if (suited) {
//                 //            return (int) (ourBank * 0.5);
//                 if (r1 > 9 && r2 > 9) {
//                     return call(game);
//                 } else {
//                     return 0;
//                 }
//             }
//
//             if (pair) {
//                 //            return (int) (ourBank * 0.3);
//                 if (r1 > 9 && r2 > 9) {
//                     return ourBank;
//                 } else {
//                     Random rand = new Random();
//                     int value = rand.nextInt(8) + 2;
//
//                     if (r1 > value) {
//                         return call(game);
//                     }
//
//                     return 0;
//                 }
//
//                 // return raise(game);
//             }
//             //        return game.getSmallBlind();
//
//             if (r1 >= 12 || r2 >= 12) {
//                 return call(game);
//             }
//
//             return 0;

        // } else {
            // FLOP, TURN, RIVER

            if (game.getCurrentBuyIn() > (0.3 * ourBank)) {
                return 0;
            }

            return call(game);
        // }
    }

    public static void showdown(JsonElement game) {
    }


}
