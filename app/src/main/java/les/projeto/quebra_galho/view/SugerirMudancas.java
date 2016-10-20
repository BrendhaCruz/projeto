package les.projeto.quebra_galho.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import les.projeto.quebra_galho.ChatFake;
import les.projeto.quebra_galho.R;

/**
 * Created by enio on 20/10/2016.
 */
public class SugerirMudancas extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerir_mudancas);

        final Button enviar_mudancas = (Button)findViewById(R.id.enviar_segestoes);


        Button btnAceitarProposta = (Button) findViewById(R.id.btnAceitarProposta);
        enviar_mudancas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Obrigado por colaborar com a melhoria de nossa plataforma ;)", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(SugerirMudancas.this, EscolherClienteProfissional.class);
                startActivity(intent);
            }
        });

    }

}
