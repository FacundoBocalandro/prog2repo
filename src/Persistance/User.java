package Persistance;

import java.util.List;

public class User implements CreateFromAttributes<User>{
    private String id;
    private String name;
    private String surname;
    private String password;

    public User(String id, String name, String surname, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public User(){}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof User && ((User) obj).getId().equals(id);
    }


    @Override
    public void addAttributes(List<Object> attributes) {
        id = (String) attributes.get(0);
        name = (String) attributes.get(1);
        surname = (String) attributes.get(2);
        password = (String) attributes.get(3);
    }
}
