package Model;

public class Studente {
    private String nome;
    private String cognome;
    private String classe;

    // mettere controlli per numeri
    public Studente(String nome, String cognome, String classe) throws Exception{
        //controllo nome
        // IllegalArgumentException: e' l'ecceziome di java da usare quando un parametro 
        // passato a un metodo o costruttore non e' valido
        if(nome.equals("")){
            throw new Exception("ERRORE: inserisci il nome");
        }
        if (nome.chars().anyMatch(Character::isDigit)){
            throw new IllegalArgumentException("ERRORE: il nome contine dei numeri.");
        }
        else{
            this.nome = nome;     
        }

        //controllo cognome
        if(cognome.equals("")){
            throw new Exception("ERRORE: inserisci il cognome");
        }
        if (cognome.chars().anyMatch(Character::isDigit)){
            throw new IllegalArgumentException("ERRORE: il cognome contine dei numeri.");
        }
        else{
            this.cognome = cognome;     
        }
        
        //controllo classe
        if(classe.equals("")){
            throw new Exception("ERRORE: inserisci la classe");
        }
        if (classe == null || !classe.matches("^[0-9][a-zA-Z]$")){
            throw new IllegalArgumentException("ERRORE: formato classe errato. Usa il formato 4C");
        }
        else{
            this.classe = classe;     
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getClasse() {
        return classe;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return cognome + " " + nome + " - " + classe;
    }

    //evitare duplicati
    public boolean equals(Studente s) {
        if (this == s) return true;  
        
        // equalsIgnoreCase è un metodo String che restituisce true se le due stringhe sono ugali (ignora minuscole a maiuscole)
        return nome.equalsIgnoreCase(s.nome)
                && cognome.equalsIgnoreCase(s.cognome)
                && classe.equalsIgnoreCase(s.classe);
    }
}
