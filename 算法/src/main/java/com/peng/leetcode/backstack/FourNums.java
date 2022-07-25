package com.peng.leetcode.backstack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18-四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourNums {
    /**
     * 排序+双指针
     * 需要进行多次剪枝操作
     * 在确定第一个数之后，如果 \textit{nums}[i]+\textit{nums}[i+1]+\textit{nums}[i+2]+\textit{nums}[i+3]>\textit{target}nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target，说明此时剩下的三个数无论取什么值，四数之和一定大于 \textit{target}target，因此退出第一重循环；
     * 在确定第一个数之后，如果 \textit{nums}[i]+\textit{nums}[n-3]+\textit{nums}[n-2]+\textit{nums}[n-1]<\textit{target}nums[i]+nums[n−3]+nums[n−2]+nums[n−1]<target，说明此时剩下的三个数无论取什么值，四数之和一定小于 \textit{target}target，因此第一重循环直接进入下一轮，枚举 \textit{nums}[i+1]nums[i+1]；
     * 在确定前两个数之后，如果 \textit{nums}[i]+\textit{nums}[j]+\textit{nums}[j+1]+\textit{nums}[j+2]>\textit{target}nums[i]+nums[j]+nums[j+1]+nums[j+2]>target，说明此时剩下的两个数无论取什么值，四数之和一定大于 \textit{target}target，因此退出第二重循环；
     * 在确定前两个数之后，如果 \textit{nums}[i]+\textit{nums}[j]+\textit{nums}[n-2]+\textit{nums}[n-1]<\textit{target}nums[i]+nums[j]+nums[n−2]+nums[n−1]<target，说明此时剩下的两个数无论取什么值，四数之和一定小于 \textit{target}target，因此第二重循环直接进入下一轮，枚举 \textit{nums}[j+1]nums[j+1]
     *

     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
//        1. 特殊情况处理
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums == null ||  nums.length < 4){
            return res;
        }
        Arrays.sort(nums);
        int length = nums.length;

        for (int  i = 0;i<length-3;i++){
//            剪枝

            if (i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            if ((long) nums[i]+nums[i+1]+nums[i+2]+nums[i+3] > target){
                break;
            }
            if ((long) nums[i] + nums[length-1] + nums[length-2]+nums[length-3] < target){
                continue;
            }
            for (int j = i+1 ;j<length-2;j++){
                if (j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                if ((long)nums[i] + nums[j] + nums[j+1]+nums[j+2] > target){
                    break;
                }
                if ((long)nums[i] + nums[j] + nums[length - 1]+nums[length - 2] < target){
                    continue;
                }
//                二次剪枝
                int left = j+1;
                int right = length - 1;
                while (left < right){
                    int sum = nums[left] + nums[right] + nums[i] +nums[j];
                    if (sum == target){
                        res.add(Arrays.asList(nums[left] , nums[right] , nums[i] ,nums[j]));
                        while (left< right && nums[left] == nums[left+1]){
                            left++;
                        }
                        left++;
                        while (left< right && nums[right] == nums[right-1]){
                            right--;
                        }
                        right--;
                    }else if(sum > target){
                        right -- ;
                    }
                    else if(sum < target){
                        left++;
                    }
                }
            }
        }
        return  res;
    }
}
