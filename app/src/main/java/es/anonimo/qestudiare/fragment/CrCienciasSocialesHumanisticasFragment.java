package es.anonimo.qestudiare.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
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

public class CrCienciasSocialesHumanisticasFragment extends Fragment {
    TextView textView;
    CardView cvBibInform, cvComunicationSocial, cvJournalism, cvHumPhychology, cvRight, cvPhilosophy,
            cvHistory, cvSociology, cvLangEnglish, cvlangGerman, cvLangRus, cvLangFrench, cvHistoryArt,
            cvLettering, cvStudySocialCult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cr_ciencias_sociales_humanisticas, container, false);

        textView = (TextView) view.findViewById(R.id.tvTextDescCrCiencSocHum);
        String text = "";
        try
        {
            InputStream fraw = getResources().openRawResource(R.raw.dc_carreras_ciencias_sociales_humanisticas);
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

        cvBibInform = (CardView) view.findViewById(R.id.cvBibInform);
        cvBibInform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_bibliotecologia_ciencia_informacion);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvComunicationSocial = (CardView) view.findViewById(R.id.cvComunicationSocial);
        cvComunicationSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_comunicacion_social);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvJournalism = (CardView) view.findViewById(R.id.cvJournalism);
        cvJournalism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_periodismo);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvHumPhychology = (CardView) view.findViewById(R.id.cvHumPhychology);
        cvHumPhychology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_cs_psicologia);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvRight = (CardView) view.findViewById(R.id.cvRight);
        cvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_derecho);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvPhilosophy = (CardView) view.findViewById(R.id.cvPhilosophy);
        cvPhilosophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_filosofia_marxista_leninista);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvHistory = (CardView) view.findViewById(R.id.cvHistory);
        cvHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_historia);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvSociology = (CardView) view.findViewById(R.id.cvSociology);
        cvSociology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_sociologia);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvLangEnglish = (CardView) view.findViewById(R.id.cvLangEnglish);
        cvLangEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_lengua_inglesa);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvBibInform = (CardView) view.findViewById(R.id.cvBibInform);
        cvBibInform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_bibliotecologia_ciencia_informacion);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvlangGerman = (CardView) view.findViewById(R.id.cvlangGerman);
        cvlangGerman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_lengua_alemana);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvLangRus = (CardView) view.findViewById(R.id.cvLangRus);
        cvLangRus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_lengua_rusa);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvLangFrench = (CardView) view.findViewById(R.id.cvLangFrench);
        cvLangFrench.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_lengua_francesa);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvHistoryArt = (CardView) view.findViewById(R.id.cvHistoryArt);
        cvHistoryArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_historia_arte);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvLettering = (CardView) view.findViewById(R.id.cvLettering);
        cvLettering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_letras);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvStudySocialCult = (CardView) view.findViewById(R.id.cvStudySocialCult);
        cvStudySocialCult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_estudios_socioculturales);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        boolean themeDark = prefs.getBoolean("dark_theme", false);
        if (themeDark){
            cvBibInform.setCardBackgroundColor(Color.parseColor("#363636"));
            cvComunicationSocial.setCardBackgroundColor(Color.parseColor("#363636"));
            cvJournalism.setCardBackgroundColor(Color.parseColor("#363636"));
            cvHumPhychology.setCardBackgroundColor(Color.parseColor("#363636"));
            cvRight.setCardBackgroundColor(Color.parseColor("#363636"));
            cvPhilosophy.setCardBackgroundColor(Color.parseColor("#363636"));
            cvHistory.setCardBackgroundColor(Color.parseColor("#363636"));
            cvSociology.setCardBackgroundColor(Color.parseColor("#363636"));
            cvLangEnglish.setCardBackgroundColor(Color.parseColor("#363636"));
            cvBibInform.setCardBackgroundColor(Color.parseColor("#363636"));
            cvlangGerman.setCardBackgroundColor(Color.parseColor("#363636"));
            cvLangRus.setCardBackgroundColor(Color.parseColor("#363636"));
            cvLangFrench.setCardBackgroundColor(Color.parseColor("#363636"));
            cvHistoryArt.setCardBackgroundColor(Color.parseColor("#363636"));
            cvLettering.setCardBackgroundColor(Color.parseColor("#363636"));
            cvStudySocialCult.setCardBackgroundColor(Color.parseColor("#363636"));

        }

        return view;
    }

}
