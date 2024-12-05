import java.util.List; 
import java.util.stream.Collectors; 
public class TransformProcessor {
    @DataProcessor
    public void transformData(List<String> data) {
        // Преобразуем строки в верхний регистр
        List<String> transformed = data.stream()
        .map(line -> line.toUpperCase())
        .collect(Collectors.toList());
        data.clear();
        data.addAll(transformed);
    }
}