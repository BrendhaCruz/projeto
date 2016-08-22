package les.projeto.quebra_galho;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

;

public class TutorialFragment extends Fragment {

    public TutorialFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_video, null);

        Button btVideo = (Button)rootView.findViewById(R.id.btnVideo);
        btVideo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=dQw4w9WgXcQ"));
//                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });


//        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
//        rv.setHasFixedSize(true);
//        MyAdapter adapter = new MyAdapter(new String[]{"Pintar Parede", "Pintar Porta", "Pintar Banco", "test four", "test five" , "test six" ,"test six" ,"test six" ,"test six" , "test seven"});
//        rv.setAdapter(adapter);

//        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
//        rv.setLayoutManager(llm);

        return rootView;
    }

}