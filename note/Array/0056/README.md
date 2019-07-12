# [Merge Intervals](https://leetcode.com/problems/merge-intervals/)

Given a collection of intervals, merge all overlapping intervals.

**Example 1:**

```
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
```

**Example 2:**

```
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
```

**NOTE:** input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

## 思路0

这个题目怎么说呢，我其实一开始没有好的办法去做，只好愣头青一个一个遍历过去，把有交集的都合并一起，然后得出结果放回，下面展示我的烂代码

```java
package com.lhj1998.leetcode.Array._0056;

public class Solution {

    public int[][] merge(int[][] intervals) {
        int rows = intervals.length;
        if(rows == 1) return intervals;
        int[][] temp = new int[rows][2];
        int index = 0;
        sort(intervals);
        for(int i = 0; i < rows; i++){
            if(i == 0){
                temp[0][0] = intervals[0][0];
                temp[0][1] = intervals[0][1];
                index++;
                continue;
            }
            int preStart = temp[index - 1][0];
            int preEnd = temp[index - 1][1];
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            //两者是否有交集
            if(isOverlapping(preStart, preEnd, currStart, currEnd)){
                int start = Math.min(preStart, currStart);
                int end = Math.max(preEnd, currEnd);
                temp[index - 1][0] = start;
                temp[index - 1][1] = end;
            }else{
                temp[index][0] = currStart;
                temp[index][1] = currEnd;
                index++;
            }
        }
        int[][] res = new int[index][2];
        for(int i = 0; i < index; i++){
            res[i][0] = temp[i][0];
            res[i][1] = temp[i][1];
        }
        return res;
    }

    private boolean isOverlapping(int preStart, int preEnd, int currStart, int currEnd){
        return (currStart >= preStart && currStart <= preEnd)
                || (preStart >= currStart && preEnd <= currEnd);
    }

    private void sort(int[][] array){
        int rows = array.length;
        for(int i = 0; i < rows; i++){
            for(int j = i + 1; j < rows; j++){
                if(array[j][0] < array[i][0]){
                    //交换
                    int tempStart = array[i][0], tempEnd = array[i][1];
                    array[i][0] = array[j][0];
                    array[i][1] = array[j][1];
                    array[j][0] = tempStart;
                    array[j][1] = tempEnd;
                }
            }
        }
    }

}

```

烂的一逼，我自己都看不下去了，耗时64ms，打败了5.64%的人，菜啊自己

上面的代码我觉得可以改进的地方一个是排序的地方，还有一个是最后由于长度问题，需要把temp复制到res的部分