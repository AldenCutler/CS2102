public class ChallengeResult {
    ReadingResult ReadingResult;
    WritingResult WritingResult;

    ChallengeResult (ReadingResult ReadingResult, WritingResult WritingResult) {
        this.ReadingResult = ReadingResult;
        this.WritingResult = WritingResult;
    }

    public double howClose() {
        return (ReadingResult.differenceFromGoal() * 10000) + WritingResult.averagePerDay();
    }

}
