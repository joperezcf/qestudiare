package es.anonimo.qestudiare.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import androidx.annotation.Nullable;
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

public class CrCienciasTecnicasFragment extends Fragment {
    TextView textView;
    CardView cvArchitecture, cvEnginCivil, cvEnginHydra, cvEnginTelecElect, cvEnginElect, cvEnginAutomatic,
            cvEnginBiomedic, cvEnginInformatic, cvEnginChemistry, cvEnginMechanic, cvEnginMetallurgic, cvEnginMine,
            cvEnginGeo, cvEnginIndust, cvEnginPhysics, cvEnginUci;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cr_ciencias_tecnicas, container, false);

        textView = (TextView) view.findViewById(R.id.tvTextDescCrCiencTec);
        String text = "";
        try
        {
            InputStream fraw = getResources().openRawResource(R.raw.dc_carreras_ciencias_tecnicas);
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

        cvArchitecture = (CardView) view.findViewById(R.id.cvArchitecture);
        cvArchitecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_arquitectura);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginCivil = (CardView) view.findViewById(R.id.cvEnginCivil);
        cvEnginCivil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_civil);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginHydra = (CardView) view.findViewById(R.id.cvEnginHydra);
        cvEnginHydra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_hidraulica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginTelecElect = (CardView) view.findViewById(R.id.cvEnginTelecElect);
        cvEnginTelecElect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_telecomunicaciones_electronica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginElect = (CardView) view.findViewById(R.id.cvEnginElect);
        cvEnginElect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_electrica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginAutomatic = (CardView) view.findViewById(R.id.cvEnginAutomatic);
        cvEnginAutomatic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_automatica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginBiomedic = (CardView) view.findViewById(R.id.cvEnginBiomedic);
        cvEnginBiomedic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_biomedica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginInformatic = (CardView) view.findViewById(R.id.cvEnginInformatic);
        cvEnginInformatic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.rc_ingenieria_informatica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginChemistry = (CardView) view.findViewById(R.id.cvEnginChemistry);
        cvEnginChemistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_quimica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginMechanic = (CardView) view.findViewById(R.id.cvEnginMechanic);
        cvEnginMechanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_mecanica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginMetallurgic = (CardView) view.findViewById(R.id.cvEnginMetallurgic);
        cvEnginMetallurgic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_metalurgica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginMine = (CardView) view.findViewById(R.id.cvEnginMine);
        cvEnginMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_minas);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginGeo = (CardView) view.findViewById(R.id.cvEnginGeo);
        cvEnginGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_geologica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginIndust = (CardView) view.findViewById(R.id.cvEnginIndust);
        cvEnginIndust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_industrial);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginPhysics = (CardView) view.findViewById(R.id.cvEnginPhysics);
        cvEnginPhysics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_fisica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginUci = (CardView) view.findViewById(R.id.cvEnginUci);
        cvEnginUci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_universidad_ciencias_informaticas);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        boolean themeDark = prefs.getBoolean("dark_theme", false);
        if (themeDark){
            cvArchitecture.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginCivil.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginHydra.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginTelecElect.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginElect.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginAutomatic.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginBiomedic.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginInformatic.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginChemistry.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginMechanic.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginMetallurgic.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginMine.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginGeo.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginIndust.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginPhysics.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginUci.setCardBackgroundColor(Color.parseColor("#363636"));
        }

        return view;
    }
}
