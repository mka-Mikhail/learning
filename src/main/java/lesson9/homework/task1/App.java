package lesson9.homework.task1;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@AllArgsConstructor
class Spec {
    private String field1;
    private String field2;
    private String field3;
}

public class App {
    public static void main(String[] args) {
        Map<String, Map<String, String>> mp = new HashMap<>();
        mp.put("key1", new HashMap<>(){{
            put("Art1", "100");
            put("Max1", "200");
        }});
        mp.put("key2", new HashMap<>(){{
            put("Rita2", "300");
            put("Sasha2", "400");
            put("Igor2", "500");
        }});

        List<Spec> specs = mp.entrySet().stream()
                .flatMap(entry -> entry.getValue().entrySet().stream()
                        .map(innerEntry -> new Spec(entry.getKey(), innerEntry.getKey(), innerEntry.getValue())))
                .toList();

        for (Spec spec : specs) {
            System.out.println(spec);
        }
    }
}
