package augusto.com.br.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

public class Barbers extends AppCompatActivity{

    private Context context;
    private Button  comeBack;
    private SimpleAdapter adapter;
    private ArrayList<HMaux> barber;
    private ListView lv_barbers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barbers);

        startVariables();
        startAction();

    }



    private void startVariables() {

        context = getBaseContext();
        lv_barbers = findViewById(R.id.lv_barber);
        comeBack = findViewById(R.id.btn_come_back);

        schedulingBarber();

        String[] De = {Constantes.FOTO,Constantes.NOME};
        int[] Para = {R.id.celula_iv_foto,R.id.celula_tv_nome};

        adapter = new SimpleAdapter(context, barber,
                R.layout.cell,De,Para);

        lv_barbers.setAdapter(adapter);

    }

    private void startAction() {

        lv_barbers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                HMaux aux = (HMaux) adapterView.getItemAtPosition(position);


            }
        });

    }
    String[] nome = {"Joao","Antonio","Pedro"};

    int[] foto = {R.drawable.avenger01, R.drawable.avenger02,R.drawable.avenger03};

    private void schedulingBarber() {
        barber = new ArrayList<>();
        for (int i = 0; i < nome.length; i++) {
            HMaux barbersHMaux = new HMaux();
            barbersHMaux.put(Constantes.NOME,nome[i]);
            barbersHMaux.put(Constantes.FOTO, String.valueOf(foto[i]));
            barber.add(barbersHMaux);
        }


        comeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                backToHomeScreen();

            }
        });
    }
    private void backToHomeScreen(){

        Intent mIntent = new Intent(context,MainActivity.class);
        startActivity(mIntent);
    }
}
