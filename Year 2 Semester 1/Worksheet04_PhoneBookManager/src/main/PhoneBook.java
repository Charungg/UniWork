package main;

/**
 * An interface that you need to implement to solve the task.
 * @author Christine Zarges
 * @version 2.0, 17th October 2019
 */

public interface PhoneBook {

    /**
     * Method to look up the owner of phone number.
     * @param phoneNumber the phone number whose owner is to be returned
     * @return the name of the owner, or null if the number does not exist
     */
    public String search(int phoneNumber);

    /**
     * Method to add a new contact with phone number and name to the phone book. If the phone number already exists,
     * the query is ignored. Otherwise the new contact is added. Returns a boolean indicating if adding the contact
     * was successful.
     * @param phoneNumber the phone number of the new contact
     * @param name the name in the new contact
     * @return true if the entry was added, false if the phone number already exists
     */
    public boolean add(int phoneNumber, String name);

    /**
     * Method to update the name associated with a given phone number. If the phone number does not exist, the
     * query is ignored. Otherwise, the associated name is updated and the old name returned.
     * @param phoneNumber the phone number of the contact to be updated
     * @param name the new name of the contact
     * @return the old name if the entry was updated, null if the phone number does not exist
     */
    public String update(int phoneNumber, String name);

    /**
     * Method to remove a contact with a given phone number.
     * @param phoneNumber the phone number of the contact to be deleted
     * @return the name of the associated person, or null if the name does not exist
     */
    public String remove(int phoneNumber);

    // Implementing task 4
    public Integer search(String name);

    public Integer remove(String name);

    public Integer update(String name, int phoneNumber);

}
