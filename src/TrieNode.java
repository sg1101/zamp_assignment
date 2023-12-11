import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children;
    List<Contact> contacts;

    public TrieNode() {
        this.children = new HashMap<>();
        this.contacts = new LinkedList<>();
    }
}
