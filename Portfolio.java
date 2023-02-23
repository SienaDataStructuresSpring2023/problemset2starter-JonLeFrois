import java.util.ArrayList;
/**
 * Write a description of class Portfolio here.
 *
 * @author Jon LeFrois
 * @version 2/23/23
 */
public class Portfolio
{
    private ArrayList<StockHolding> stocks;
    private double lifetimeInvestment;
    private double lifetimePayout;
    
    public Portfolio(){
        stocks = new ArrayList<StockHolding>();
        lifetimeInvestment = 0;
        lifetimePayout = 0;
    }
    
    public double getLifetimeInvestment(){
        return lifetimeInvestment;
    }
    
    public double getLifetimePayout(){
        return lifetimePayout;
    }
    
    public double buyStock(String symbol, String name, int numToBuy, double price){
        for(int i = 0; i < stocks.size(); i++){
            if(stocks.get(i).getSymbol().equals(symbol)){
                stocks.get(i).buyShares(numToBuy, price);
                lifetimeInvestment = lifetimeInvestment + (numToBuy * price);
            }
        }
        StockHolding newStock = new StockHolding(name, price, numToBuy, symbol);
        stocks.add(newStock);
        return numToBuy * price;
    }
    
    private int getIndex(String symbol){
        for(int i = 0; i < stocks.size(); i++){
            if(stocks.get(i).getSymbol().equals(symbol)){
                return i;
            }
        }
        return -1;
    }
    
    public double sellStock(String symbol, int numToSell){
        for(int i = 0; i < stocks.size(); i++){
            if(stocks.get(i).getSymbol().equals(symbol)){
                stocks.get(i).sellShares(numToSell);
                double price = stocks.get(1).getPrice();
                if(stocks.get(i).getNumShares() == 0){
                    stocks.remove(i);
                }
                lifetimePayout = lifetimePayout + (numToSell * price);
                return numToSell * price;
            }
        }
        return 0;
    }
    
    public double getCurrentValue(){
        double value = 0;
        for(int i = 0; i < stocks.size(); i++){
            value = value + (stocks.get(i).getNumShares() * stocks.get(i).getPrice());
        }
        return value;
    }
    
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
