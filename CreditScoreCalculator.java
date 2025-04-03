public class CreditScoreCalculator {
    /** My credit score calculator method estimates the credit score of the user using a  simplified version of the fico formula.
     *it takes as input the    
     *-paymentHistory (If the user has missed payments)
     *-creditUtilization (How much credit they are using vs. total available credit)
     *-creditHistory (How long the user has had credit) 
     *-newCredit (Hard inquiries affect scores)
     *-creditMix (Having different types of credit (loans, cards, etc.))*/
    public static int calculateCreditScore(int paymentHistory, int creditUtilization, int creditHistory, int newCredit, int creditMix) {
    	/** The credit score start from 300 up to 850 */
        int baseScore = 300;
        /** the formula to calculate the score */
        int finalScore = baseScore 
            + (int) (paymentHistory * 0.35)                
            + (int) (creditUtilization * 0.30)     
            + (int) (creditHistory * 0.15)               
            + (int) (newCredit * 0.10) 
            + (int) (creditMix * 0.10);
        
        return Math.min(finalScore, 850); 
    }

    public static void main(String[] args) {
        /** the method in action */
        int creditScore = calculateCreditScore(1000, 1000, 1000, 1000, 1000);
        System.out.println("Calculated Credit Score: " + creditScore);
    }
}
