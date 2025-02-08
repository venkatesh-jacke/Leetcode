package HashTable;

import java.util.*;

//2349. Design a Number Container System

public class NumberContainers {
    HashMap<Integer,TreeSet<Integer>> numberToIndices;
    HashMap<Integer,Integer> indexToNumbers;

    public NumberContainers() {
        numberToIndices= new HashMap<>();
        indexToNumbers=  new HashMap<>();
    }

    public void change(int index, int number) {
        // If index already has a number, remove it from the old number's index set
        if(indexToNumbers.containsKey(index)){
            int prevNumber = indexToNumbers.get(index);
            numberToIndices.get(prevNumber).remove(index);
            if(numberToIndices.get(prevNumber).isEmpty()){
                numberToIndices.remove(prevNumber);
            }
        }
        // Update the number and add the index to the new number's set
        indexToNumbers.put(index,number);
        numberToIndices.putIfAbsent(number, new TreeSet<>());
        numberToIndices.get(number).add(index);
    }

    public int find(int number) {
        if(!numberToIndices.containsKey(number)) return -1;
        return numberToIndices.get(number).first();
    }
}