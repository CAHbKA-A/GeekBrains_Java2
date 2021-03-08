package Lesson_7.Server.interfaces;

public interface AuthenticationInt {
    String authenticationAlgorithm(String login, String pass);

    void createMemberList();
}


