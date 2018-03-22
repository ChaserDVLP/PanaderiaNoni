package panaderiaonline.com.proyectofinal.grupo.panaderiaonline;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity_old extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_old);
    }

    public void salir(View v) {
        Toast.makeText(MainActivity_old.this, "Intentando salir...", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder mensaje = new AlertDialog.Builder(MainActivity_old.this);
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

                        startActivity(new Intent(MainActivity_old.this, SignupActivity.class));
                        MainActivity_old.this.finish();
                        // this listener will be called when there is change in firebase user session
                        FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
                            @Override
                            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                if (user == null) {
                                    // user auth state is changed - user is null
                                    // launch login activity
                                    startActivity(new Intent(MainActivity_old.this, SignupActivity.class));
                                    MainActivity_old.this.finish();
                                }
                            }
                        };
                    }
                });
        //no se define ningún escuchador para el botón de negación
        mensaje.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity_old.this, "Gracias por permanecer aquí...", Toast.LENGTH_LONG).show();
            }
        });
        mensaje.show();
    }

    public void Mapa(View view) {
        startActivity(new Intent(MainActivity_old.this, MapsActivity.class));
    }
}
