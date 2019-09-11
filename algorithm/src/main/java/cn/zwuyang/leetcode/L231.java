package cn.zwuyang.leetcode;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方
 *
 * 核心是2的幂次方的数的二进制表示中，只有一位是1，非最高位，最高位是符号位，表示负数
 * @author wuyang
 **/
public class L231 {

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(-2147483648));
    }

    /** 解法1 **/
    public static boolean isPowerOfTwo(int n) {

        if (n <= 0) {
            return false;
        }

        String value = Integer.toBinaryString(n);
        int i = 0;
        char[] values = value.toCharArray();
        for (char c : values) {
            if (c == '1') {
                i++;
            }
        }

        return i==1;
    }

    /**
     * 解法2
     * 这种解法是说 如果这个数只有一个是1，那么减一以后应该原来的1变成0，原来的1后面的0全部变成1，
     * 基于这一点，做位运算出来一定是全0
     **/
    public static boolean isPowerOfTwo2(int n) {
        return n>0 && (n & (n-1))==0;
    }
}
