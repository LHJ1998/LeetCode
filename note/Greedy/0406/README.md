# [Queue Reconstruction by Height](https://leetcode.com/problems/queue-reconstruction-by-height/)

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers `(h, k)`, where `h` is the height of the person and `k` is the number of people in front of this person who have a height greater than or equal to `h`. Write an algorithm to reconstruct the queue.

**Note:**
The number of people is less than 1,100.

 

**Example**

```
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
```

## 思路0

这题目一开始是一脸懵逼的，然后看了一下Solution的解释，我才恍然大悟，原来还可以这样。昨天晚上被牛课上的讨论打击的心态要崩溃了，有的人都5个offer了，我还没有面试...

回到正题，这个题目可以先假设这么个情况，假如说只有两个人，然后身高一样，但是一个的k是0，一个的k是1.那么排序的时候，肯定那个k为0的排前面，k为1的排后面，所以

`如果两个人的身高一样，那么k小的在前`

继续上面的假设，如果此时有另外一个人假如进来了，这个人的身高比两人小，而此人的k为k，那么这个人的位置就需要根据这个k来确定了（假设前面两个人已经排好序了），那么，假如`k = 0`那么就是在第一个位置，如果`k = 1`，那么就是在中间的额那个位置，如果`k = 2`那么就是在第三个位置。而如果换成下表为0的索引来看的话，后面进来的这个比前面的人**矮**的人，他的位置就是k的值

`如果进来了一个比较矮的人，那么这个矮人的位置就是k的位置`

有了这两条就可以解题了，首先就是对二维数组排序，然后一个一个的插进去就可以了，so easy

简单是简单，但是效率不高啊	37ms，34.20%

```java
package com.lhj1998.leetcode.Greedy._0406;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            //按照身高排序，如果身高一样，那么按照k排序
            //最后排序结果是，高的在前面，k小的在前面
            return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
        });
        LinkedList<int[]> list = new LinkedList<>();
        for(int[] p : people){
            //将p插入到第k个位置上去
            list.add(p[1], p);
        }
        return list.toArray(new int[people.length][2]);
    }

}

```

优化一下，说出来你可能不信，Arrays.sort的比较器我不用lambda表达式以后，从37ms到了7ms，然后把LinkedList改成ArrayList，从7ms到了5ms

所以说lambda表达式比较慢吗???

```java
package com.lhj1998.leetcode.Greedy._0406;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0 || people[0].length == 0)
            return new int[][]{};
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < people.length; i++){
            list.add(people[i][1], people[i]);
        }
        return list.toArray(new int[people.length][2]);
    }

}

```



