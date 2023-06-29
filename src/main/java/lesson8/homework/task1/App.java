package lesson8.homework.task1;

import java.util.ArrayList;
import java.util.LinkedList;

public class App {
    private static ArrayList<Detail> detailsArrayList = new ArrayList<>();
    private static LinkedList<Detail> detailsLinkedList = new LinkedList<>();

    public static void main(String[] args) {
        initArrays();

        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            detailsArrayList.add(i, new Detail("@" + i));
        }
        System.out.println("В начало arrayList " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            detailsLinkedList.addFirst(new Detail("@" + i));
        }
        System.out.println("В начало linkedList " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            detailsArrayList.add(new Detail("#" + i));
        }
        System.out.println("В конец arrayList " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            detailsLinkedList.addLast(new Detail("#" + i));
        }
        System.out.println("В конец linkedList " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            detailsArrayList.add(detailsArrayList.size() / 2, new Detail("$" + i));
        }
        System.out.println("В середину arrayList " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            detailsLinkedList.add(detailsLinkedList.size() / 2, new Detail("$" + i));
        }
        System.out.println("В середину linkedList " + (System.currentTimeMillis() - time));

        String element;
        time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            element = detailsArrayList.get((int) (Math.random() + detailsArrayList.size() - 1)).getNumber();
        }
        System.out.println("Рандомное значение из arrayList " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            element = detailsLinkedList.get((int) (Math.random() + detailsLinkedList.size() - 1)).getNumber();
        }
        System.out.println("Рандомное значение из linkedList " + (System.currentTimeMillis() - time));
    }

    private static void initArrays() {
        for (int i = 0; i < 10000; i++) {
            detailsArrayList.add(new Detail("!" + i));
            detailsLinkedList.add(new Detail("!" + i));
        }
        System.out.println("arrayList: " + detailsArrayList.size() + "\nlinkedList: " + detailsLinkedList.size());
    }
}
