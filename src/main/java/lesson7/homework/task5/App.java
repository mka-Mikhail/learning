package lesson7.homework.task5;

public class App {
    public static void main(String[] args) {
        TelephoneDirectory.add("Иванов", "892312312");
        TelephoneDirectory.add("Михайлов", "89874336158");
        TelephoneDirectory.add("Куликов", "89012563789");
        TelephoneDirectory.add("Кузнецов", "89367854232");
        TelephoneDirectory.add("Кузнецов", "896543596482");
        TelephoneDirectory.add("Иванов", "89076543311");

        System.out.println("\nФамилия: Иванов:\n" + TelephoneDirectory.getNumberBySurname("Иванов"));
        System.out.println("\nФамилия: Михайлов:\n" + TelephoneDirectory.getNumberBySurname("Михайлов"));
        System.out.println("\nФамилия: Куликов:\n" + TelephoneDirectory.getNumberBySurname("Куликов"));
        System.out.println("\nФамилия: Кузнецов:\n" + TelephoneDirectory.getNumberBySurname("Кузнецов"));
    }
}
