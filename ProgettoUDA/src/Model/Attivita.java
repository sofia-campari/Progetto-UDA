package Model;

import java.util.List;

public class Attivita {
    private String nome;
    private String luogo;
    private int maxPartecipanti;

    public Attivita(String nome, String luogo, int maxPartecipanti) throws Exception {
        if(nome.equals("")){
            throw new Exception("ERRORE: inserisci nome attività");
        }
        if (nome.chars().anyMatch(Character::isDigit)){
            throw new IllegalArgumentException("ERRORE: il nome contine dei numeri.");
        }
        else{
            this.nome = nome;     
        }
        
        if(luogo.equals("")){
            throw new Exception("ERRORE: inserisci luogo");
        }
        if (luogo.chars().anyMatch(Character::isDigit)){
            throw new IllegalArgumentException("ERRORE: il luogo contine dei numeri.");
        }
        else{
            this.luogo = luogo;     
        }
        
        if(maxPartecipanti <= 0){
            throw new Exception("ERRORE: numero massimo partecipanti non valido");
        }
        else{
            this.maxPartecipanti = maxPartecipanti;     
        }
    }

    public String getNome() {
        return nome;
    }

    public String getLuogo() {
        return luogo;
    }

    public int getMaxPartecipanti() {
        return maxPartecipanti;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public void setMaxPartecipanti(int maxPartecipanti) {
        this.maxPartecipanti = maxPartecipanti;
    }

    // scorre tutte le attivita
    public boolean isFull(List<Iscrizione> iscrizioni) {
        int count = 0;
        for (Iscrizione i : iscrizioni) {
            // se il nome dellattivita è uguale a quella di this (oggetto che ha chiamato il metodo) conta
            if (i.getAttivita().equals(this)) {
                count++;
            }
        }
        return count >= maxPartecipanti;
    }


    @Override
    public String toString() {
        return nome;
    }
}
