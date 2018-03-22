package panaderiaonline.com.proyectofinal.grupo.panaderiaonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PanMedidaActivity extends AppCompatActivity {

    private float PrecioTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pan_medida);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

    }

    public void Comprar (View v){
        PrecioTotal=0.00f;

        RadioGroup gtamaño = (RadioGroup) this.findViewById(R.id.gtamaño);
        RadioGroup gmasa = (RadioGroup) this.findViewById(R.id.gmasa);
        CheckBox checkSemillas=(CheckBox)this.findViewById(R.id.checkSemillas);
        CheckBox checkCereales=(CheckBox)this.findViewById(R.id.checkCereales);
        CheckBox checkHarina=(CheckBox)this.findViewById(R.id.checkHarina);

        switch (gtamaño.getCheckedRadioButtonId()){
            case R.id.radioMedio:
                PrecioTotal= (float) (PrecioTotal+1.30);
                break;
            case R.id.radioNormal:
                PrecioTotal= (float) (PrecioTotal+0.50);
                break;
            case R.id.radioBaguette:
                PrecioTotal= (float) (PrecioTotal+0.50);
                break;
            case R.id.radioPanecillo:
                PrecioTotal= (float) (PrecioTotal+0.20);
                break;
        }

        switch (gmasa.getCheckedRadioButtonId()){
            case R.id.radioMasaNormal:
                PrecioTotal= (float) (PrecioTotal+0.20);
                break;
            case R.id.radioGluten:
                PrecioTotal= (float) (PrecioTotal+1.00);
                break;
            case R.id.radioIntegral:
                PrecioTotal= (float) (PrecioTotal+0.50);
                break;
        }

        if (checkSemillas.isChecked()){
            PrecioTotal= (float) (PrecioTotal+0.20);
        }
        if (checkCereales.isChecked()){
            PrecioTotal= (float) (PrecioTotal+0.20);
        }
        if (checkHarina.isChecked()){
            PrecioTotal= (float) (PrecioTotal+0.00);
        }

        TextView TOTAL = (TextView) findViewById(R.id.tvTotal);
        TOTAL.setText(PrecioTotal+"");

        Toast.makeText(this,"Generando pedido y número de referencia, Por favor, espere...",Toast.LENGTH_LONG).show();

        final Intent intent = new Intent(this,PantallaCompraActivity.class);
        Thread timer = new Thread(){
            public void run (){
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    //creación del objeto Intent asociado a la nueva actividad
                    Intent intent=new Intent(PanMedidaActivity.this,PantallaCompraActivity.class);
                    //guardamos el resultado de la operación
                    intent.putExtra("precio",PrecioTotal);
                    intent.putExtra("tiempo","45 min");
                    // lanzamiento de la actividad
                    PanMedidaActivity.this.startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}
