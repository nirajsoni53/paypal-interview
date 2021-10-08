package algoritham.sliding_window;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindowImproved {

    public int[] maxSlidingWindow(int[] A, int B) {

        int n = A.length;
        int [] res = new int[n-B+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int j = 0;
        for(int i = 0;i<n;i++)
        {
            int x = A[i];
            if(dq.size() !=0)
            {
                while(!dq.isEmpty() && (dq.peekLast()<x))
                    dq.pollLast();

                dq.addLast(x);
            }
            else
            {
                dq.addLast(x);
            }

            if(i>=B-1)
            {
                if(i>B-1)
                {
                    if(A[i-B]==dq.peekFirst())
                        dq.pollFirst();
                }
                res[j++] = dq.peekFirst();
            }


        }

        return res;

    }
}
