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
    private EditText categoriaEt;
    private EditText descricaoEt;
    private EditText emailEt;
    private EditText telefoneEt;
    private Button salvarBt;
    private Button editarBt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_profissional);

        nomeEt = (EditText) findViewById(R.id.nome);
        categoriaEt = (EditText) findViewById(R.id.categoria);
        descricaoEt = (EditText) findViewById(R.id.descricao);
        emailEt = (EditText) findViewById(R.id.email);
        telefoneEt = (EditText) findViewById(R.id.telefone);
        salvarBt = (Button) findViewById(R.id.button1);
        editarBt = (Button) findViewById(R.id.button2);


        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){

                profissional.setId(bundle.getLong("id"));
                profissional.setNome(bundle.getString("nome"));
                profissional.setCategoria(bundle.getString("categoria"));
                profissional.setDescricao(bundle.getString("descricao"));
                profissional.setEmail(bundle.getString("email"));
                profissional.setTelefone(bundle.getString("telefone"));


                nomeEt.setText(profissional.getNome());
                categoriaEt.setText(profissional.getCategoria());
                descricaoEt.setText(profissional.getDescricao());
                emailEt.setText(profissional.getEmail());
                telefoneEt.setText(profissional.getTelefone());

                salvarBt.setVisibility(View.GONE);
                editarBt.setVisibility(View.VISIBLE);
            }
        }
    }


    public void salvarProfissional(View view){
        profissional.setNome(nomeEt.getText().toString());
        profissional.setCategoria(categoriaEt.getText().toString());
        profissional.setDescricao(descricaoEt.getText().toString());
        profissional.setEmail(emailEt.getText().toString());
        profissional.setTelefone(telefoneEt.getText().toString());

        BD bd = new BD(this);
        bd.inserir(profissional);

        Toast.makeText(this, "profissional inserido com sucesso!", Toast.LENGTH_SHORT).show();
    }


    public void editarProfissional(View view){
        profissional.setNome(nomeEt.getText().toString());
        profissional.setCategoria(categoriaEt.getText().toString());
        profissional.setDescricao(descricaoEt.getText().toString());
        profissional.setEmail(emailEt.getText().toString());
        profissional.setTelefone(telefoneEt.getText().toString());


        BD bd = new BD(this);
        bd.atualizar(profissional);

        Toast.makeText(this, "profissional \""+profissional.getNome()+"\" atuailizado com sucesso.", Toast.LENGTH_SHORT).show();
    }

}
