package propulsar.sinnix.presentationlayer.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.auth.FirebaseUser;

import propulsar.sinnix.R;
import propulsar.sinnix.domainlayer.ws.WS;
import propulsar.sinnix.presentationlayer.fragments.LoginFragment;
import propulsar.sinnix.presentationlayer.fragments.RegisterFragment;
import propulsar.sinnix.presentationlayer.fragments.VipFragment;

/**
 * Created by givet on 06/02/2018.
 */

public class LoginRegisterActivity extends AppCompatActivity implements View.OnClickListener, WS.OnLoginRequested {

    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private Button mButtonIniciarSesion;
    private Button mButonVipPass;

    // -------------------------------------------- //
    // ---------------- LIFE CYCLE ---------------- //
    // -------------------------------------------- //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        mViewPager = findViewById(R.id.activitylogin_viewpager_loginviewpager);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mButtonIniciarSesion = findViewById(R.id.activitylogin_button_iniciarsesion);
        mButtonIniciarSesion.setOnClickListener(this);
        mButonVipPass = findViewById(R.id.activitylogin_button_vippass);
        mButonVipPass.setOnClickListener(this);
    }


    // -------------------------------------------- //
    //---------------- OWN METHODS ---------------- //
    // -------------------------------------------- //

    /**
     * Metodo que esconde el teclado de manera programatica
     */
    private void hideKeyboard(){
        try{
            View view = this.getCurrentFocus();
            if(view != null){
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(),0);

            }

        }catch (Exception e){e.printStackTrace();}
    }

    public boolean isGooglePlayServicesAvailable(Activity activity){
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int status = googleApiAvailability.isGooglePlayServicesAvailable(activity);
        if(status != ConnectionResult.SUCCESS){
            if(googleApiAvailability.isUserResolvableError(status)){
                googleApiAvailability.getErrorDialog(activity, status,2404).show();
            }
            return false;
        }
        return true;
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return (LoginFragment.newInstance());
                case 1:
                    return (RegisterFragment.newInstance());
                case 2:
                    return (VipFragment.newInstance());
            }
            return LoginFragment.newInstance();

        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    // ----------------------------------------------------------- //
    // ---------------- INTERFACES IMPLEMENTATION ---------------- //
    //------------------------------------------------------------ //

    /**
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activitylogin_button_iniciarsesion:
                break;
            case R.id.activitylogin_button_vippass:
                break;
        }
    }

    @Override
    public void loginAnswered(boolean success, Exception error) {

    }
}
