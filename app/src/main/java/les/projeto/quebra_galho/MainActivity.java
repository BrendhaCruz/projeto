package les.projeto.quebra_galho;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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

        iv1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                iv1.setImageResource(R.drawable.icone);
                Intent intent = new Intent(MainActivity.this, TutoriaisActivity.class);
                startActivity(intent);

            }
        });
    }
}
