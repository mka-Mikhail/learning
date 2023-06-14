package lesson4.homework.classes.staticOuterClass;

public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    static class Query {
        void printToLog(String login) {
            System.out.printf("Пользователь %s отправил запрос", login);
        }
    }
}



class App {
    public static void main(String[] args) {
        User user = new User("nick", "pass");
        User.Query query = new User.Query();
        query.printToLog(user.getLogin());
    }
}