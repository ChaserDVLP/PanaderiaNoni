package panaderiaonline.com.proyectofinal.grupo.panaderiaonline;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TartaMedidaActivity extends AppCompatActivity {
    private float PrecioTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarta_medida);
    }


    public void Comprar (View v){
        PrecioTotal=0.00f;

        RadioGroup gtamaño = (RadioGroup) this.findViewById(R.id.gtamaño);
        RadioGroup gforma = (RadioGroup) this.findViewById(R.id.gforma);
        CheckBox checkFresa=(CheckBox)this.findViewById(R.id.checkFresa);
        CheckBox checkChoco=(CheckBox)this.findViewById(R.id.checkChoco);
        CheckBox check3Chocos=(CheckBox)this.findViewById(R.id.check3Chocos);
        CheckBox checkVainilla=(CheckBox)this.findViewById(R.id.checkVainilla);
        CheckBox checkNata=(CheckBox)this.findViewById(R.id.checkNata);

        switch (gtamaño.getCheckedRadioButtonId()){
            case R.id.radioPeque:
                PrecioTotal= (float) (PrecioTotal+5.00);
                break;
            case R.id.radioMedio:
                PrecioTotal= (float) (PrecioTotal+10.00);
                break;
            case R.id.radioGrande:
                PrecioTotal= (float) (PrecioTotal+15.00);
                break;
        }

        switch (gforma.getCheckedRadioButtonId()){
            case R.id.radioRedonda:
                PrecioTotal= (float) (PrecioTotal+0.00);
                break;
            case R.id.radioCuadrado:
                PrecioTotal= (float) (PrecioTotal+0.00);
                break;
        }

        if (checkFresa.isChecked()){
            PrecioTotal= (float) (PrecioTotal+0.50);
        }
        if (checkChoco.isChecked()){
            PrecioTotal= (float) (PrecioTotal+0.50);
        }
        if (check3Chocos.isChecked()){
            PrecioTotal= (float) (PrecioTotal+0.50);
        }
        if (checkVainilla.isChecked()){
            PrecioTotal= (float) (PrecioTotal+0.50);
        }
        if (checkNata.isChecked()){
            PrecioTotal= (float) (PrecioTotal+0.50);
        }

        final TextView TOTAL = (TextView) findViewById(R.id.tvTotal);
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
                    Intent intent=new Intent(TartaMedidaActivity.this,PantallaCompraActivity.class);
                    //guardamos el resultado de la operación
                    intent.putExtra("precio",PrecioTotal);
                    intent.putExtra("tiempo","1h 30min");
                    // lanzamiento de la actividad
                    TartaMedidaActivity.this.startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}
