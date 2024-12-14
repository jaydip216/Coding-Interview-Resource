package com.lowLevelDesign.keyValueStore;

import java.util.*;

public class KeyValueStore {
    private Map<String, String> store; // Main key-value store
    private Stack<Map<String, String>> transactions; // Stack to maintain transactional states
    private boolean isTransaction; // Flag to indicate if a transaction is active
    private static KeyValueStore instance = null; // Singleton instance

    private KeyValueStore() {
        store = new HashMap<>();
        transactions = new Stack<>();
        isTransaction = false;
    }

    public static KeyValueStore getInstance() {
        if (instance == null) {
            instance = new KeyValueStore();
        }
        return instance;
    }

    // Start a transaction
    public void begin() {
        if (!isTransaction) {
            isTransaction = true;
        }
        transactions.push(new HashMap<>(store)); // Save the current state
        System.out.println("Transaction started.");
    }

    // Commit the current transaction
    public void commit() {
        if (!isTransaction || transactions.isEmpty()) {
            System.out.println("No active transaction to commit.");
            return;
        }
        transactions.pop(); // Discard saved state
        if (transactions.isEmpty()) {
            isTransaction = false; // No active transactions left
        }
        System.out.println("Transaction committed.");
    }

    // Rollback the current transaction
    public void rollback() {
        if (!isTransaction || transactions.isEmpty()) {
            System.out.println("No active transaction to rollback.");
            return;
        }
        store = transactions.pop(); // Restore the last saved state
        if (transactions.isEmpty()) {
            isTransaction = false; // No active transactions left
        }
        System.out.println("Transaction rolled back.");
    }

    // Add or update a key-value pair
    public void put(String key, String value) {
        store.put(key, value);
        System.out.println("Put: " + key + " = " + value);
    }

    // Retrieve a value by key
    public void get(String key) {
        String value = store.get(key);
        if (value != null) {
            System.out.println("Get: " + key + " = " + value);
        } else {
            System.out.println("Get: " + key + " not found.");
        }
    }

    // Delete a key-value pair
    public void delete(String key) {
        if (store.containsKey(key)) {
            store.remove(key);
            System.out.println("Deleted: " + key);
        } else {
            System.out.println("Delete: " + key + " not found.");
        }
    }

    // For debugging purposes: Print the current state of the store
    public void printStore() {
        System.out.println("Current Store: " + store);
    }

    public static void main(String[] args) {
        KeyValueStore kvStore = KeyValueStore.getInstance();

        // Basic operations
        kvStore.put("key1", "value1");
        kvStore.put("key2", "value2");
        kvStore.get("key1");
        kvStore.delete("key2");
        kvStore.get("key2");

        // Transactions
        kvStore.begin();
        kvStore.put("key3", "value3");
        kvStore.get("key3");
        kvStore.rollback();
        kvStore.get("key3");

        kvStore.begin();
        kvStore.put("key4", "value4");
        kvStore.commit();
        kvStore.get("key4");

        // Print final state
        kvStore.printStore();
    }
}
