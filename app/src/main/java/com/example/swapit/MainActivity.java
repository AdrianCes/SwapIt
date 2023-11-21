package com.example.swapit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private EditText editTextPassword;
    private boolean isPasswordVisible = false;
    private TextView textViewRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar las variables
        editTextPassword = findViewById(R.id.editTextText2);

        // Establecer el listener de pulsación en el ícono de la contraseña
        editTextPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // Al pulsar, cambiar la visibilidad de la contraseña
                    togglePasswordVisibility();
                }
                return false;
            }
        });

        textViewRegister = findViewById(R.id.textView5);
        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción al hacer clic en el TextView de registro
                // Puedes cambiar la clase de la actividad según tus necesidades
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
    }


    private void togglePasswordVisibility() {
        // Cambiar la visibilidad de la contraseña
        isPasswordVisible = !isPasswordVisible;

        int inputType = isPasswordVisible ? InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                : InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD;

        editTextPassword.setInputType(inputType);
        editTextPassword.setSelection(editTextPassword.getText().length());  // Mover el cursor al final del texto

        // Cambiar el ícono
        int iconId = isPasswordVisible ? R.drawable.show_password : R.drawable.hide_password;
        editTextPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, iconId, 0);

    }


}


