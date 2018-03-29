package stqulab;

import java.util.LinkedList;
import java.util.Queue;

/**
 * StockTracker
 * 
 * Class to model a financial security of which an investor
 * buys and sells several lots. This accounts for capital
 * gains using the FIFO method.
 * 
 * @author 
 * CSCI 245, Wheaton College, Fall 2015
 * Aug 3, 2015
 * Lab 9
 */
public class StockTracker {

	private Queue<Transaction> purchases;
	private Queue<Transaction> sells;
	
	public StockTracker() {
		this.purchases = new LinkedList<Transaction>();
		this.sells = new LinkedList<Transaction>();
	}
	
    /**
     * Process a given transaction
     * @param trans The transaction to process
     */
    public void processTransaction(Transaction trans) {
    	purchases.add(trans);
    		/*
    	else {
    		sells.add(trans);
    		purchases.remove(trans);
    	}
    	*/
    }

    /**
     * Get the number of shares currently held (all lots)
     * @return The total number of shares held
     */
    public int numShares() {
    	Queue<Transaction> buys = purchases;
    	Queue<Transaction> loss = sells;
        int totalShares = 0;
        while ((buys.size()+loss.size())>0) {
        	totalShares += buys.remove().shares;
        	totalShares -= loss.remove().shares;
        }
        return totalShares;
    }

    /**
     * Get the total cost basis of all shares currently held,
     * that is, how much the currently held shares cost when 
     * purchased.
     * @return The total cost basis of all shares currently held.
     */
    public int totalBasis() {
    	Queue<Transaction> toCheck = purchases;
    	int basis = 0;
    	while (!toCheck.isEmpty()) {
    		Transaction toRemove = toCheck.remove();
    		basis += (toRemove.price * toRemove.shares);
    	}
    	return basis;
    }

    /**
     * Get the capital gains of all shares sold so far.
     * @return The current capital gains on sales of this stock
     */
    public int capitalGains() {
        return -1;
    }
    
}
