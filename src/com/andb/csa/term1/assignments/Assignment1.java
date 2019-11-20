package com.andb.csa.term1.assignments;

import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int web1 = scanner.nextInt();
        int web2 = scanner.nextInt();
        int web3 = scanner.nextInt();
        double focus1 = scanner.nextDouble();
        double focus2 = scanner.nextDouble();
        double critic = scanner.nextDouble();

        double webAvg = (double) (web1 + web2 + web3) / 3;
        double focusAvg = (focus1 + focus2) / 2;
        System.out.println("Average website rating: " + webAvg);
        System.out.println("Average focus group rating: " + focusAvg);
        System.out.println("Average movie critic rating: " + critic);

        double overall = (webAvg * .20) + (focusAvg * .30) + (critic * .50);

        System.out.println("Overall movie rating: " + overall);
    }
}
