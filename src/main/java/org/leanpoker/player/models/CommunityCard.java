package org.leanpoker.player.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommunityCard {

    @SerializedName("rank")
    @Expose
    private String rank;
    @SerializedName("suit")
    @Expose
    private String suit;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}
