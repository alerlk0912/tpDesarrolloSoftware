package Tp.DS;

public class ModeSelection {
    public final boolean useJDBC;
    public final String username;
    public final String password;

    public ModeSelection(boolean useJDBC, String username, String password) {
        this.useJDBC = useJDBC;
        this.username = username;
        this.password = password;
    }
}
