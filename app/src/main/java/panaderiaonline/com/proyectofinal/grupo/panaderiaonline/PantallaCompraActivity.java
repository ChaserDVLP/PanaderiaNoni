package panaderiaonline.com.proyectofinal.grupo.panaderiaonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PantallaCompraActivity extends AppCompatActivity {
private TextView tvPrecio, tvHora, tvTiempo;
private float resultado;
private String tiempo;
    Date d=new Date();

   /* @Override
    public String toString() {
        return "PantallaCompraActivity{" +
                "tvPrecio=" + tvPrecio +
                '}';
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_compra);

        char[] elementos={'0','1','2','3','4','5','6','7','8','9' ,'a',
                'b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t',
                'u','v','w','x','y','z'};

        char[] conjunto = new char[5];
        String pass = null;
        for(int i=1;i<conjunto.length;i++) {
            int el = (int) (Math.random() * 37);
            conjunto[i] = (char) elementos[el];
            pass = new String(conjunto);
        }
        TextView NRef = (TextView) findViewById(R.id.tvRef);
        NRef.setText(pass);

        tvPrecio = (TextView) findViewById(R.id.tvPrecio);
        Intent intent=this.getIntent();
        resultado=intent.getFloatExtra("precio",0);
        tvPrecio.setText(""+resultado);


        tvTiempo=(TextView) findViewById(R.id.tvTiempo);
        tiempo=intent.getStringExtra("tiempo");
        tvTiempo.setText(tiempo);






    }

    public void IrMenu (View v){
        startActivity(new Intent(PantallaCompraActivity.this,MainActivity.class));
        finish();
    }
}
