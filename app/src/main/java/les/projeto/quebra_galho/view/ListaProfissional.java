package les.projeto.quebra_galho.view;

/**
 * Created by Brendha-PC on 02/09/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import android.widget.Button;


import les.projeto.quebra_galho.R;

import java.util.Arrays;
import java.util.List;

import les.projeto.quebra_galho.model.Profissional;
import les.projeto.quebra_galho.model.ProfissionalSQL;


public class ListaProfissional extends AppCompatActivity {
    private ListView listaProfissionais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listaprofissional);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ProfissionalSQL sql = new ProfissionalSQL(this);
        List<Profissional> profissionais = sql.getLista();
        sql.close();


        ArrayAdapter<Profissional> adapter = new ArrayAdapter<Profissional>(this, android.R.layout.simple_list_item_1, profissionais);

        listaProfissionais = (ListView) findViewById(R.id.listaProfissionais);
        listaProfissionais.setAdapter(adapter);
        listaProfissionais.setClickable(true);
        listaProfissionais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
                Toast.makeText(ListaProfissional.this, "Posição selecionada: " + posicao, Toast.LENGTH_LONG).show();
            }
        });

        listaProfissionais.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> adapter, View view, int posicao, long id) {
                registerForContextMenu(listaProfissionais);

                return false;
            }
        });


        Button btn = (Button) findViewById(R.id.btnNovo);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ListaProfissional.this, les.projeto.quebra_galho.view.Formulario.class);
                //intent.putExtra("categoria", 1);
                startActivity(intent);

            }
        });
    }




}