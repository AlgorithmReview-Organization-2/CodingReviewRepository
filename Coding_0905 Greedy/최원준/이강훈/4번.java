/*
https://leetcode.com/problems/gas-station/

아이디어
구현 -> 시작점 찾기 ( 0보다 큰곳을 시작점으로 잡고 뒤로 갈때마다 음수가 안되는 곳이 시작점 ) , 총 비용이 양수여야 순환 가능

자료구조
배열

시간복잡도
O(N)
*/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int startIndex = -1;
        int startIndexWithGas = 0;

        for (int i = 0; i < gas.length; i++) {
            int currentCost = gas[i] - cost[i];

            totalGas += currentCost;
            startIndexWithGas += currentCost;

            if (startIndex == -1 && currentCost >= 0){
                startIndex = i;
                startIndexWithGas = currentCost;
            } else if (startIndexWithGas < 0) {
                startIndex = -1;
                startIndexWithGas = 0;
            }
        }

        if (totalGas >= 0) return startIndex;
        return -1;
    }
}
