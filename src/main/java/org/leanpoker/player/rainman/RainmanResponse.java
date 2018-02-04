package org.leanpoker.player.rainman;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.leanpoker.player.models.HoleCard;

import java.util.ArrayList;
import java.util.List;

public class RainmanResponse {


    @SerializedName("cards")
    @Expose
    private List<HoleCard> cards = new ArrayList<>();
    @SerializedName("cards_used")
    @Expose
    private List<HoleCard> cardsUsed = new ArrayList<>();
    @SerializedName("rank")
    @Expose
    private int rank;
    @SerializedName("value")
    @Expose
    private int value;
    @SerializedName("second_value")
    @Expose
    private int secondValue;
    @SerializedName("kickers")
    @Expose
    private List<Integer> kickers = new ArrayList<>();

    public List<HoleCard> getCards() {
        return cards;
    }

    public void setCards(List<HoleCard> cards) {
        this.cards = cards;
    }

    public List<HoleCard> getCardsUsed() {
        return cardsUsed;
    }

    public void setCardsUsed(List<HoleCard> cardsUsed) {
        this.cardsUsed = cardsUsed;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(int secondValue) {
        this.secondValue = secondValue;
    }

    public List<Integer> getKickers() {
        return kickers;
    }

    public void setKickers(List<Integer> kickers) {
        this.kickers = kickers;
    }
}
