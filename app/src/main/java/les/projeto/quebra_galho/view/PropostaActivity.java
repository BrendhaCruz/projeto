package les.projeto.quebra_galho.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import les.projeto.quebra_galho.ChatFake;
import les.projeto.quebra_galho.ListProfissionalActivity;
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

        Button btnAceitarProposta = (Button) findViewById(R.id.btnAceitarProposta);
        btnAceitarProposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PropostaActivity.this, ChatFake.class);
                startActivity(intent);
            }
        });

    }


}
