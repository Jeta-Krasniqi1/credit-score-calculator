public class PaymentHistoryCalculator {
	 private static final int MAX_SCORE = 100;

	    public static double calculatePaymentHistory(int totalPayments, int onTimePayments, int overduePayments, 
	                                                 double delinquentDebt, boolean hasBankruptcy, int yearsSinceDelinquency) {
	        if (totalPayments <= 0){ 
	          return 1; } // Avoid division by zero
               
	        // 1. On-time Payment Ratio (weighted heavily)
	        double paymentRatio = (double) onTimePayments / totalPayments;
	        double paymentScore = paymentRatio * 70; // On-time payments contribute up to 70% of the score

	        // 2. Overdue Payments Penalty
	        double overduePenalty = overduePayments * 3; // Each overdue payment reduces score

	        // 3. Delinquent Debt Penalty
	        double debtPenalty = (delinquentDebt > 0) ? Math.min((delinquentDebt / 1000) * 2, 15) : 0; // Max 15 points deduction

	        // 4. Bankruptcy Penalty (if applicable, reduces score significantly)
	        double bankruptcyPenalty = hasBankruptcy ? 30 : 0;

	        // 5. Time Since Delinquency (older delinquencies reduce impact)
	        double delinquencyRecovery = Math.min(yearsSinceDelinquency * 5, 20); // Max 20 points recovery

	        // Final Score Calculation
	        double finalScore = paymentScore - overduePenalty - debtPenalty - bankruptcyPenalty + delinquencyRecovery;

	        return Math.max(finalScore, 0); // Ensure score doesn't go below 0
	    }
}
