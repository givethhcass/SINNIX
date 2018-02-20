package propulsar.sinnix.presentationlayer.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.crash.FirebaseCrash;

import propulsar.sinnix.R;
import propulsar.sinnix.domainlayer.ws.WS;
import propulsar.sinnix.presentationlayer.fragments.LoginFragment;
import propulsar.sinnix.presentationlayer.fragments.SpeakersFragment;

public class SplashActivity extends AppCompatActivity implements WS.OnLoginRequested {

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private boolean loggedInBOOL;


    // -------------------------------------------- //
    // ---------------- LIFE CYCLE ---------------- //
    // -------------------------------------------- //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        WS.setLoginListerner(SplashActivity.this);

        WS.getInstance(SplashActivity.this);

        FirebaseCrash.log("SplashCreated");
    }

    @Override
    public void onStart(){
        super.onStart();

        // Se inicia el listener //
        WS.removeFirebaseAuthListener();
    }

    @Override
    public void onStop(){
        super.onStop();
        if(mAuthStateListener != null){

            //desactiva el listener cuando termina la actividad //
            WS.removeFirebaseAuthListener();
        }
    }



    // --------------------------------------------- //
    // ---------------- OWN METHODS ---------------- //
    //---------------------------------------------- //

    private void delayedAndContinue(final boolean loggedIn){

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Si no esta loggeado iniciar LoginRegisterActivity
                if(!loggedIn){

                    //Iniciar LoginRegisterActivity

                    Intent intent = new Intent(SplashActivity.this, LoginRegisterActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(SplashActivity.this, MainTabsActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        },3000);

    }

    // --------------------------------------------------- //
    // ---------------- WS IMPLEMENTATION ---------------- //
    //---------------------------------------------------- //


    @Override
    public void loginAnswered(boolean success, Exception error) {
        FirebaseCrash.log("LoginWSAnswered");
        loggedInBOOL=success;
    }
}
