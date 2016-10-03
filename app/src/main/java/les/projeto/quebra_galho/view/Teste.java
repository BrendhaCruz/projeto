package les.projeto.quebra_galho.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import les.projeto.quebra_galho.R;
import les.projeto.quebra_galho.model.Comentario;

/**
 * Created by Fab on 03/10/2016.
 */
public class Teste extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.teste);

        Button escrever = (Button) findViewById(R.id.escrever);
        Button ler = (Button) findViewById(R.id.ler);

        final TextView tv_nome = (TextView) findViewById(R.id.tv_nome);

        Bundle bundle = getIntent().getExtras();

        tv_nome.setText("Oi " + bundle.getString("USER"));

        final String email = bundle.getString("USER");

        escrever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Teste.this, Escrever_Comentario.class);
                Bundle d = new Bundle();
                d.putString("US", email);
                i.putExtras(d);

                startActivity(i);

            }
        });

        ler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Teste.this, Forum.class);
                startActivity(i);

            }
        });

    }

}
