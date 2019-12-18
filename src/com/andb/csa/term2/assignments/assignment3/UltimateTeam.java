package com.andb.csa.term2.assignments.assignment3;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class UltimateTeam {
    private ArrayList<UltimatePlayer> players;
    private ArrayList<Coach> coaches;

    public UltimateTeam(ArrayList<UltimatePlayer> players, ArrayList<Coach> coaches) {
        this.players = players;
        this.coaches = coaches;
    }

    private ArrayList<UltimatePlayer> getCuttersList() {
        return players.stream().filter(p -> p.getPosition().equals(UltimatePlayer.POSITION_CUTTER)).collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<UltimatePlayer> getHandlersList() {
        return players.stream().filter(p -> p.getPosition().equals(UltimatePlayer.POSITION_HANDLER)).collect(Collectors.toCollection(ArrayList::new));
    }

    public String getCutters() {
        StringBuilder sb = new StringBuilder();
        getCuttersList().forEach(cutter -> sb.append(cutter.toString()).append("\n"));
        return sb.toString();
    }

    public String getHandlers() {
        StringBuilder sb = new StringBuilder();
        getHandlersList().forEach(handler -> sb.append(handler.toString()).append("\n"));
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("COACHES\n");
        coaches.forEach(c -> sb.append(c.toString()).append("\n"));
        sb.append("\nPLAYERS\n");
        players.forEach(p -> sb.append(p.toString()).append("\n"));
        return sb.toString();
    }
}
