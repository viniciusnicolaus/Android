package br.com.fiap.aulanotificacoes;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviar(View view) {
        NotificationManager notificationManager
                = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(
                    "alertas", "Canal de alertas", NotificationManager.IMPORTANCE_DEFAULT
            );
            notificationChannel.setDescription("Alertas emitidos em caso não urgentes");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500,1000});
            notificationChannel.enableVibration(true);

            notificationManager.createNotificationChannel(notificationChannel);

            NotificationCompat.Builder notification
                    = new NotificationCompat.Builder(this, "alertas");
            notification.setContentTitle("Minha notificação");
            notification.setContentText("Hello World");
            notification.setSmallIcon(R.mipmap.ic_launcher);

            notification.setContentIntent(
                    PendingIntent.getActivity(
                            this,
                            0,
                            new Intent(MainActivity.this, MainActivity.class),
                            PendingIntent.FLAG_UPDATE_CURRENT
                    )
            );

            notificationManager.notify(50, notification.build());
        }
    }
}
