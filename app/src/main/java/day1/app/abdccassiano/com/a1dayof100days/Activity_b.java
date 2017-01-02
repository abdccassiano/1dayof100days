package day1.app.abdccassiano.com.a1dayof100days;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Activity_b extends AppCompatActivity {

    private TextView txtnumberB;
    private Button buttonB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        txtnumberB = (TextView) findViewById(R.id.txtnumberB);
        buttonB = (Button) findViewById(R.id.buttonB);

        //Catch the intent that come of ActivityA
        Intent intentA = getIntent();
        int aleatorio = intentA.getIntExtra("numero", -1);

        txtnumberB.setText(aleatorio + "");

        //Toast.makeText(getApplication(),"Aleatorio es: "+ aleatorio, Toast.LENGTH_SHORT).show();
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int numero = random.nextInt(100 - 10) + 10;
                //Toast.makeText(getApplication(),"Aleatorio: " + numero, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Activity_b.this, Activity_a.class);
                intent.putExtra("numero", numero);
                Activity_b.this.startActivity(intent);
            }
        });
    }
}
