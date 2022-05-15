package Design;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _933 {
    class RecentCounter {

        private List<Integer> req;
        private int startIndex = 0;
        public RecentCounter() {
            this.req = new ArrayList<>();
        }

        public int ping(int t) {
            req.add(t);
            int index = Collections.binarySearch(req, t - 3000);
            startIndex = index < 0 ? -index - 1 : index;
            return req.size() - startIndex;
        }
    }

    @Test
    public void test(){
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));
        System.out.println(counter.ping(2));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));
    }

    @Test
    public void testBinarySearch(){

        List<Integer> list = Arrays.asList(1,3,5,7,9);
        System.out.println(Collections.binarySearch(list, 2));
        System.out.println(Collections.binarySearch(list, 3));
        System.out.println(Collections.binarySearch(list, 4));
    }
}
