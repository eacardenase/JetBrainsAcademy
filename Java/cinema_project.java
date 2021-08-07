import java.util.*;

public class Cinema {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scan.nextInt();
        
        String[][] cinema = new String[rows][(seats)];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinema[i][j] = "S"; 
            }
        }
        
        int currentIncome = 0;
        int purchasedTickets = 0;
        int totalIncome = 0;
        
        int numberOfSeats = rows * seats;
        int price = 0;
        int mitad = rows / 2;
        
        if (numberOfSeats <= 60) {
            totalIncome = numberOfSeats * 10;
        } else {
             if (rows % 2 == 0) {
                totalIncome = (mitad * 10) + (mitad * 8);
            } else {
                int mitadInferior = rows / 2;
                int mitadSuperior = mitadInferior + 1;
                totalIncome = ((mitadInferior * seats) * 10) + ((mitadSuperior * seats) * 8);
            }
        }

        boolean continuar = true;
        
        while (continuar) {
                System.out.println("1. Show the seats");
                System.out.println("2. Buy a ticket");
                System.out.println("3. Statistics");
                System.out.println("0. Exit");
            
            int action = scan.nextInt();
            
            switch (action) {
                case 1:
                    System.out.println("Cinema:");
                    for (int i = 0; i <= seats; i++) {
                        if (i == 0) {
                            System.out.print("  ");
                        } else {
                            System.out.print(i + " ");
                        }
                    } System.out.println();
                    
                    for (int i = 0; i < rows; i++) {
                        System.out.print((i + 1) + " ");
                        for (int j = 0; j < seats; j++) {
                            
                            System.out.print(cinema[i][j] + " ");   
                        } 
                        System.out.println();
                    }
                    break;
                
                case 2:
                    System.out.println("Enter a row number:");
                    int rowNumber = scan.nextInt() - 1;
                    System.out.println("Enter a seat number in that row:");
                    int seatNumber = scan.nextInt() - 1;
                    
                    if (rowNumber >= rows || seatNumber >= seats) {
                        System.out.println("Wrong input!");
                        break;
                    }
                    
                    if (cinema[rowNumber][seatNumber] == "B") {
                        System.out.println("That ticket has already been purchased!");
                        
                        while (cinema[rowNumber][seatNumber] == "B") {
                            System.out.println("Enter a row number:");
                            rowNumber = scan.nextInt() - 1;
                            System.out.println("Enter a seat number in that row:");
                            seatNumber = scan.nextInt() - 1;
                        }
                    } 
                    
                    if (numberOfSeats <= 60) {
                        price = 10;
                    } else {
                        if (rowNumber < mitad) {
                            price = 10;
                        } else {
                            price = 8;
                        }
                    }
                    
                    System.out.println("Ticket Price: $" + price);
                    cinema[rowNumber][seatNumber] = "B";
                    purchasedTickets++;
                    currentIncome += price;
                    break;
                
                case 3:
                    double percentage = (double) (purchasedTickets * 100) / numberOfSeats;
                    System.out.println("Number of purchased tickets: " + purchasedTickets);
                    System.out.printf("Percentage: %.2f%s", percentage, "%");
                    System.out.println();
                    System.out.println("Current income: $" + currentIncome);
                    System.out.println("Total Income: $" + totalIncome);
                    break;
                
                case 0:
                    continuar = false;
                    break;
                
                default:
                    System.out.println("Wrong input!");         
            }           
        }
    }
}