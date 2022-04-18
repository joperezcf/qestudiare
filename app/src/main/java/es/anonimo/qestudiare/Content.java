package es.anonimo.qestudiare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Objects;

import es.anonimo.qestudiare.data.Favorite;
import es.anonimo.qestudiare.fragment.FavoriteFragment;
import es.anonimo.qestudiare.fragment.HomeFragment;

public class Content extends AppCompatActivity {
    int idFavortite;
    boolean flagFavorite = false;
    boolean isFavorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("PreferencesApp", Context.MODE_PRIVATE);
        boolean themeDark = prefs.getBoolean("dark_theme", false);
        int textSize = prefs.getInt("textSize", -1);
        if (themeDark){
            setTheme(R.style.ThemeOverlay_AppCompat_Dark_ActionBar);
        }

        setContentView(R.layout.activity_content);

        //Typeface face = Typeface.createFromAsset(getAssets(), "fonts/futura.ttf");

        TextView textView = (TextView) findViewById(R.id.tvTextContent);
        textView.setTextSize(textSize);

        //textView.setTypeface(face);

        String text = "";
        Bundle b = this.getIntent().getExtras();
        int rec = b.getInt("value");
        idFavortite = rec;
        isFavorite = b.getBoolean("isFavorite");
        if (rec != 0){
            try
            {
                InputStream fraw = getResources().openRawResource(rec);
                BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));

                String linea = brin.readLine();
                while (linea != null) {
                    if (linea != null){
                        text += linea + "\n";
                    }
                    linea = brin.readLine();
                }
                fraw.close();
                textView.setText(text);
            }
            catch (Exception ex)
            {
                Toast.makeText(this, "Error al leer fichero desde recurso raw", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.content, menu);

        //View icon Favorite
        if (isFileFavorite() && isFavorite(idFavortite)){
            menu.findItem(R.id.action_favorite).setIcon(R.drawable.ic_action_fav_on);
            flagFavorite = true;
        }else {
            menu.findItem(R.id.action_favorite).setIcon(R.drawable.ic_action_fav);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_favorite) {
            if (!flagFavorite){
                addFavorite(idFavortite);
                recreate();
            }else {
                deleteLineFile(idFavortite);
                flagFavorite = false;
                recreate();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (isFavorite){
            Intent intent = new Intent(this, Main.class);
            startActivity(intent);
            finish();
        }else{
            super.onBackPressed();
        }
    }

    public boolean isFileFavorite() {
        boolean result;

        InputStreamReader flujo = null;
        try {
            flujo = new InputStreamReader(openFileInput("favorite.txt"));
            result = true;
        } catch (Exception ex) {
            result = false;
        }

        return result;
    }

    public void addFavorite (int id) {
        OutputStreamWriter escritor = null;
        try {
            escritor = new OutputStreamWriter(openFileOutput("favorite.txt", Context.MODE_APPEND));
            escritor.write(String.valueOf(id));
            escritor.write("\n");
        } catch (Exception ex) {
            Toast.makeText(this, "ErrorWrite: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (escritor != null)
                    escritor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Integer> readFavorite() {
        ArrayList<Integer> list = new ArrayList<>();

        InputStreamReader flujo = null;
        BufferedReader lector = null;
        try {
            flujo = new InputStreamReader(openFileInput("favorite.txt"));
            lector = new BufferedReader(flujo);
            String texto = lector.readLine();
            while (texto != null) {
                list.add(Integer.valueOf(texto));
                texto = lector.readLine();
            }
        } catch (Exception ex) {
            Toast.makeText(this, "ErrorRead: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (flujo != null)
                    flujo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public boolean isFavorite(int rec) {
        boolean result = false;

        InputStreamReader flujo = null;
        BufferedReader lector = null;
        try {
            flujo = new InputStreamReader(openFileInput("favorite.txt"));
            lector = new BufferedReader(flujo);
            String texto = lector.readLine();
            while (texto != null) {
                if (rec == Integer.valueOf(texto)){
                    result = true;
                    break;
                }
                texto = lector.readLine();
            }
        } catch (Exception ex) {
            Toast.makeText(this, "ErrorRead: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (flujo != null)
                    flujo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void deleteLineFile (int id){
        int pos = -1;
        ArrayList<Integer> list = readFavorite();
        pos = list.indexOf(id);
        list.remove(pos);

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

        for (int i = 0; i < list.size(); i++) {
            addFavorite(list.get(i));
        }
    }

}
