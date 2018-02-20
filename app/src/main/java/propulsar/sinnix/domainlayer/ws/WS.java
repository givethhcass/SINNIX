package propulsar.sinnix.domainlayer.ws;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

/**
 * Created by givet on 08/02/2018.
 */

public class WS {

    private static final String TAG = "WSDebug";
    private static WS instance;

    private static FirebaseDatabase mFirebaseDatabase;
    private static DatabaseReference mDatabaseReference;
    private static FirebaseAnalytics mFirebaseAnalytics;
    private static FirebaseUser currentUser;
    private static FirebaseAuth mFirebaseAuth;
    private static FirebaseAuth.AuthStateListener mAuthStateListener;
    private static FirebaseStorage mFirebaseStorage;

    public static boolean loggedIn;


    public synchronized static WS getInstance(final Context c){

        if(instance == null){
            instance = new WS();

            if(mFirebaseAuth == null){
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                firebaseDatabase.setPersistenceEnabled(false);
                mDatabaseReference = firebaseDatabase.getReference();
                mFirebaseAuth = FirebaseAuth.getInstance();
            }

            /**
             * Declaramos el escucha de sesiones de Firebase para gestionar si esta loggeado o no
             */

            if(mAuthStateListener==null) mAuthStateListener = new FirebaseAuth.AuthStateListener() {

                @Override
                public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                    currentUser = firebaseAuth.getCurrentUser();
                    if(currentUser!=null){

                        //User is signed in
                        Log.d("FirebaseDebug","onAuthStateChangedTo:signed_in" + currentUser.getUid());
                        loggedIn = true;

                        mFirebaseAnalytics = FirebaseAnalytics.getInstance(c);


                    }else{

                        //User signed out
                        Log.d("FirebasDebug","onAuthStateChangedTo:signed_out");
                        loggedIn=false;
                    }
                    onLoginRequested.loginAnswered(loggedIn,null);
                }
            };
        }

        return instance;

    }

    // --------------------------------------------- //
    // ---------------- OWN METHODS ---------------- //
    //---------------------------------------------- //

    /**
     * Metodo que intenta hacer el login mediante Firebase Authentication
     * @param email
     * @param password
     */

    public static void userLogin(String email, String password){
        Log.d("LoginDebug","Will try now");
        mFirebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            currentUser = mFirebaseAuth.getCurrentUser();
                        }else{
                            Log.d("LoginDebug","signInWithEmail:failure",task.getException());
                            loggedIn = true;
                            onLoginRequested.loginAnswered(false, task.getException());
                        }

                    }
                });
    }

    // --------------------------------------------------- //
    // ---------------- SETTERS & GETTERS ---------------- //
    //---------------------------------------------------- //

    public static FirebaseUser getCurrentUser(){ return currentUser; }

    public static void setCurrentUser(FirebaseUser currentUser) { WS.currentUser = currentUser; }

    //--------------------------------------------- //
    //----------------  LISTENERS  ---------------- //
    //--------------------------------------------- //

    /**
     * Settea el listener en cuestion para la escucha de las sesiones
     * @param loginRequested
     */

    public void setLoginListener(OnLoginRequested loginRequested){
        onLoginRequested=loginRequested;
    }

    /**
     * Se declara la interfaz que se encarga de mantener comunicancion entre WS y la LoginRegister
     */

    public static OnLoginRequested onLoginRequested;
    public interface OnLoginRequested{
        void loginAnswered(boolean success, Exception error);
    }

    /**
     * Settea el listener en cuestion para la escucha de las sesiones
     * @param loginRequested
     */

    public static void setLoginListerner(OnLoginRequested loginRequested){
        onLoginRequested = loginRequested;
    }

    /**
     * Metodo que se encarga de activar el escucha de las sesiones de Firebase
     */

    public static void addFirebaseAuthStateListener(){
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    /**
     * Metodo que se encarga de desactivar el escucha de las sesiones de Firebase
     */

    public static void removeFirebaseAuthListener(){
        if(mAuthStateListener != null){
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

}
