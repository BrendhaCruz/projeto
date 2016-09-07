package les.projeto.quebra_galho.view;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import les.projeto.quebra_galho.R;
import les.projeto.quebra_galho.model.Profissional;
import les.projeto.quebra_galho.model.ProfissionalSQL;
import les.projeto.quebra_galho.model.Proposta;
import les.projeto.quebra_galho.model.PropostaSQL;

public class ListaServicosActivity extends AppCompatActivity {

    private ListView listaPropostas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_servicos);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        PropostaSQL sql = new PropostaSQL(this);
        List<Proposta> propostas = sql.getLista();
        sql.close();


        ArrayAdapter<Proposta> adapter = new ArrayAdapter<Proposta>(this, android.R.layout.simple_list_item_1, propostas);

        listaPropostas= (ListView) findViewById(R.id.listaPropostas);
        listaPropostas.setAdapter(adapter);
        listaPropostas.setClickable(true);
        listaPropostas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
                Toast.makeText(ListaServicosActivity.this, "Posição selecionada: " + posicao, Toast.LENGTH_LONG).show();
            }
        });

        listaPropostas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> adapter, View view, int posicao, long id) {
                registerForContextMenu(listaPropostas);

                return false;
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_servicos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.miProfile:
                Intent intent = new Intent(ListaServicosActivity.this, FormularioProfissional.class);
                startActivity(intent);
                //TODO
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
