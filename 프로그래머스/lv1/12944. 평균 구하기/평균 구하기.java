class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int sum = 0;
        for (int s : arr)
            sum += s;
        return (double) sum/arr.length;
    }
}