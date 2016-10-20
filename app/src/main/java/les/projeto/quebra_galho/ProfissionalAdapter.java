package les.projeto.quebra_galho;

/**
 * Created by Brendha-PC on 21/09/2016.
 */
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfissionalAdapter extends BaseAdapter {
    private Context context;
    private List<Profissional> list;

    public ProfissionalAdapter(Context context, List<Profissional> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0).getId();
    }


    @Override
    public View getView(int position, View arg1, ViewGroup arg2) {
        final int auxPosition = position;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.profissional, null);

        TextView tvNome = (TextView) layout.findViewById(R.id.nome);
        TextView tvCategoria = (TextView) layout.findViewById(R.id.categoria);
        TextView tvDescricao = (TextView) layout.findViewById(R.id.descricao);
        TextView tvEmail = (TextView) layout.findViewById(R.id.email);
        TextView tvTelefone = (TextView) layout.findViewById(R.id.telefone);

        tvNome.setText(list.get(position).getNome());
        tvCategoria.setText(list.get(position).getCategoria());
        tvDescricao.setText(list.get(position).getDescricao());
        tvEmail.setText(list.get(position).getEmail());
        tvTelefone.setText(list.get(position).getTelefone());

        Button editarBt = (Button) layout.findViewById(R.id.editar);
        editarBt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, NewProfissionalActivity.class);
                intent.putExtra("nome", list.get(auxPosition).getNome());
                intent.putExtra("categoria", list.get(auxPosition).getCategoria());
                intent.putExtra("descricao", list.get(auxPosition).getDescricao());
                intent.putExtra("email", list.get(auxPosition).getEmail());
                intent.putExtra("telefone", list.get(auxPosition).getTelefone());
                intent.putExtra("id", list.get(auxPosition).getId());
                context.startActivity(intent);
            }
        });

        Button deletarBt = (Button) layout.findViewById(R.id.deletar);
        deletarBt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                BD bd = new BD(context);
                bd.deletar(list.get(auxPosition));

                layout.setVisibility(View.GONE);
            }
        });

        Button btAvalia = (Button) layout.findViewById(R.id.btAvalia);
        btAvalia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AvaliacaoActivity.class);
                context.startActivity(intent);
            }
        });

        return layout;



    }

}

