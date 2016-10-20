package les.projeto.quebra_galho.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.FacebookSdk;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import les.projeto.quebra_galho.NotifyService;
import les.projeto.quebra_galho.R;

public class EscolherClienteProfissional extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_cliente_profissional);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        FacebookSdk.sdkInitialize(getApplicationContext());

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        if (FirebaseAuth.getInstance().getCurrentUser() == null) { // deslogado
            loadLoginPage();
        }

        final ImageView cliente = (ImageView) findViewById(R.id.cliente);
        final ImageView profissional = (ImageView) findViewById(R.id.profissional);
        final Button sugerir_mudancas = (Button)findViewById(R.id.mudancas);

        sugerir_mudancas.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscolherClienteProfissional.this, SugerirMudancas.class);
                startActivity(intent);
            }
        });

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

    private void loadLoginPage() {
        Intent i = new Intent(EscolherClienteProfissional.this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
