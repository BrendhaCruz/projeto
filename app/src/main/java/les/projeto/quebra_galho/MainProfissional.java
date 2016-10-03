package les.projeto.quebra_galho;

/**
 * Created by Brendha-PC on 21/09/2016.
 */


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import les.projeto.quebra_galho.view.Escrever_Comentario;

public class MainProfissional extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional);

        Button btn_forum = (Button) findViewById(R.id.btn_forum);

        btn_forum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(MainProfissional.this, Escrever_Comentario.class);
                startActivity(i);
            }
        });

    }
    public void getActivity(View view){
        Button bt = (Button) view;
        Intent intent;

        if(bt.getText().toString().equalsIgnoreCase("Novo profissional")){
            intent = new Intent(this, NewProfissionalActivity.class);
        }
        else{
            intent = new Intent(this, ListProfissionalActivity.class);
        }

        startActivity(intent);
    }

}


