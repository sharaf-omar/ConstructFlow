package com.constructflow.entity; // Ensure this matches your package structure

public class Client {

    // Fixed the auto-generated UML pseudo-code into proper Java attributes
    private int clientID; // Primary Key
    private String clientName;
    private String contactPerson;

    /**
     * Default constructor
     */
    public Client() {
        System.out.println("[Entity] Default Client created.");
    }

    /**
     * Parameterized constructor
     * @param clientID
     * @param clientName
     * @param contactPerson
     */
    public Client(int clientID, String clientName, String contactPerson) {
        this.clientID = clientID;
        this.clientName = clientName;
        this.contactPerson = contactPerson;
        System.out.println("[Entity] Client '" + clientName + "' created.");
    }

    // --- GETTERS AND SETTERS ---

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientID +
                ", clientName='" + clientName + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                '}';
    }
}