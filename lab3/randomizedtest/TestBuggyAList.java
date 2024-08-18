package randomizedtest;

import com.google.errorprone.annotations.FormatString;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    private void addLastToBoth(AListNoResizing<Integer> correct, BuggyAList<Integer> broken, int num) {
        correct.addLast(num);
        broken.addLast(num);
    }

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        addLastToBoth(correct, broken, 4);
        addLastToBoth(correct, broken, 5);
        addLastToBoth(correct, broken, 6);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                broken.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeBroken = broken.size();
            } else if (operationNumber == 2) {
                if (L.size() > 0) {
                    int last = L.getLast();
                    int lastBroken = broken.getLast();
                }
            } else if (operationNumber == 3) {
                if (L.size() > 0) {
                    int removeNum = L.removeLast();
                    int removeNumBroken = broken.removeLast();
                }
            }
        }
    }
}
