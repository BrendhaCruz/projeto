package les.projeto.quebra_galho.view;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import java.util.ArrayList;

import les.projeto.quebra_galho.model.Comentario;
import les.projeto.quebra_galho.model.Usuario;

/**
 * Created by Fab on 02/10/2016.
 */
public class BDados extends SQLiteOpenHelper {

    private static final String DB_NAME = "bdforum";
    private static final int SCHEME_VERSION=1;
    private SQLiteDatabase db;

    public BDados (Context context) {
        super(context, DB_NAME, null, SCHEME_VERSION);
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE %s (%s varchar(30) not null ," +
                        "%s varchar(100) primary key not null," +
                        "%s varchar(25) not null)", Tables.BDADOS_USERS, BDComentarios.ColunasUser.NOME,
                        BDComentarios.ColunasUser.EMAIL,
                        BDComentarios.ColunasUser.SENHA));
        db.execSQL(String.format("CREATE TABLE %s (%s varchar(30) not null %s," +
                "%s varchar(200) not null)" , Tables.BDADOS_COMENTARIOS, BDComentarios.ColunasComentarios.USER,
                Referencias.EMAIL_USER, BDComentarios.ColunasComentarios.COMENTARIO));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    interface Tables {
        String BDADOS_COMENTARIOS = "comentarios";
        String BDADOS_USERS = "usuarios";
    }

    interface Referencias {

        String EMAIL_USER = String.format("REFERENCES %s (%s)", Tables.BDADOS_USERS, BDComentarios.ColunasUser.EMAIL);

    }

    public void onOpen (SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            db.setForeignKeyConstraintsEnabled(true);
        }
    }

    public void insertUsu(Usuario us) {
        db.insert(Tables.BDADOS_USERS, null, gerarValores(us));
    }

    private ContentValues gerarValores(Usuario us) {
        ContentValues valores = new ContentValues();

        valores.put(BDComentarios.ColunasUser.NOME, us.getNome());
        valores.put(BDComentarios.ColunasUser.EMAIL, us.getEmail());
        valores.put(BDComentarios.ColunasUser.SENHA, us.getSenha());

        return valores;
    }

    public ArrayList<Usuario> SelecionarUser() {
        ArrayList<Usuario> users = new ArrayList<>();

        String sql = String.format("SELECT %s, %s FROM %s",
                BDComentarios.ColunasUser.EMAIL, BDComentarios.ColunasUser.SENHA, Tables.BDADOS_USERS);

                Cursor c = db.rawQuery(sql, null);

                if (c==null) {
                    System.out.println("Vazio");
                }

                if (c.moveToFirst()) {
                    do {
                        Usuario p = new Usuario();
                        p.setEmail(c.getString(0));
                        p.setSenha(c.getString(1));

                        users.add(p);

                    }while (c.moveToNext());
        }

        return users;
    }

    //comemtarios-------------------------------------------------------

    private ContentValues gerarValoresComentarios(Comentario c) {
        ContentValues valoresC = new ContentValues();

        valoresC.put(BDComentarios.ColunasComentarios.USER, c.getUser());
        valoresC.put(BDComentarios.ColunasComentarios.COMENTARIO, c.getComentario());

        return valoresC;

    }

    public void inserirComentario(Comentario c) {
        db.insert(Tables.BDADOS_COMENTARIOS, null, gerarValoresComentarios(c));
    }

    public ArrayList<Comentario> selectComentarios() {
        ArrayList<Comentario> comentarios = new ArrayList<>();

        String sql = String.format("SELECT * FROM %s", Tables.BDADOS_COMENTARIOS);
        Cursor c = db.rawQuery(sql, null);
        if (c==null) {
            System.out.println("Vazio");
        }

        if (c.moveToFirst()) {
            do {
                Comentario p = new Comentario();
                p.setUser(c.getString(0));
                p.setComentario(c.getString(1));

                comentarios.add(p);

            }while (c.moveToNext());
        }

        return comentarios;

    }

}
