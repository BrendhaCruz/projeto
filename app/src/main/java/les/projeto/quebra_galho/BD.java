package les.projeto.quebra_galho;

/**
 * Created by Brendha-PC on 21/09/2016.
 */
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BD {
    private SQLiteDatabase bd;

    public BD(Context context){
        BDCore auxBd = new BDCore(context);
        bd = auxBd.getWritableDatabase();
    }


    public void inserir(Profissional profissional){
        ContentValues valores = new ContentValues();
        valores.put("nome", profissional.getNome());
        valores.put("sobrenome", profissional.getSobrenome());
        valores.put("categoria", profissional.getCategoria());

        bd.insert("profissional", null, valores);
    }


    public void atualizar(Profissional profissional){
        ContentValues valores = new ContentValues();
        valores.put("nome", profissional.getNome());
        valores.put("sobrenome", profissional.getSobrenome());

        bd.update("profissional", valores, "_id = ?", new String[]{""+profissional.getId()});
    }


    public void deletar(Profissional profissional){
        bd.delete("profissional", "_id = "+profissional.getId(), null);
    }


    public List<Profissional> buscar(){
        List<Profissional> list = new ArrayList<Profissional>();
        String[] colunas = new String[]{"_id", "nome", "sobrenome"};

        Cursor cursor = bd.query("profissional", colunas, null, null, null, null, "nome ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{

                Profissional p = new Profissional();
                p.setId(cursor.getLong(0));
                p.setNome(cursor.getString(1));
                p.setSobrenome(cursor.getString(2));
                list.add(p);

            }while(cursor.moveToNext());
        }

        return(list);
    }
}


