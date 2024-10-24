package tests;

import main.PhoneBook;
import main.HashPhoneBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the HashPhoneBook
 *
 * @author Christine Zarges
 * @version 1.0, 16 October 2019
 */
public class TestHashPhoneBook {
    private PhoneBook phoneBook;

    @BeforeEach
    public void setUp() {
        phoneBook = new HashPhoneBook();
    }

    @Test
    @DisplayName("Search and Insert.")
    public void testSearchAndInsert() {
        // Search for entry in empty phone book. Should return null.
        assertEquals(null, phoneBook.search(123456),
                "Phone number 123456 found, but should not be in phone book.");

        // Add a new entry. Should return true for successful insert.
        assertEquals(true, phoneBook.add(123456, "Test"),
                "Entry (123456, Test) not successfully added.");

        // Search for entry just added. Should return the associated name.
        assertEquals("Test", phoneBook.search(123456),
                "Phone number 123456 not found or associated with the wrong name.");

        // Try to add the same entry a second time. Should return false as entry exists.
        assertEquals(false, phoneBook.add(123456, "Test"),
                "Entry (123455, Test) should not be added as it already exists.");

        // Search for the entry again. Should still return the associated name.
        assertEquals("Test", phoneBook.search(123456),
                "Phone number 123456 not found or associated with the wrong name.");

        // Try to add the same entry a third time - now with different name. Should return false as entry exists.
        assertEquals(false, phoneBook.add(123456, "Test2"),
                "Entry (123455, Test2) should not be added as key already exists.");

        // Search for the entry again. Should still return the old associated name.
        assertEquals("Test", phoneBook.search(123456),
                "Phone number 123456 not found or associated with the wrong name.");
    }

    @Test
    @DisplayName("Remove.")
    public void testRemove() {
        // Remove entry from empty phone book. Should return null for unsuccessful delete.
        assertEquals(null, phoneBook.remove(123456),
                "Entry (123456, Test) cannot be removed as it does not exist.");

        // Search for entry. Should return null as entry does not exist.
        assertEquals(null, phoneBook.search(123456),
                "Phone number 123456 found, but should not be in phone book.");

        // Add a new entry. Should return true for successful insert.
        assertEquals(true, phoneBook.add(123456, "Test"),
                "Entry (123456, Test) not added.");

        // Remove entry. Should return associated name for successful delete.
        assertEquals("Test", phoneBook.remove(123456),
                "Phone number 123456 not removed or associated with the wrong name");

        // Search for entry just removed. Should return null as entry does not exist any more.
        assertEquals(null, phoneBook.search(123456),
                "Phone number 123456 found, but should not be in phone book.");

        // Remove entry again. Should return null for unsuccessful delete.
        assertEquals(null, phoneBook.remove(123456),
                "Entry (123456, Test) cannot be removed as it does not exist.");

        // Add a new entry (same key, different value). Should return true for successful insert.
        assertEquals(true, phoneBook.add(123456, "Test2"),
                "Entry (123456, Test2) not added.");

        // Search for entry. Should return associated name.
        assertEquals("Test2", phoneBook.search(123456),
                "Phone number 123456 not found or associated with the wrong name..");
    }

    @Test
    @DisplayName("Update.")
    public void testUpdate() {
        // Try to update entry in empty phone book. Should return null.
        assertEquals(null, phoneBook.update(123456, "Test2"),
                "Phone number 123456 does not exist, so should not be updated.");

        // Search for entry in empty phone book. Should return null.
        assertEquals(null, phoneBook.search(123456),
                "Phone number 123456 found, but should not be in phone book.");

        // Add a new entry. Should return true for successful insert.
        assertEquals(true, phoneBook.add(123456, "Test"),
                "Entry (123456, Test) not successfully added.");

        // Search for entry just added. Should return the associated name.
        assertEquals("Test", phoneBook.search(123456),
                "Phone number 123456 not found or associated with the wrong name.");

        // Update the entry. Should return old associated name for successful update.
        assertEquals("Test", phoneBook.update(123456, "Test2"),
                "Key 123456 not successfully updated or associated with the wrong name.");

        // Search for entry just updated. Should return the new associated name.
        assertEquals("Test2", phoneBook.search(123456),
                "Phone number 123456 not found or associated with the wrong name.");
    }

    @Test
    @DisplayName("Sample Phone Book (small).")
    public void testSample() {
        File file = new File("phoneBook-small.txt");
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(file));

            // read file line by line
            String readLine;
            while ((readLine = buffer.readLine()) != null) {
                String[] entry = readLine.split("\\s");
                int phoneNumber = Integer.parseInt(entry[0]);

                //add to phone book
                phoneBook.add(phoneNumber, entry[1]);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found. Starting with empty phone book.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Unable to read file. Starting with empty phone book.");
        }

        // Search for non-existing entry in phone book. Should return null.
        assertEquals(null, phoneBook.search(234540),
                "Phone number 234540 found, but should not be in phone book.");

        // Search for existing entry in phone book. Should return associated name.
        assertEquals("Darryl", phoneBook.search(123600),
                "Phone number 123600 not found or associated with the wrong name.");

        // Add new entry with existing key. Should return false for unsuccessful insert.
        assertEquals(false, phoneBook.add(123600, "Test"),
                "Key 123600 should not be added as it already exists.");

        // Search for existing entry in phone book. Should return associated name.
        assertEquals("Darryl", phoneBook.search(123600),
                "Phone number 123600 not found or associated with the wrong name.");

        // Add new entry. Should return true for successful insert.
        assertEquals(true, phoneBook.add(234540, "Test2"),
                "Key 234540 not successfully added.");

        // Search for existing entry in phone book. Should return associated name.
        assertEquals("Test2", phoneBook.search(234540),
                "Phone number 234540 not found or associated with the wrong name.");

        // Update entry with non-existing key. Should return null for unsuccessful update.
        assertEquals(null, phoneBook.update(234541, "Test3"),
                "Key 234541 cannot be updated as it does not exist.");

        // Search for non-existing entry in phone book. Should return null.
        assertEquals(null, phoneBook.search(234541),
                "Phone number 234541 does not exist.");

        // Update entry with existing key. Should return old associated name for successful update.
        assertEquals("Darryl", phoneBook.update(123600, "Test3"),
                "Key 123600 not updated.");

        // Search for update entry in phone book. Should return new associated name.
        assertEquals("Test3", phoneBook.search(123600),
                "Phone number 123600 not found or associated with the wrong name.");

        // Remove entry with non-existing key. Should return null for unsuccessful remove.
        assertEquals(null, phoneBook.remove(234541),
                "Key 234541 cannot be removed as it does not exist.");

        // Search for non-existing entry in phone book. Should return null.
        assertEquals(null, phoneBook.search(234541),
                "Phone number 234541 does not exist.");

        // Remove entry with existing key. Should return associated name for successful remove.
        assertEquals("Shannon", phoneBook.remove(123602),
                "Key 123600 not removed or associated with the wrong name.");

        // Search for removed entry in phone book. Should return null.
        assertEquals(null, phoneBook.search(123602),
                "Phone number 234541 does not exist.");
    }
}
