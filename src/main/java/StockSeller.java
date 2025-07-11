public class StockSeller {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        boolean shares = false;
        for (int i = 0; i < prices.length; i++){
            if(!shares && isBuying(prices, i)){
                profit -= prices[i];
                shares = true;
            } else if(shares && isSelling(prices, i)){ //are we going to sell
                shares = false;
                profit += prices[i];
            }
        }
        return profit;
    }

    private static boolean isBuying(int[] prices, int i){
        // BUG: Should return true on the last day
        //if(i == prices. length - 1 || (prices[i] > prices[i+1])) return false;
        //Correct version:
        if(i == prices.length - 1 || (prices[i] > prices[i+1])) return false;
        return true;
    }

    private static boolean isSelling(int[] prices, int i) {

        // BUG: Should return true on the last day
        //if (i == prices.length - 1) return false;
        //Correct version:
        if (i == prices.length - 1) return true;
        if (prices[i] < prices[i + 1]) return false;
        return true;
    }
}
