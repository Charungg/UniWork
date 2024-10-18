package main;

public class CuckooHashSet<K> implements Set<K>{

    private K[][] data;
    private int size;

    public CuckooHashSet(int capacity){
        data = (K[][]) new Object[2][capacity];
        size = capacity;
    }

    public int hashFunction(int functionNumber, K key){
        int hashCode;

        if (functionNumber == 0){
            hashCode = key.hashCode() % size;
            return hashCode;
        }

        else if (functionNumber == 1){
            hashCode = ((key.hashCode())/size) % size;
            return hashCode;
        }

        System.out.println("no");
        return -1;
    }

    public int[] findIndex(K key){
        int hashValue;
        int[] indexArray;

        for (int i = 0; i<2; i++ ){
            hashValue = hashFunction(i,key);
            if (data[i][hashValue] == key){
                System.out.println("Found dupe");
                indexArray = new int[] {i,hashValue};
                return indexArray;
            }
        }

        System.out.println("NULL");
        return null;
    }

    @Override
    public boolean contains(K key) {
        int[] position;
        position = findIndex(key);

        return (position != null);
    }

    @Override
    public boolean put(K key) {
        System.out.println("KEY = " + key);
        System.out.println("KEY Table 0 = " + (key.hashCode() % size));
        System.out.println("KEY Table 1 = " + ((key.hashCode()/size) % size));
        System.out.println("Data = " + data);

        if (contains(key)){
            return false;
        }

        int currentTable = 0;
        K currentKey = key;
        int evictions = 0;
        boolean keyPlaced = false;

        int hashValue;

        while (keyPlaced == false){
             K tempKeyHolder;
             hashValue = hashFunction(currentTable,currentKey);

             if (data[currentTable][hashValue] == null){
                 data[currentTable][hashValue] = key;
                 size++;
                 keyPlaced = true;
             }

             else if(data[currentTable][hashValue] != null){
                 tempKeyHolder = data[currentTable][hashValue];
                 data[currentTable][hashValue] = key;
                 key = tempKeyHolder;
                 evictions++;
                 currentTable = (currentTable + 1) % 2;
             }

            if (evictions>size){
                throw new IllegalStateException();
            }
        }

        return true;
    }

    @Override
    public boolean remove(K key) {
        int[] position;
        position = findIndex(key);

        if (position != null){
            data[position[0]][position[1]] = null;
            size--;
            return true;
        }

        return false;
    }
}
