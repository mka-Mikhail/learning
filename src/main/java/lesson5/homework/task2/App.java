package lesson5.homework.task2;

/**
 * -Xlog:gc:gc.log:time,pid,tid,level,tags - флаг запуска программы:
 * gc.log - куда сохранять лог,
 * time - дата и время записи,
 * pid - номер процесса,
 * tid - номер потока,
 * level - уровень сообщения,
 * tags - тег
 */
public class App {
    public static void main(String[] args) {
        int count = 0;
        String mask = "#";
        while (true) {
            String num = mask + (++count);
            A a = new A(num);
            a = null;
        }
    }
}
