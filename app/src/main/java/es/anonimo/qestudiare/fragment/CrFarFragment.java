package es.anonimo.qestudiare.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
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

public class CrFarFragment extends Fragment {
    TextView textView;
    CardView cvLicScienMilInterarmas, cvLicScienMilNac, cvLicScienNav, cvLicScienMilNaut, cvLicDerContra, cvLicDer, cvEnginMil,
            cvEnginMachInterarmas, cvEnginMachInstituto, cvEnginMachNaval, cvEnginMachNavalMaq, cvEnginMachMarinero,
            cvEnginMachNavalConstruccion, cvEnginRadioInstituto, cvEnginRadioNaval, cvEnginRadioNavalServ,
            cvEnginInformaticInstituto, cvEnginHidroGeo, cvLicScienSocial;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cr_far, container, false);

        textView = (TextView) view.findViewById(R.id.tvTextDescCrFar);
        String text = "";
        try
        {
            InputStream fraw = getResources().openRawResource(R.raw.dc_ensenanza_militar_fuerzas_armadas_revolucionarias);
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

        cvLicScienMilInterarmas = (CardView) view.findViewById(R.id.cvLicScienMilInterarmas);
        cvLicScienMilInterarmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_licenciatura_ciencias_militares_1);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvLicScienMilNac = (CardView) view.findViewById(R.id.cvLicScienMilNac);
        cvLicScienMilNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_licenciatura_ciencias_militares_2);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvLicScienNav = (CardView) view.findViewById(R.id.cvLicScienNav);
        cvLicScienNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_licenciatura_ciencias_navales);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvLicScienMilNaut = (CardView) view.findViewById(R.id.cvLicScienMilNaut);
        cvLicScienMilNaut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_licenciatura_ciencias_nauticas);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvLicDerContra = (CardView) view.findViewById(R.id.cvLicDerContra);
        cvLicDerContra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_licenciatura_derecho_1);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvLicDer = (CardView) view.findViewById(R.id.cvLicDer);
        cvLicDer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_licenciatura_derecho_2);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginMil = (CardView) view.findViewById(R.id.cvEnginMil);
        cvEnginMil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_militar);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginMachInterarmas = (CardView) view.findViewById(R.id.cvEnginMachInterarmas);
        cvEnginMachInterarmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_mecanica_1);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginMachInstituto = (CardView) view.findViewById(R.id.cvEnginMachInstituto);
        cvEnginMachInstituto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_mecanica_2);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginMachNaval = (CardView) view.findViewById(R.id.cvEnginMachNaval);
        cvEnginMachNaval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_mecanica_3);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginMachNavalMaq = (CardView) view.findViewById(R.id.cvEnginMachNavalMaq);
        cvEnginMachNavalMaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_mecanica_4);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginMachMarinero = (CardView) view.findViewById(R.id.cvEnginMachMarinero);
        cvEnginMachMarinero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_mecanica_5);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginMachNavalConstruccion = (CardView) view.findViewById(R.id.cvEnginMachNavalConstruccion);
        cvEnginMachNavalConstruccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_mecanica_6);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginRadioInstituto = (CardView) view.findViewById(R.id.cvEnginRadioInstituto);
        cvEnginRadioInstituto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_radioelectronica_1);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginRadioNaval = (CardView) view.findViewById(R.id.cvEnginRadioNaval);
        cvEnginRadioNaval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_radioelectronica_2);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginRadioNavalServ = (CardView) view.findViewById(R.id.cvEnginRadioNavalServ);
        cvEnginRadioNavalServ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_radioelectronica_3);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginInformaticInstituto = (CardView) view.findViewById(R.id.cvEnginInformaticInstituto);
        cvEnginInformaticInstituto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_mf_ingenieria_informatica);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvEnginHidroGeo = (CardView) view.findViewById(R.id.cvEnginHidroGeo);
        cvEnginHidroGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_ingenieria_hidrografia_geodesia);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvLicScienSocial = (CardView) view.findViewById(R.id.cvLicScienSocial);
        cvLicScienSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_licenciatura_ciencias_sociales);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        boolean themeDark = prefs.getBoolean("dark_theme", false);
        if (themeDark){
            cvLicScienMilInterarmas.setCardBackgroundColor(Color.parseColor("#363636"));
            cvLicScienMilNac.setCardBackgroundColor(Color.parseColor("#363636"));
            cvLicScienNav.setCardBackgroundColor(Color.parseColor("#363636"));
            cvLicScienMilNaut.setCardBackgroundColor(Color.parseColor("#363636"));
            cvLicDerContra.setCardBackgroundColor(Color.parseColor("#363636"));
            cvLicDer.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginMil.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginMachInterarmas.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginMachInstituto.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginMachNaval.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginMachNavalMaq.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginMachMarinero.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginMachNavalConstruccion.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginRadioInstituto.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginRadioNaval.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginRadioNavalServ.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginInformaticInstituto.setCardBackgroundColor(Color.parseColor("#363636"));
            cvEnginHidroGeo.setCardBackgroundColor(Color.parseColor("#363636"));
            cvLicScienSocial.setCardBackgroundColor(Color.parseColor("#363636"));
        }

        return view;
    }
}
