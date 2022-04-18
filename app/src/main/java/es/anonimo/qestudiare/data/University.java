package es.anonimo.qestudiare.data;

import java.util.ArrayList;

import es.anonimo.qestudiare.R;

/**
 * Created by JOPVcc on 14/07/2018.
 */

public class University {
    private String nameUniversity;
    private int rec;

    public ArrayList<Integer> getRec() {
        ArrayList<Integer> result = new ArrayList<>();

        result.add(0, R.raw.univ_art);
        result.add(1, R.raw.univ_cujae);
        result.add(2, R.raw.univ_ij);
        result.add(3, R.raw.univ_ismmm);
        result.add(4, R.raw.univ_uc);
        result.add(5, R.raw.univ_ucf);
        result.add(6, R.raw.univ_uci);
        result.add(7, R.raw.univ_uclv);
        result.add(8, R.raw.univ_udg);
        result.add(9, R.raw.univ_ug);
        result.add(10, R.raw.univ_uh);
        result.add(11, R.raw.univ_uho);
        result.add(12, R.raw.univ_um);
        result.add(13, R.raw.univ_unah);
        result.add(14, R.raw.univ_unica);
        result.add(15, R.raw.univ_uo);

        return result;
    }

    public University(String nameUniversity) {
        this.nameUniversity = nameUniversity;
    }

    public String getNameUniversity() {
        return nameUniversity;
    }
}
