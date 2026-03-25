package api.dto;

public class RegisterRequest {
    private final String email;
    private final String password;
    private final String submitPassword;

    public RegisterRequest(String email, String password) {
        this.email = email;
        this.password = password;
        this.submitPassword = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSubmitPassword() {
        return submitPassword;
    }
}