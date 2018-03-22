package panaderiaonline.com.proyectofinal.grupo.panaderiaonline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private TextView tvNombre;
    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        tvNombre = (TextView)findViewById(R.id.tvNombre);
        ivLogo = (ImageView)findViewById(R.id.ivLogo);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tvNombre.startAnimation(myanim);
        ivLogo.startAnimation(myanim);
        final Intent intent = new Intent(this,SignupActivity.class);
        Thread timer = new Thread(){
            public void run (){
                try {
                    sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();


    }
}
