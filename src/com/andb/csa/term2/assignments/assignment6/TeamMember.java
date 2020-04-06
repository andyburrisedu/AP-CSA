package com.andb.csa.term2.assignments.assignment6;

public class TeamMember implements Comparable<TeamMember> {
    private String fullName;
    private String uniqueID;

    public TeamMember(String fullName, String uniqueID) {
        this.fullName = toTitleCase(fullName);
        this.uniqueID = uniqueID;
    }

    private static String toTitleCase(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            String append = input.substring(i, i + 1);
            if (i == 0 || Character.isWhitespace(input.charAt(i - 1))) {
                sb.append(append.toUpperCase());
            } else {
                sb.append(append.toLowerCase());
            }
        }
        return sb.toString();
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    @Override
    public int compareTo(TeamMember o) {
        int stringCompare = uniqueID.compareTo(o.getUniqueID());
        return polarize(stringCompare);
    }

    private int polarize(int input) {
        if (input == 0)
            return 0;
        else if (input < 0)
            return -1;
        else
            return 1;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
