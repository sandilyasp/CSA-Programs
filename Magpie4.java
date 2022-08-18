/*
   Sandilya Parimi
   12/11/2022

   Program will carry on conversations with a human user
   Will use advanced search for keywords
   Will transform statements as well as react to keywords
*/
//import java.util.MagpieRunner4;

public class Magpie4 {
    //Get a default greeting and return it
    public String getGreeting() {
        return "Hello, let's talk.";
    }
    //Gives a response to a user statement and returns a response based on the rules given

    public String getResponse(String statement) {
        String response = "";
        if (statement.length() == 0) {
            response = "Say something, please.";
        } else if (findKeyword(statement, "no") >= 0) {
            response = "Why so negative?";
        } else if (findKeyword(statement, "mother") >= 0
                || findKeyword(statement, "father") >= 0
                || findKeyword(statement, "sister") >= 0
                || findKeyword(statement, "brother") >= 0) {
            response = "Tell me more about your family.";
        }

        // Responses which require transformations
        else if (findKeyword(statement, "I want to", 0) >= 0) {
            response = transformIWantToStatement(statement);
        }

        // ADD Responses which require transformations!
        else if (findKeyword(statement, "I want", 0) >= 0) {
            response = transformIWantStatement(statement);
        } else if (findKeyword(statement, "me", (findKeyword(statement, "you", 0))) >=
                0) {
            // Look for a two word (you <something> me) pattern
            int psn = findKeyword(statement, "you", 0);

            if (psn >= 0
                    && findKeyword(statement, "me", psn) >= 0) {
                response = transformYouMeStatement(statement);
            } else {
                response = getRandomResponse();
            }
        } else {
            // Look for a two word (I <something> you) pattern
            int psn = findKeyword(statement, "I", 0);

            if (psn >= 0
                    && findKeyword(statement, "you", psn) >= 0) {
                response = transformIMeStatement(statement);
            } else {
                response = getRandomResponse();
            }
        }
        return response;
    }

    //Takes a statement with I want to, and returns it as what it would mean to
    private String transformIWantToStatement(String statement) {
        //Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement.length() - 1);
        }
        int psn = findKeyword(statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "What would it mean to " + restOfStatement + "?";
    }

    //Takes a statement with "I want <something>." and returns it as "Would you really be happy if you had <something>?"

    private String transformIWantStatement(String statement) {
        //Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement.length() - 1);
        }
        int psn = findKeyword(statement, "I want", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "Would you really be happy if you had " + restOfStatement + "?";
    }
    //Takes a statement with "I <something> you" and returns it as "Why do you <something> me?"

    private String transformIMeStatement(String statement) {
        //Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement.length() - 1);
        }

        int psnOfI = findKeyword(statement, "I", 0);
        int psnOfU = findKeyword(statement, "you", psnOfI + 1);

        String restOfStatement = statement.substring(psnOfI + 1, psnOfU).trim();
        return "Why do you " + restOfStatement + " me?";
    }

    //Takes a statement with "you <something> me" and return it as "What makes you think that I<something> you?"

    private String transformYouMeStatement(String statement) {
        //Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement.length() - 1);
        }

        int psnOfYou = findKeyword(statement, "you", 0);
        int psnOfMe = findKeyword(statement, "me", psnOfYou + 3);

        String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
        return "What makes you think that I " + restOfStatement + " you?";
    }

    //Searches for one word in phrase and checks that the goal is not a substring of a longer string

    private int findKeyword(String statement, String goal, int startPos) {
        String phrase = statement.trim();
        //  The only change to incorporate the startPos is in the line below
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
        //  Refinement--make sure the goal isn't part of a word
        while (psn >= 0) {
            //  Find the string of length 1 before and after the word
            String before = " ", after = " ";
            if (psn > 0) {
                before = phrase.substring(psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length()) {
                after = phrase.substring(psn + goal.length(), psn + goal.length() +
                        1).toLowerCase();
            }
            //  If before and after aren't letters, we've found the word
            if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0))  // before is not a letter
                    && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
            {
                return psn;
            }
            //  The last position didn't work, so let's find the next, if there is one.
                    psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
        }
        return -1;
    }

    //Searches for one word in phrase and checks that the given goal is not a substring of a longer string

    private int findKeyword(String statement, String goal) {
        return findKeyword(statement, goal, 0);
    }

    //Picks a default response to use if nothing else fits.
    private String getRandomResponse() {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0) {
            response = "Interesting, tell me more.";
        } else if (whichResponse == 1) {
            response = "Hmmm.";
        } else if (whichResponse == 2) {
            response = "Do you really think so?";
        } else if (whichResponse == 3) {
            response = "You don't say.";
        } else if (whichResponse == 4) {
            response = "Wow, you seem to know a lot about this!";
        } else if (whichResponse == 5) {
            response = "What an interesting thing to say!";
        }

        return response;
    }

    public String getGoodbye() {
        return "It was fun talking to you. See ya later!";
    }

    public static void main(String[] args) {
        Magpie4 maggie = new Magpie4();
        String statement = "I love you.";
        System.out.println("Statement: " + statement);
        System.out.println("Response: " + maggie.getResponse(statement));
    }
}