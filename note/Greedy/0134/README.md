# [Gas Station](https://leetcode.com/problems/gas-station/)

There are *N* gas stations along a circular route, where the amount of gas at station *i* is `gas[i]`.

You have a car with an unlimited gas tank and it costs `cost[i]` of gas to travel from station *i* to its next station (*i*+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

**Note:**

- If there exists a solution, it is guaranteed to be unique.
- Both input arrays are non-empty and have the same length.
- Each element in the input arrays is a non-negative integer.

**Example 1:**

```
Input: 
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

Output: 3

Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
```

**Example 2:**

```
Input: 
gas  = [2,3,4]
cost = [3,4,3]

Output: -1

Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
```

## 思路0

em...简单的模拟了一下

虽然通过了，但是这个效率 42ms 19.75%...

```java
package com.lhj1998.leetcode.Greedy._0134;

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(null == gas || gas.length == 0 ||
                cost == null || cost.length == 0) return -1;
        int i = 0;
        while(i < gas.length){
            if(gas[i] >= cost[i]){
                int j = i, gasj = gas[i], costj = cost[i];
                while(true){
                    j++;
                    if(j >= gas.length) j = j % gas.length;
                    gasj = gasj + gas[j] - costj;
                    costj = cost[j];
                    if(j == i && gasj >= 0) return i;
                    if(gasj <= 0 || gasj < costj) break;
                }
            }
            i++;
        }
        return -1;
    }

}

```

## 思路1

先计算出gas和cost差的和，如果和大于等于0，说明总有办法可以回到起点，否则，燃料不够，根本不存在一个点可以走一圈以后回到出发点。

接着找到一条链路，从`i`位置到末尾的位置，使得这条链路最终的gas不会小于0，这样一来，就可以确定起点就是i了，因为之前已经检测过燃料是充足的，即使从0到i这一段燃料会有为负的情况，但是从i到末尾一定会有燃料剩余，且足够填平前面欠缺的燃料。因此只要一次遍历就可以搞定了

```java
package com.lhj1998.leetcode.Greedy._0134;

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(null == gas || gas.length == 0 ||
                cost == null || cost.length == 0) return -1;
        int sum = 0;
        for(int i = 0; i < gas.length; i++) sum = sum + gas[i] - cost[i];
        if(sum < 0) return -1;
        int start = 0, earn = 0;
        for(int i = 0; i < gas.length; i++){
            earn = earn + gas[i] - cost[i];
            if(earn < 0){
                earn = 0;
                start = i + 1;
            }
        }
        return start;
    }

}

```

