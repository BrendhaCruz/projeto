package les.projeto.quebra_galho.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

;import les.projeto.quebra_galho.NotifyService;
import les.projeto.quebra_galho.R;
import les.projeto.quebra_galho.model.Proposta;
import les.projeto.quebra_galho.model.PropostaSQL;
import les.projeto.quebra_galho.view.MainActivity;

public class OrcamentoFragment extends Fragment {
    RadioGroup categoria1, categoria2;

    private Proposta proposta = new Proposta();

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
        final View rootView = inflater.inflate(R.layout.fragment_orcamento, container, false);


        categoria1 = (RadioGroup) rootView.findViewById(R.id.rgCategoria1);
        categoria2 = (RadioGroup) rootView.findViewById(R.id.rgCategoria2);

        categoria1.clearCheck(); // this is so we can start fresh, with no selection on both RadioGroups
        categoria2.clearCheck();

        categoria1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                if (checkedId != -1) {
                    fun2();
                }
            }
        });

        categoria2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                if (checkedId != -1) {
                    fun1();
                }
            }
        });

        Button botao = (Button) rootView.findViewById(R.id.btnEnviarProposta);
        botao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Boolean erro = false;
                EditText nome = (EditText) rootView.findViewById(R.id.etFormName);
                EditText data = (EditText) rootView.findViewById(R.id.etFormData);
                EditText endereco = (EditText) rootView.findViewById(R.id.etFormEndereco);
                EditText problema = (EditText) rootView.findViewById(R.id.etFormProblema);

                int chkId1 = categoria1.getCheckedRadioButtonId();
                int chkId2 = categoria2.getCheckedRadioButtonId();
                int realCheck = chkId1 == -1 ? chkId2 : chkId1;
                RadioButton r = (RadioButton) rootView.findViewById(realCheck);
                if (nome.getEditableText().toString() == null || nome.getEditableText().toString().trim() == "") {
                    erro = true;
                }
                proposta.setNome(nome.getEditableText().toString());
                if (data.getEditableText().toString() == null || data.getEditableText().toString().trim() == "") {
                    erro = true;
                }
                proposta.setData(data.getEditableText().toString());
                if (endereco.getEditableText().toString() == null || endereco.getEditableText().toString().trim() =="") {
                    erro = true;
                }
                proposta.setEndereco(endereco.getEditableText().toString());
                if (problema.getEditableText().toString() == null || problema.getEditableText().toString().trim() =="") {
                    erro = true;
                }
                proposta.setProblema(problema.getEditableText().toString());
                if (r != null ) {
                    proposta.setCategoria(r.getText().toString());
                }else {
                    erro = true;
                }

                if(!erro) {
                    PropostaSQL sql = new PropostaSQL(getActivity());
                    sql.inserir(proposta);
                    sql.close();
                    Intent intent2 = new Intent(getActivity(), NotifyService.class);
                    getActivity().startService(intent2);

                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getActivity(), "Por favor, preencha todos os campos" , Toast.LENGTH_LONG).show();

                }

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


    public void fun1() {
        categoria1.setOnCheckedChangeListener(null);
        categoria1.clearCheck();
        categoria1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                fun2();
                Log.v("Inside fun1", "fun2");
            }
        });
    }

    public void fun2() {
        categoria2.setOnCheckedChangeListener(null);
        categoria2.clearCheck();
        categoria2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                fun1();
                Log.v("Inside fun2", "fun1");

            }
        });
    }

}