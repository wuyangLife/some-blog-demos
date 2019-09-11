package cn.zwuyang.algorithm.heapsort;

import java.util.Arrays;

/**
 * 堆排序
 * @author wuyang
 **/
public class HeapSort {
    public static void main(String []args){
        int []arr = {18,15,2,14,10};
        sortHeap(arr);
        System.out.println(Arrays.toString(arr));
    }


    private static int[] sortHeap(int[] arr) {
        // 构建大顶堆 只对父节点操作 并且是从下至上 从右至左
        for (int i=arr.length>>>2-1; i>=0; i--) {
            heapAdjust(arr, i, arr.length);
        }

        // 开始排序 把根节点和最后一个节点互换 然后对互换之后的堆进行重新建堆
        for (int i=arr.length-1; i>0; i--) {
            swap(arr, 0, i);
            // 为什么这里只调整根节点 是因为其余节点已经在之前调整过，只有根节点换了值
            // 所以只有根节点可能是不满足堆的要求 故只调整根节点即可
            heapAdjust(arr, 0, i);
        }

        return arr;
    }

    /**
     * 构建大顶堆
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr, int i, int length){
        int temp = arr[i];//先取出当前元素i
        for(int k = 2*i+1; k < length; k = k*2+1) {//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1 < length && arr[k] < arr[k+1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] > temp) { //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp; //将temp值放到最终的位置
    }

    /**
     * 交换元素
     * @param arr
     * @param a 下标a
     * @param b 下标b
     */
    public static void swap(int []arr, int a ,int b){
        //int temp=arr[a];
        //arr[a] = arr[b];
        //arr[b] = temp;

        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }



    /**
     * 构建大顶堆
     * @param arr 待调整数组
     * @param index 需要调整的数组下标
     * @param length 数组长度
     **/
    private static void heapAdjust(int[] arr, int index, int length) {

        // 取出当前元素
        int temp = arr[index];

        // 坐孩子下标为 2*index+1
        for (int i = 2*index+1; i<length; i=2*i+1) {
            // 判断左右孩子的大小
            if (i+1<length && arr[i]<arr[i+1]) {
                i++;
            }
            // 孩子比父节点大
            if (arr[i] > arr[index]) {
                arr[index] = arr[i];
                // 为了实现父节点值与孩子节点进行交换
                // 用index来记录下被交换掉的孩子节点的数组下标
                index = i;
            } else {
                break;
            }
            // 被调整的父节点的值赋值给被交换的孩子结点  完成交换
            arr[index] = temp;
        }
    }

}
