package day1.app.abdccassiano.com.a1dayof100days;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Activity_a extends AppCompatActivity {

    private TextView txtnumberA;
    private Button buttonA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        txtnumberA = (TextView) findViewById(R.id.txtnumberA);
        buttonA = (Button) findViewById(R.id.buttonA);

        Intent intentB = getIntent();
        int aleatorio = intentB.getIntExtra("numero", -1);
        if (aleatorio == -1){aleatorio=0;}

        txtnumberA.setText(aleatorio + "");

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Random number
                Random random = new Random();
                int numero = random.nextInt(100 - 10) + 10;

                //Toast.makeText(getApplication(),"El número aleatorio es: "+ numero,Toast.LENGTH_LONG).show();
                //Inten move to ActivityB.class
                Intent intent = new Intent(Activity_a.this, Activity_b.class);
                intent.putExtra("numero", numero);
                Activity_a.this.startActivity(intent);
            }
        });
    }
}
