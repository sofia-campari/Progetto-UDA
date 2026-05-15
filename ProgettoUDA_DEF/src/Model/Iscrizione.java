package Model;

public class Iscrizione {
    private Studente studente;
    private Attivita attivita;
    private String turno;
    private boolean isIscritto;

    public Iscrizione(Studente studente, Attivita attivita, String turno, boolean isIscritto) throws Exception {
        this.studente = studente;
        this.attivita = attivita;
        
        if(turno.equals("")){
            throw new Exception("ERRORE: inserisci il turno");
        }
        if (!turno.equalsIgnoreCase("primo") && !turno.equalsIgnoreCase("secondo")){
            throw new Exception("ERRORE: turno non valido");        
        }
        else {
            this.turno = turno;
        }
        
        this.isIscritto = isIscritto;
    }

    public Studente getStudente() {
        return studente;
    }

    public Attivita getAttivita() {
        return attivita;
    }

    public String getTurno() {
        return turno;
    }

    public boolean isIscritto() {
        return isIscritto;
    }

    public void setAttivita(Attivita attivita) {
        this.attivita = attivita;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setIsIscritto(boolean isIscritto) {
        this.isIscritto = isIscritto;
    }

    @Override
    public String toString() {
        return studente + " -> " + attivita + " (" + turno + ")";
    }
}
