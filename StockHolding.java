/**
 * Write a description of class Asset here.
 *
 * @author Jon LeFrois
 * @version 2/23/2023
 */
public class StockHolding
{
    private String name;
    private double price;
    private int numShares;
    private String symbol;
    
    /**
     * Constructor for StockHolding class
     * 
     * @param  name  the name of the stock
     * @param  price  the current price per share of the stock
     * @param  numShares  the number of shares held
     * @param  symbol  the stock symbol
     */
    public StockHolding(String name, double price, int numShares, String symbol){
        this.name = name;
        this.price = price;
        this.numShares = numShares;
        this.symbol = symbol;
    }
    
    /**
     * Returns the name of the stock
     * 
     * @return  the name of the stock
     */
    public String getName(){
        return name;
    }
    
    /**
     * Returns the price per share of the stock
     * 
     * @return  the price per share of the stock
     */
    public double getPrice(){
        return price;
    }
    
    /**
     * Returns the number of shares held
     * 
     * @return  the number of shares held
     */
    public int getNumShares(){
        return numShares;
    }
    
    /**
     * Returns the symbol of the stock
     * 
     * @return  the symbol of the stock
     */
    public String getSymbol(){
        return symbol;
    }
    
    /**
     * Buys the inputted amount of new shares at the inputted price
     * and updates the appropriate instance variables
     * 
     * @param  newShares  the number of new shares to purchase
     * @param  price  the price the new shares are bought at
     */
    public void buyShares(int newShares, double price){
        numShares = numShares + newShares;
        this.price = price;
    }
    
    /**
     * Sells the inputted amount of shares if there are enough shares to sell,
     * returns the dollar amount from the sale and updates the appropriate 
     * instance variable, numShares
     * 
     * @param  sell  the number of shares to sell
     * @return  the dollar amount resulting from the sale, or 0 if no sale
     */
    public double sellShares(int sell){
        if(numShares >= sell){
            numShares = numShares - sell;
            return sell * price;
        }
        return 0.0;
    }
    
    /**
     * Returns the formatted string for the stock with its information
     * 
     * @return  formatted string for the stock and its information
     */
    @Override
    public String toString()
    {
        // DO NOT EDIT THIS METHOD.
        return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n", 
            symbol, name, numShares, price, numShares * price); 
    }
}
