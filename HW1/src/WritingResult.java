class WritingResult implements IChallenge{
    double numWords;
    int day;

    WritingResult (double numWords, Integer day) {
        this.numWords = numWords;
        this.day = day;
    }

    public double averagePerDay() {
        return numWords/day;
    }
    public double differenceFromGoal() {
        return (50000 - numWords)/(30 - day + 1);
    }

}
