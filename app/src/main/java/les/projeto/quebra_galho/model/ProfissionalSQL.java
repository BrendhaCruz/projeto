package les.projeto.quebra_galho.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import les.projeto.quebra_galho.model.Profissional;

public class ProfissionalSQL extends SQLiteOpenHelper {

    private static final int VERSAO = 2;
    private static final String TABELA = "Profissional";
    private static final String[] COLS = {"id", "nome", "telefone", "endereco", "site", "nota", "foto"};

    public ProfissionalSQL (Context context) {
        super(context, TABELA, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + TABELA + " ");
        sb.append("(id INTEGER PRIMARY KEY, ");
        sb.append(" nome TEXT UNIQUE NOT NULL, ");
        sb.append(" telefone TEXT, ");
        sb.append(" endereco TEXT, ");
        sb.append(" site TEXT, ");
        sb.append(" nota REAL, ");
        sb.append(" foto TEXT);");
        db.execSQL(sb.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE IF EXISTS " + TABELA);
        db.execSQL(sb.toString());
        onCreate(db);

    }

    public void inserir(Profissional profissional) {
        ContentValues values = new ContentValues();
        values.put("nome", profissional.getNome());
        values.put("telefone", profissional.getTelefone());
        values.put("endereco", profissional.getEndereco());
        values.put("site", profissional.getSite());
        values.put("nota", profissional.getNota());
        values.put("foto", profissional.getFoto());

        getWritableDatabase().insert(TABELA, null, values);
    }

    public List<Profissional> getLista(){
        List<Profissional> profissionais = new ArrayList<Profissional>();

        Cursor c = getWritableDatabase().query(TABELA,COLS, null, null, null, null, null);

        while(c.moveToNext()){
            Profissional profissional = new Profissional();
            profissional.setId(c.getLong(0));
            profissional.setNome(c.getString(1));
            profissional.setTelefone(c.getString(2));
            profissional.setEndereco(c.getString(3));
            profissional.setSite(c.getString(4));
            profissional.setNota(c.getDouble(5));
            profissional.setFoto(c.getString(6));
            profissionais.add(profissional);
        }
        c.close();

        return profissionais;
    }
}
