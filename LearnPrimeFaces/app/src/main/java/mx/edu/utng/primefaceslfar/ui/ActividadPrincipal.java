package mx.edu.utng.primefaceslfar.ui;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import mx.edu.utng.primefaceslfar.R;
import mx.edu.utng.primefaceslfar.database.puntaje.MisDocumentos;
import mx.edu.utng.primefaceslfar.database.puntaje.MyActivity;
import mx.edu.utng.primefaceslfar.juego2.MainActivity;
import mx.edu.utng.primefaceslfar.modelo.Codigo;
import mx.edu.utng.primefaceslfar.modelo.MusicOnline;
import mx.edu.utng.primefaceslfar.ui.a_tema_i.FragmentoWebComponentesPrincipal;
import mx.edu.utng.primefaceslfar.ui.a_tema_ii.FragmentoInputPrincipal;
import mx.edu.utng.primefaceslfar.ui.acercade.FragmentoAcercaDe;
import mx.edu.utng.primefaceslfar.ui.c_tema_iii.FragmentoButtonPrincipal;
import mx.edu.utng.primefaceslfar.ui.d_tema_iv.FragmentoDataPrincipal;
import mx.edu.utng.primefaceslfar.ui.e_tema_v.FragmentoPanelPrincipal;
import mx.edu.utng.primefaceslfar.ui.f_tema_vi.FragmentoOverLayPrincipal;
import mx.edu.utng.primefaceslfar.ui.g_tema_vii.FragmentoMenuPrincipal;
import mx.edu.utng.primefaceslfar.ui.login.Login;


