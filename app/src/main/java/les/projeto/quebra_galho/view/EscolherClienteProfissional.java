package les.projeto.quebra_galho.view;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import les.projeto.quebra_galho.NotifyService;
import les.projeto.quebra_galho.R;
import les.projeto.quebra_galho.model.Usuario;

public class EscolherClienteProfissional extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_cliente_profissional);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);


        final ImageView cliente = (ImageView) findViewById(R.id.cliente);
        final ImageView profissional = (ImageView) findViewById(R.id.profissional);

        //Apagar/arrumar depois
        final BDados base = new BDados(this);

        final Button btn_forum = (Button) findViewById(R.id.btn_forum);

        btn_forum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Usuario bdados = new Usuario("User", "user@gmail", "ff");
                base.insertUsu(bdados);

                Intent i = new Intent(EscolherClienteProfissional.this, Teste.class);
                Bundle b = new Bundle();
                b.putString("USER", "user@gmail");
                i.putExtras(b);
                startActivity(i);
            }
        });

        ////////////////////

        cliente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setAction(NotifyService.ACTION);
                intent2.putExtra("RQS", NotifyService.STOP_SERVICE);
                sendBroadcast(intent2);

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
