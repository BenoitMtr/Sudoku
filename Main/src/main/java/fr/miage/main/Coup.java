package fr.miage.main;

/**
 * Coup: Classe correspondant aux coups entrés sur la console
 */
public class Coup {

    String[] id;

    public Coup(String[] id)
    {
        this.id=id;
    }

    /**
     * getId: récupère l'id du coup
     * @return l'id du coup
     */
    public String[] getId()
    {
        return id;
    }
}
