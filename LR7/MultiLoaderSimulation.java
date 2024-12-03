import java.util.ArrayList;
import java.util.List;

    class Item {
        private int weight;

        public Item(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    class Warehouse {
        private List<Item> items;

        public Warehouse(List<Item> items) {
            this.items = new ArrayList<>(items);
        }

        public synchronized List<Item> getItemsForLoader() {
            List<Item> loaderItems = new ArrayList<>();
            int totalWeight = 0;

            for (int i = 0; i < items.size(); ) {
                Item item = items.get(i);
                if (totalWeight + item.getWeight() <= 150) {
                    loaderItems.add(item);
                    totalWeight += item.getWeight();
                    items.remove(i); 
                } else {
                    i++;
                }
            }

            return loaderItems;
        }

        public synchronized boolean isEmpty() {
            return items.isEmpty();
        }
    }

    class Loader extends Thread {
        private Warehouse warehouse;
        private int id;

        public Loader(Warehouse warehouse, int id) {
            this.warehouse = warehouse;
            this.id = id;
        }

        @Override
        public void run() {
            while (!warehouse.isEmpty()) {
                List<Item> itemsToLoad = warehouse.getItemsForLoader();
                if (!itemsToLoad.isEmpty()) {
                    int totalWeight = 0;
                    for (Item item : itemsToLoad) {
                        totalWeight += item.getWeight();
                    }
                    System.out.println("Грузчик " + id + " переносит " + totalWeight + " кг товаров.");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Грузчик " + id + " был прерван.");
                    }

                    System.out.println("Грузчик " + id + " завершил переноску.");
                }
            }
        }
    }

    public class MultiLoaderSimulation {
        public static void main(String[] args) {
            List<Item> items = new ArrayList<>();
            for (int i = 1; i <= 20; i++) {
                int weight = (int) (Math.random() * 30) + 1; 
                items.add(new Item(weight));
            }

            Warehouse warehouse = new Warehouse(items);

            Loader loader1 = new Loader(warehouse, 1);
            Loader loader2 = new Loader(warehouse, 2);
            Loader loader3 = new Loader(warehouse, 3);

            loader1.start();
            loader2.start();
            loader3.start();

            try {
                loader1.join();
                loader2.join();
                loader3.join();
            } catch (InterruptedException e) {
                System.out.println("Работа грузчиков была прервана.");
            }

            System.out.println("Все товары успешно перенесены.");
        }
    }
