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

public class CrPedagogicasFragment extends Fragment {
    TextView textView;
    CardView cvEducPreescolar, cvEducPrimaria, cvEducEspecial, cvProfGenInteg, cvScienceReq, cvScienNat,
            cvHuman, cvLangExtrang, cvConstruc, cvMachine, cvAgriculture, cvMechanization, cvElectric,
            cvInformatic, cvEconomy, cvPedPsic, cvInstrArt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cr_pedagogicas, container, false);

        textView = (TextView) view.findViewById(R.id.tvTextDescCrPedag);
        String text = "";
        try
        {
            InputStream fraw = getResources().openRawResource(R.raw.dc_carreras_pedagogicas);
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

        cvInstrArt = (CardView) view.findViewById(R.id.cvInstrArt);
        cvInstrArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_instructor_arte);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvPedPsic = (CardView) view.findViewById(R.id.cvPedPsic);
        cvPedPsic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_pedagogia_psicologia);
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
                b.putInt("value", R.raw.cr_cp_economia);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvInformatic = (CardView) view.findViewById(R.id.cvInformatic);
        cvInformatic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_cp_informatica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvElectric = (CardView) view.findViewById(R.id.cvElectric);
        cvElectric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_electrica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvMechanization = (CardView) view.findViewById(R.id.cvMechanization);
        cvMechanization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_mecanizacion);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvAgriculture = (CardView) view.findViewById(R.id.cvAgriculture);
        cvAgriculture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_agropecuaria);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvMachine = (CardView) view.findViewById(R.id.cvMachine);
        cvMachine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_mecanica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvConstruc = (CardView) view.findViewById(R.id.cvConstruc);
        cvConstruc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_construccion);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvLangExtrang = (CardView) view.findViewById(R.id.cvLangExtrang);
        cvLangExtrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_lenguas_extranjeras);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvHuman = (CardView) view.findViewById(R.id.cvHuman);
        cvHuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_humanidades);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvScienNat = (CardView) view.findViewById(R.id.cvScienNat);
        cvScienNat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ciencias_naturales);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvScienceReq = (CardView) view.findViewById(R.id.cvScienceReq);
        cvScienceReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.rc_ciencias_exactas);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvProfGenInteg = (CardView) view.findViewById(R.id.cvProfGenInteg);
        cvProfGenInteg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_profesor_general_integral);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEducEspecial = (CardView) view.findViewById(R.id.cvEducEspecial);
        cvEducEspecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_educacion_especial);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEducPrimaria = (CardView) view.findViewById(R.id.cvEducPrimaria);
        cvEducPrimaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_educacion_primaria);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEducPreescolar = (CardView) view.findViewById(R.id.cvEducPreescolar);
        cvEducPreescolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_educacion_preescolar);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        boolean themeDark = prefs.getBoolean("dark_theme", false);
        if (themeDark){
            cvInstrArt.setCardBackgroundColor(Color.parseColor("#363636"));
            cvPedPsic.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEconomy.setCardBackgroundColor(Color.parseColor("#363636"));
            cvInformatic.setCardBackgroundColor(Color.parseColor("#363636"));
            cvElectric.setCardBackgroundColor(Color.parseColor("#363636"));
            cvMechanization.setCardBackgroundColor(Color.parseColor("#363636"));
            cvAgriculture.setCardBackgroundColor(Color.parseColor("#363636"));
            cvMachine.setCardBackgroundColor(Color.parseColor("#363636"));
            cvConstruc.setCardBackgroundColor(Color.parseColor("#363636"));
            cvLangExtrang.setCardBackgroundColor(Color.parseColor("#363636"));
            cvHuman.setCardBackgroundColor(Color.parseColor("#363636"));
            cvScienNat.setCardBackgroundColor(Color.parseColor("#363636"));
            cvScienceReq.setCardBackgroundColor(Color.parseColor("#363636"));
            cvProfGenInteg.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEducEspecial.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEducPrimaria.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEducPreescolar.setCardBackgroundColor(Color.parseColor("#363636"));
        }

        return view;
    }
}
