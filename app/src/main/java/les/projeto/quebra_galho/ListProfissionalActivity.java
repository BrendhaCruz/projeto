package les.projeto.quebra_galho;

/**
 * Created by Brendha-PC on 21/09/2016.
 */
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import les.projeto.quebra_galho.view.EscolherClienteProfissional;
import les.projeto.quebra_galho.view.ListaServicosActivity;
import les.projeto.quebra_galho.view.MainActivity;

public class ListProfissionalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_profissional);

        final ImageView telaProfissionais = (ImageView) findViewById(R.id.telaProfissionais);


        telaProfissionais.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListProfissionalActivity.this, ChatFake.class);
                startActivity(intent);

            }
        });
    }
}
