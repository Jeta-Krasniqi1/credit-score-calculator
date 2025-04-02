public class CreditUtilizationCalculator {
    // Constants for scoring
    private static final int MAX_SCORE = 100;

    public static double calculateCreditUtilization(double totalCreditUsed, double totalCreditLimit) {
        if (totalCreditLimit <= 0) {
            return 1; // If no credit limit exists, return the lowest score.                   
        }

        // Calculate credit utilization percentage            
        double utilizationRatio = (totalCreditUsed / totalCreditLimit) * 100;          

        // Scoring logic
        double score;
        if (utilizationRatio <= 10) {
            score = 100;  // Best case: less than 10% utilization
        } else if (utilizationRatio <= 30) {
            score = 80 + ((30 - utilizationRatio) / 20) * 20; // Linearly scale between 80 and 100
        } else if (utilizationRatio <= 50) {
            score = 60 + ((50 - utilizationRatio) / 20) * 20; // Linearly scale between 60 and 80
        } else if (utilizationRatio <= 70) {
            score = 40 + ((70 - utilizationRatio) / 20) * 20; // Linearly scale between 40 and 60
        } else if (utilizationRatio <= 100) {
            score = 10 + ((100 - utilizationRatio) / 30) * 30; // Linearly scale between 10 and 40
        } else {
            score = 0; // Over 100% utilization (debt exceeding limit)
        }

        return Math.max(0, Math.min(score, MAX_SCORE)); // Ensure score is between 0 and 100
    }
}
