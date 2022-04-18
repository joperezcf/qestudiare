package es.anonimo.qestudiare.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import es.anonimo.qestudiare.Content;
import es.anonimo.qestudiare.R;
import es.anonimo.qestudiare.adapter.AdapterCourse;
import es.anonimo.qestudiare.data.Course;

public class CrCienciasMedicasFragment extends Fragment {
    TextView textView;

    CardView cvMedic;
    CardView cvStomatology;
    CardView cvInfirmary;
    CardView cvTechnologyHealth;
    CardView cvPsychology;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cr_ciencias_medicas, container, false);

        textView = (TextView) view.findViewById(R.id.tvTextDescCrCiencMed);
        String text = "";
        try
        {
            InputStream fraw = getResources().openRawResource(R.raw.dc_carreras_ciencias_medicas);
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

        cvMedic = (CardView) view.findViewById(R.id.cvMedic);
        cvMedic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putInt("value", R.raw.cr_medicina);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvStomatology = (CardView) view.findViewById(R.id.cvStomatology);
        cvStomatology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putInt("value", R.raw.cr_estomatologia);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvInfirmary = (CardView) view.findViewById(R.id.cvInfirmary);
        cvInfirmary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putInt("value", R.raw.cr_enfermeria);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvTechnologyHealth = (CardView) view.findViewById(R.id.cvTechnologyHealth);
        cvTechnologyHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putInt("value", R.raw.cr_tecnologia_salud);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvPsychology = (CardView) view.findViewById(R.id.cvPsychology);
        cvPsychology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putInt("value", R.raw.cr_cm_psicologia);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        boolean themeDark = prefs.getBoolean("dark_theme", false);
        if (themeDark){
            cvMedic.setCardBackgroundColor(Color.parseColor("#363636"));
            cvStomatology.setCardBackgroundColor(Color.parseColor("#363636"));
            cvInfirmary.setCardBackgroundColor(Color.parseColor("#363636"));
            cvTechnologyHealth.setCardBackgroundColor(Color.parseColor("#363636"));
            cvPsychology.setCardBackgroundColor(Color.parseColor("#363636"));
        }

        return view;
    }

}
