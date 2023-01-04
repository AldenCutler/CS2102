import org.junit.Assert.*;

class Literarian {
    ChallengeResult ChallengeResult;
    Literarian (ChallengeResult ChallengeResult) {
        this.ChallengeResult = ChallengeResult;
    }

    public boolean betterBookworm(Literarian aLiterarian) {
        return aLiterarian.ChallengeResult.howClose() > ChallengeResult.howClose();
    }

    public boolean wittierWordsmith(Literarian aLiterarian) {
        return aLiterarian.ChallengeResult.WritingResult.averagePerDay() > ChallengeResult.WritingResult.averagePerDay();
    }

    public boolean succesfulScholar(Literarian aLiterarian) {
        if (betterBookworm(aLiterarian)) {
            return true;
        } else return wittierWordsmith(aLiterarian);
    }
}
