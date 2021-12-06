package com.github.zipcodewilmington;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMap2 implements HashMapX{
    SinglyLinkedList[] hashArray = new SinglyLinkedList[26];
    public DashaMap2(){
        for(int i = 0; i< 26; i++){
            //+97
            hashArray[i] = new SinglyLinkedList(new Node<>(Character.toString((char) i + 97),null));
        }
    }

    @Override
    public void set(String key, String value) {
        hashArray[Integer.parseInt(Objects.requireNonNull(HashFunctionTwo(key)))].addNode(new Node<>(key,value,null));
    }

    @Override
    public String delete(String key) {
        SinglyLinkedList sll = hashArray[Integer.parseInt(Objects.requireNonNull(HashFunctionTwo(key)))];
        String comeback = null;
        while(sll.contains(new Node<String>(key,null))){
            comeback = sll.removeNode(new Node<String>(key,null)).getKey();
        }
        return comeback;
    }

    @Override
    public String get(String key) {
        return hashArray[Integer.parseInt(Objects.requireNonNull(HashFunctionTwo(key)))].getNode(new Node<String>(key,null)).getKey();
    }

    @Override
    public boolean isEmpty() {
        for(SinglyLinkedList sll: hashArray){
            if(sll.size > 1){
                return false;
            }
        }
        return true;
    }

    @Override
    public long size() {
        AtomicLong i = new AtomicLong(0);
        Arrays.stream(hashArray)
                .forEach(q -> i.addAndGet(q.size));
        return i.longValue();
    }

    @Override
    public boolean bucketSize(String key) {
        return false;
    }
    private String HashFunctionTwo(String input) {
        if (input.length() > 0) {
            return String.valueOf(input.charAt(1)).toLowerCase(Locale.ROOT);
        }
        return null;
    }
}
