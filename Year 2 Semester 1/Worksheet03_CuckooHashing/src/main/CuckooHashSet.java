package main;

public class CuckooHashSet<K> implements Set<K>{

    private K[][] data;
    private int size;

    private int capacity;



    public CuckooHashSet(int capacity){
        data = (K[][]) new Object[2][capacity];
        size = 0;
        this.capacity = capacity;
    }

    public int hashFunction(int functionNumber, K key){
        int hashCode;

        if (functionNumber == 0){
            hashCode = (key.hashCode()) % capacity;
            return hashCode;
        }

        else if (functionNumber == 1){
            hashCode = ((key.hashCode())/capacity) % capacity;
            return hashCode;
        }

        return -1;
    }

    public int[] findIndex(K key){
        int hashValue;
        int[] indexArray;

        for (int i = 0; i<2; i++ ){
            hashValue = hashFunction(i,key);
            if (data[i][hashValue] == key){
                System.out.println(key + " is dupe");
                System.out.println("Table " + i + " in index " + hashValue);
                indexArray = new int[] {i, hashValue};
                return indexArray;

            }
            else{
                System.out.println(key + " does not exist within table " + i);
            }
        }

        System.out.println(key + " does not exist, returning null");
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
        System.out.println("-------------------------------------------------------------");
        System.out.println("KEY = " + key);
        System.out.println("KEY Table 0 = " + (key.hashCode() % capacity));
        System.out.println("KEY Table 1 = " + ((key.hashCode()/capacity) % capacity));

        if (contains(key)){
            return false;
        }

        int currentTable = 0;
        int evictions = 0;
        int hashValue;
        K currentKey = key;
        K tempKey;
        boolean keyPlaced = false;

        while (keyPlaced == false){
            hashValue = hashFunction(currentTable,key);
            if (evictions > size){
                throw new IllegalStateException();
            }

            else if (data[currentTable][hashValue] == null){
                data[currentTable][hashValue] = key;
                keyPlaced = true;
            }

            else if(data[currentTable][hashValue] != null){
                tempKey = data[currentTable][hashValue];
                data[currentTable][hashValue] = key;
                key = tempKey;
                currentTable = (currentTable + 1) % 2;
                evictions++;
            }
        }

        size++;
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

    public void printData(){
        System.out.print("\n");
        System.out.println("Table 0:");
        System.out.print("[");
        for (int i =0; i<data[0].length; i++){
            System.out.print((data[0][i]) + ", ");
        }
        System.out.println("]");

        System.out.println("Table 1:");
        System.out.print("[");
        for (int i =0; i<data[0].length; i++){
            System.out.print((data[1][i]) + ", ");
        }
        System.out.println("]");
        System.out.print("\n");
    }
}
