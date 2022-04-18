package es.anonimo.qestudiare.fragment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import es.anonimo.qestudiare.Content;
import es.anonimo.qestudiare.R;
import es.anonimo.qestudiare.adapter.AdapterFavorite;
import es.anonimo.qestudiare.adapter.AdapterUniversity;
import es.anonimo.qestudiare.data.Favorite;
import es.anonimo.qestudiare.data.University;

public class UniversityFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_university, container, false);

        ArrayList<University> universities = new ArrayList<>();
        universities.add(new University("Universidad de Artemisa"));//pos:0
        universities.add(new University("Universidad Tecnológica de La Habana José Antonio Echeverría"));
        universities.add(new University("Universidad de la Isla de la Juventud"));
        universities.add(new University("Instituto Superior Minero Metalúrgico de Moa"));
        universities.add(new University("Universidad de Camagüey"));
        universities.add(new University("Universidad de Cienfuegos"));
        universities.add(new University("Universidad de las Ciencias Informáticas"));
        universities.add(new University("Universidad Central de Las Villas"));
        universities.add(new University("Universidad de Granma"));
        universities.add(new University("Universidad de Guantánamo"));
        universities.add(new University("Universidad de La Habana"));
        universities.add(new University("Universidad de Holguín"));
        universities.add(new University("Universidad de Matanzas"));
        universities.add(new University("Universidad Agraria de La Habana"));
        universities.add(new University("Universidad de Ciego de Ávila"));
        universities.add(new University("Universidad de Oriente"));

        ListView listView = (ListView) view.findViewById(R.id.lvUniversity);

        AdapterUniversity listUniversity = new AdapterUniversity(getContext(), universities);

        listView.setAdapter(listUniversity);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                University university = (University) parent.getItemAtPosition(position);

                /*
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();

                b.putIntArray("imgs", travel.getImgsTravel(position));
                b.putString("name", travel.getNameTravel());
                b.putInt("text", travel.getTextTravel(position));

                intent.putExtras(b);
                startActivity(intent);
                */

                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();
                b.putInt("value", university.getRec().get(position));
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        return view;
    }
}
