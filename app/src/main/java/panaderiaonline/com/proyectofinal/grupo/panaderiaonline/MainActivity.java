package panaderiaonline.com.proyectofinal.grupo.panaderiaonline;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainGrid = (GridLayout)this.findViewById(R.id.mainGrid);
        //setSingleEvent(mainGrid);
    }

    public void ComprarPan (View view){
        Toast.makeText(this,"La opción 'Comprar Pan' no está disponible. Disculpe las molestias.",Toast.LENGTH_SHORT).show();
    }

    public void A_MEDIDA(View view){
        startActivity(new Intent(MainActivity.this,ElegirActivity.class));
    }

    public void ComprarTartas(View view){
        Toast.makeText(this,"La opción 'Comprar Tartas' no está disponible. Disculpe las molestias.",Toast.LENGTH_SHORT).show();
    }

    public void ComprarBollería(View view){
        Toast.makeText(this,"La opción 'Comprar Bollería' no está disponible. Disculpe las molestias.",Toast.LENGTH_SHORT).show();
    }

    public void ComprarBebidas (View view){
        Toast.makeText(this,"La opción 'Comprar Bebidas' no está disponible. Disculpe las molestias.",Toast.LENGTH_SHORT).show();
    }

    public void CONTACTO (View view) {
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }
    public void salir(View v) {
        Toast.makeText(MainActivity.this, "Intentando salir...", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder mensaje = new AlertDialog.Builder(MainActivity.this);
        mensaje.setMessage("¿Desea cerrar la sesión?");
        //el escuchador del botón de afirmación se define como
        //una clase anónima
        mensaje.setPositiveButton(android.R.string.yes,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Cerramos sesión
                        FirebaseAuth.getInstance().signOut();
                        LoginManager.getInstance().logOut();

                        startActivity(new Intent(MainActivity.this, SignupActivity.class));
                        MainActivity.this.finish();
                        // this listener will be called when there is change in firebase user session
                        FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
                            @Override
                            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                if (user == null) {
                                    // user auth state is changed - user is null
                                    // launch login activity
                                    startActivity(new Intent(MainActivity.this, SignupActivity.class));
                                    MainActivity.this.finish();
                                }
                            }
                        };
                    }
                });
        //no se define ningún escuchador para el botón de negación
        mensaje.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Gracias por permanecer aquí...", Toast.LENGTH_LONG).show();
            }
        });
        mensaje.show();
    }
}
