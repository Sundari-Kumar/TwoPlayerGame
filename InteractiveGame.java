import java.util.Scanner;

public class InteractiveGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===GAME ===");
        System.out.println("Rules: Start at 0, add 2, 3, or 4 each turn");
        System.out.println("Goal: Be the first to reach exactly 40");
        System.out.println("You are Player 2, Computer is Player 1");
        System.out.println();
        
        int total = 0;
        boolean gameOver = false;
        
        while (!gameOver) {
            // Computer's turn (Player 1 - knows winning strategy)
            System.out.println("Current total: " + total);
            System.out.print("Press Enter for computer's move...");
            scanner.nextLine(); // Wait for user to press Enter
            
            int computerMove = getOptimalMove(total);
            total += computerMove;
            System.out.println("Computer adds " + computerMove + " -> Total: " + total);
            
            if (total == 40) {
                System.out.println("\n🤖 COMPUTER WINS! 🤖");
                System.out.println("The computer used the optimal strategy!");
                gameOver = true;
                break;
            }
            
            // Human's turn (Player 2 - doesn't know strategy)
            System.out.println("\nCurrent total: " + total);
            System.out.print("Your turn! Add 2, 3, or 4: ");
            
            try {
                int humanMove = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                
                // Validate move
                if (humanMove < 2 || humanMove > 4) {
                    System.out.println("❌ Invalid! Must add 2, 3, or 4. Try again.");
                    continue;
                }
                
                if (total + humanMove > 40) {
                    System.out.println("❌ That would go over 40! Try a smaller number.");
                    continue;
                }
                
                total += humanMove;
                System.out.println("You add " + humanMove + " -> Total: " + total);
                
                if (total == 40) {
                    System.out.println("\n🎉 YOU WIN! 🎉");
                    System.out.println("Amazing! You beat the optimal strategy!");
                    System.out.println("(The computer must have made an error)");
                    gameOver = true;
                }
                
            } catch (Exception e) {
                System.out.println("❌ Please enter a valid number (2, 3, or 4)");
                scanner.nextLine(); // Clear invalid input
            }
            
            System.out.println(); // Empty line for readability
        }
        
        // Reveal the strategy
        System.out.println("\n=== THE SECRET STRATEGY ===");
        System.out.println("The computer always tries to leave totals at:");
        System.out.println("1, 6, 11, 16, 21, 26, 31, 36 (pattern: 5k+1)");
        System.out.println("These are 'losing positions' - whoever reaches them loses!");
        System.out.println("Since the game starts at 0, Player 1 can always force a win.");
        
        scanner.close();
    }
    
    // Computer uses optimal strategy
    static int getOptimalMove(int currentTotal) {
        // Try each possible move to find one that puts opponent in losing position
        for (int move = 2; move <= 4; move++) {
            int newTotal = currentTotal + move;
            
            // Win immediately if possible
            if (newTotal == 40) {
                return move;
            }
            
            // Put opponent in losing position (5k+1 pattern)
            if (newTotal < 40 && isLosingPosition(newTotal)) {
                return move;
            }
        }
        
        // Fallback (shouldn't happen with correct strategy)
        return 2;
    }
    
    // Check if position is losing (follows 5k+1 pattern)
    static boolean isLosingPosition(int position) {
        return position % 5 == 1;
    }
}
