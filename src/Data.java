public class Data {
    private Data() {
    }

    public static final String VALID_CHARACTERS = "abcdefjhigklmnopqrustyvwxvzABCDEFJHIJKLMNOPQRUSTYVWXVZ0987654321_";

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
        } catch (WrongLoginExeption | WrongPasswordExeption e) {
            System.out.println(e.getMessage());
            return false;

        }
        return true;
    }

    private static void check(String login, String password, String confirmPassword)
            throws WrongPasswordExeption, WrongLoginExeption {
        if (!validate(login)) {
            throw new WrongLoginExeption("Логин невалидный!");
        }
           if (!validate(password)){
               throw  new WrongPasswordExeption("Пароль невалидный");
           }
    }

    public static boolean validate(String s) {
        if (s.length() > 20) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_CHARACTERS.contains(String.valueOf(s.charAt(i)))) {
            }
        }
    }
}
