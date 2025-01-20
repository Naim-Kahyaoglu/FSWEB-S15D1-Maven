package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    // Constructor that takes two parameters: myNumber and a list of contacts
    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts != null ? new ArrayList<>(myContacts) : new ArrayList<>();
    }

    // Getter for myNumber
    public String getMyNumber() {
        return myNumber;
    }

    // Getter for myContacts
    public List<Contact> getMyContacts() {
        return myContacts;
    }

    // Method to add a new contact
    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return false; // Contact already exists
        }
        myContacts.add(contact);
        return true;
    }

    // Method to update an existing contact
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            return false; // Contact not found
        }

        // Check if the new contact already exists (but allow update for the same name)
        if (findContact(newContact.getName()) != -1 && !oldContact.getName().equals(newContact.getName())) {
            return false; // Cannot update to an existing contact name
        }

        myContacts.set(foundPosition, newContact);
        return true;
    }

    // Method to remove a contact
    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            return false; // Contact not found
        }

        myContacts.remove(foundPosition);
        return true;
    }

    // Method to find a contact by the Contact object
    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    // Method to find a contact by the name (String)
    public int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1; // Contact not found
    }

    // Method to query a contact by name and return the Contact object
    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return myContacts.get(position);
        }
        return null; // Contact not found
    }

    // Method to print all contacts
    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}
