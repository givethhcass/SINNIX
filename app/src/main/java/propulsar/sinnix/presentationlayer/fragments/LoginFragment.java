package propulsar.sinnix.presentationlayer.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.crash.FirebaseCrash;

import java.net.ConnectException;

import propulsar.sinnix.R;
import propulsar.sinnix.domainlayer.ws.WS;
import propulsar.sinnix.presentationlayer.activities.LoginRegisterActivity;
import propulsar.sinnix.presentationlayer.activities.MainTabsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener,WS.OnLoginRequested{

    public TextInputLayout textInputUsuario;
    public TextInputLayout textInputContra;
    public EditText editTextUsuario;
    public EditText editTextContraseña;
    public Button mButtonIniciarSesion;



    public LoginFragment() {
        // Required empty public constructor
    }

    // -------------------------------------------- //
    // ---------------- LIFE CYCLE ---------------- //
    // -------------------------------------------- //

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        textInputUsuario = view.findViewById(R.id.fragmentlogin_textinput_usuario);
        textInputContra = view.findViewById(R.id.fragmentlogin_textinput_contra);
        editTextUsuario = view.findViewById(R.id.editText_usuario);
        editTextUsuario.setOnClickListener(this);
        editTextContraseña = view.findViewById(R.id.editText_contra);
        editTextContraseña.setOnClickListener(this);
        mButtonIniciarSesion = view.findViewById(R.id.fragmentlogin_button_iniciarsesion);
        mButtonIniciarSesion.setOnClickListener(this);


        return view;
    }


    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }
    // --------------------------------------------- //
    // ---------------- OWN METHODS ---------------- //
    //---------------------------------------------- //



    // ----------------------------------------------------------- //
    // ---------------- INTERFACES IMPLEMENTATION ---------------- //
    //------------------------------------------------------------ //

    @Override
    public void onClick(View v) {
        int errorCount=0;

        switch (v.getId()) {
            case R.id.fragmentlogin_button_iniciarsesion:

                //intanciamos las cadenas que se obtienen de los campos //
                String stringUsuario = editTextUsuario.getText().toString();
                String stringContra = editTextContraseña.getText().toString();

                //si el campo usuario esta vacio muestra un error en el inputLayout//
                if(stringUsuario.isEmpty()){
                    textInputUsuario.setError(getString(R.string.login_error_usuario_vacio));
                    errorCount++;
                }else{
                    textInputUsuario.setError(null);
                }

                //si el campo contraseña esta vacio muestra un error en el inputLayout//
                if(stringContra.isEmpty()){
                    textInputContra.setError(getString(R.string.login_error_contra_vacia));
                    errorCount++;
                }else{
                    textInputContra.setError(null);
                }

                // Si los campos no estan vacios intenta hacer el login mediante Firebase Auth //
                if(errorCount==0){
                    FirebaseCrash.log("LoginTry");
                    WS.userLogin(stringUsuario,stringContra);
                }

        }
    }

    @Override
    public void loginAnswered(boolean success, Exception error) {
        if(success){

            FirebaseCrash.log("LoginAnsweSuccess");

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Iniciar actividad de Menu
                }
            },1000);

        }
    }
}


