package Persistance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class GenController<T extends CreateFromAttributes<T>> {
    private List<T> elements;
    private String path;
    Class<T> clazz;

    public GenController(String path, Class<T> clazz){
        elements = new ArrayList<>();
        this.path = path;
        this.clazz = clazz;
    }

    public List<T> readFromFile() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<T> result = new ArrayList<>();

        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String objectInfo;
        while ((objectInfo = br.readLine()) != null) {
            String[] userParts = objectInfo.split(",");

            List<Object> attributes = new ArrayList<>();
            for (String part : userParts) {
                char first = part.charAt(0);

                if (first == '[') {
                    attributes.add(part.substring(1, part.length() - 2).split(";"));
                } else {
                    attributes.add(part);
                }
            }
            result.add(createObject(attributes));
        }


        return result;
    }

    T createObject(List<Object> attributes) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        T obj = clazz.getDeclaredConstructor().newInstance();
        obj.addAttributes(attributes);
        return obj;
    }
}
