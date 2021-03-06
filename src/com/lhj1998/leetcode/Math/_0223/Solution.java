package com.lhj1998.leetcode.Math._0223;

public class Solution {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left1 = A, right1 = C, top1 = D, bottom1 = B;
        int left2 = E, right2 = G, top2 = H, bottom2 = F;
        int cover = 0, total = 0;
        //求出总面积
        total = (right1 - left1) * (top1 - bottom1) + (right2 - left2) * (top2 - bottom2);
        //检查两个矩形是否右公共区域
        if(!(top2 <= bottom1 || bottom2 >= top1 || left2 >= right1 || right2 <= left1)){
            //最大左边界、最小右边界、最小上边界、最大下边界
            int maxLeft = Math.max(left1, left2);
            int minRight = Math.min(right1, right2);
            int minTop = Math.min(top1, top2);
            int maxBottom = Math.max(bottom1, bottom2);
            cover =  (minRight - maxLeft) * (minTop - maxBottom);
        }
        return total - cover;
    }

}
