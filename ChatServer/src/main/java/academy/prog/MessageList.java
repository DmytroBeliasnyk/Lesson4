package academy.prog;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MessageList {
    private static final MessageList msgList = new MessageList();
    private final Gson gson;
    private final List<Message> list = new LinkedList<>();

    public static MessageList getInstance() {
        return msgList;
    }

    private MessageList() {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    public synchronized void add(Message m) {
        list.add(m);
    }

    public synchronized Message get() {
        return list.get(list.size() - 1);
    }

    public synchronized boolean isEmpty(MessageList ml) {
        return list.isEmpty();
    }

    public synchronized void remove(Message m) {
        list.remove(m);
    }

    public synchronized String toJSON(int n) {
        if (n < 0 || n >= list.size()) return null;
        return gson.toJson(new JsonMessages(list, n));
    }
}
