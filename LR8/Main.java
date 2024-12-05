import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try {
            DataManager manager = new DataManager();
            manager.registerDataProcessor(new FilterProcessor());
            manager.registerDataProcessor(new TransformProcessor());
            manager.registerDataProcessor(new AggregateProcessor());

            // Загрузка данных из файла
            manager.loadData("source.txt");

            // Обработка данных
            manager.processData();

            // Сохранение обработанных данных в новый файл
            manager.saveData("output.txt");

            System.out.println("Данные успешно обработаны и сохранены.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}