package les.projeto.quebra_galho.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

;import les.projeto.quebra_galho.R;

public class TutorialFragment extends Fragment {

    public String url;


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

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            url = bundle.getString("url");
            Log.d("URL", url);
        }

        Button btVideo = (Button)rootView.findViewById(R.id.btnVideo);
        btVideo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });


        Button btAjuda = (Button) rootView.findViewById(R.id.btnAjuda);
        btAjuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), les.projeto.quebra_galho.MainProfissional.class);
                startActivity(intent);
            }
        });


        return rootView;
    }

}