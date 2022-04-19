package es.anonimo.qestudiare.adapter;

import android.content.Context;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import es.anonimo.qestudiare.R;
import es.anonimo.qestudiare.data.Favorite;

/**
 * Created by JOPVcc on 14/07/2018.
 */

public class AdapterFavorite extends ArrayAdapter<Favorite> {

    public AdapterFavorite(Context context, List<Favorite> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.item_course,
                    parent,
                    false);
        }

        TextView tvTittle = (TextView) convertView.findViewById(R.id.tvTittle);

        Favorite favorite = getItem(position);

        tvTittle.setText(favorite.getNameFavorite());

        return convertView;
    }

}
