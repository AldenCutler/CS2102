public class Candidate {
    String name;
    private int firstChoiceVotes;
    private int secondChoiceVotes;
    private int thirdChoiceVotes;



    public Candidate(String name) {
        this.name = name;
        this.firstChoiceVotes = 0;
        this.secondChoiceVotes = 0;
        this.thirdChoiceVotes = 0;
    }


    /**
     *
     * @param rank represents the user's first, second, or third choice
     */
    public void vote(int rank) {
        if (rank == 1) firstChoiceVotes++;
        else if (rank == 2) secondChoiceVotes++;
        else if (rank == 3) thirdChoiceVotes++;
    }


    /**
     *
     * @return the number of firstChoiceVotes
     */
    public int getFirstVotes () {
        return this.firstChoiceVotes;
    }

    /**
     *
     * @return calculates the adjusted number of votes depending on the user's first, second, and third choices
     */
    public int getPoints () {
        return (3 * this.firstChoiceVotes)
                + (2 * this.secondChoiceVotes)
                + this.thirdChoiceVotes;
    }
}