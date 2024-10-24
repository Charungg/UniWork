package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashPhoneBook implements PhoneBook{

    Map<Integer, String> phoneBook = new HashMap<>();

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


    // Task 4
    @Override
    public Integer search(String name) {
        for (Integer i: phoneBook.keySet()){
            if (phoneBook.get(i) == name){
                return i;
            }
        }

        return null;
    }

    @Override
    public Integer remove(String name) {
        return null;
    }

    @Override
    public Integer update(String name, int phoneNumber) {
        return null;
    }
}
