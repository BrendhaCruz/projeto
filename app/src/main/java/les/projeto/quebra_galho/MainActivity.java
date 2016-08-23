package les.projeto.quebra_galho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
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

        iv1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                iv1.setImageResource(R.drawable.eletrico);
                Intent intent = new Intent(MainActivity.this, TutoriaisPinturaActivity.class);
                startActivity(intent);

            }
        });

        iv2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                iv2.setImageResource(R.drawable.encanador);
                Intent intent = new Intent(MainActivity.this, TutoriaisPinturaActivity.class);
                startActivity(intent);

            }
        });

        iv3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                iv3.setImageResource(R.drawable.marceneiro);
                Intent intent = new Intent(MainActivity.this, TutoriaisPinturaActivity.class);
                startActivity(intent);

            }
        });

        iv4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                iv4.setImageResource(R.drawable.mecanico);
                Intent intent = new Intent(MainActivity.this, TutoriaisPinturaActivity.class);
                startActivity(intent);

            }
        });

        iv5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                iv5.setImageResource(R.drawable.pedreiro);
                Intent intent = new Intent(MainActivity.this, TutoriaisPinturaActivity.class);
                startActivity(intent);

            }
        });

        iv6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                iv6.setImageResource(R.drawable.diversos);
                Intent intent = new Intent(MainActivity.this, TutoriaisPinturaActivity.class);
                startActivity(intent);

            }
        });
    }
}
