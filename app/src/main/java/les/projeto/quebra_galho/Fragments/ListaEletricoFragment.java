package les.projeto.quebra_galho.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

;import les.projeto.quebra_galho.MyAdapter;
import les.projeto.quebra_galho.R;

public class ListaEletricoFragment extends Fragment {
    private int id = 1;

    public ListaEletricoFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
//        ImageView iv = (ImageView) rootView.findViewById(R.id.iv_image);
//        iv.setBackgroundResource(R.drawable.pincel);


        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        MyAdapter adapter = new MyAdapter(new String[]{"Como instalar interruptor", "Como Instalar ou Trocar uma Lâmpada", "Trocar a Resistência do Chuveiro Elétrico", "Como Montar Extensão Elétrica"}, getActivity(), id);
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }

}