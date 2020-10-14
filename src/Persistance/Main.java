package Persistance;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        GenController<User> userController = new GenController<>("src/Persistance/users", User.class);

        for (User user : userController.readFromFile()) {
            System.out.println("nombre: " + user.getName());
            System.out.println("apellido: " + user.getSurname());
            System.out.println("pass: " + user.getPassword());
        }

//        userController.addUser(new User("2", "ignacio", "chalub", "1234"));
    }
}
