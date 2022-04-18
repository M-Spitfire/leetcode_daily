package DFS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class _386 {
    List<Integer> res;
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>(n);   //已知数据量，可以使list不再进行扩容
        for (int i = 1; i < 10; i++){
            dfs(i, n);
        }
        return res;
    }

    private void dfs(int prefix, int limit) {
        if (prefix > limit) return;

        res.add(prefix);
        int base = prefix * 10;
        for (int i = 0; i < 10; i++){
            dfs(base + i, limit);
        }
    }

}
