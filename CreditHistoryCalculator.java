import java.util.List; 
           
public class CreditHistoryCalculator {
    private static final int MAX_SCORE = 100; 
    private static final int MAX_CREDIT_AGE = 25; // Maximum age for full score

    public static double calculateCreditHistory(List<Integer> accountAges) {
        if (accountAges == null || accountAges.isEmpty()) {
            return 1; // No credit history, return the lowest non-zero score.
        }

        // Find the oldest account age
        int oldestAccountAge = accountAges.stream().mapToInt(Integer::intValue).max().orElse(0);
        
        // Calculate credit history score
        double score = (oldestAccountAge / (double) MAX_CREDIT_AGE) * MAX_SCORE;

        return Math.max(0, Math.min(score, MAX_SCORE)); // Ensure score is between 0 and 100
    }

    public static void main(String[] args) {
        // Example test cases
        List<Integer> accountAges1 = List.of(10, 5, 3); // Oldest account is 10 years
        List<Integer> accountAges2 = List.of(2, 1); // Oldest account is 2 years
        List<Integer> accountAges3 = List.of(); // No credit history

        System.out.println("Credit History Score 1: " + calculateCreditHistory(accountAges1)); // Expected: 40
        System.out.println("Credit History Score 2: " + calculateCreditHistory(accountAges2)); // Expected: 8
        System.out.println("Credit History Score 3: " + calculateCreditHistory(accountAges3)); // Expected: 1
    }
}
