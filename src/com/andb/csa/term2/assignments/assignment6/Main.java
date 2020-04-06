package com.andb.csa.term2.assignments.assignment6;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        ArrayList<TeamMember> team = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the next name:");
            String name = scanner.nextLine();

            if (name.toLowerCase().trim().equals("stop")) {
                break;
            }

            System.out.println("Enter the next ID:");
            String id = scanner.nextLine();

            if (id.toLowerCase().equals("stop")) {
                break;
            }

            TeamMember member = new TeamMember(name, id);
            addSorted(team, member);
        }

        System.out.println(team);
        System.out.println(team.stream().map(TeamMember::getUniqueID).collect(Collectors.toList()));
    }

    private static void addSorted(ArrayList<TeamMember> sortedList, TeamMember value) {
        for (int i = 0; i < sortedList.size(); i++) {
            TeamMember toCompare = sortedList.get(i);
            int comparison = value.compareTo(toCompare);
            //System.out.println("comparing " + toCompare + " to " + value + " returns " + comparison);
            if (comparison <= 0) {
                sortedList.add(i, value);
                return;
            }
        }
        sortedList.add(value);
    }
}
