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

public class CrTecnologiaCienciasAplicadasFragment extends Fragment {
    TextView textView;
    CardView cvPhysicsNuclear, cvRadioquimic, cvEnginTechNucEnerg, cvMeteorology;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cr_tecnologia_ciencias_aplicadas, container, false);

        textView = (TextView) view.findViewById(R.id.tvTextDescCrCiencAplic);
        String text = "";
        try
        {
            InputStream fraw = getResources().openRawResource(R.raw.dc_carreras_tecnologia_ciencias_aplicadas);
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

        cvPhysicsNuclear = (CardView) view.findViewById(R.id.cvPhysicsNuclear);
        cvPhysicsNuclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_fisica_nuclear);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvRadioquimic = (CardView) view.findViewById(R.id.cvRadioquimic);
        cvRadioquimic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_radioquimica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginTechNucEnerg = (CardView) view.findViewById(R.id.cvEnginTechNucEnerg);
        cvEnginTechNucEnerg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_tecnologias_nucleares_energeticas);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvMeteorology = (CardView) view.findViewById(R.id.cvMeteorology);
        cvMeteorology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_meteorologia);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        boolean themeDark = prefs.getBoolean("dark_theme", false);
        if (themeDark){
            cvPhysicsNuclear.setCardBackgroundColor(Color.parseColor("#363636"));
            cvRadioquimic.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginTechNucEnerg.setCardBackgroundColor(Color.parseColor("#363636"));
            cvMeteorology.setCardBackgroundColor(Color.parseColor("#363636"));
        }

        return view;
    }
}