public class ActividadPrincipal extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);

        agregarToolbar();
        notificacion();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (navigationView != null) {
            prepararDrawer(navigationView);
            // Seleccionar item por defecto
            seleccionarItem(navigationView.getMenu().getItem(0));
        }
    }

    private static final int NOTIF_ALERTA_ID = 1;

    public void notificacion() {
        final String[] horas = {
                "0:0",
                "00:10",
                "00:15",
                "00:20",
                "00:25",
                "00:30",
                "00:35",
                "00:40",
                "00:45",
                "00:50",
                "00:55",
                "01:0",
                "01:5",
                "01:10",
                "01:15",
                "01:20",
                "01:25",
                "01:30",
                "01:35",
                "01:40",
                "01:45",
                "01:50",
                "01:55",
                "02:0",
                "02:5",
                "02:10",
                "02:15",
                "02:20",
                "02:25",
                "02:30",
                "02:35",
                "02:40",
                "02:45",
                "02:50",
                "02:55",
                "03:0",
                "03:5",
                "03:10",
                "03:15",
                "03:20",
                "03:25",
                "03:30",
                "03:35",
                "03:40",
                "03:45",
                "03:50",
                "03:55",
                "04:0",
                "04:5",
                "04:10",
                "04:15",
                "04:20",
                "04:25",
                "04:30",
                "04:35",
                "04:40",
                "04:45",
                "04:50",
                "04:55",
                "05:0",
                "05:5",
                "05:10",
                "05:15",
                "05:20",
                "05:25",
                "05:30",
                "05:35",
                "05:40",
                "05:45",
                "05:50",
                "05:55",
                "06:0",
                "06:5",
                "06:10",
                "06:15",
                "06:20",
                "06:25",
                "06:30",
                "06:35",
                "06:40",
                "06:45",
                "06:50",
                "06:55",
                "07:0",
                "07:5",
                "07:10",
                "07:15",
                "07:20",
                "07:25",
                "07:30",
                "07:35",
                "07:40",
                "07:45",
                "07:50",
                "07:55",
                "08:0",
                "08:5",
                "08:10",
                "08:15",
                "08:20",
                "08:25",
                "08:30",
                "08:35",
                "08:40",
                "08:45",
                "08:50",
                "08:55",
                "09:0",
                "09:5",
                "09:10",
                "09:15",
                "09:20",
                "09:25",
                "09:30",
                "09:35",
                "09:40",
                "09:45",
                "09:50",
                "09:55",
                "00:00",
                "0:00",
                "0:5",
                "00:05",
                "0:10",
                "0:15",
                "0:20",
                "0:25",
                "0:30",
                "0:35",
                "0:40",
                "0:45",
                "0:50",
                "0:55",
                "1:0",
                "1:5",
                "1:10",
                "1:15",
                "1:20",
                "1:25",
                "1:30",
                "1:35",
                "1:40",
                "1:45",
                "1:50",
                "1:55",
                "2:0",
                "2:5",
                "2:10",
                "2:15",
                "2:20",
                "2:25",
                "2:30",
                "2:35",
                "2:40",
                "2:45",
                "2:50",
                "2:55",
                "3:0",
                "3:5",
                "3:10",
                "3:15",
                "3:20",
                "3:25",
                "3:30",
                "3:35",
                "3:40",
                "3:45",
                "3:50",
                "3:55",
                "4:0",
                "4:5",
                "4:10",
                "4:15",
                "4:20",
                "4:25",
                "4:30",
                "4:35",
                "4:40",
                "4:45",
                "4:50",
                "4:55",
                "5:0",
                "5:5",
                "5:10",
                "5:15",
                "5:20",
                "5:25",
                "5:30",
                "5:35",
                "5:40",
                "5:45",
                "5:50",
                "5:55",
                "6:0",
                "6:5",
                "6:10",
                "6:15",
                "6:20",
                "6:25",
                "6:30",
                "6:35",
                "6:40",
                "6:45",
                "6:50",
                "6:55",
                "7:0",
                "7:5",
                "7:10",
                "7:15",
                "7:20",
                "7:25",
                "7:30",
                "7:35",
                "7:40",
                "7:45",
                "7:50",
                "7:55",
                "8:0",
                "8:5",
                "8:10",
                "8:15",
                "8:20",
                "8:25",
                "8:30",
                "8:35",
                "8:40",
                "8:45",
                "8:50",
                "8:55",
                "9:0",
                "9:5",
                "9:10",
                "9:15",
                "9:20",
                "9:25",
                "9:30",
                "9:35",
                "9:40",
                "9:45",
                "9:50",
                "9:55",
                "10:00",
                "10:5",
                "10:10",
                "10:15",
                "10:20",
                "10:25",
                "10:30",
                "10:35",
                "10:40",
                "10:45",
                "10:50",
                "10:55",
                "11:0",
                "11:5",
                "11:10",
                "11:15",
                "11:20",
                "11:25",
                "11:30",
                "11:35",
                "11:40",
                "11:45",
                "11:50",
                "11:55",
                "12:0",
                "12:5",
                "12:10",
                "12:15",
                "12:20",
                "12:25",
                "12:30",
                "12:35",
                "12:40",
                "12:45",
                "12:50",
                "12:55",
                "13:0",
                "13:5",
                "13:10",
                "13:15",
                "13:20",
                "13:25",
                "13:30",
                "13:35",
                "13:40",
                "13:45",
                "13:50",
                "13:55",
                "14:0",
                "14:5",
                "14:10",
                "14:15",
                "14:20",
                "14:25",
                "14:30",
                "14:35",
                "14:40",
                "14:45",
                "14:50",
                "14:55",
                "15:0",
                "15:5",
                "15:10",
                "15:15",
                "15:20",
                "15:25",
                "15:30",
                "15:35",
                "15:40",
                "15:45",
                "15:50",
                "15:55",
                "16:0",
                "16:5",
                "16:10",
                "16:15",
                "16:20",
                "16:25",
                "16:30",
                "16:35",
                "16:40",
                "16:45",
                "16:50",
                "16:55",
                "17:0",
                "17:5",
                "17:10",
                "17:15",
                "17:20",
                "17:25",
                "17:30",
                "17:35",
                "17:40",
                "17:45",
                "17:50",
                "17:55",
                "18:0",
                "18:5",
                "18:10",
                "18:15",
                "18:20",
                "18:25",
                "18:30",
                "18:35",
                "18:40",
                "18:45",
                "18:50",
                "18:55",
                "19:0",
                "19:5",
                "19:10",
                "19:15",
                "19:20",
                "19:25",
                "19:30",
                "19:35",
                "19:40",
                "19:45",
                "19:50",
                "19:55",
                "20:0",
                "20:5",
                "20:10",
                "20:15",
                "20:20",
                "20:25",
                "20:30",
                "20:35",
                "20:40",
                "20:45",
                "20:50",
                "20:55",
                "21:0",
                "21:5",
                "21:10",
                "21:15",
                "21:20",
                "21:25",
                "21:30",
                "21:35",
                "21:40",
                "21:45",
                "21:50",
                "21:55",
                "22:0",
                "22:5",
                "22:10",
                "22:15",
                "22:20",
                "22:25",
                "22:30",
                "22:35",
                "22:40",
                "22:45",
                "22:50",
                "22:55",
                "23:0",
                "23:5",
                "23:10",
                "23:15",
                "23:20",
                "23:25",
                "23:30",
                "23:35",
                "23:40",
                "23:45",
                "23:50",
                "23:55",};

        //String match= "23:40";

        TimerTask timeTask = new TimerTask() {

            @Override
            public void run() {
                for (int w = 0; w < horas.length; w++) {
                    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                    Calendar calendar = Calendar.getInstance();
                    String time = dateFormat.format(calendar.getTime());
                    if (time.equals(horas[w])) {
                        NotificationCompat.Builder mBuilder =
                                new NotificationCompat.Builder(ActividadPrincipal.this)
                                        .setSmallIcon(android.R.drawable.stat_sys_warning)
                                        .setLargeIcon((((BitmapDrawable) getResources()
                                                .getDrawable(R.drawable.ic_primefaces)).getBitmap()))
                                        .setContentTitle("PrimeFaces te espera" + time)
                                        .setContentText("Logro de 45%.")
                                        .setContentInfo("4")
                                        .setTicker("LearnPrimeFaces")
                                        .setPriority(1);

                        Intent notIntent =
                                new Intent(ActividadPrincipal.this, ActividadPrincipal.class);

                        PendingIntent contIntent = PendingIntent.getActivity(
                                ActividadPrincipal.this, 0, notIntent, 0);

                        mBuilder.setContentIntent(contIntent);

                        NotificationManager mNotificationManager =
                                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                        mNotificationManager.notify(NOTIF_ALERTA_ID, mBuilder.build());
                    }
                }

            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timeTask, 0, 60000);

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
                fragmentoGenerico = new FragmentoPanelPrincipal();
                break;
            case R.id.item_7:
                fragmentoGenerico = new FragmentoOverLayPrincipal();
                break;
            case R.id.item_8:
                fragmentoGenerico = new FragmentoMenuPrincipal();
                break;
           /* case R.id.item_9:
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
                break;*/
            case R.id.item_13:
                startActivity(new Intent(this, MyActivity.class));
                break;
            case R.id.item_14:
                fragmentoGenerico = new FragmentoAcercaDe();
                break;
            case R.id.item_15:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.item_16:
                startActivity(new Intent(this, MisDocumentos.class));
                break;
            case R.id.item_17:

                break;
            case R.id.item_19:
                startActivity(new Intent(this, Login.class));
                break;
            case R.id.item_18:
                fragmentoGenerico = new FragmentoPerfil();
                break;
            case R.id.item_20:
                startActivity(new Intent(this, MusicOnline.class));
                break;
            case R.id.item_21:
                startActivity(new Intent(this, Codigo.class));
                break;

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
