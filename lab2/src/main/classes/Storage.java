package src.main.classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Storage {
    private static Storage instance;
    private Map<String, Object> storage;

    private Storage() {
        storage = new HashMap<>();
    }

    public static synchronized Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public void put(String key, Object value) {
        storage.put(key, value);
    }

    public Object get(String key) {
        return storage.get(key);
    }

    public Set<Entry<String, Object>> getEntrySet() {
        return storage.entrySet();
    }
}
