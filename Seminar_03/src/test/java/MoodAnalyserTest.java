import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoodAnalyserTest {
    MoodAnalyser mA;
    @BeforeEach
    void testInit(){
        mA = new MoodAnalyser();
    }
    @Test
    void testAnalyserMoodIsGood(){
        assertEquals("Good day", mA.analyseMood("i have a good mood"));
    }
    @Test
    void testAnalyserMoodIsBad(){
        assertEquals("Bad day", mA.analyseMood("i have a sad mood"));
    }
    @Test
    void testAnalyserMoodIsNeutral(){
        assertEquals("Neutral day", mA.analyseMood("i have a usual mood"));
    }
}
