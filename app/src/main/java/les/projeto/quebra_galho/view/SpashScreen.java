package les.projeto.quebra_galho.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.os.Handler;

import les.projeto.quebra_galho.R;

public class SpashScreen extends AppCompatActivity {
    // Tempo da splash screen
    private static int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            /*
             * Exibindo splash com um timer.
             */
            @Override
            public void run() {
                // Esse método será executado sempre que o timer acabar
                // E inicia a activity principal
                Intent i = new Intent(SpashScreen.this, EscolherClienteProfissional.class);
                startActivity(i);

                // Fecha esta activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}


