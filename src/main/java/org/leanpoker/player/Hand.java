package org.leanpoker.player;

import org.leanpoker.player.models.Game;
import org.leanpoker.player.models.Card;
import org.leanpoker.player.models.PokerPlayer;

import java.util.List;
import java.util.Objects;

import static org.leanpoker.player.PokerUtils.getMe;

public class Hand {

    private String card1, card2;
    private boolean suited;
    private float[] probabilities;

    public Hand(Game game) {
        final PokerPlayer me = getMe(game);
        final List<Card> holeCards = me.getHoleCards();
        card1 = holeCards.get(0).getRank().replace("10", "T");
        card2 = holeCards.get(1).getRank().replace("10", "T");
        suited = holeCards.get(0).getSuit().equals(holeCards.get(1).getSuit());
    }

    public Hand(String shortDescription, float[] probabilities) {
        this.probabilities = probabilities;
        final char[] chars = shortDescription.toCharArray();
        card1 = String.valueOf(chars[0]);
        card2 = String.valueOf(chars[1]);
        suited = chars.length == 3 && chars[2] == 's';
    }

    public boolean isSuited() {
        return suited;
    }

    public float getWinProbability(int numberOfPlayers) {
        return probabilities[numberOfPlayers - 2];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hand) {
            final Hand other = (Hand) obj;
            return ((Objects.equals(this.card1, other.card1) && Objects.equals(this.card2, other.card2)) || (
                    Objects.equals(this.card1, other.card2) && Objects.equals(this.card2, other.card1)))
                    && this.suited == other.suited;

        }
        return super.equals(obj);
    }
}
