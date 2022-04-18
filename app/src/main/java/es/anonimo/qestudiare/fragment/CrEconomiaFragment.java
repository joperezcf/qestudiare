package es.anonimo.qestudiare.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
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

public class CrEconomiaFragment extends Fragment {
    TextView textView;
    CardView cvContFinanz, cvEconomy, cvTourism;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cr_economia, container, false);

        textView = (TextView) view.findViewById(R.id.tvTextDescCrEconom);
        String text = "";
        try
        {
            InputStream fraw = getResources().openRawResource(R.raw.dc_carreras_economia);
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
        boolean themeDark = prefs.getBoolean("dark_theme", false);
        textView.setTextSize(textSize);

        cvContFinanz = (CardView) view.findViewById(R.id.cvContFinanz);
        cvContFinanz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_contabilidad_finanzas);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEconomy = (CardView) view.findViewById(R.id.cvEconomy);
        cvEconomy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_economia);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvTourism = (CardView) view.findViewById(R.id.cvTourism);
        cvTourism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_turismo);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        if (themeDark){
            cvContFinanz.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEconomy.setCardBackgroundColor(Color.parseColor("#363636"));
            cvTourism.setCardBackgroundColor(Color.parseColor("#363636"));
        }

        return view;
    }
}
