package exercise;

import java.util.Map;


// BEGIN
public class App {

    public static void swapKeyValue(KeyValueStorage dataBase) {
        Map<String, String> dataBaseSwap = dataBase.toMap();

        dataBaseSwap.forEach((k, v) -> {
            dataBase.set(v, k);
            dataBase.unset(k);
        });
    }
}
// END
