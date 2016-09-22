package les.projeto.quebra_galho.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import java.util.Iterator;

import les.projeto.quebra_galho.R;


public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private FirebaseStorage firebaseStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);


        final ImageView iv1 = (ImageView) findViewById(R.id.iv1);
        final ImageView iv2 = (ImageView) findViewById(R.id.iv2);
        final ImageView iv3 = (ImageView) findViewById(R.id.iv3);
        final ImageView iv4 = (ImageView) findViewById(R.id.iv4);
        final ImageView iv5 = (ImageView) findViewById(R.id.iv5);
        final ImageView iv6 = (ImageView) findViewById(R.id.iv6);

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        firebaseDatabase.getReference("categorias").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> it = dataSnapshot.getChildren().iterator();

                while (it.hasNext()) {
                    DataSnapshot prox = it.next();
                    String file = prox.child("imagem").getValue(String.class);
                    Log.i("atag", file);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        firebaseDatabase.getReference("categorias").child("0").child("imagem").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String file = dataSnapshot.getValue(String.class);
                
                firebaseStorage.getReference("imagens/categorias/" + file).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.with(MainActivity.this).load(uri.toString()).into(iv1);
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
        });

        iv1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //iv1.setImageResource(R.drawable.eletrico);
                Intent intent = new Intent(MainActivity.this, ListaTutorialActivity.class);
                intent.putExtra("categoria", 1);
                startActivity(intent);

            }
        });

        iv2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                iv2.setImageResource(R.drawable.encanador);
                Intent intent = new Intent(MainActivity.this, ListaTutorialActivity.class);
                intent.putExtra("categoria", 2);
                startActivity(intent);

            }
        });

        iv3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                iv3.setImageResource(R.drawable.marceneiro);
                Intent intent = new Intent(MainActivity.this, ListaTutorialActivity.class);
                intent.putExtra("categoria", 3);
                startActivity(intent);

            }
        });

        iv4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                iv4.setImageResource(R.drawable.mecanico);
                Intent intent = new Intent(MainActivity.this, ListaTutorialActivity.class);
                intent.putExtra("categoria", 4);
                startActivity(intent);

            }
        });

        iv5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                iv5.setImageResource(R.drawable.pedreiro);
                Intent intent = new Intent(MainActivity.this, ListaTutorialActivity.class);
                intent.putExtra("categoria", 5);
                startActivity(intent);

            }
        });

        iv6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                iv6.setImageResource(R.drawable.diversos);
                Intent intent = new Intent(MainActivity.this, ListaTutorialActivity.class);
                intent.putExtra("categoria", 6);
                startActivity(intent);

            }
        });
    }
}

