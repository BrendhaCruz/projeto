package les.projeto.quebra_galho;

/**
 * Created by Brendha-PC on 21/09/2016.
 */
import java.util.List;

import android.os.Bundle;
import android.app.ListActivity;

public class ListProfissionalActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_profissional);

        BD bd = new BD(this);

        List<Profissional> list = bd.buscar();
        setListAdapter(new ProfissionalAdapter(this, list));
    }
}
