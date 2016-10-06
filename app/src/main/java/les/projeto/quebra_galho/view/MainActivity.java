package les.projeto.quebra_galho.view;

import android.databinding.ObservableArrayList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;

import com.github.nitrico.lastadapter.LastAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import les.projeto.quebra_galho.BR;
import les.projeto.quebra_galho.R;
import les.projeto.quebra_galho.model.Categoria;

public class MainActivity extends AppCompatActivity {

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
                .into(categoriesView);

        /*firebaseDatabase.getReference("categorias").child("5").child("imagem").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String file = dataSnapshot.getValue(String.class);
                firebaseStorage.getReference("imagens/categorias/" + file).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                            Picasso.with(MainActivity.this).load(uri.toString()).into(new Target() {
                                @Override
                                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                                    byte[] bytes = baos.toByteArray();
                                    String base64Image = Base64.encodeToString(bytes, Base64.DEFAULT);

                                    // we finally have our base64 string version of the image, save it.
                                    firebaseDatabase.getReference("categorias").child("5").child("img").setValue(base64Image);
                                }
                                @Override
                                public void onBitmapFailed(Drawable errorDrawable) {
                                }
                                @Override
                                public void onPrepareLoad(Drawable placeHolderDrawable) {
                                }
                            });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("ataga", e.toString());
                    }
                });
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });*/
//        iv1.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ListaTutorialActivity.class);
//                intent.putExtra("categoria", 1);
//                startActivity(intent);
//            }
//        });
    }
}

