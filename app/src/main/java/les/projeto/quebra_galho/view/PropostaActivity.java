package les.projeto.quebra_galho.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import les.projeto.quebra_galho.R;

public class PropostaActivity extends AppCompatActivity {

    private String nome;
    private String data;
    private String endereco;
    private String problema;
    private String categoria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposta);

        nome = getIntent().getStringExtra("nome");
        data = getIntent().getStringExtra("data");
        endereco = getIntent().getStringExtra("endereco");
        problema = getIntent().getStringExtra("problema");
        categoria = getIntent().getStringExtra("categoria");

        TextView tvData = (TextView) findViewById(R.id.TVData);
        TextView tvNome = (TextView) findViewById(R.id.TvNome);
        TextView tvEndereco = (TextView) findViewById(R.id.TVEndereco);
        TextView tvProblema = (TextView) findViewById(R.id.TVProblema);
        TextView tvCategoria = (TextView) findViewById(R.id.TVCategoria);

        tvNome.setText(nome);
        tvData.setText(data);
        tvEndereco.setText(endereco);
        tvProblema.setText(problema);
        tvCategoria.setText(categoria);




    }
}
