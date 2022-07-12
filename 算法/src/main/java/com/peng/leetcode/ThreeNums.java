package com.peng.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * leetcode 15
 *
 */
public class ThreeNums {
    public static void main(String[] args) {
        Integer[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(Integer[] nums) {
        // 1. 双指针排序
        Arrays.sort(nums);
        // 2. 创建结果容器
        List<List<Integer>>  res = new ArrayList();
        // 3. 获取输入数组长度
        Integer length = nums.length;
        // 4. 创建循环指针k   左右双指针 i，j 限定范围(k+1,nums.length)
        for(int k = 0; k < length -2 ; k++){
            if(nums[k] > 0) break;
            if(k > 0  && nums[k] == nums[k-1]) continue;
            int i = k+1;
            int j = length-1;
            while(i<j){
                Integer sum =  nums[k] +nums[i] + nums[j];
                if (sum < 0){
                    while(i<j && nums[i] == nums[++i]);
                }
                else if (sum > 0){
                    while (i<j && nums[j] == nums[--j]);
                }
                else {
                    res.add(new ArrayList(Arrays.asList(nums[k],nums[i],nums[j])));
                    while(i<j && nums[i] == nums[++i]);
                    while (i<j && nums[j] == nums[--j]);
                }

            }
        }
        return res;
    }
}
