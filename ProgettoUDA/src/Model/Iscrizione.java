package Model;

public class Iscrizione {
    private Studente studente;
    private Attivita attivita;
    private String turno; // "prima" o "dopo"
    private boolean isIscritto;

    public Studente getStudente(){
        return this.studente;
    }
    public Attivita getAttivita(){
        return this.attivita;
    }
    public String getTurno(){
        return this.turno;
    }
}
