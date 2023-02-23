import java.util.ArrayList;
/**
 * Write a description of class Portfolio here.
 *
 * @author Jon LeFrois
 * @version 2/23/23
 */
public class Portfolio
{
    private ArrayList<StockHolding> stocksHeld = new ArrayList<StockHolding>();
    private double lifetimeInvestment;
    private double lifetimePayout;
    
    // @Override
    // public String toString()
    // {
        // //DO NOT EDIT THIS METHOD.
        // StringBuffer sb = new StringBuffer();
        // sb.append(String.format("%6s%25s%10s%15s%15s%n", 
                // "Symbol", "Name", "Shares", "@Price", "Total"));
        // sb.append("-----------------------------------------------------------------------\n");

        // for(StockHolding s : stocks){
            // sb.append(s.toString());
        // }
        // return sb.toString();
    // }
}
