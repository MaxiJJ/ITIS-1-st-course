package course1.april11;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyProperty {
    private Map<Object, Object> map;

    public MyProperty() {
        map = new HashMap<>();
    }

    public MyProperty(MyProperty defaults) {
        map = defaults.map;
    }

    public String getProperty(String key) {
        return map.get(key).toString();
    }

    public String getProperty(String key, String defaultValue) {
        Object value = map.get(key);
        return value == null ? defaultValue : value.toString();
    }

    public void load(InputStream inStream) throws IOException {
        load(new InputStreamReader(inStream));
    }

    public void load(Reader reader) throws IOException {
        BufferedReader buffReader = new BufferedReader(reader);
        String line;
        while ((line = buffReader.readLine()) != null) {
            String[] keyValue = line.split("=");
            map.put(keyValue[0], keyValue[1]);
        }
    }

    public void list(PrintStream out) {
        list(new PrintWriter(out));
    }

    public void list(PrintWriter out) {
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    public Object setProperty(String key, String value) {
        return map.put(key, value);
    }

    public void store(Writer writer, String comments) throws IOException {
        storeBuffer(new BufferedWriter(writer), comments);
    }

    public void store(OutputStream out, String comments) throws IOException {
        storeBuffer(new BufferedWriter(new OutputStreamWriter(out)), comments);
    }

    private void storeBuffer(BufferedWriter bf, String comments) throws IOException {
        bf.write("#" + comments);
        bf.newLine();

        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            bf.write(key + " = " + value);
            bf.newLine();
        }
        bf.flush();
    }

    public Set<String> stringPropertyNames() {
        Set<String> setKeys = new HashSet<>();
        for (Object key : map.keySet()) {
            setKeys.add(key.toString());
        }
        return setKeys;
    }

    @Override
    public String toString() {
        return stringPropertyNames().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyProperty that = (MyProperty) o;

        return map.equals(that.map);
    }

    @Override
    public int hashCode() {
        return map.hashCode();
    }
}
