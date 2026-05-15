package Model;

import java.util.ArrayList;
import java.util.List;

public class GiornataMonteore {
    private List<Studente> studenti;
    private List<Attivita> attivita;
    private List<Iscrizione> iscrizioni;

    public GiornataMonteore() {
        studenti = new ArrayList<>();
        attivita = new ArrayList<>();
        iscrizioni = new ArrayList<>();
    }

    // STUDENTI

    public void aggiungiStudente(Studente s) {
        if (!studenti.contains(s)) {
            studenti.add(s);
        }
    }

    public List<Studente> getStudenti() {
        return studenti;
    }

    // ATTIVITA

    public void aggiungiAttivita(Attivita a) {
        if (!attivita.contains(a)) {
            attivita.add(a);
        }
    }

    public List<Attivita> getAttivita() {
        return attivita;
    }

    // ISCRIZIONI

    public void aggiungiIscrizione(Iscrizione i) {
        iscrizioni.add(i);
    }

    public void rimuoviIscrizione(Iscrizione i) {
        iscrizioni.remove(i);
    }

    public List<Iscrizione> getIscrizioni() {
        return iscrizioni;
    }

    @Override
    public String toString() {

        return "Studenti: " + studenti.size()
                + " | Attività: " + attivita.size()
                + " | Iscrizioni: " + iscrizioni.size();
    }
}