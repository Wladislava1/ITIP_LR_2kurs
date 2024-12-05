import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class DataManager {
    private final List<Object> processors = new ArrayList<>();
    private List<String> data;

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) throws IOException {
        data = Files.readAllLines(Paths.get(source));
    }

    public void processData() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        
        for (Object processor : processors) {
            for (var method : processor.getClass().getMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    executorService.submit(() -> {
                        try {
                            method.invoke(processor, data);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        }
        
        executorService.shutdown();
        while (!executorService.isTerminated()) {}
    }

    public void saveData(String destination) throws IOException {
        Files.write(Paths.get(destination), data);
    }
}