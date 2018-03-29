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
 * @author: Joel Armstrong and Mitchell Smith
 * CSCI 245, Wheaton College, Spring 2018
 * March 29, 2018
 * Lab 8
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
    	if (trans) { // a buy
		purchases.add(trans);
		return;
	}
    	sells.add(trans);
    	}

    /**
     * Get the number of shares currently held (all lots)
     * @return The total number of shares held
     */
    public int numShares() {
    	Queue<Transaction> buys = purchases;
    	Queue<Transaction> loss = sells;
        int totalShares = 0;
        while (!buys.isEmpty()) totalShares += buys.remove().shares;
        while (!sells.isEmpty()) totalShares -= sells.remove().shares;
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
