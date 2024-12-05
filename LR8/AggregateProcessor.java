import java.util.List; 
import java.util.stream.Collectors; 
public class AggregateProcessor {
    @DataProcessor
    public void aggregateData(List<String> data) {
        // Подсчитываем количество строк
        int count = data.size();
        data.add("Total lines: " + count);
    }
}