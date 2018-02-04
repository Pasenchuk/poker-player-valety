package org.leanpoker.player;

import org.leanpoker.player.models.Game;
import org.leanpoker.player.models.HoleCard;
import org.leanpoker.player.models.PokerPlayer;

public class PokerUtils {

    public static int getValueRank(HoleCard card) {
        switch (card.getRank()) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return 0;
        }
    }

    public static PokerPlayer getMe(Game game) {
        return game.getPlayers().get(game.getInAction());
    }

    public static int call(Game game) {
        final PokerPlayer me = getMe(game);
        return game.getCurrentBuyIn() - me.getBet();
    }

    public static int raise(Game game) {
        final PokerPlayer me = getMe(game);
        return game.getCurrentBuyIn() - me.getBet() + game.getMinimumRaise();
    }
}
