package com.miteris.mywidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MiWidget extends AppWidgetProvider {

    public static void actualizarWidget(Context context, AppWidgetManager appWidgetManager, int widgetId) {

        //Recuperamos el mensaje personalizado para el widget actual
        SharedPreferences prefs =
                context.getSharedPreferences("WidgetPrefs", Context.MODE_PRIVATE);
        String mensaje = prefs.getString("msg_" + widgetId, "Hora actual:");

        //Obtenemos la lista de controles del widget actual
        RemoteViews controles =
                new RemoteViews(context.getPackageName(), R.layout.miwidget);

        //Actualizamos el mensaje en el control del widget
        controles.setTextViewText(R.id.LblMensaje, mensaje);

        //Obtenemos la hora actual
        Calendar calendario = new GregorianCalendar();
        String hora = calendario.getTime().toLocaleString();

        //Actualizamos la hora en el control del widget
        controles.setTextViewText(R.id.LblHora, hora);

        //Notificamos al manager de la actualización del widget actual
        appWidgetManager.updateAppWidget(widgetId, controles);

        Intent intent = new Intent("com.miteris.mywidget.ACTUALIZAR_WIDGET");
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);

        PendingIntent pendingIntent =
                PendingIntent.getBroadcast(context, widgetId, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        controles.setOnClickPendingIntent(R.id.BtnActualizar, pendingIntent);


        Intent intent2 = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent2 =
                PendingIntent.getActivity(context, widgetId, intent2, PendingIntent.FLAG_UPDATE_CURRENT);

        controles.setOnClickPendingIntent(R.id.FrmWidget, pendingIntent2);


    }


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        //Iteramos la lista de widgets en ejecución
        for (int i = 0; i < appWidgetIds.length; i++) {
            //ID del widget actual
            int widgetId = appWidgetIds[i];

            //Actualizamos el widget actual
            actualizarWidget(context, appWidgetManager, widgetId);
        }
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.miteris.mywidget.ACTUALIZAR_WIDGET")) {
            //Obtenemos el ID del widget a actualizar
            int widgetId = intent.getIntExtra(
                    AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);

            //Obtenemos el widget manager de nuestro contexto
            AppWidgetManager widgetManager =
                    AppWidgetManager.getInstance(context);

            //Actualizamos el widget
            if (widgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
                actualizarWidget(context, widgetManager, widgetId);
            }
        }
    }
}