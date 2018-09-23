package augusto.com.br.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private Button  starts;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_scream);

        startVariables();
        startAction();
    }

    private void startVariables() {
        context = getApplicationContext();

        starts = findViewById(R.id.btn_start);

    }

    private void startAction() {

        starts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mIntent = new Intent(context,Barbers.class);
                startActivity(mIntent);

            }
        });


    }




}
