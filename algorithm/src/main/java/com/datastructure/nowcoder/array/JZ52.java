package com.datastructure.nowcoder.array;

/**
 * @author hj
 * @date 2021-08-26 11:26 下午
 * @description 描述：给定一个数组A[0, 1, ..., n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，
 * B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 * <p>
 * 示例：
 * 输入：
 * [1,2,3,4,5]
 * 返回值：
 * [120,60,40,30,24]
 */
public class JZ52 {
    /**
     * 暴力的方法
     * 1.将A[i]赋值为1
     * 2.求A数组所有元素的乘积
     *
     * @param A
     * @return
     */
    public int[] multiply1(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        for (int i = 0; i < B.length; i++) {
        }
        return null;
    }
}
