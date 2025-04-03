# Credit Score Calculator                                                
### 🚀 A simple yet effective credit score estimation tool using a simplified FICO-like formula.
                                  
## 📌 Overview                              
The Credit Score Calculator is a Java-based tool that estimates a user's credit score based on key financial factors. It follows a weighted formula inspired by real-world credit scoring models.
            
## 🛠 Features
✅ Uses a simplified FICO-like formula to estimate credit scores

✅ Accepts five key financial inputs:
                                         
- Payment History (35%) → Impact of missed/on-time payments
                     
- Credit Utilization (30%) → Percentage of credit limit used

- Credit History Length (15%) → How long the user has had credit                   
             
- New Credit Inquiries (10%) → Impact of recent hard inquiries

- Credit Mix (10%) → Variety of credit types (loans, credit cards, etc.)
  
✅ Returns a credit score range from 300 to 850

✅ Designed for future API and database integration

📌 Formula Used: 

-> Score = 300 + (pH × 0.35) + (cU × 0.30) + (cH × 0.15) + (nC × 0.10) + (cM × 0.10)

Where:

𝑝𝐻 = Payment History Score (0-1000)


c𝑈 = Credit Utilization Score (0-1000)

𝑐𝐻 = Credit History Score (0-1000)

𝑛𝐶 = New Credit Inquiries Score (0-1000)

𝑐𝑀 = Credit Mix Score (0-1000)

## 📂 Project Structure
```bash
/CreditScoreCalculator
│── src
│   ├── CreditScoreCalculator.java  # Main class with credit score logic
│── README.md                        # Project documentation
│── LICENSE                          # (Optional) License file
│── .gitignore                     # Git ignore file
```
## 🚀 Installation & Usage
🔹 Prerequisites
Java 8+ installed

A Java IDE (IntelliJ IDEA, VS Code, Eclipse)

🔹 Running the Program

Clone the repository:

```sh
git clone https://github.com/your-username/CreditScoreCalculator.git
cd CreditScoreCalculator
```
Compile the Java program:

```sh
javac CreditScoreCalculator.java
```
Run the program:

```sh
java CreditScoreCalculator
```
## 📌 Code Example
Here’s how the calculator works in action:

```java
public static void main(String[] args) {
    int creditScore = calculateCreditScore(85, 70, 80, 50, 60);
    System.out.println("Calculated Credit Score: " + creditScore);
}
```
📝 Output Example:
```yaml
Calculated Credit Score: 710
```
## 🛠 Future Enhancements

📌 API Integration → Fetch real financial data via APIs

📌 Database Storage → Store user credit scores for tracking

📌 Web UI → Build a front-end for user interaction

## 📜 License
This project is open-source under the MIT License.

👨‍💻 Contributions & Feedback Welcome! 🚀

### Made with love by Jeta-Krasniqi1

