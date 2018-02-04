package org.leanpoker.player.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Player {


    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("stack")
    @Expose
    private int stack;
    @SerializedName("bet")
    @Expose
    private int bet;
    @SerializedName("hole_cards")
    @Expose
    private List<HoleCard> holeCards = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public List<HoleCard> getHoleCards() {
        return holeCards;
    }

    public void setHoleCards(List<HoleCard> holeCards) {
        this.holeCards = holeCards;
    }
}
