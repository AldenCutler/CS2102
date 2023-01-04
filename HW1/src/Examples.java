import org.junit.Test;
import static org.junit.Assert.*;

public class Examples {
    booksread brAlden = new booksread(4, 5);
    ReadingResult rrAlden = new ReadingResult(1,brAlden);
    WritingResult wrAlden = new WritingResult(700, 15);
    ChallengeResult crAlden = new ChallengeResult(rrAlden, wrAlden);
    Literarian Alden = new Literarian(crAlden);

    booksread brMax = new booksread(5, 7);
    ReadingResult rrMax  = new ReadingResult(3, brMax);
    WritingResult wrMax = new WritingResult(400, 10);
    ChallengeResult crMax = new ChallengeResult(rrMax, wrMax);
    Literarian Max = new Literarian(crMax);


    @Test
    public void rrbspd() {
        assertEquals(1, Alden.ChallengeResult.ReadingResult.bookspd);
        assertEquals(3, Max.ChallengeResult.ReadingResult.bookspd);
    }
    @Test
    public void bb() {
        assertTrue(Alden.betterBookworm(Max));
        assertFalse(Max.betterBookworm(Alden));
    }
    @Test
    public void ww() {
        assertFalse(Alden.wittierWordsmith(Max));
        assertTrue(Max.wittierWordsmith(Alden));
    }
}
