package es.anonimo.qestudiare;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

import es.anonimo.qestudiare.fragment.LegalFragment;

public class About extends AppCompatActivity {
    Button btPagLegal, btLicense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("PreferencesApp", Context.MODE_PRIVATE);
        boolean themeDark = prefs.getBoolean("dark_theme", false);
        int textSize = prefs.getInt("textSize", -1);
        if (themeDark){
            setTheme(R.style.ThemeOverlay_AppCompat_Dark_ActionBar);
        }

        setContentView(R.layout.activity_about);

        TextView tvDedic = (TextView) findViewById(R.id.tvDedic);
        TextView tvPowerBy = (TextView) findViewById(R.id.tvPowerBy);

        tvDedic.setTextSize(textSize);
        tvPowerBy.setTextSize(textSize);

        btPagLegal = (Button) findViewById(R.id.btPagLegal);
        btPagLegal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(v.getContext())
                        .customView(R.layout.fragment_legal, false)
                        .show();
            }
        });
        btLicense = (Button) findViewById(R.id.btLicense);
        btLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(v.getContext())
                        .customView(R.layout.dialog_license, false)
                        .show();
            }
        });

    }

}
