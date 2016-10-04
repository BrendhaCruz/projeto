package les.projeto.quebra_galho;

/**
 * Created by Brendha-PC on 21/09/2016.
 */
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewProfissionalActivity extends Activity {
    private Profissional profissional = new Profissional();
    private EditText nomeEt;
    private EditText sobrenomeEt;
    private EditText categoriaEt;
    private Button salvarBt;
    private Button editarBt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_profissional);

        nomeEt = (EditText) findViewById(R.id.nome);
        sobrenomeEt = (EditText) findViewById(R.id.sobrenome);
        categoriaEt = (EditText) findViewById(R.id.categoria);
        salvarBt = (Button) findViewById(R.id.button1);
        editarBt = (Button) findViewById(R.id.button2);


        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){

                profissional.setId(bundle.getLong("id"));
                profissional.setNome(bundle.getString("nome"));
                profissional.setSobrenome(bundle.getString("sobrenome"));

                nomeEt.setText(profissional.getNome());
                sobrenomeEt.setText(profissional.getSobrenome());

                categoriaEt.setVisibility(View.GONE);
                salvarBt.setVisibility(View.GONE);
                editarBt.setVisibility(View.VISIBLE);
            }
        }
    }


    public void salvarProfissional(View view){
        profissional.setNome(nomeEt.getText().toString());
        profissional.setSobrenome(sobrenomeEt.getText().toString());
        profissional.setCategoria(categoriaEt.getText().toString());

        BD bd = new BD(this);
        bd.inserir(profissional);

        Toast.makeText(this, "profissional inserido com sucesso!", Toast.LENGTH_SHORT).show();
    }


    public void editarProfissional(View view){
        profissional.setNome(nomeEt.getText().toString());
        profissional.setSobrenome(sobrenomeEt.getText().toString());

        BD bd = new BD(this);
        bd.atualizar(profissional);

        Toast.makeText(this, "profissional \""+profissional.getNome()+"\" atuailizado com sucesso.", Toast.LENGTH_SHORT).show();
    }

}


