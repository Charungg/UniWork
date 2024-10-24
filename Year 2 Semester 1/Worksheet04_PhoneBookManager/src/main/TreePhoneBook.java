package main;

import java.util.TreeMap;
import java.util.Map;

public class TreePhoneBook implements PhoneBook{

    Map<Integer, String> phoneBook = new TreeMap<>();

    @Override
    public String search(int phoneNumber) {
        return (phoneBook.get(phoneNumber));
    }

    @Override
    public boolean add(int phoneNumber, String name) {
        if (phoneBook.get(phoneNumber) != null){
            return false;
        }

        phoneBook.put(phoneNumber,name);
        return true;
    }

    @Override
    public String update(int phoneNumber, String name) {
        String phoneName;
        phoneName = phoneBook.get(phoneNumber);

        if (phoneName == null){
            return null;
        }

        phoneBook.put(phoneNumber, name);
        return phoneName;
    }

    @Override
    public String remove(int phoneNumber) {
        String phoneName;
        phoneName = phoneBook.get(phoneNumber);

        if (phoneName == null){
            return null;
        }

        phoneBook.remove(phoneNumber);
        return phoneName;
    }
}
