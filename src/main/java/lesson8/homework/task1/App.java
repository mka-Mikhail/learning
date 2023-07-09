package lesson8.homework.task1;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Время операции в мс:
 * вставка:
 *      в начало:
 *          arrayList 2239000
 *          linkedList 442700
 *      в конец:
 *          arrayList 308800
 *          linkedList 297800
 *      в середину:
 *          arrayList 736500
 *          linkedList 33359700
 * чтение рандомного значения:
 *      из arrayList 1203600
 *      из linkedList 23629800
 */
public class App {
    private static ArrayList<Detail> detailsArrayList = new ArrayList<>();
    private static LinkedList<Detail> detailsLinkedList = new LinkedList<>();

    public static void main(String[] args) {
        initArrays();

        long time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            detailsArrayList.add(0, new Detail("@" + i));
        }
        System.out.println("В начало arrayList " + (System.nanoTime() - time));
        time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            detailsLinkedList.addFirst(new Detail("@" + i));
        }
        System.out.println("В начало linkedList " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            detailsArrayList.add(new Detail("#" + i));
        }
        System.out.println("В конец arrayList " + (System.nanoTime() - time));
        time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            detailsLinkedList.addLast(new Detail("#" + i));
        }
        System.out.println("В конец linkedList " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            detailsArrayList.add(detailsArrayList.size() / 2, new Detail("$" + i));
        }
        System.out.println("В середину arrayList " + (System.nanoTime() - time));
        time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            detailsLinkedList.add(detailsLinkedList.size() / 2, new Detail("$" + i));
        }
        System.out.println("В середину linkedList " + (System.nanoTime() - time));

        String element;
        time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            element = detailsArrayList.get((int) (Math.random() * detailsArrayList.size())).getNumber();
        }
        System.out.println("Рандомное значение из arrayList " + (System.nanoTime() - time));
        time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            element = detailsLinkedList.get((int) (Math.random() * detailsLinkedList.size())).getNumber();
        }
        System.out.println("Рандомное значение из linkedList " + (System.nanoTime() - time));
    }

    private static void initArrays() {
        for (int i = 0; i < 10000; i++) {
            detailsArrayList.add(new Detail("!" + i));
            detailsLinkedList.add(new Detail("!" + i));
        }
        System.out.println("arrayList: " + detailsArrayList.size() + "\nlinkedList: " + detailsLinkedList.size());
    }
}
