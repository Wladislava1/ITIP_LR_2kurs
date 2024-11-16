import java.util.ArrayList;

public class SalesTracker {
    public static void main(String[] args) {
        ArrayList<String> soldProducts = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        
        soldProducts.add("Товар 1");
        prices.add(100.0);
        soldProducts.add("Товар 2");
        prices.add(200.0);
        soldProducts.add("Товар 1");
        prices.add(100.0);
        soldProducts.add("Товар 3");
        prices.add(150.0);

        System.out.println("Список проданных товаров:");
        for (int i = 0; i < soldProducts.size(); i++) {
            System.out.println(soldProducts.get(i) + " - " + prices.get(i) + " руб.");
        }

        double totalSales = 0;
        for (double price : prices) {
            totalSales += price;
        }
        System.out.println("Общая сумма продаж: " + totalSales + " руб.");

        String mostPopularProduct = "";
        int maxCount = 0;
        
        for (String product : soldProducts) {
            int count = 0;
            for (String p : soldProducts) {
                if (product.equals(p)) {
                    count++;
                }
            }
            if (count > maxCount) {
                mostPopularProduct = product;
                maxCount = count;
            }
        }
        
        System.out.println("Наиболее популярный товар: " + mostPopularProduct + " (продан " + maxCount + " раз(а))");
    }
}

public class SalesTracker {
    public static void main(String[] args) {
    }
}