/**
 * Write a description of class Asset here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StockHolding
{
    private String name;
    private double price;
    private int numShares;
    private String symbol;
    
    public StockHolding(String name, double price, int numShares, String symbol){
        this.name = name;
        this.price = price;
        this.numShares = numShares;
        this.symbol = symbol;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getNumShares(){
        return numShares;
    }
    
    public String getSymbol(){
        return symbol;
    }
    
    @Override
    public String toString()
    {
        // DO NOT EDIT THIS METHOD.
        return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n", 
            symbol, name, numShares, price, numShares * price); 
    }
}
