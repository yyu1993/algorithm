package leetcode.maimaigupiao;

/**
 * 买卖股票的最佳时机含手续费
 *
 * Created by ouyangxizhu on 2019/4/22.
 */
public class SevenOneFour {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;

        // dp[i][0]表示第i天没有股票； dp[i][1]表示第i天持有股票
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][1]+prices[i]-fee, dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i], dp[i-1][1]);
        }
        return dp[n-1][0];
    }
}
