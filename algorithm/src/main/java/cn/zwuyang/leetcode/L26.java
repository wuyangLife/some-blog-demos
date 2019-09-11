package cn.zwuyang.leetcode;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wuyang
 **/
public class L26 {

    /**
     * 双指针捣鼓了半天 陷入了困局，
     * 一致朝着要实时把重复后面的数据前移，还考虑了尾元素补数据
     * 结果 官方题解 简直巧妙 如下：
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/
     **/
    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static void main(String[] args) {
        int[] a = {0,8,1,1,2,2,3,3,4};
        Arrays.toString(a);
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(a));
    }
}
