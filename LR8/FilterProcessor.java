import java.util.List; 
import java.util.stream.Collectors; 
public class FilterProcessor {
    @DataProcessor
    public void filterData(List<String> data) {
        // Строки длиной больше 5 символов
        List<String> filtered = data.stream()
        .filter(line -> line.length() > 5)
        .collect(Collectors.toList());
        data.clear();
        data.addAll(filtered);
    }
}