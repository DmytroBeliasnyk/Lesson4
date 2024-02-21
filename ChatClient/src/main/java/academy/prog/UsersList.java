package academy.prog;

import java.util.ArrayList;
import java.util.List;

public class UsersList {
    private List<String> users = new ArrayList<>();

    public UsersList(List<String> users) {
        this.users = users;
    }

    public List<String> getUsers() {
        return users;
    }
}
