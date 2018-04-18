package br.com.fiap.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.alert_dialog);
        builder.setMessage(R.string.conteudo_do_alert);
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, R.string.cliquei_em_ok,Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    public void abrirProgressDialog(View view) {
        ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle(getString(R.string.progress_dialog));
        pd.setMessage(getString(R.string.aguarde));
        pd.show();
        // pd.dismiss(); -> Fecha o dialog
    }

    public void abrirDatePickerDialog(View view) {
        DatePickerDialog dialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String msg = String.format("%02d/%02d/%d",dayOfMonth,month + 1,year);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                },
                2018,
                3,
                18
        );
        dialog.show();

    }

    public void abrirTimePickerDialog(View view) {
        TimePickerDialog picker = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String msg = String.format("%02d:%02d",hourOfDay,minute);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                },
                9,
                9,
                true

        );
        picker.show();
    }

    public void abrirAlertPersonalizado(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setTitle(R.string.personalizado);
        dialog.setContentView(R.layout.dialog_personalizado);
        dialog.show();
    }
}