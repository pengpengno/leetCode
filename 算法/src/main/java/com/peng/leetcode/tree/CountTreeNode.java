package com.peng.leetcode.tree;

import com.peng.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountTreeNode {
    
    public int sumNumbers(TreeNode root) {
        int dfs = dfs(root, 0);
        int bfs = bfs(root);
        return bfs;
    }
    
    public int dfs(TreeNode root ,int presum){
//        终止操作
        if (root ==null){
            return 0;
        }
//       执行逻辑
        int sum = presum*10+root.val;
//        返回结果
        if (root.left ==null && root.right ==null){
            return sum;
        }
        int dfs = dfs(root.left, sum);
        int dfs1 = dfs(root.right, sum);
        return dfs +dfs1;
    }

    public int bfs (TreeNode root ){
//       特殊情况处理
        if (root == null){
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        queue.offer(root);
        sumQueue.offer(root.val);
        while (!queue.isEmpty()){
            int size = queue.size();
            Integer num = sumQueue.poll();
//            while(size>0){
            TreeNode poll = queue.poll();
            if (poll.left== null && poll.right ==null){
                sum += num;
            }
            else {
                if (poll.left!=null){
                    queue.offer(poll.left);
                    sumQueue.offer(num * 10+ poll.left.val);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                    sumQueue.offer(num *10+ poll.right.val);
                }
            }
        }
        return  sum;
    }
}
