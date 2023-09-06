import java.util.Arrays;
import java.util.Comparator;

class Item {
    int weight;
    int profit;

    public Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
    }
}

class FracKanpSack {
    public static double fractionalKnapsack(int knapsackCapacity, Item[] items) {
        // Sort the items in descending order of profit-to-weight ratio
        Arrays.sort(items, Comparator.comparingDouble((Item item) -> (double) item.profit / item.weight).reversed());

        double totalprofit = 0;
        int remainingCapacity = knapsackCapacity;

        for (Item item : items) {
            if (item.weight <= remainingCapacity) {
                // Take the whole item
                totalprofit += item.profit;
                remainingCapacity -= item.weight;
            } else {
                // Take a fraction of the item to fill the knapsack
                totalprofit += (double) remainingCapacity / item.weight * item.profit;
                break; // Knapsack is full, no more items can be added
            }
        }

        return totalprofit;
    }

    public static void main(String[] args) {
        int knapsackCapacity = 50;
        Item[] items = {
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        };

        double maxprofit = fractionalKnapsack(knapsackCapacity, items);
        System.out.println("Maximum profit in the knapsack: " + maxprofit);
    }
}
