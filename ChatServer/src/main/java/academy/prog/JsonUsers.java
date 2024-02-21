package academy.prog;

import java.util.Set;
import java.util.TreeSet;

public class JsonUsers {
    private final Set<String> users = new TreeSet<>();

    public JsonUsers(Set<String> sourceList) {
        users.addAll(sourceList);
    }
}
