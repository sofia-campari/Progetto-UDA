package Model;

public class StudenteUtente extends Utente{
    private Studente studente;

    public StudenteUtente(String username, String password, Studente studente) throws Exception {
        super(username, password);
        this.studente = studente;
    }

    public Studente getStudente() {
        return studente;
    }

    @Override
    public String toString() {
        return "StudenteUtente: " + studente.toString();
    }
}
