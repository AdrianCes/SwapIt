package com.example.swapit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {
    private EditText editTextPassword;
    private EditText editTextPassword2;
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        editTextPassword = findViewById(R.id.editTextText5);
        editTextPassword2 = findViewById(R.id.editTextText6);

        setupPasswordVisibilityToggle(editTextPassword);
        setupPasswordVisibilityToggle(editTextPassword2);
    }

    private void setupPasswordVisibilityToggle(EditText editText) {
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // Al pulsar, cambiar la visibilidad de la contraseña
                    togglePasswordVisibility(editText);
                }
                return false;
            }
        });
    }

    private void togglePasswordVisibility(EditText editText) {
        // Cambiar la visibilidad de la contraseña
        isPasswordVisible = !isPasswordVisible;

        int inputType = isPasswordVisible ? InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                : InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD;

        editText.setInputType(inputType);
        editText.setSelection(editText.getText().length());  // Mover el cursor al final del texto

        // Cambiar el ícono
        int iconId = isPasswordVisible ? R.drawable.show_password : R.drawable.hide_password;
        editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, iconId, 0);
    }
}