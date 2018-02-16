package net.ivanvega.clientecpusuariosb;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class COntacto extends AppCompatActivity {

    EditText id;
    EditText nombre;
    EditText correo;
    EditText password;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        id = (EditText) findViewById(R.id.txtId);
        nombre = (EditText) findViewById(R.id.txtNombre);
        correo = (EditText) findViewById(R.id.txtCorreo);
        password = (EditText) findViewById(R.id.txtContraseña);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
    }

    public void insertar()
    {
        ContentValues cv = new ContentValues();
        cv.put(UsuarioContrato.FIELD_NAME,  nombre.getText().toString());
        cv.put(UsuarioContrato.FIELD_EMAIL, correo.getText().toString());
        cv.put(UsuarioContrato.FIELD_PASS, password.getText().toString());
        Uri u = getContentResolver().insert(Uri.parse( UsuarioContrato.CONTENT_URI),cv);
        Log.d(nombre.toString(),u.toString());
    }


    public void modificar()
    {
        ContentValues cv = new ContentValues();
        cv.put(UsuarioContrato.FIELD_NAME,  nombre.getText().toString());
        cv.put(UsuarioContrato.FIELD_EMAIL, correo.getText().toString());
        cv.put(UsuarioContrato.FIELD_PASS, password.getText().toString());
        int u = getContentResolver().update(Uri.parse( UsuarioContrato.CONTENT_URI),cv,"_id="+nombre.getText().toString(),null);

    }


    public void guardar(View v)
    {
        insertar();
        Intent miIntent = new Intent(this, MainActivity.class);
        startActivity(miIntent);
        Toast.makeText(this, nombre.getText().toString(),Toast.LENGTH_LONG).show();
    }

    public void Actualizar(View v) {
        modificar();
        Intent miIntent = new Intent(this, MainActivity.class);
        startActivity(miIntent);

    }
}
