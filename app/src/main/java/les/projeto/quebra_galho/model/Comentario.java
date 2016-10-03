package les.projeto.quebra_galho.model;

/**
 * Created by Fab on 02/10/2016.
 */
public class Comentario {

    String user;
    String comentario;

    public Comentario(String user, String comentario) {
        this.user = user;
        this.comentario = comentario;
    }

    public Comentario() {

    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
