package les.projeto.quebra_galho.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import les.projeto.quebra_galho.R;
import les.projeto.quebra_galho.model.Comentario;

/**
 * Created by Fab on 02/10/2016.
 */
public class Escrever_Comentario extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final BDados base = new BDados(this);

        setContentView(R.layout.escrever_comentario);

        final ArrayList<Comentario> comentarios = base.selectComentarios();

        Button enviar = (Button) findViewById(R.id.btn_enviarComentario);
        TextView tv_m = (TextView) findViewById((R.id.tv_m));

        Bundle bundle = getIntent().getExtras();

        tv_m.setText("Escreva algo " + bundle.getString("US"));

        final String userName = bundle.getString("US");

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String coment = ((EditText) findViewById(R.id.edt_coment)).getText().toString();

                Comentario bdados = new Comentario(userName, coment);

                base.inserirComentario(bdados);

                Intent forum = new Intent(Escrever_Comentario.this, Forum.class);
                startActivity(forum);

            }
        });

    }

}
