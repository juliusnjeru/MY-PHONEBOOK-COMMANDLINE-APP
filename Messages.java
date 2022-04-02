package com.challenge;

public class Messages {
    private String text;
    private String recipient;
    private int id;

    public Messages(String text, String recipient, int id) {
        this.text = text;
        this.recipient = recipient;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void getDetails() {
        System.out.println("Contact Name: " + recipient
                + "\n Message: " + text
                + "\nid: " + id);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
