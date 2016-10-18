package les.projeto.quebra_galho;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Brendha-PC on 17/10/2016.
 */

public class ChatFake  extends AppCompatActivity {

    ImageView telachat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telachatprovisoria);

        telachat = (ImageView) findViewById(R.id.telachat);


    }



}
