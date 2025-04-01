public class NewCreditCalculator {
    private static final int MAX_SCORE = 100;
    
    public static double calculateNewCreditScore(int hardInquiries) {
        if (hardInquiries <= 0) {
            return MAX_SCORE; // No inquiries, perfect score
        } else if (hardInquiries == 1) {
            return 90;
        } else if (hardInquiries == 2) {
            return 75;
        } else if (hardInquiries == 3) {              
            return 55;
        } else if (hardInquiries == 4) {
            return 30;
        } else {
            return 10; // 5 or more inquiries = worst score
        }
    }
}
