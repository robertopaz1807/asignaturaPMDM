package com.miteris.myasynctaskii;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button btnSinHilos;
    private Button btnConHilos;

    private Button btnAsyncTask;
    private Button btnCancelar;

    private ProgressBar pbarProgreso;
    private TextView txtProgreso;
    private MitareaAsincrona tarea1;

    private Button btnAsyncDialog;
    private ProgressDialog pDialog;
    private MiTareaAsincronaDialog tarea2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSinHilos = (Button)findViewById(R.id.btnSinHilos);
        btnConHilos = (Button)findViewById(R.id.btnHilo);

        btnAsyncTask = (Button)findViewById(R.id.btnAsyncTask);
        btnCancelar = (Button)findViewById(R.id.btnCancelar);

        btnAsyncDialog = (Button)findViewById(R.id.btnAsyncDialog);

        pbarProgreso = (ProgressBar)findViewById(R.id.pbarProgreso);
        txtProgreso = (TextView)findViewById(R.id.textView1);

        btnSinHilos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pbarProgreso.setMax(100);
                pbarProgreso.setProgress(0);
                for (int i=1; i<=10; i++){
                    tareaLarga();
                    pbarProgreso.incrementProgressBy(10);
                }
                Toast.makeText(MainActivity.this, "Tarea Finalizada",Toast.LENGTH_SHORT).show();
            }
        });



        btnConHilos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    public void run() {

                        pbarProgreso.post(new Runnable() {
                            public void run() {
                                pbarProgreso.setProgress(0);
                            }
                        });
                        for(int i=1; i<=10; i++) {
                           tareaLarga();
                           pbarProgreso.post(new Runnable() {
                                public void run() {
                                    pbarProgreso.incrementProgressBy(10);
                                }
                            });
                        }

                       runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(MainActivity.this, "Tarea finalizada!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                }).start();

            }
        });

        btnAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tarea1 = new MitareaAsincrona();
                tarea1.execute();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tarea1.cancel(true);
            }
        });

        btnAsyncDialog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                pDialog = new ProgressDialog(MainActivity.this);
                pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pDialog.setMessage("Procesando...");
                pDialog.setCancelable(true);
                pDialog.setMax(100);

                tarea2 = new MiTareaAsincronaDialog();
                tarea2.execute();
            }
        });



    }








    //Doormir 1Seg
    private void tareaLarga()
    {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {}
    }


    private class MitareaAsincrona extends AsyncTask<Void, Integer, Boolean>{

        @Override
        protected void onPreExecute() {
            pbarProgreso.setMax(100);
            pbarProgreso.setProgress(0);
        }
        @Override
        protected Boolean doInBackground(Void... params) {

            for(int i=1; i<=10; i++) {
                tareaLarga();
                publishProgress(i*10);  // cuando lo ejecutamos se ejecuta onProgressUpdate en el hilo principal
                if(isCancelled())
                    break;
            }
            return true;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            int progreso = values[0].intValue();
            pbarProgreso.setProgress(progreso);
        }
        @Override
        protected void onPostExecute(Boolean result){
            if (result)
                Toast.makeText(MainActivity.this, "Tarea finalizada!",
                        Toast.LENGTH_SHORT).show();
        }
        @Override
        protected void onCancelled(Boolean result){

            Toast.makeText(MainActivity.this, "Tarea Cancelada!",
                    Toast.LENGTH_SHORT).show();
        }

    }


    private class MiTareaAsincronaDialog extends AsyncTask<Void, Integer, Boolean>{

        @Override
        protected void onPreExecute() {
            pbarProgreso.setMax(100);
            pbarProgreso.setProgress(0);
        }
        @Override
        protected Boolean doInBackground(Void... params) {

            for(int i=1; i<=10; i++) {
                tareaLarga();
                publishProgress(i*10);  // cuando lo ejecutamos se ejecuta onProgressUpdate en el hilo principal
                if(isCancelled())
                    break;
            }
            return true;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            int progreso = values[0].intValue();
            pbarProgreso.setProgress(progreso);
        }
        @Override
        protected void onPostExecute(Boolean result){
            if (result)
                Toast.makeText(MainActivity.this, "Tarea finalizada!",
                        Toast.LENGTH_SHORT).show();
        }
        @Override
        protected void onCancelled(Boolean result){

            Toast.makeText(MainActivity.this, "Tarea Cancelada!",
                    Toast.LENGTH_SHORT).show();
        }

    }




}