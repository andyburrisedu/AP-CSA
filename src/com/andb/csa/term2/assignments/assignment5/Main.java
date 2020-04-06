package com.andb.csa.term2.assignments.assignment5;

public class Main {
    public static void main(String[] args) {
        GameWheel wheel = new GameWheel();
        Slice spin1 = wheel.spinWheel();
        Slice spin2 = wheel.spinWheel();
        Slice spin3 = wheel.spinWheel();
        int totalPrize = spin1.getPrizeAmount() + spin2.getPrizeAmount() + spin3.getPrizeAmount();
        boolean sameColor = spin1.getColor().equals(spin2.getColor())
                && spin1.getColor().equals(spin3.getColor());
        if (sameColor) {
            totalPrize *= 2;
        }
        System.out.println("Total prize money: $" + totalPrize);
        System.out.println("Spin 1 - Color: " + spin1.getColor() + ", Prize Amount: $" + spin1.getPrizeAmount());
        System.out.println("Spin 2 - Color: " + spin2.getColor() + ", Prize Amount: $" + spin2.getPrizeAmount());
        System.out.println("Spin 3 - Color: " + spin3.getColor() + ", Prize Amount: $" + spin3.getPrizeAmount());

        if (sameColor) {
            System.out.println("Three " + spin1.getColor() + "s = double your money!");
        }
    }
}
