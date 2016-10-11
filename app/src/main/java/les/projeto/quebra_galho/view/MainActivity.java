package les.projeto.quebra_galho.view;

import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import com.github.nitrico.lastadapter.LastAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import les.projeto.quebra_galho.BR;
import les.projeto.quebra_galho.R;
import les.projeto.quebra_galho.model.Categoria;

public class MainActivity extends AppCompatActivity implements LastAdapter.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        final List<Categoria> categoriesList = new ObservableArrayList<>();
        final RecyclerView categoriesView = (RecyclerView) findViewById(R.id.categories_list);
        categoriesView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        FirebaseDatabase.getInstance().getReference("categorias").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot prox : dataSnapshot.getChildren()) {
                    String titulo = prox.child("titulo").getValue(String.class);

                    // converte de string em base64 para bitmap
                    String base64Image = prox.child("img").getValue(String.class);
                    byte[] imageAsBytes = Base64.decode(base64Image.getBytes(), Base64.DEFAULT);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
                    categoriesList.add(new Categoria(bitmap, titulo));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        LastAdapter.with(categoriesList, BR.categoria)
                .map(Categoria.class, R.layout.single_category)
                .onClickListener(this)
                .into(categoriesView);
    }

    @Override
    public void onClick(@NotNull Object o, @NotNull View view, int i, int i1) {
        startActivity(new Intent(MainActivity.this, ListaTutorialActivity.class).putExtra("categoria", i1));
    }
}

