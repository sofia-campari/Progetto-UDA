package Controller;

import Model.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GestoreMonteore {

    private GiornataMonteore model;
    private GestoreCSV gestoreCSV;
    private Utente utenteCorrente;

    public GestoreMonteore() {
        model = new GiornataMonteore();
        gestoreCSV = new GestoreCSV();
    }

    // LOGIN

    public void login(Utente utente) {

        if (utente == null) {
            throw new IllegalArgumentException("Utente non valido");
        }

        utenteCorrente = utente;
    }

    public Utente getUtenteCorrente() {
        return utenteCorrente;
    }

    // FILE

    public void apriFile(File file) throws IOException, Exception {
        model = gestoreCSV.leggiCSV(file);
    }

    public void salvaConNome(File file) throws IOException {
        gestoreCSV.salvaCSV(file, model);
    }

    // CONTROLLO ADMIN

    private void checkAdmin() {

        if (!(utenteCorrente instanceof AmministratoreUtente)) {
            throw new SecurityException("Operazione consentita solo agli admin");
        }
    }

    // INSERIMENTO ISCRIZIONE

    public void aggiungiIscrizione(Iscrizione iscrizione) {
        if (iscrizione == null) {
            throw new IllegalArgumentException("Iscrizione null");
        }

        // controllo attività piena
        if (iscrizione.getAttivita().isFull(model.getIscrizioni())) {
            throw new IllegalStateException("Attività piena");
        }

        // controllo doppia iscrizione
        for (Iscrizione i : model.getIscrizioni()) {

            if (i.getStudente().equals(iscrizione.getStudente())
                    &&
                    i.getTurno()
                    .equalsIgnoreCase(
                            iscrizione.getTurno()
                    )) {

                throw new IllegalStateException(
                        "Studente già iscritto in questo turno"
                );
            }
        }

        model.aggiungiStudente(
                iscrizione.getStudente()
        );

        model.aggiungiAttivita(
                iscrizione.getAttivita()
        );

        model.aggiungiIscrizione(iscrizione);
    }

    // ==========================
    // MODIFICA
    // ==========================

    public void modificaIscrizione(
            Iscrizione vecchia,
            Attivita nuovaAttivita
    ) {

        checkAdmin();

        if (vecchia == null || nuovaAttivita == null) {

            throw new IllegalArgumentException(
                    "Parametri non validi"
            );
        }

        vecchia.setAttivita(nuovaAttivita);
    }

    // ==========================
    // CANCELLAZIONE
    // ==========================

    public void eliminaIscrizione(
            Iscrizione iscrizione
    ) {

        checkAdmin();

        model.rimuoviIscrizione(iscrizione);
    }

    // ==========================
    // VISUALIZZA LISTA
    // ==========================

    public List<Iscrizione> getListaIscrizioni() {

        return model.getIscrizioni();
    }

    // ==========================
    // RICERCA
    // ==========================

    public List<Iscrizione> cerca(
            String classe,
            String attivita
    ) {

        List<Iscrizione> risultati =
                new ArrayList<>();

        for (Iscrizione i : model.getIscrizioni()) {

            boolean matchClasse =
                    classe == null
                    || classe.trim().isEmpty()
                    || i.getStudente()
                    .getClasse()
                    .equalsIgnoreCase(classe);

            boolean matchAttivita =
                    attivita == null
                    || attivita.trim().isEmpty()
                    || i.getAttivita()
                    .getNome()
                    .equalsIgnoreCase(attivita);

            if (matchClasse && matchAttivita) {

                risultati.add(i);
            }
        }

        return risultati;
    }

    // ==========================
    // ORDINAMENTO
    // ==========================

    public List<Studente> ordinaPerCognome() {

        List<Studente> lista =
                new ArrayList<>(
                        model.getStudenti()
                );

        lista.sort(
                Comparator.comparing(
                        Studente::getCognome
                )
        );

        return lista;
    }

    public GiornataMonteore getModel() {
        return model;
    }
}