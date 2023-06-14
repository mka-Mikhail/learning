package lesson4.homework.classes.innerClass;

public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    void createQuery() {
        new Query().printToLog();
    }

    class Query {
        void printToLog() {
            System.out.println("Пользователь " + User.this.login + " отправил запрос");
        }
    }
}

class App {
    public static void main(String[] args) {
        User user = new User("nick1", "pass1");
        user.createQuery();
        User.Query query = new User("nick2", "pass2").new Query();
        query.printToLog();
    }
}