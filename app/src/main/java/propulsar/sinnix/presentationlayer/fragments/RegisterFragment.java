package propulsar.sinnix.presentationlayer.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import propulsar.sinnix.R;
import propulsar.sinnix.domainlayer.ws.WS;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener, WS.OnLoginRequested{

    private TextInputLayout textInputUsuario;
    private TextInputLayout textInputContra;
    private EditText editTextUsuario;
    private EditText editTextContra;
    private Button mButtonRegister;
    private ImageButton mButtonLinkedin;


    public RegisterFragment() {
        // Required empty public constructor
    }

    // -------------------------------------------- //
    // ---------------- LIFE CYCLE ---------------- //
    // -------------------------------------------- //

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        textInputUsuario = view.findViewById(R.id.fragmentregister_textInputLayout_usuario);
        textInputContra = view.findViewById(R.id.fragmentregister_textInputLayout_contra);
        editTextUsuario = view.findViewById(R.id.fragmentregister_editText_usuario);
        editTextUsuario.setOnClickListener(this);
        editTextContra = view.findViewById(R.id.fragmentregister_editText_contra);
        editTextContra.setOnClickListener(this);
        mButtonRegister = view.findViewById(R.id.fragmentregister_button_registrarse);
        mButtonRegister.setOnClickListener(this);
        mButtonLinkedin = view.findViewById(R.id.fragmentregister_button_linkedin);
        mButtonLinkedin.setOnClickListener(this);
        return view;
    }

    public static RegisterFragment newInstance(){
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }



    // ----------------------------------------------------------- //
    // ---------------- INTERFACES IMPLEMENTATION ---------------- //
    //------------------------------------------------------------ //

    @Override
    public void onClick(View v) {

        int errorCount=0;

        switch (v.getId()){
            case R.id.fragmentregister_button_registrarse:
                Toast.makeText(getActivity(), "Desplegar Register", Toast.LENGTH_SHORT).show();
                break;



            case R.id.fragmentregister_button_linkedin:
                Toast.makeText(getActivity(), "Desplegar Linkedin", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void loginAnswered(boolean success, Exception error) {

    }
}
