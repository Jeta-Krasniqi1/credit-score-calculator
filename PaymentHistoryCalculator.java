public class PaymentHistoryCalculator {
    private static final int MAX_SCORE = 100;   
    private static final int ON_TIME_PAYMENT_WEIGHT = 70;
    private static final int OVERDUE_PENALTY_PER_PAYMENT = 3;
    private static final double DELINQUENT_DEBT_PENALTY_RATE = 2.0;
    private static final double MAX_DEBT_PENALTY = 15;                                              
    private static final int BANKRUPTCY_PENALTY = 30;
    private static final int DELINQUENCY_RECOVERY_PER_YEAR = 5;        
    private static final int MAX_DELINQUENCY_RECOVERY = 20;

	    public static double calculatePaymentHistory(int totalPayments, int onTimePayments, int overduePayments, 
	                                                 double delinquentDebt, boolean hasBankruptcy, int yearsSinceDelinquency) {
	        if (totalPayments <= 0){ 
	          return 1; } // Avoid division by zero
                if (onTimePayments < 0 || overduePayments < 0 || delinquentDebt < 0 || yearsSinceDelinquency < 0) {
                    throw new IllegalArgumentException("Negative values are not allowed.");
                }
                if (onTimePayments + overduePayments > totalPayments) {
                    throw new IllegalArgumentException("Invalid payment counts: onTime + overdue > total.");
		}
	        // 1. On-time Payment Ratio (weighted heavily)
	        double paymentRatio = (double) onTimePayments / totalPayments;
	        double paymentScore = paymentRatio * ON_TIME_PAYMENT_WEIGHT; // On-time payments contribute up to 70% of the score

	        // 2. Overdue Payments Penalty
	        double overduePenalty = overduePayments * OVERDUE_PENALTY_PER_PAYMENT; // Each overdue payment reduces score

	        // 3. Delinquent Debt Penalty
	        double debtPenalty = (delinquentDebt > 0) ? Math.min((delinquentDebt / 1000) * DELINQUENT_DEBT_PENALTY_RATE, MAX_DEBT_PENALTY) : 0; // Max 15 points deduction

	        // 4. Bankruptcy Penalty (if applicable, reduces score significantly)
	        double bankruptcyPenalty = hasBankruptcy ? BANKRUPTCY_PENALTY : 0;

	        // 5. Time Since Delinquency (older delinquencies reduce impact)
	        double delinquencyRecovery = Math.min(yearsSinceDelinquency * DELINQUENCY_RECOVERY_PER_YEAR, MAX_DELINQUENCY_RECOVERY); // Max 20 points recovery

	        // Final Score Calculation
	        double finalScore = paymentScore - overduePenalty - debtPenalty - bankruptcyPenalty + delinquencyRecovery;

	        return Math.min(MAX_SCORE , Math.max(finalScore, 0)); // Ensure score doesn't go below 0
	    }
}
