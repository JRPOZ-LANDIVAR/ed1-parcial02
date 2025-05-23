package ed.lab;

import java.util.HashMap;
import java.util.Map;

public class E02Logger {
    private final Map<String, Integer> mensajesmap;

    public E02Logger() {
        mensajesmap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!mensajesmap.containsKey(message) || timestamp >= mensajesmap.get(message)) {
            mensajesmap.put(message, timestamp + 10);
            return true;
        }

        return false;
    }
}
