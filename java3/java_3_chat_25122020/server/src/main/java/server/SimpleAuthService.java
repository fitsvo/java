package server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService implements AuthService {
    private static Connection connection;
    private static Statement stmt;

    private class UserData {
        String login;
        String password;
        String nickname;

        public UserData(String login, String password, String nickname) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }
    }

    private List<UserData> users;

    private static void connection() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:auth.db");
        stmt = connection.createStatement();
    }

    private static void disconnect(){
        try {
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public SimpleAuthService() {
        try {
            connection();
            users = new ArrayList<>();
            ResultSet rs = stmt.executeQuery("SELECT login, password, nickname FROM users;");
            while (rs.next()){
                users.add(new UserData(rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("nickname")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        for (UserData user : users) {
            if(user.login.equals(login) && user.password.equals(password)){
                return user.nickname;
            }
        }
        return null;
    }

    @Override
    public boolean registration(String login, String password, String nickname) {
        for (UserData user : users) {
            if(user.login.equals(login) || user.nickname.equals(nickname)){
                return false;
            }
        }

        users.add(new UserData(login, password, nickname));
        return true;
    }
}
