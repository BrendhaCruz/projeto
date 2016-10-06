package les.projeto.quebra_galho.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class PropostaSQL extends SQLiteOpenHelper {

    private static final int VERSAO = 2;
    private static final String TABELA = "PropostaActivity";
    private static final String[] COLS = {"id", "nome", "data", "endereco", "problema", "categoria"};

    public PropostaSQL(Context context) {
        super(context, TABELA, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + TABELA + " ");
        sb.append("(id INTEGER PRIMARY KEY, ");
        sb.append(" nome TEXT NOT NULL, ");
        sb.append(" data TEXT, ");
        sb.append(" endereco TEXT, ");
        sb.append(" problema TEXT, ");
        sb.append(" categoria TEXT);");
        db.execSQL(sb.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE IF EXISTS " + TABELA);
        db.execSQL(sb.toString());
        onCreate(db);

    }

    public void inserir(Proposta proposta) {
        ContentValues values = new ContentValues();
        values.put("nome", proposta.getNome());
        values.put("data", proposta.getData());
        values.put("endereco", proposta.getEndereco());
        values.put("problema", proposta.getProblema());
        values.put("categoria", proposta.getCategoria());

        getWritableDatabase().insert(TABELA, null, values);
    }

    public List<Proposta> getLista(){
        List<Proposta> propostas = new ArrayList<Proposta>();

        Cursor c = getWritableDatabase().query(TABELA,COLS, null, null, null, null, null);

        while(c.moveToNext()){
            Proposta proposta = new Proposta();
            proposta.setId(c.getLong(0));
            proposta.setNome(c.getString(1));
            proposta.setData(c.getString(2));
            proposta.setEndereco(c.getString(3));
            proposta.setProblema(c.getString(4));
            proposta.setCategoria(c.getString(5));
            propostas.add(proposta);
        }
        c.close();

        return propostas;
    }
}
