package les.projeto.quebra_galho.model;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.widget.ImageView;

public class Categoria {

    private Bitmap img;
    private String titulo;

    public Categoria(Bitmap img, String titulo) {
        this.img = img;
        this.titulo = titulo;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @BindingAdapter("loadImage")
    public static void loadImage(ImageView iv, Bitmap bitmap) {
        iv.setImageBitmap(bitmap);
    }
}
