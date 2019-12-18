package com.andb.csa.term2.labs.magpie.activity2;

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 *
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2 {
    /**
     * Get a default greeting
     *
     * @return a greeting
     */
    public String getGreeting() {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement) {
        String response = "";
        if (statement.trim().length() == 0) {
            response = "Say something, please.";
        } else if (statement.contains("say")) {
            response = statement.substring((statement.indexOf("say") + 4));
        } else if (statement.contains("you")) {
            response = "I'm a computer, I can't really answer that";
        } else if (statement.contains("no")) {
            response = "Why so negative?";
        } else if (statement.contains("mother")
                || statement.contains("father")
                || statement.contains("sister")
                || statement.contains("brother")) {
            response = "Tell me more about your family.";
        } else if (statement.contains("dog")
                || statement.contains("cat")) {
            response = "Tell me more about your pets.";
        } else if (statement.contains("Mr. Jacoby")) {
            response = "He sounds like a good teacher.";
        } else if (statement.contains("food")
                || statement.contains("eat")) {
            response = "What are your favorite foods?";
        } else {
            response = getRandomResponse();
        }
        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     *
     * @return a non-committal string
     */
    private String getRandomResponse() {
        final int NUMBER_OF_RESPONSES = 5;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        switch (whichResponse) {
            case 0:
                response = "Interesting, tell me more.";
                break;
            case 1:
                response = "Hmmm.";
                break;
            case 2:
                response = "Do you really think so?";
                break;
            case 3:
                response = "You don't say.";
                break;
            case 4:
                response = "Keep going...";
                break;
            case 5:
                response = "Huh.";
        }

        return response;
    }
}
