package es.anonimo.qestudiare.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import es.anonimo.qestudiare.Content;
import es.anonimo.qestudiare.R;

public class CrArteFragment extends Fragment {
    TextView textView;
    CardView cvArtPlastic, cvArtDance, cvArtDramatic, cvComunAudiov, cvMusic;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cr_arte, container, false);

        textView = (TextView) view.findViewById(R.id.tvTextDescCrArte);
        String text = "";
        try
        {
            InputStream fraw = getResources().openRawResource(R.raw.dc_carreras_arte);
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
            Toast.makeText(getActivity(), "Error al leer fichero desde recurso raw", Toast.LENGTH_SHORT).show();
        }

        SharedPreferences prefs = getActivity().getSharedPreferences("PreferencesApp", Context.MODE_PRIVATE);
        int textSize = prefs.getInt("textSize", -1);
        textView.setTextSize(textSize);

        cvArtPlastic = (CardView) view.findViewById(R.id.cvArtPlastic);
        cvArtPlastic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_artes_plasticas);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvArtDance = (CardView) view.findViewById(R.id.cvArtDance);
        cvArtDance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_arte_danzario);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvArtDramatic = (CardView) view.findViewById(R.id.cvArtDramatic);
        cvArtDramatic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_arte_teatral);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvComunAudiov = (CardView) view.findViewById(R.id.cvComunAudiov);
        cvComunAudiov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_comunicacion_audiovisual);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvMusic = (CardView) view.findViewById(R.id.cvMusic);
        cvMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_musica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        boolean themeDark = prefs.getBoolean("dark_theme", false);
        if (themeDark){
            cvArtDramatic.setCardBackgroundColor(Color.parseColor("#363636"));
            cvArtDramatic.setCardBackgroundColor(Color.parseColor("#363636"));
            cvArtPlastic.setCardBackgroundColor(Color.parseColor("#363636"));
            cvComunAudiov.setCardBackgroundColor(Color.parseColor("#363636"));
            cvMusic.setCardBackgroundColor(Color.parseColor("#363636"));
        }

        return view;
    }
}
