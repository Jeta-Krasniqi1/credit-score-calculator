import java.util.*;
public class CreditMx {     
	/**           
	 * Calculates a credit mix score based on the diversity of credit types.
	 *      
	 * @param creditTypes An array of strings representing the different credit types the person has
	 *                   (e.g., "mortgage", "auto_loan", "credit_card", "personal_loan", "student_loan")
	 * @return A credit mix score between 0 (poor diversity) and 100 (excellent diversity)         
	 */
	public static int calculateCreditMixScore(String[] creditTypes) {         
	    if (creditTypes == null || creditTypes.length == 0) {
	        return 0;   
	    }
	    
	    // Count the number of unique credit types
	    Set<String> uniqueTypes = new HashSet<>(Arrays.asList(creditTypes));
	    
	    // Define weights for different credit types (more weight for installment loans)
	    Map<String, Integer> typeWeights = new HashMap<>();
	    typeWeights.put("mortgage", 3);
	    typeWeights.put("auto_loan", 2);
	    typeWeights.put("student_loan", 2);
	    typeWeights.put("personal_loan", 1);
	    typeWeights.put("credit_card", 1);
	    typeWeights.put("retail_card", 1);
	    
	    // Calculate weighted score
	    int weightedScore = 0;
	    for (String type : uniqueTypes) {
	        weightedScore += typeWeights.getOrDefault(type.toLowerCase(), 0);
	    }
	    
	    // Normalize the score to a 0-100 range
	    // Max possible score with all types is 3+2+2+1+1+1 = 10
	    int normalizedScore = (int) Math.min(100, (weightedScore * 10));
	    
	    // Bonus for having both installment and revolving credit
	    boolean hasInstallment = uniqueTypes.stream().anyMatch(type -> 
	        type.equalsIgnoreCase("mortgage") || 
	        type.equalsIgnoreCase("auto_loan") || 
	        type.equalsIgnoreCase("student_loan") ||
	        type.equalsIgnoreCase("personal_loan"));
	    
	    boolean hasRevolving = uniqueTypes.stream().anyMatch(type -> 
	        type.equalsIgnoreCase("credit_card") || 
	        type.equalsIgnoreCase("retail_card"));
	    
	    if (hasInstallment && hasRevolving) {
	        normalizedScore = Math.min(100, normalizedScore + 20);
	    }
	    
	    return normalizedScore;
	}
}
