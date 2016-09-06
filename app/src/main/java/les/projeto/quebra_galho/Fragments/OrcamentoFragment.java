package les.projeto.quebra_galho.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

;import les.projeto.quebra_galho.R;
import les.projeto.quebra_galho.view.ListaProfissional;

public class OrcamentoFragment extends Fragment {

    public OrcamentoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_orcamento, container, false);

//        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
//        rv.setHasFixedSize(true);
//        MyAdapter adapter = new MyAdapter(new String[]{"Pintar Parede", "Pintar Porta", "Pintar Banco", "test four", "test five" , "test six" ,"test six" ,"test six" ,"test six" , "test seven"});
//        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
//        rv.setLayoutManager(llm);

        Button btAjuda = (Button) rootView.findViewById(R.id.btnAjuda);
        btAjuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListaProfissional.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

}