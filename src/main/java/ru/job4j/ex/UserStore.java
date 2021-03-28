package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("No user");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() && (user.getUsername().length() > 3)) {
            return true;
        }
        throw new UserInvalidException("User invalid or name length < 3");
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Qwerty 123", false)
        };
        User user = null;
        try {
            user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
            user = findUser(users, "Qwerty 123");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println("Not valid");
        } catch (UserNotFoundException e) {
            System.out.println("No user");
        }
    }
}