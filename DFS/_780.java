package DFS;

import org.junit.Test;

public class _780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty)return false;
        if (sx == tx)return 0 == (ty - sy) % tx;
        if (sy == ty)return 0 == (tx - sx) % ty;


        if (tx > ty){
            return reachingPoints(sx, sy, tx % ty, ty);
        }
        else {
            return reachingPoints(sx, sy, tx, ty % tx);
        }
    }

    @Test
    public void test(){
        System.out.println(reachingPoints(1,1,3,5));
    }
}
