package lesson4.homework.classes.localInnerClass;

public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    void createQuery() {
        String log = "ЗАПРОС";
        class Query {
            void printToLog() {
                System.out.printf("%s Пользователь %s отправил запрос", log, User.this.login);
            }
        }
        new Query().printToLog();
    }
}

class App {
    public static void main(String[] args) {
        User user = new User("qwer1", "opi1");
        user.createQuery();
    }
}