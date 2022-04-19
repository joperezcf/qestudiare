package es.anonimo.qestudiare;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Setting extends AppCompatActivity implements MaterialDialog.SingleButtonCallback {
    LinearLayout llCleanFav, llTextSize, llTheme, llTextLang;
    boolean themeDark;
    int textSize;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("PreferencesApp", Context.MODE_PRIVATE);
        themeDark = prefs.getBoolean("dark_theme", false);
        textSize = prefs.getInt("textSize", -1);
        if (themeDark){
            setTheme(R.style.ThemeOverlay_AppCompat_Dark_ActionBar);
            setContentView(R.layout.activity_setting);
            setTitle("Configuración");

            ImageView ivSize = (ImageView) findViewById(R.id.ivTxtSize);
            ImageView ivTheme = (ImageView) findViewById(R.id.ivTxtTheme);
            //ImageView ivLang = (ImageView) findViewById(R.id.ivTxtLanguage);
            ImageView ivFav = (ImageView) findViewById(R.id.ivTxtFavorite);
            ivSize.setImageResource(R.drawable.ic_stg_sizefont_w);
            ivTheme.setImageResource(R.drawable.ic_stg_style_w);
            //ivLang.setImageResource(R.drawable.ic_stg_language_w);
            ivFav.setImageResource(R.drawable.ic_stg_fav_w);

            TextView tvSize = (TextView) findViewById(R.id.tvTextSize);
            TextView tvTheme = (TextView) findViewById(R.id.tvTheme);
            //TextView tvLang = (TextView) findViewById(R.id.tvLang);
            TextView tvFav = (TextView) findViewById(R.id.tvFav);

            tvSize.setTextSize(textSize);
            tvTheme.setTextSize(textSize);
            //tvLang.setTextSize(textSize);
            tvFav.setTextSize(textSize);
        }else {
            setContentView(R.layout.activity_setting);
            setTitle("Configuración");

            TextView tvSize = (TextView) findViewById(R.id.tvTextSize);
            TextView tvTheme = (TextView) findViewById(R.id.tvTheme);
            //TextView tvLang = (TextView) findViewById(R.id.tvLang);
            TextView tvFav = (TextView) findViewById(R.id.tvFav);

            tvSize.setTextSize(textSize);
            tvTheme.setTextSize(textSize);
            //tvLang.setTextSize(textSize);
            tvFav.setTextSize(textSize);
        }

        llTextSize = (LinearLayout) findViewById(R.id.llTextSize);
        llTextSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogTextSize(v);
            }
        });

        llTheme = (LinearLayout) findViewById(R.id.llTheme);
        llTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogTheme();
            }
        });

        /*
        llTextLang = (LinearLayout) findViewById(R.id.llTextLang);
        llTextLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogLanguage();
            }
        });
        */

        llCleanFav = (LinearLayout) findViewById(R.id.llCleanFav);
        llCleanFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogFav();
            }
        });


    }

    public void showDialogTextSize(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(Setting.this);
        builder.setTitle("Tamaño de Letra");
        final int[] size = {-1};

        //list of items
        String[] items = getResources().getStringArray(R.array.list_TxtSize);
        builder.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0: size[0] = -1;
                                break;
                            case 1: size[0] = 16;
                                break;
                            case 2: size[0] = 20;
                                break;
                        }
                    }
                });

        String positiveText = getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefs = getSharedPreferences("PreferencesApp", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        switch (size[0]){
                            case -1:
                                editor.putInt("textSize", -1);
                                break;
                            case 16:
                                editor.putInt("textSize", 16);
                                break;
                            case 20:
                                editor.putInt("textSize", 20);
                                break;
                        }
                        editor.commit();
                        recreate();
                    }
                });

        String negativeText = getString(android.R.string.cancel);
        builder.setNegativeButton(negativeText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // negative button logic
                    }
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }

    public void showDialogTheme() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Setting.this);
        builder.setTitle("Tema");
        final boolean[] themeDark = {false};

        //list of items
        String[] items = getResources().getStringArray(R.array.list_theme);
        builder.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which != 0){
                            if (which == 0){
                                themeDark[0] = false;
                            }else {
                                themeDark[0] = true;
                            }
                        }
                    }
                });

        String positiveText = getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefs = getSharedPreferences("PreferencesApp", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        if (themeDark[0] == true){
                            editor.putBoolean("dark_theme", true);
                        }else {
                            editor.putBoolean("dark_theme", false);
                        }
                        editor.commit();
                        recreate();
                    }
                });

        String negativeText = getString(android.R.string.cancel);
        builder.setNegativeButton(negativeText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // negative button logic
                    }
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }

    @Override
    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

    }

    public void showDialogLanguage(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Lenguaje");
        builder.setMessage("Esta opción no se encuentra disponible para esta versión");
        builder.setPositiveButton("Aceptar", null);
        builder.create().show();
    }

    public void showDialogFav(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Favoritos");
        builder.setMessage("Desea eliminar la lista de los favoritos?");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                OutputStreamWriter escritor = null;
                try {
                    escritor = new OutputStreamWriter(openFileOutput("favorite.txt", Context.MODE_PRIVATE));
                    escritor.write("");
                    escritor.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(Setting.this, "Eliminados correctamente...", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancelar", null);
        builder.create().show();
    }

}
