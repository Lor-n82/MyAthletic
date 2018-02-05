package com.example.in2dm3_03.myathletic;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class nuevo_registro extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    EditText mNombre, mUsuario, mPass, mPassConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_registro);
    }

    public void registrarse(View v) {

        if (v.getId() == R.id.buttonRegistrateLeon) {
            mNombre = (EditText) findViewById(R.id.editTextNombreR);
            mUsuario = (EditText) findViewById(R.id.editTextUsuarioR);
            mPass = (EditText) findViewById(R.id.editTextPassR);
            mPassConfirm = (EditText) findViewById(R.id.editTextRePassR);

            String nombre = mNombre.getText().toString();
            String username = mUsuario.getText().toString();
            String pass = mPass.getText().toString();
            String pass2 = mPassConfirm.getText().toString();

            if (!pass.equals(pass2)) {
                Toast p = Toast.makeText(nuevo_registro.this, "Las claves no coinciden", Toast.LENGTH_SHORT);
                p.show();
            } else {
                Contacto c = new Contacto();
                c.setNombre(nombre);
                c.setUname(username);
                c.setPass(pass);
                helper.insertContact(c);
                notificacion(c.getNombre(), c.getUname());
            }
        }
    }

    public void notificacion(String nombre, String usuario) {
        //Paso 1:conseguir Notificaciones
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //Paso 2: Crear notificacion
        int icon = R.drawable.athletic;
        CharSequence text = "Notification ticket text";
        long when = System.currentTimeMillis();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setSmallIcon(icon);
        builder.setTicker(text);
        builder.setWhen(when);

        Intent intent = new Intent(this, Notificacion.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, 0);

        builder.setContentTitle("Registro completado");
        builder.setContentText(nombre + " te has registrado como " + usuario + " !!!");
        builder.setContentIntent(contentIntent);
        builder.setAutoCancel(true);

        builder.setDefaults(NotificationCompat.DEFAULT_VIBRATE);
        builder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        Notification notif = builder.build();

        final int HELLO_ID = 1;
        mNotificationManager.notify(HELLO_ID, notif);
        finish();
    }
}
