package com.challenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id = 0;

    public static void main(String[] args) {
        contacts = new ArrayList<>();
        System.out.println("Welcome to my humble world of programming...");
        showInitialOptions();
    }

    public static void showInitialOptions() {
        System.out.println(
                "Please select one: " +
                        "\n\t1. Manage Contacts" +
                        "\n\t2. Messages" +
                        "\n\t 3. Quit"
        );

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                manageContacts();
                break;
            case 2:
                managemessages();
                break;
            default:
                break;

        }
    }

    private static void managemessages() {
        System.out.println(
                "Please select one: " +
                        "\n\t1. Show all messages" +
                        "\n\t2. Send a new message" +
                        "\n\t 3. GO back"
        );

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllMessages();
                break;
            case 2:
                sendNewmessages();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void sendNewmessages() {
        System.out.println("Who are you doing to send the message to");
        String name = scanner.next();
        if (name.equals("")) {
            System.out.println("Pleas enter the name of the new contact: ");
            sendNewmessages();
        } else {
            boolean doesNotExist = false;
            for (Contact c : contacts) {
                if (c.getMessages().equals(name)) {
                    doesNotExist = true;
                }
            }
            if (doesNotExist) {
                System.out.println("What are you doing to say?");
                String text = scanner.next();

                if (text.equals("")) {
                    System.out.println("Please enter some text");
                    sendNewmessages();
                } else {
                    id++;
                    Messages newMessage = new Messages(text, name, id);
                    for (Contact c : contacts) {
                        if (c.getName().equals(name)) {
                            ArrayList<Messages> newMessges = c.getMessages();
                            newMessges.add(newMessage);

                            Contact currentContact = c;
                            currentContact.setMessages(newMessges);

                            contacts.remove(c);

                            contacts.add(currentContact);
                        }
                    }
                }


            } else {
                System.out.println("There is such no contact");
            }
        }
        showInitialOptions();

    }

    private static void showAllMessages() {
        ArrayList<Messages> allMessages = new ArrayList<>();
        for (Contact c : contacts) {
            allMessages.addAll(c.getMessages());
        }

        if (allMessages.size() > 0) {
            for (Messages m : allMessages) {
                m.getDetails();
                System.out.println("*********");


            }

        } else {
            System.out.println("You do not have any message");
        }

    }

    public static void manageContacts() {
        System.out.println("Please select one: " +
                "\n\t1. Show Contacts" +
                "\n\t2. Add a new contact" +
                "\n\t3. Search for a contact" +
                "\n\t4. Delete a contact" +
                "\n\t5. Go back");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContacts();
                break;
            case 3:
                searchForContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void deleteContact() {
        System.out.println("Please enter a name: ");
        String name = scanner.next();

        if (name.equals("")) {
            System.out.println("Please enter a name: ");
            deleteContact();
        } else {
            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                    contacts.remove(c);
                }
            }
            if (!doesExist) {
                System.out.println("There is no such contact");
            }
        }
    }

    private static void searchForContact() {
        System.out.println("Please enter the contact's name: ");
        String name = scanner.next();
        if (name.equals("")) {
            System.out.println("Please enter a name");
            searchForContact();
        } else {
            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                    c.getDetails();
                }
            }
            if (!doesExist) {
                System.out.println("There is no such contact in your phone.");
            }
        }
        showInitialOptions();
    }

    private static void addNewContacts() {
        System.out.println("Adding a new contact..." +
                "\nPlease enter the contact's name:");

        String name = scanner.next();

        System.out.println("Please enter a contact's number: ");
        String number = scanner.next();

        System.out.println("Please enter a contact's email: ");
        String email = scanner.next();

        if (name.equals("") || number.equals("") || number.equals("")) {
            System.out.println("Please enter all the information");
            addNewContacts();
        } else {

            boolean doesNotExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesNotExist = true;
                }
            }

            if (doesNotExist) {
                System.out.println("We have a contact named " + name + " saved on this device.");
            }

            Contact contact = new Contact(name, number, email);
            contacts.add(contact);

            System.out.println(name + " was added successfully");
        }

        showInitialOptions();
    }

    private static void showAllContacts() {
        for (Contact c : contacts) {
            c.getDetails();

        }
        showInitialOptions();
    }

}
