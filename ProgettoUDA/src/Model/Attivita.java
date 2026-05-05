package Model;

import java.util.List;

public class Attivita {
    private String nome;
    private String descrizione;
    private int maxPartecipanti;

    public boolean isFull(List<Iscrizione> iscrizioni){
        return true;
    }
}
