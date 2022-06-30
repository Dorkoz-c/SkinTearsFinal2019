package cl.ccu.skintears;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import cl.ccu.skintears.activities.InicioActivity;
import cl.ccu.skintears.androidpdfviewer.MainActivity;

public class LoginActivity extends AppCompatActivity {

    EditText usuario, pass;
    Button registrarbtn, ingresarbtn, cancelarbtn;

    DBHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.UsuarioeditText);
        pass = usuario = findViewById(R.id.PasswordeditText);
        registrarbtn = findViewById(R.id.Registerbutton);
        ingresarbtn = findViewById(R.id.LoginButton);
        cancelarbtn = findViewById(R.id.Cancelbutton);


        ingresarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailUser = usuario.getText().toString();
                String passUser = pass.getText().toString();

                if(emailUser.equals("")|| passUser.equals("")){
                    Toast.makeText(getBaseContext(),"Completar Campos", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean result = myDB.checkusernamePassword(emailUser,passUser);
                    if(result == true){
                        Intent intent = new Intent(LoginActivity.this, InicioActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getBaseContext(),"Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        registrarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailUser = usuario.getText().toString();
                String passUser = pass.getText().toString();

                if(emailUser.equals("")|| passUser.equals("")){
                    Toast.makeText(getBaseContext(),"Completar Campos", Toast.LENGTH_SHORT).show();
                }else{
                    if(passUser.equals(passUser)){
                        Boolean usercheckResult = myDB.checkusername(emailUser);
                        if(usercheckResult == false){
                            Boolean regResult = myDB.insertData(emailUser,passUser);
                            if(regResult == true){
                                Toast.makeText(getBaseContext(),"Registro Completo :)", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, InicioActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(getBaseContext(),"Registro Fallido :(", Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(getBaseContext(),"El Usuario Ya Existe", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getBaseContext(),"Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        cancelarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, InicioActivity.class);
                startActivity(intent);
            }
        });
    }

}