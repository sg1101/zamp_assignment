import java.util.LinkedList;
import java.util.List;

public class AddressBook {
    TrieNode nameTrie;
    TrieNode phoneTrie;

    public AddressBook() {
        this.nameTrie = new TrieNode();
        this.phoneTrie = new TrieNode();
    }

    public void addContact(String firstName, String lastName, String address, String phoneNumber) {
        Contact contact = new Contact(firstName, lastName, address, phoneNumber);
        insertIntoTrie(nameTrie, firstName.toLowerCase()+lastName.toLowerCase(), contact);
        insertIntoTrie(phoneTrie, phoneNumber, contact);
    }

    private void insertIntoTrie(TrieNode root, String key, Contact contact) {
        TrieNode node = root;
        for (char ch : key.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.contacts.add(contact);
    }

    public List<Contact> searchByName(String name) {
        // Using replaceAll to remove spaces
        String searchName = name.replaceAll("\\s", "");
        return searchInTrie(nameTrie, searchName.toLowerCase());
    }

    public List<Contact> searchByPhoneNumber(String phoneNumber) {
        return searchInTrie(phoneTrie, phoneNumber);
    }

    private List<Contact> searchInTrie(TrieNode root, String key) {
        TrieNode node = root;
        for (char ch : key.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return new LinkedList<>(); // No matching contacts found
            }
            node = node.children.get(ch);
        }
        List<Contact> matchingContacts = new LinkedList<>();

//        matchingContacts.addAll(node.contacts);

        // Collect contacts from all nodes below this point - additional functionality
        // to return all the results which have the prefix matched with the given input
        // To disable: uncomment line 48 and comment line 53
        collectContacts(node, matchingContacts);

        return matchingContacts;
    }

    // Helper method to recursively collect contacts from a trie node and its children
    // based on the prefix matching with the input string
    private void collectContacts(TrieNode node, List<Contact> result) {
        result.addAll(node.contacts);

        for (TrieNode child : node.children.values()) {
            collectContacts(child, result);
        }
    }
}
