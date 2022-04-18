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
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import es.anonimo.qestudiare.Content;
import es.anonimo.qestudiare.R;

public class CrCienciasNaturalesMatematicasFragment extends Fragment {
    TextView textView;
    CardView cvMath, cvScienceComp, cvPhysics, cvGeography, cvQuimica, cvBiology, cvBiochemistry, cvMicrobiology,
            cvScienceFarmer, cvScienceAliment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cr_ciencias_naturales_matematicas, container, false);

        textView = (TextView) view.findViewById(R.id.tvTextDescCrCiencNaturMat);
        String text = "";
        try
        {
            InputStream fraw = getResources().openRawResource(R.raw.dc_carreras_ciencias_naturales_matematica);
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

        cvMath = (CardView) view.findViewById(R.id.cvMath);
        cvMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_matematica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvScienceComp = (CardView) view.findViewById(R.id.cvScienceComp);
        cvScienceComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ciencia_computacion);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvPhysics = (CardView) view.findViewById(R.id.cvPhysics);
        cvPhysics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_fisica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvGeography = (CardView) view.findViewById(R.id.cvGeography);
        cvGeography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_geografia);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvQuimica = (CardView) view.findViewById(R.id.cvQuimica);
        cvQuimica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_quimica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvBiology = (CardView) view.findViewById(R.id.cvBiology);
        cvBiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_biologia);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvBiochemistry = (CardView) view.findViewById(R.id.cvBiochemistry);
        cvBiochemistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_bioquimica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvScienceFarmer = (CardView) view.findViewById(R.id.cvScienceFarmer);
        cvScienceFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ciencias_farmaceuticas);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvScienceAliment = (CardView) view.findViewById(R.id.cvScienceAliment);
        cvScienceAliment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ciencias_alimentarias);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvMicrobiology = (CardView) view.findViewById(R.id.cvMicrobiology);
        cvMicrobiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_microbiologia);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        boolean themeDark = prefs.getBoolean("dark_theme", false);
        if (themeDark){
            cvMath.setCardBackgroundColor(Color.parseColor("#363636"));
            cvScienceComp.setCardBackgroundColor(Color.parseColor("#363636"));
            cvPhysics.setCardBackgroundColor(Color.parseColor("#363636"));
            cvGeography.setCardBackgroundColor(Color.parseColor("#363636"));
            cvQuimica.setCardBackgroundColor(Color.parseColor("#363636"));
            cvBiology.setCardBackgroundColor(Color.parseColor("#363636"));
            cvBiochemistry.setCardBackgroundColor(Color.parseColor("#363636"));
            cvScienceFarmer.setCardBackgroundColor(Color.parseColor("#363636"));
            cvScienceAliment.setCardBackgroundColor(Color.parseColor("#363636"));
            cvMicrobiology.setCardBackgroundColor(Color.parseColor("#363636"));
        }

        return view;
    }
}
