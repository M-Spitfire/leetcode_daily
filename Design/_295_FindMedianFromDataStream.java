package Design;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _295_FindMedianFromDataStream {
    class MedianFinder{

        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        /** initialize your data structure here. */
        public MedianFinder() {
            //小于中位数的部分用大顶堆
            left = new PriorityQueue<>((o1, o2) -> o2 - o1);
            //大于中位数的部分用小顶堆
            right = new PriorityQueue<>();
        }

        /**
         * 维护左右两个优先队列，使其满足下列两个条件：
         * 1. 当数量为奇数时，中位数是left的队首元素
         * 2. 当数量为偶数时，中位数时left和right队首元素的平均值
         */
        public void addNum(int num) {
            if(left.isEmpty() || num < left.peek()){
                left.offer(num);
                if(left.size() > right.size() + 1){
                    right.offer(left.poll());
                }
            }
            else{
                right.offer(num);
                if(right.size() > left.size()){
                    left.offer(right.poll());
                }
            }
        }

        public double findMedian() {
            if(left.size() > right.size()){
                return left.peek();
            }
            return (left.peek() + right.peek()) / 2.0;
        }
        /**
         * Your MedianFinder object will be instantiated and called as such:
         * MedianFinder obj = new MedianFinder();
         * obj.addNum(num);
         * double param_2 = obj.findMedian();
         */
    }
}
