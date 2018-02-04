package org.leanpoker.player.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Game {


    @SerializedName("tournament_id")
    @Expose
    private String tournamentId;
    @SerializedName("game_id")
    @Expose
    private String gameId;
    @SerializedName("round")
    @Expose
    private int round;
    @SerializedName("bet_index")
    @Expose
    private int betIndex;
    @SerializedName("small_blind")
    @Expose
    private int smallBlind;
    @SerializedName("current_buy_in")
    @Expose
    private int currentBuyIn;
    @SerializedName("pot")
    @Expose
    private int pot;
    @SerializedName("minimum_raise")
    @Expose
    private int minimumRaise;
    @SerializedName("dealer")
    @Expose
    private int dealer;
    @SerializedName("orbits")
    @Expose
    private int orbits;
    @SerializedName("in_action")
    @Expose
    private int inAction;
    @SerializedName("players")
    @Expose
    private List<Player> players = null;
    @SerializedName("community_cards")
    @Expose
    private List<CommunityCard> communityCards = null;

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getBetIndex() {
        return betIndex;
    }

    public void setBetIndex(int betIndex) {
        this.betIndex = betIndex;
    }

    public int getSmallBlind() {
        return smallBlind;
    }

    public void setSmallBlind(int smallBlind) {
        this.smallBlind = smallBlind;
    }

    public int getCurrentBuyIn() {
        return currentBuyIn;
    }

    public void setCurrentBuyIn(int currentBuyIn) {
        this.currentBuyIn = currentBuyIn;
    }

    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public int getMinimumRaise() {
        return minimumRaise;
    }

    public void setMinimumRaise(int minimumRaise) {
        this.minimumRaise = minimumRaise;
    }

    public int getDealer() {
        return dealer;
    }

    public void setDealer(int dealer) {
        this.dealer = dealer;
    }

    public int getOrbits() {
        return orbits;
    }

    public void setOrbits(int orbits) {
        this.orbits = orbits;
    }

    public int getInAction() {
        return inAction;
    }

    public void setInAction(int inAction) {
        this.inAction = inAction;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<CommunityCard> getCommunityCards() {
        return communityCards;
    }

    public void setCommunityCards(List<CommunityCard> communityCards) {
        this.communityCards = communityCards;
    }
}
