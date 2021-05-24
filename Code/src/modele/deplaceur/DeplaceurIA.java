package modele.deplaceur;

import modele.Carte;
import modele.collisionneur.Collisionneur;
import modele.collisionneur.CollisionneurIA;
import modele.entite.Entite;
import modele.entite.personnages.IA;
import modele.entite.personnages.PersoPrincipal;

import java.util.Iterator;

public class DeplaceurIA extends Deplaceur{

    /**
     * Classe fille du deplaceur pour nos IA
     * Elle permet de gérer le déplacement aléatoire de nos IA.
     */

    private Carte carte;
    public DeplaceurIA(CollisionneurIA leCollisionneur, Carte carte){//todo voir s'il faut quand meme le ramasseur
        super(leCollisionneur);
        this.carte = carte;
        pas = 10;
    }

    public void deplacerHaut(Entite e){
        if (leCollisionneur.canMove(e.getX(), e.getY()-pas)){
            e.setPosiPerso(e.getX(), e.getY()-pas);
            ((CollisionneurIA)leCollisionneur).contaminerAuContacte(e);
        }
        else{
            ((IA) e).resetDest();
        }
    }

    public void deplacerBas(Entite e){
        if (leCollisionneur.canMove(e.getX(), e.getY()+pas)){
            e.setPosiPerso(e.getX(), e.getY()+pas);
            ((CollisionneurIA)leCollisionneur).contaminerAuContacte(e);
        }else
            ((IA) e).resetDest();
    }

    public void deplacerGauche(Entite e){
        if (leCollisionneur.canMove(e.getX()-pas, e.getY())){
            e.setPosiPerso(e.getX()-pas, e.getY());
            ((CollisionneurIA)leCollisionneur).contaminerAuContacte(e);
        }else
            ((IA) e).resetDest();
    }

    public void deplacerDroit(Entite e){
        if (leCollisionneur.canMove(e.getX()+pas, e.getY())){
            e.setPosiPerso(e.getX()+pas, e.getY());
            ((CollisionneurIA)leCollisionneur).contaminerAuContacte(e);
        }else
            ((IA) e).resetDest();
    }

    public void deplacerIA(){
        Iterator<IA> it = carte.getLesIA().iterator();
        while (it.hasNext()){
            Entite e = it.next();
            if (e.getX() < ((IA) e).getDestX()) {
                deplacerDroit(e);
            }
            if (e.getX() > ((IA) e).getDestX()) {
                deplacerGauche(e);
            }
            if (e.getY() < ((IA) e).getDestY()) {
                deplacerBas(e);
            }
            if (e.getY() > ((IA) e).getDestY()) {
                deplacerHaut(e);
            }
            if (e.getX() > ((IA) e).getDestX() - 40 && e.getX() < ((IA) e).getDestX() + 40 && e.getX() > ((IA) e).getDestX() - 40 && e.getX() < ((IA) e).getDestX() + 40) {
                ((IA) e).resetDest();
            }
        }
    }

    @Override
    public void deplacerPersonnage(boolean up, boolean down, boolean right, boolean left, boolean space, PersoPrincipal perso) {
        return;
    }


    @Override
    public void attaquer(PersoPrincipal perso) {
        return;
    }
}
