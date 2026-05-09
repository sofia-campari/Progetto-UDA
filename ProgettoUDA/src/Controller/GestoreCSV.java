package Controller;

import Model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestoreCSV {

    // LETTURA CSV

    public GiornataMonteore leggiCSV(File file) throws IOException, Exception {

        if (file == null || !file.exists()) {
            throw new FileNotFoundException("File non trovato");
        }

        GiornataMonteore giornata = new GiornataMonteore();

        BufferedReader br = new BufferedReader(new FileReader(file));

        // salta intestazione
        String riga = br.readLine();

        while ((riga = br.readLine()) != null) {

            String[] campi = riga.split(",");

            if (campi.length != 6) {
                throw new IOException("Formato CSV non valido");
            }

            String nome = campi[0];
            String cognome = campi[1];
            String classe = campi[2];
            String turno = campi[3];
            String nomeAttivita = campi[4];
            boolean isIscritto = Boolean.parseBoolean(campi[5]);

            // crea oggetti
            Studente studente = new Studente(nome, cognome, classe);

            Attivita attivita = new Attivita(nomeAttivita,"Descrizione non disponibile",30);

            Iscrizione iscrizione = new Iscrizione(studente,attivita,turno,isIscritto);

            // aggiunta
            giornata.aggiungiStudente(studente);
            giornata.aggiungiAttivita(attivita);
            giornata.aggiungiIscrizione(iscrizione);
        }

        br.close();

        return giornata;
    }

    // SCRITTURA CSV

    public void salvaCSV(File file, GiornataMonteore giornata)throws IOException {

        if (file == null) {
            throw new IOException("File non valido");
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        // intestazione
        bw.write("nome,cognome,classe,turno,attivita,isIscritto");

        bw.newLine();

        for (Iscrizione i : giornata.getIscrizioni()) {

            bw.write(
                    i.getStudente().getNome() + "," +
                    i.getStudente().getCognome() + "," +
                    i.getStudente().getClasse() + "," +
                    i.getTurno() + "," +
                    i.getAttivita().getNome() + "," +
                    i.isIscritto()
            );

            bw.newLine();
        }

        bw.close();
    }
}