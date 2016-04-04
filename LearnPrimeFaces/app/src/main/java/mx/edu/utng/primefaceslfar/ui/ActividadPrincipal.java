package mx.edu.utng.primefaceslfar.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import mx.edu.utng.primefaceslfar.R;
import mx.edu.utng.primefaceslfar.ui.a_tema_i.FragmentoWebComponentesPrincipal;
import mx.edu.utng.primefaceslfar.ui.a_tema_ii.FragmentoInputPrincipal;
import mx.edu.utng.primefaceslfar.ui.acercade.FragmentoAcercaDe;
import mx.edu.utng.primefaceslfar.ui.ayuda.FragmentoAyuda;
import mx.edu.utng.primefaceslfar.ui.c_tema_iii.FragmentoButtonPrincipal;
import mx.edu.utng.primefaceslfar.ui.d_tema_iv.FragmentoDataPrincipal;
import mx.edu.utng.primefaceslfar.ui.f_tema_vi.FragmentoOverLay;
import mx.edu.utng.primefaceslfar.ui.g_tema_vii.FragmentoMenu;
import mx.edu.utng.primefaceslfar.ui.h_tema_viii.FragmentoMessages;
import mx.edu.utng.primefaceslfar.ui.i_tema_ix.FragmentoMultimedia;
import mx.edu.utng.primefaceslfar.ui.j_tema_x.FragmentoMisc;
import mx.edu.utng.primefaceslfar.ui.k_tema_xi.FragmentoSamples;
import mx.edu.utng.primefaceslfar.ui.l_tema_xii.FragmentoDoce;
import mx.edu.utng.primefaceslfar.ui.login.Login;


public class ActividadPrincipal extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);

        agregarToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (navigationView != null) {
            prepararDrawer(navigationView);
            // Seleccionar item por defecto
            seleccionarItem(navigationView.getMenu().getItem(0));
        }
    }

    private void agregarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner icono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.drawer_toggle);
            ab.setDisplayHomeAsUpEnabled(true);
        }

    }

    private void prepararDrawer(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        seleccionarItem(menuItem);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });

    }

    private void seleccionarItem(MenuItem itemDrawer) {
        Fragment fragmentoGenerico = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (itemDrawer.getItemId()) {
            case R.id.item_1:
                fragmentoGenerico = new FragmentoInicio();
                break;


            case R.id.item_2:
                fragmentoGenerico = new FragmentoWebComponentesPrincipal();
                break;
            case R.id.item_3:

                fragmentoGenerico = new FragmentoInputPrincipal();
                break;

            case R.id.item_4:
                fragmentoGenerico = new FragmentoButtonPrincipal();
                break;
            case R.id.item_5:
                fragmentoGenerico = new FragmentoDataPrincipal();
                break;
            case R.id.item_6:
                fragmentoGenerico = new FragmentoOverLay();
                break;
            case R.id.item_7:
                fragmentoGenerico = new FragmentoMenu();
                break;
            case R.id.item_8:
            fragmentoGenerico = new FragmentoMessages();
                break;
            case R.id.item_9:
                fragmentoGenerico = new FragmentoMultimedia();
                break;
            case R.id.item_10:
                fragmentoGenerico = new FragmentoMisc();
                break;

            case R.id.item_11:
                fragmentoGenerico = new FragmentoSamples();
                break;
            case R.id.item_12:
                fragmentoGenerico = new FragmentoDoce();
                break;
            case R.id.item_13:
                fragmentoGenerico = new FragmentoAyuda();
                break;
            case R.id.item_14:
                fragmentoGenerico = new FragmentoAcercaDe();
                break;
            case R.id.item_15:
                fragmentoGenerico = new FragmentoInicio();
                break;
            case R.id.item_16:
                fragmentoGenerico = new FragmentoInicio();
                break;
            case R.id.item_17:
                startActivity(new Intent(this, ActividadConfiguracion.class));
                break;
            case R.id.item_19:
                startActivity(new Intent(this, Login.class));
                break;
            case R.id.item_18:
                fragmentoGenerico = new FragmentoPerfil();
        }
        if (fragmentoGenerico != null) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.contenedor_principal, fragmentoGenerico)
                    .commit();
        }



        // Setear título actual
        setTitle(itemDrawer.getTitle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actividad_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
