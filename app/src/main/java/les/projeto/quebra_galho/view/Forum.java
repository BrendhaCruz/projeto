package les.projeto.quebra_galho.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import les.projeto.quebra_galho.R;
import les.projeto.quebra_galho.model.Comentario;

/**
 * Created by Fab on 02/10/2016.
 */
public class Forum extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceSaved) {
        super.onCreate(savedInstanceSaved);
        setContentView(R.layout.forum);

        BDados base = new BDados(this);

        ListView lv = (ListView) findViewById(R.id.lv_comentarios);

        final ArrayList<Comentario> comentarios = base.selectComentarios();

        final ArrayList<String> d = new ArrayList<>();

        for (int i = 0; i < comentarios.size(); i++) {

            d.add(comentarios.get(i).getUser().toString());
            d.add(comentarios.get(i).getComentario().toString());

        }

        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, d));

    }

}
