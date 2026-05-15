package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistiche {

    // ==========================
    // NUMERO STUDENTI PER ATTIVITA
    // ==========================

    public Map<String, Integer>
    numeroStudentiPerAttivita(
            List<Iscrizione> iscrizioni
    ) {

        Map<String, Integer> statistiche =
                new HashMap<>();

        for (Iscrizione i : iscrizioni) {

            String nomeAttivita =
                    i.getAttivita().getNome();

            if (statistiche.containsKey(nomeAttivita)) {

                int valore =
                        statistiche.get(nomeAttivita);

                statistiche.put(
                        nomeAttivita,
                        valore + 1
                );

            } else {

                statistiche.put(nomeAttivita, 1);
            }
        }

        return statistiche;
    }

    // ==========================
    // NUMERO PER TURNO
    // ==========================

    public Map<String, Integer>
    numeroPerTurno(
            List<Iscrizione> iscrizioni
    ) {

        Map<String, Integer> risultati =
                new HashMap<>();

        for (Iscrizione i : iscrizioni) {

            String turno = i.getTurno();

            if (risultati.containsKey(turno)) {

                risultati.put(
                        turno,
                        risultati.get(turno) + 1
                );

            } else {

                risultati.put(turno, 1);
            }
        }

        return risultati;
    }

    // ==========================
    // CLASSIFICA ATTIVITA
    // ==========================

    public List<String>
    classificaAttivita(
            List<Iscrizione> iscrizioni
    ) {

        Map<String, Integer> conteggio =
                numeroStudentiPerAttivita(iscrizioni);

        List<String> classifica =
                new ArrayList<>();

        for (String nome : conteggio.keySet()) {

            classifica.add(
                    nome + " -> " +
                    conteggio.get(nome) +
                    " iscritti"
            );
        }

        return classifica;
    }
}