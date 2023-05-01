package uru.crdvp.aplicoconocimiento2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmacionDatos extends AppCompatActivity {

    TextView tvNombre;
    TextView tvFecha;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;
    Button btn_confirmar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos);
        recibirDatos();
        btn_confirmar = (Button) findViewById(R.id.btn_confirmar);
        btn_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    };

    private void recibirDatos() {
        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String fecha = extras.getString("fecha");
        String telefono = extras.getString("telefono");
        String email = extras.getString("email");
        String descripcion = extras.getString("descripcion");

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvNombre.setText(nombre);

        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvFecha.setText(fecha);

        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvTelefono.setText(telefono);

        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvEmail.setText(email);

        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvDescripcion.setText(descripcion);

    }

}