package academy.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.LinkedHashSet;
import java.util.Set;

public class UserList {
    private static final UserList userList = new UserList();
    private final Gson gson;
    private final Set<String> users = new LinkedHashSet<>();

    public static UserList getInstance() {
        return userList;
    }

    private UserList() {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    public synchronized void add(String login) {
        users.add(login);
    }

    public synchronized String toJSON() {
        return gson.toJson(new JsonUsers(users));
    }
}


