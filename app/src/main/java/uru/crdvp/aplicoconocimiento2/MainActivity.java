package uru.crdvp.aplicoconocimiento2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import static uru.crdvp.aplicoconocimiento2.R.id.btn_name;
import static uru.crdvp.aplicoconocimiento2.R.id.tiedt_nombre;
import static uru.crdvp.aplicoconocimiento2.R.id.til_nombre;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    //ArrayList<Persona> persona;

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private View.OnClickListener onClickListener;
    String nombre;
    String fecha;
    String telefono;
    String email;
    String descripcion;
    Button siguiente;

    private TextInputEditText tiedt_nombre;
    private TextInputEditText til_telefono;
    private TextInputEditText tiedt_email;
    private TextInputEditText tiedt_descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDisplayDate = (TextView) findViewById(R.id.tvDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener, year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: " + month + "/" + dayOfMonth + "/" + year);
                String date = dayOfMonth + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        siguiente = (Button) findViewById(btn_name);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tiedt_nombre = (TextInputEditText) findViewById(R.id.tiedt_nombre);
                mDisplayDate = (TextView) findViewById(R.id.tvDate);
                til_telefono = (TextInputEditText) findViewById(R.id.tiedt_telefono);
                tiedt_email = (TextInputEditText) findViewById(R.id.tiedt_email);
                tiedt_descripcion = (TextInputEditText) findViewById(R.id.tiedt_descripcion);

                Intent i = new Intent(getApplicationContext(), ConfirmacionDatos.class);

                i.putExtra("nombre", tiedt_nombre.getText().toString());
                i.putExtra("fecha", mDisplayDate.getText().toString());
                i.putExtra("telefono", til_telefono.getText().toString());
                i.putExtra("email", tiedt_email.getText().toString());
                i.putExtra("descripcion", tiedt_descripcion.getText().toString());

                startActivity(i);
            }
        });
    }
};
