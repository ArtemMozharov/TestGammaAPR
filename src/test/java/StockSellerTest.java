
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockSellerTest {

    @Test
    void testMaxProfit_emptyPrices() {
        int[] prices = {};
        assertEquals(0, StockSeller.maxProfit(prices));
    }

    @Test
    void testMaxProfit_singlePrice() {
        int[] prices = {10};
        assertEquals(0, StockSeller.maxProfit(prices));
    }

    @Test
    void testMaxProfit_alwaysIncreasing() {
        int[] prices = {10, 20, 30, 40, 50};
        assertEquals(40, StockSeller.maxProfit(prices));
    }

    @Test
    void testMaxProfit_alwaysDecreasing() {
        int[] prices = {50, 40, 30, 20, 10};
        assertEquals(0, StockSeller.maxProfit(prices));
    }

    @Test
    void testMaxProfit_mixedPrices() {
        int[] prices = {10, 50, 5, 25};
        assertEquals(60, StockSeller.maxProfit(prices));
    }

    @Test
    void testMaxProfit_buyAtTheEnd() {
        int[] prices = {10, 50, 5, 25, 30};
        assertEquals(65, StockSeller.maxProfit(prices));
    }

    @Test
    void testMaxProfit_sellAtTheEnd() {
        int[] prices = {10, 50, 5, 30, 25};
        assertEquals(65, StockSeller.maxProfit(prices));
    }

    @Test
    void testMaxProfit_noProfit() {
        int[] prices = {10, 9, 8, 7, 6};
        assertEquals(0, StockSeller.maxProfit(prices));
    }

    @Test
    void testMaxProfit_peakAndValley() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertEquals(7, StockSeller.maxProfit(prices));
    }

    @Test
    void testMaxProfit_multipleTransactions() {
        int[] prices = {1, 2, 3, 4, 5};
        assertEquals(4, StockSeller.maxProfit(prices));
    }
}
