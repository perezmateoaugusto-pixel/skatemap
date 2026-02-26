package com.example.localizadordeskateparks;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistroActivity extends AppCompatActivity {

        EditText edtDni, edtNombre, edtApePaterno, edtApeMaterno, edtCelular, edtCorreo, edtPassword;
        Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        edtDni = findViewById(R.id.edtDni);
        edtNombre = findViewById(R.id.edtNombre);
        edtApePaterno = findViewById(R.id.edtApePaterno);
        edtApeMaterno = findViewById(R.id.edtApeMaterno);
        edtCelular = findViewById(R.id.edtCelular);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtPassword = findViewById(R.id.edtContraseña);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(v -> guardarDatos());
    }

    private void guardarDatos() {

        String dni = edtDni.getText().toString();
        String nombre = edtNombre.getText().toString();
        String apePat = edtApePaterno.getText().toString();
        String apeMat = edtApeMaterno.getText().toString();
        String celular = edtCelular.getText().toString();
        String correo = edtCorreo.getText().toString();
        String password = edtPassword.getText().toString();

        if (dni.isEmpty() || nombre.isEmpty() || apePat.isEmpty() ||
                apeMat.isEmpty() || celular.isEmpty() || correo.isEmpty() || password.isEmpty()) {

            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences prefs = getSharedPreferences("usuarios", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("correo", correo);
        editor.putString("password", password);
        editor.apply();

        Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_LONG).show();

        finish();




    }
}