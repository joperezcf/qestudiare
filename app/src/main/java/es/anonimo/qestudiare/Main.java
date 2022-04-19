package es.anonimo.qestudiare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import es.anonimo.qestudiare.fragment.CrArteFragment;
import es.anonimo.qestudiare.fragment.CrCienciasAgropecuariasFragment;
import es.anonimo.qestudiare.fragment.CrCienciasMedicasFragment;
import es.anonimo.qestudiare.fragment.CrCienciasNaturalesMatematicasFragment;
import es.anonimo.qestudiare.fragment.CrCienciasSocialesHumanisticasFragment;
import es.anonimo.qestudiare.fragment.CrCienciasTecnicasFragment;
import es.anonimo.qestudiare.fragment.CrCulturaFisicaFragment;
import es.anonimo.qestudiare.fragment.CrDisenoFragment;
import es.anonimo.qestudiare.fragment.CrEconomiaFragment;
import es.anonimo.qestudiare.fragment.CrFarFragment;
import es.anonimo.qestudiare.fragment.CrMinintFragment;
import es.anonimo.qestudiare.fragment.CrPedagogicasFragment;
import es.anonimo.qestudiare.fragment.CrTecnologiaCienciasAplicadasFragment;
import es.anonimo.qestudiare.fragment.FavoriteFragment;
import es.anonimo.qestudiare.fragment.HomeFragment;
import es.anonimo.qestudiare.fragment.UniversityFragment;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final int INTERVALO = 2000; //2 segundos para salir
    private long tiempoPrimerClick;

    public Fragment fragment = null;
    public FragmentTransaction ft = null;
    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("PreferencesApp", Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = prefs.edit();
        //editor.putBoolean("install", true);
        //editor.putBoolean("dark_theme", false);
        //editor.commit();
        boolean themeDark = prefs.getBoolean("dark_theme", false);
        if (themeDark){
            setTheme(R.style.ThemeOverlay_AppCompat_Dark_ActionBar);
        }

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragment = new HomeFragment();
        if(fragment != null){
            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flContentMain, fragment);
            ft.commit();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {

                }
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
            if (tiempoPrimerClick + INTERVALO > System.currentTimeMillis()) {
                super.onBackPressed();
                return;
            } else {
                Toast.makeText(this, "Pulse otra vez para salir...", Toast.LENGTH_SHORT).show();
            }
            tiempoPrimerClick = System.currentTimeMillis();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent = null;

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_paghome) {
            fragment = new HomeFragment();
        }
        if (id == R.id.action_university) {
            fragment = new UniversityFragment();
        }
        if (id == R.id.action_favorite_main) {
            fragment = new FavoriteFragment();
        }
        if (id == R.id.action_settings) {
            intent = new Intent(this, Setting.class);
        }
        if (id == R.id.action_about) {
            intent = new Intent(this, About.class);
        }

        if (intent != null){
            startActivity(intent);
        }else {
            if(fragment != null){
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flContentMain, fragment);
                ft.commit();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_carreras_ciencias_medicas) {
            fragment = new CrCienciasMedicasFragment();
        } else if (id == R.id.nav_carreras_arte) {
            fragment = new CrArteFragment();
        }else if (id == R.id.nav_carreras_ciencias_agropecuarias) {
            fragment = new CrCienciasAgropecuariasFragment();
        }else if (id == R.id.nav_carreras_ciencias_naturales_matematica) {
            fragment = new CrCienciasNaturalesMatematicasFragment();
        }else if (id == R.id.nav_carreras_ciencias_sociales_humanisticas) {
            fragment = new CrCienciasSocialesHumanisticasFragment();
        }else if (id == R.id.nav_carreras_ciencias_tecnicas) {
            fragment = new CrCienciasTecnicasFragment();
        }else if (id == R.id.nav_carreras_cultura_fisica) {
            fragment = new CrCulturaFisicaFragment();
        }else if (id == R.id.nav_carreras_diseno) {
            fragment = new CrDisenoFragment();
        }else if (id == R.id.nav_carreras_economia) {
            fragment = new CrEconomiaFragment();
        }else if (id == R.id.nav_carreras_pedagogicas) {
            fragment = new CrPedagogicasFragment();
        }else if (id == R.id.nav_carreras_tecnologia_ciencias_aplicadas) {
            fragment = new CrTecnologiaCienciasAplicadasFragment();
        }else if (id == R.id.nav_ensenanza_militar_fuerzas_armadas_revolucionarias) {
            fragment = new CrFarFragment();
        }else if (id == R.id.nav_ensenanza_militar_ministerio_interior) {
            fragment = new CrMinintFragment();
        }

        if(fragment != null){
            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flContentMain, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
