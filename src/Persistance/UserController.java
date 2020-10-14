package Persistance;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class UserController {
    private static String filePath = "src/Persistance/users";
    private Set<User> users;

    public UserController() throws IOException {
        users = getUsersFromFile();
    }

    private Set<User> getUsersFromFile() throws IOException {
        Set<User> users = new HashSet<>();

        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String userInfo;
        while ((userInfo = br.readLine()) != null) {
            String[] userParts = userInfo.split(",");
            User user = new User(userParts[0], userParts[1], userParts[2], userParts[3]);
            users.add(user);
        }
        return users;
    }

    public void writeUsersToFile(){
        try {
            FileWriter fw = new FileWriter(filePath);
            for (User user : users) {
                fw.write(user.getId() + "," + user.getName() + "," + user.getSurname() + "," + user.getPassword() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user){
        users.add(user);
        writeUsersToFile();
    }

    public Set<User> getUsers() {
        return users;
    }
}
