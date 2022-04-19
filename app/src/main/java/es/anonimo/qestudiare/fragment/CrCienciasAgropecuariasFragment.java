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

public class CrCienciasAgropecuariasFragment extends Fragment {
    TextView textView;
    CardView cvMedicVeterinary, cvForest, cvAgronomy, cvMechanicalAgriculture;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cr_ciencias_agropecuarias, container, false);

        textView = (TextView) view.findViewById(R.id.tvTextDescCrCiencAgrop);
        String text = "";
        try
        {
            InputStream fraw = getResources().openRawResource(R.raw.dc_carreras_ciencias_agropecuarias);
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

        cvMedicVeterinary = (CardView) view.findViewById(R.id.cvMedicVeterinary);
        cvMedicVeterinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_medicina_veterinaria_zootecnia);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvAgronomy = (CardView) view.findViewById(R.id.cvAgronomy);
        cvAgronomy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_agronomia);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvForest = (CardView) view.findViewById(R.id.cvForest);
        cvForest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_forestal);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        cvMechanicalAgriculture = (CardView) view.findViewById(R.id.cvMechanicalAgriculture);
        cvMechanicalAgriculture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putString("data", "career");
                b.putInt("value", R.raw.cr_mecanizacion_agropecuaria);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        boolean themeDark = prefs.getBoolean("dark_theme", false);
        if (themeDark){
            cvMedicVeterinary.setCardBackgroundColor(Color.parseColor("#363636"));
            cvAgronomy.setCardBackgroundColor(Color.parseColor("#363636"));
            cvForest.setCardBackgroundColor(Color.parseColor("#363636"));
            cvMechanicalAgriculture.setCardBackgroundColor(Color.parseColor("#363636"));
        }

        return view;
    }
}
