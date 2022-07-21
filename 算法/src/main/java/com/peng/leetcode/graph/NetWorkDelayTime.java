package com.peng.leetcode.graph;

/**
 * 743-网络延迟时间
 * 有 n 个网络节点，标记为 1 到 n。
 *
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 *
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NetWorkDelayTime {
//    1.使用矩阵实现
    private Integer INF = Integer.MAX_VALUE/2;

    public int networkDelayTime(int[][] times, int n, int k) {

        int[][] w = new int[n+1][n+1];
//        1.初始化矩阵
        for(int i = 1;i<=n ;i ++) {
            for (int j = 1;j <= n; j++) {
                int value = i==j ? 0: INF;
                 w[i][j] = w[j][i] = value;
            }
        }
//        2. 矩阵存图
        for(int[] time :times){
            w[time[0]][ time[1]] = time[2];
        }
//        3. 全图节点 最短路处理
        floyd(w,n);
//        4. 获取 节点k的最短路
        int  res = Integer.MIN_VALUE;
        for(int i =1 ;i<=n;i++){
            res = Math.max(res,w[k][i]);
        }
        return res >= INF?-1:res;
    }
    void floyd(int[][] graph,int n ){
//        1.遍历所有中转节点
            for(int tmp = 1; tmp <= n;tmp ++) {
//            2.遍历所有起始节点
                for (int i = 1; i <= n; i++) {
                    //                3.遍历所有终止节点
                    for (int j = 1; j <= n; j++) {
                        graph[i][j] = Math.min(graph[i][j],graph[i][tmp] +graph[tmp][j]);
                    }
                }
            }
    }

    public static void main(String[] args) {
        int[][] re = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        NetWorkDelayTime netWorkDelayTime = new NetWorkDelayTime();
        System.out.println(netWorkDelayTime.networkDelayTime(re, 4, 2));
    }
}
