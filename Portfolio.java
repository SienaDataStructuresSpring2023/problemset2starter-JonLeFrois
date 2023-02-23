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
    
    private int getIndex(String symbol){
        for(int i = 0; i < stocks.size(); i++){
            if(stocks.get(i).getSymbol().equals(symbol)){
                return i;
            }
        }
        return -1;
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
