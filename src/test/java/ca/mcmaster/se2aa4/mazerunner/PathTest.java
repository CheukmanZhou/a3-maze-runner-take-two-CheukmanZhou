package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class PathTest {
    @Test
    void expandFactorizedStringPathTest() {
        Path path = new Path();
        assertEquals("FFF RRR LLL", path.expandFactorizedStringPath("3F 3R 3L"));
    }
    
    @Test
    void getPathStepsTest() {
        Path path = new Path("FFF");
        ArrayList<Character> expected = new ArrayList<Character>();
        expected.add('F');
        expected.add('F');
        expected.add('F');

        assertEquals(expected, path.getPathSteps());
    }

    @Test
    void addStepTest() {
        Path path = new Path("F");
        path.addStep('F');
        
        ArrayList<Character> expected = new ArrayList<Character>();
        expected.add('F');
        expected.add('F');

        assertEquals(expected, path.getPathSteps());
    }

    @Test
    void getCanonicalFormTest() {
        Path path = new Path("FLFFFFFRFFRFFLFFFFFFRFFFFLF");

        assertEquals("F L FFFFF R FF R FF L FFFFFF R FFFF L F", path.getCanonicalForm());
    }

    @Test
    void getFactorizedFormTest() {
        Path path = new Path("FLFFFFFRFFRFFLFFFFFFRFFFFLF");

        assertEquals("F L 5F R 2F R 2F L 6F R 4F L F", path.getFactorizedForm());
    }
}