package com.interview.books.leetcodeoj;

/**
 * Created_By: stefanie
 * Date: 14-12-22
 * Time: 下午2:39
 */
public class LOJ45_JumpGameII {
    //scan from begin to last, find the min step from the first element to i-th element
    //only scan the point is reachable from the first element
    //1. if(A[0] >= i) steps[i] = 1;
    //2. find a jump point from 1 ~ i - 1; steps[j] != Integer.MAX_VALUE && j + A[j] >= i(could reach)
    //3. return steps[A.length - 1]
    public int jump(int[] A) {
        int[] steps = new int[A.length];
        steps[0] = 0;
        for(int i = 1; i < A.length; i++){
            if(A[0] >= i) {
                steps[i] = 1;
                continue;
            }
            steps[i] = Integer.MAX_VALUE;
            for(int j = 1; j < i; j++){
                if(steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                    if(steps[i] == 2) break;
                }
            }
        }
        return steps[A.length - 1];
    }
}