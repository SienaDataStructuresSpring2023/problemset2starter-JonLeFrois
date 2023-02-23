import java.util.ArrayList;
/**
 * Holds an ArrayList with the stock portfolio and keeps track of
 * lifetime investment and payout as well as buying and selling stocks
 *
 * @author Jon LeFrois
 * @version 2/23/23
 */
public class Portfolio
{
    private ArrayList<StockHolding> stocks;
    private double lifetimeInvestment;
    private double lifetimePayout;
    
    /**
     * Constructor for Portfolio
     * Initializes ArrayList and sets investment and payout to 0
     */
    public Portfolio(){
        stocks = new ArrayList<StockHolding>();
        lifetimeInvestment = 0;
        lifetimePayout = 0;
    }
    
    /**
     * Returns total lifetime investment
     * 
     * @return  the total lifetime investment
     */
    public double getLifetimeInvestment(){
        return lifetimeInvestment;
    }
    
    /**
     * Returns total lifetime payout
     * 
     * @return  the total lifetime payout
     */
    public double getLifetimePayout(){
        return lifetimePayout;
    }
    
    /**
     * If the stock is already in the portfolio, buys the inputted amount,
     * if not, it adds the new stock to the portfolio
     * 
     * @return  the cost of buying the stock
     */
    public double buyStock(String symbol, String name, int numToBuy, double price){
        int index = getIndex(symbol);
        if(index >= 0){
            stocks.get(index).buyShares(numToBuy, price);
            lifetimeInvestment = lifetimeInvestment + (numToBuy * price);
        }
        else{
            StockHolding newStock = new StockHolding(name, price, numToBuy, symbol);
            stocks.add(newStock);
        }
        return numToBuy * price;
    }
    
    /**
     * Returns the index of the inputted stock symbol if it is in the
     * portfolio, -1 otherwise
     * 
     * @return  the index of the inputted stock, -1 otherwise
     */
    private int getIndex(String symbol){
        for(int i = 0; i < stocks.size(); i++){
            if(stocks.get(i).getSymbol().equals(symbol)){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Sells the inputted amount of the inputted stock if it is in the
     * portfolio and returns the payout
     * 
     * @return  the payout from selling the stock, or 0 if not sold
     */
    public double sellStock(String symbol, int numToSell){
        int index = getIndex(symbol);
        if(index >= 0){
            stocks.get(index).sellShares(numToSell);
            double price = stocks.get(index).getPrice();
            if(stocks.get(index).getNumShares() == 0){
                stocks.remove(index);
            }
            lifetimePayout = lifetimePayout + (numToSell * price);
            return numToSell * price;
        }
        return 0;
    }
    
    /**
     * Returns the current total value of the portfolio
     * 
     * @return  the current total value of the portfolio
     */
    public double getCurrentValue(){
        double value = 0;
        for(int i = 0; i < stocks.size(); i++){
            value = value + (stocks.get(i).getNumShares() * stocks.get(i).getPrice());
        }
        return value;
    }
    
    /**
     * Returns the formatted string for the portfolio with its information
     * 
     * @return  formatted string for the portfolio and its information
     */
    @Override
    public String toString()
    {
        //DO NOT EDIT THIS METHOD.
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%6s%25s%10s%15s%15s%n", 
                "Symbol", "Name", "Shares", "@Price", "Total"));
        sb.append("-----------------------------------------------------------------------\n");

        for(StockHolding s : stocks){
            sb.append(s.toString());
        }
        return sb.toString();
    }
}
