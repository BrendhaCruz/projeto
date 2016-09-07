package les.projeto.quebra_galho.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import les.projeto.quebra_galho.R;

public class EscolherClienteProfissional extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_cliente_profissional);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);


        final ImageView cliente = (ImageView) findViewById(R.id.cliente);
        final ImageView profissional = (ImageView) findViewById(R.id.profissional);

        cliente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(EscolherClienteProfissional.this, MainActivity.class);
                startActivity(intent);

            }
        });

        profissional.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscolherClienteProfissional.this, ListaServicosActivity.class);
                startActivity(intent);

            }
        });
    }
}
