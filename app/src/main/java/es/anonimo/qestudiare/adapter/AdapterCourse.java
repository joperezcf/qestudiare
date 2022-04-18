package es.anonimo.qestudiare.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import es.anonimo.qestudiare.R;
import es.anonimo.qestudiare.data.Course;

/**
 * Created by JOPVcc on 14/07/2018.
 */

public class AdapterCourse extends ArrayAdapter<Course> {

    public AdapterCourse(Context context, List<Course> objects) {
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

        Course course = getItem(position);

        tvTittle.setText(course.getNameCourse());

        return convertView;
    }

}