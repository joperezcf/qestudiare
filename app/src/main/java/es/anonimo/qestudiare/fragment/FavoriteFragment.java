package es.anonimo.qestudiare.fragment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import es.anonimo.qestudiare.Content;
import es.anonimo.qestudiare.R;
import es.anonimo.qestudiare.adapter.AdapterFavorite;
import es.anonimo.qestudiare.data.Favorite;

public class FavoriteFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        ListView listView = (ListView) view.findViewById(R.id.lvFavorite);

        if (!isFileFavorite()) {
            TextView tvNotFavorites = (TextView) view.findViewById(R.id.tvNotFavorites);
            listView.setVisibility(View.INVISIBLE);
            tvNotFavorites.setVisibility(View.VISIBLE);
        } else {
            final ArrayList<Integer> list = readFavorite();

            ArrayList<Favorite> favorites = new ArrayList<>();
        /*
        favorites.add(new Favorite("Favorite 1"));//pos:0
        favorites.add(new Favorite("Favorite 2"));
        favorites.add(new Favorite("Favorite 3"));
        favorites.add(new Favorite("Favorite 4"));
        favorites.add(new Favorite("Favorite 5"));
        */

            for (int i = 0; i < list.size(); i++) {
                favorites.add(new Favorite(viewNameFavorite(list.get(i))));
            }

            AdapterFavorite listFavorite = new AdapterFavorite(getContext(), favorites);

            listView.setAdapter(listFavorite);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Favorite favorite = (Favorite) parent.getItemAtPosition(position);

                    Intent intent = new Intent(getActivity(), Content.class);
                    Bundle b = new Bundle();
                    b.putBoolean("isFavorite", true);
                    b.putInt("value", list.get(position));
                    intent.putExtras(b);
                    startActivity(intent);

                    getActivity().finish();
                /*
                Intent intent = new Intent(getActivity(), Content.class);
                Bundle b = new Bundle();

                b.putIntArray("imgs", travel.getImgsTravel(position));
                b.putString("name", travel.getNameTravel());
                b.putInt("text", travel.getTextTravel(position));

                intent.putExtras(b);
                startActivity(intent);
                */
                }
            });

        }
        return view;
    }

    public ArrayList<Integer> readFavorite() {
        ArrayList<Integer> list = new ArrayList<>();
        InputStreamReader flujo = null;
        BufferedReader lector = null;
        try {
            flujo = new InputStreamReader(getActivity().openFileInput("favorite.txt"));
            lector = new BufferedReader(flujo);
            String texto = lector.readLine();
            while (texto != null) {
                list.add(Integer.valueOf(texto));
                texto = lector.readLine();
            }
        } catch (Exception ex) {
            Toast.makeText(getActivity(), "ErrorRead: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (flujo != null)
                    flujo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public String viewNameFavorite(int rec){
        String result="";
        try
        {
            InputStream fraw = getResources().openRawResource(rec);
            BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));
            result = brin.readLine();
            fraw.close();
        }
        catch (Exception ex)
        {
            Toast.makeText(getActivity(), "Error al leer fichero desde recurso raw", Toast.LENGTH_SHORT).show();
        }
        return result;
    }

    public boolean isFileFavorite() {
        boolean result;

        InputStreamReader flujo = null;
        try {
            flujo = new InputStreamReader(getActivity().openFileInput("favorite.txt"));
            result = true;
        } catch (Exception ex) {
            result = false;
        }

        return result;
    }
}
