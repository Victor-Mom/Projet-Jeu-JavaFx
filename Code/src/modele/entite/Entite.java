package modele.entite;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Entite {

    /**
     * Classe principale du modèle en effet c'est la classe mère de toute entite de notre jeu que ce soit une protection ou une ia
     * C'est le premier point d'extension du modèle.
     * On y retrouve la position de l'entite.
     */

    protected DoubleProperty x = new SimpleDoubleProperty();
        public double getX() {return x.get();}
        public DoubleProperty xProperty() {return x;}
        public void setX(double x) {this.x.set(x);}

    protected DoubleProperty y = new SimpleDoubleProperty();
        public double getY() {return y.get();}
        public DoubleProperty yProperty() {return y;}
        public void setY(double y) {this.y.set(y);}

    private String image;

    protected int maxWidth=50;
    protected int maxHeight=50;


    public void setPosiPerso(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public void setImage(String path){this.image = path;}
    public String getImage() {
        return image;
    }
    public int getMaxWidth() {return maxWidth;}
    public int getMaxHeight() {return maxHeight;}
}
