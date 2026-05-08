package Model;

public class AmministratoreUtente extends Utente{
    public AmministratoreUtente (String username, String password) throws Exception {
        super(username, password);
    }

    @Override
    public String toString() {
        return "Amministratore: " + username;
    }
}
