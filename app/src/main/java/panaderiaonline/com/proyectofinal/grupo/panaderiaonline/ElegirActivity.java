package panaderiaonline.com.proyectofinal.grupo.panaderiaonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ElegirActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir);
    }
    public void PANMEDIDA (View view){
        startActivity(new Intent(ElegirActivity.this,PanMedidaActivity.class));
    }

    public void TartaMedida (View v){
        startActivity(new Intent(ElegirActivity.this,TartaMedidaActivity.class));
    }
}
