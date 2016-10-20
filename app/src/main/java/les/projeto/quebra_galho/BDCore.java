package les.projeto.quebra_galho;

/**
 * Created by Brendha-PC on 21/09/2016.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDCore extends SQLiteOpenHelper {
    private static final String NOME_BD = "testeBD";
    private static final int VERSAO_BD = 12;


    public BDCore(Context ctx){
        super(ctx, NOME_BD, null, VERSAO_BD);
    }


    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table profissional(_id integer primary key autoincrement, nome text not null, categoria text not null, descricao text not null, email text not null, telefone text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
        bd.execSQL("drop table profissional;");
        onCreate(bd);
    }

}