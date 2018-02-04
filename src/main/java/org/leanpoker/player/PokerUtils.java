package org.leanpoker.player;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.leanpoker.player.models.Game;
import org.leanpoker.player.models.HoleCard;
import org.leanpoker.player.models.PokerPlayer;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PokerUtils {
    private static List<Hand> preFlopHands = calculatePreFlopHands();

    public static int getActivePlayerCount(Game game) {
        int count = 0;
        for (PokerPlayer pokerPlayer : game.getPlayers()) {
            if ("active".equals(pokerPlayer.getStatus()))
                count++;
        }
        return count;
    }

    public static float getPreFlopProbability(Game game) {
        final Hand hand = new Hand(game);
        for (Hand preFlopHand : preFlopHands) {
            if (preFlopHand.equals(hand))
//                return preFlopHand.getWinProbability(getActivePlayerCount(game));
                return preFlopHand.getWinProbability(3);
        }
        return 0;
    }

    public static List<Hand> getPreFlopHands() {
        return preFlopHands;
    }

    private static List<Hand> calculatePreFlopHands() {
        final LinkedList<Hand> hands = new LinkedList<>();
        try {
            final List<String> readLines = FileUtils.readLines(new File("pre flop.txt"), Charsets.UTF_8);
            for (String line : readLines) {
                final String[] chunks = line.replace("%", "").replace("\n", "").split("\t");
                final float[] probabilities = new float[chunks.length - 1];
                for (int i = 0; i < probabilities.length; i++) {
                    probabilities[i] = Float.parseFloat(chunks[i + 1]);
                }
                hands.add(new Hand(chunks[0], probabilities));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hands;
    }

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

    public static int allIn(Game game) {
        return getMe(game).getStack();
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
