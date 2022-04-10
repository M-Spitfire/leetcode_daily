package Hash;

import org.junit.Test;

import java.util.*;

public class _1606 {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int len = arrival.length;
        int[] count = new int[k];
        int max = 0;
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        TreeSet<Integer> available = new TreeSet<>();   //不提供比较器默认按照自然排序，数字就是升序
        //初始状态所有处理器都是空闲的
        for (int i = 0; i < k; i++){
            available.add(i);
        }
        for (int i = 0; i < len; i++){
            //1. 首先将busy中已经完成任务的处理器移动到available中
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]){
                available.add(busy.poll()[1]);
            }
            //2. 如果available中没有处理器，丢弃该请求
            if (available.isEmpty())continue;
            //3. 查找处理该请求的处理器编号
            Integer index = available.ceiling(i % k);
            if (index == null){
                index = available.first();
            }
            //4. 处理该请求的处理器编号的完成任务量加一；将该处理器加入busy中；将该处理器从available中移除
            count[index] += 1;
            if (count[index] > max) max = count[index];
            busy.add(new int[]{arrival[i] + load[i], index});
            available.remove(index);
        }

        for (int i = 0; i < k; i++){
            if (count[i] == max){
                res.add(i);
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{5,2,3,3,3};
        System.out.println(busiestServers(3, arr1, arr2));
    }
}
