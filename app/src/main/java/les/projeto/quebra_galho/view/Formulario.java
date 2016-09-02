package les.projeto.quebra_galho.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import les.projeto.quebra_galho.R;

import les.projeto.quebra_galho.model.Profissional;
import les.projeto.quebra_galho.model.ProfissionalSQL;

/**
 * Created by Brendha-PC on 02/09/2016.
 */
public class Formulario extends Activity {

    private Profissional profissional = new Profissional();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);

        Button botao = (Button) findViewById(R.id.botao);
        botao.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText nome = (EditText) findViewById(R.id.nome);
                EditText telefone = (EditText) findViewById(R.id.telefone);
                EditText site = (EditText) findViewById(R.id.site);
                RatingBar nota = (RatingBar) findViewById(R.id.nota);
                EditText endereco = (EditText) findViewById(R.id.endereco);

                profissional.setNome(nome.getEditableText().toString());
                profissional.setTelefone(telefone.getEditableText().toString());
                profissional.setSite(site.getEditableText().toString());
                profissional.setNota(nota.getRating());
                profissional.setEndereco(endereco.getEditableText().toString());

                ProfissionalSQL sql = new ProfissionalSQL(Formulario.this);
                sql.inserir(profissional);
                sql.close();

                finish();
            }
        });
    }

}
