package cn.zwuyang.algorithm.heapsort;

import java.util.PriorityQueue;

/**
 * leetcode 703. Kth Largest Element in a Stream
 *
 *  * Your KthLargest object will be instantiated and called as such:
 *  * KthLargest obj = new KthLargest(k, nums);
 *  * int param_1 = obj.add(val);
 *
 * @author wuyang
 **/
class KthLargest {

    private PriorityQueue<Integer> pq;
    int size=0;

    public KthLargest(int k, int[] nums) {
        size = k;
        pq = new PriorityQueue<>(k);
        for (int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        if (pq.size() < size) {
            pq.offer(val);
        }
        else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {6,3,4,5,7};
        KthLargest kthLargest = new KthLargest(2, nums);
        kthLargest.add(12);
        kthLargest.add(10);
    }
}
