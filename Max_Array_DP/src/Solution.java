public class Solution {

    static int maxSubsetSum(int[] arr) {
        int[] result = new int[arr.length];

        //Set the max for the first element to be the first element -- it can only be the max for itself
        result[0] = arr[0];
        //Set the max for the second element to be itself, it can only be its max -- non adj elements
        result[1] = arr[1];
        int ans = result[0];
        //Set the global max to be the max between both
        int max = Integer.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            //find solution by working through sub-problems solved already;
            result[i] = Integer.max(arr[i], Integer.max(arr[i] + result[i - 2], max));
            //3 possibilities 1) Max is value at arr[i], max is value at arr[i] + result [i -2](for adj elements),
            //or max is global max

            //Update global max to max at specific position
            max = result[i];
        }
        //find the max in result array
        for (int x : result) {
            ans = Integer.max(x, ans);
        }
        return ans;
    }
}
