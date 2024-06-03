package exercise;

import java.util.Map;


// BEGIN
public final class FileKV implements KeyValueStorage {
    private String filepath;

    public FileKV(String path, Map<String, String> data) {
        filepath = path;
        Utils.writeFile(path, Utils.serialize(data));
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> dataBaseUpdated = Utils.unserialize(Utils.readFile(filepath));
        dataBaseUpdated.put(key, value);
        Utils.writeFile(filepath, Utils.serialize(dataBaseUpdated));
    }

    @Override
    public void unset(String key) {
        Map<String, String> dataBaseUpdated = Utils.unserialize(Utils.readFile(filepath));
        dataBaseUpdated.remove(key);
        Utils.writeFile(filepath, Utils.serialize(dataBaseUpdated));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> dataBase = Utils.unserialize(Utils.readFile(filepath));
        return dataBase.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.unserialize(Utils.readFile(filepath));
    }
}
// END
