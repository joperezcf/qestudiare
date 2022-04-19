package es.anonimo.qestudiare.fragment;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import es.anonimo.qestudiare.R;

public class LegalFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_legal, container, false);

        TextView textView = (TextView) view.findViewById(R.id.tvTextContentPagLegal);
        String text = "";
        try
        {
            InputStream fraw = getResources().openRawResource(R.raw.pag_legal);
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
        return view;
    }

}
