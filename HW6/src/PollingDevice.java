import java.util.Scanner;
import java.util.Set;

public class PollingDevice {
    VotingData data = new VotingData();
    private Scanner keyboard = new Scanner(System.in);


    /**
     * prints the list of candidates to the screen
     */
    public void printBallot() {
        System.out.println("The candidates are ");
        for (String s : data.getCandidates()) {
            System.out.println(s);
        }
    }

    /**
     * User interface for voting
     * If a CandidateNotFoundException is caught, tell the user then ask if they want to add the given candidate to the ballot.
     * If a CandidateChosenMoreThanOnceException is caught, tell the user that candidate has duplicate votes.
     */
    public void screen() {
        this.printBallot();
        System.out.println("\nEnter your first choice:");
        String first = keyboard.nextLine();
        System.out.println("Enter your second choice:");
        String second = keyboard.nextLine();
        System.out.println("Enter your third choice:");
        String third = keyboard.nextLine();
        try {
            data.submitVote(first, second, third);
            System.out.println("You voted for " + first + ", " + second + ", and " + third + "!");
        } catch (CandidateNotFoundException e) {
            System.out.println("Error! Candidate " + e.name + " isn't running! Would you like to add " + e.name + " to the ballot?");
            String shouldAddWriteIn = keyboard.nextLine();
            if (shouldAddWriteIn.equals("y") || shouldAddWriteIn.equals("Y")) addWriteIn(e.name);
            System.out.println("Restarting voting process...\n");
            this.screen();
        } catch (CandidateChosenMoreThanOnceException e) {
            System.out.println("Error! Candidate " + e.name + " has duplicate votes!");
        }
    }


    /**
     *
     * Takes a string and adds that string to the ballot. If a RedundantCandidateException is caught, let the user know
     * @param name represents the name of the candidate to be added
     */
    private void addWriteIn(String name) {
        try {
            data.nominateCandidate(name);
            System.out.println("Candidate added successfully!");
        } catch (RedundantCandidateException e) {
            System.out.println("Candidate " + e.name + " already exists!");
        }
    }
}