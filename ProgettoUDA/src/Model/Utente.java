package Model;

public class Utente {
    protected String username;
    protected String password;

    public Utente(String username, String password) throws Exception {
        if (username.equals("") || username.equals("")){
            throw new Exception("ERRORE: nome utente non valido");        
        }
        else {
            this.username = username;
        }
        if (password.equals("") || password.equals("")){
            throw new Exception("ERRORE: password non valida");        
        }
        else {
            this.password = password;
        }
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        return username;
    }
}
