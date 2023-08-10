import java.util.Scanner;

class Candle {
    String name;
    int amount;
    int burnTime;
    double dollarPerBurnTime;

    Candle(String name, int burnTime, double dollarPerBurnTime) {
        this.name = name;
        this.burnTime = burnTime;
        this.dollarPerBurnTime = dollarPerBurnTime;
    }

    double calculatePrice() {
        return amount * dollarPerBurnTime * burnTime;
    }

    @Override
    public String toString() {
        return "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
                + name + "\nAmount: " + amount + "\nBurn Time: " + burnTime + " hours"
                + "\nDollar per Burn Time: $" + String.format("%.2f", dollarPerBurnTime)
                + "\nPrice: $" + String.format("%.2f", calculatePrice()) + "\n";
    }
}

public class CandleShop {
    public static void main(String[] args) {
        Candle[] candles = {
                new Candle("Luscious Lavender", 5, 1.50),
                new Candle("Fragrant Floral's", 7, 2.68),
                new Candle("Spicy N' Dicey", 12, 1.00),
                new Candle("Ocean Breeze", 6, 2.00),
                new Candle("Soothing Sandalwood", 8, 2.25),
                new Candle("Warm Vanilla", 4, 1.75),
                new Candle("Fresh Citrus", 3, 1.20),
                new Candle("Cozy Cinnamon", 9, 1.80),
                new Candle("Enchanting Earl Grey", 5, 2.50),
                new Candle("Mystical Moonlight", 10, 3.00),
                new Candle("Crisp Apple", 6, 1.40),
                new Candle("Exotic Orchid", 7, 3.20)
        };

        Scanner scanner = new Scanner(System.in);
        double totalBurnTime = 0;
        double totalDollarPerBurnTime = 0;
        double totalPrice = 0;

        System.out.println("Welcome to the Candle Shop!");

        for (Candle candle : candles) {
            System.out.print("How many '" + candle.name + "' candles would you like to purchase? ");
            int amount = scanner.nextInt();
            candle.amount = amount;

            totalBurnTime += candle.burnTime * amount;
            totalDollarPerBurnTime += candle.dollarPerBurnTime * amount;
            totalPrice += candle.calculatePrice();
        }

        System.out.println("\nReceipt\n");
        for (Candle candle : candles) {
            if (candle.amount > 0) {
                System.out.println(candle.toString());
            }
        }

        System.out.println("Total Burn Time: " + (int) totalBurnTime);
        System.out.println("Total Dollar per Burn Time: $" + String.format("%.2f", totalDollarPerBurnTime));
        System.out.println("Total Price: $" + String.format("%.2f", totalPrice));
    }
}
