package cl.ccu.skintears.activities.base;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.FrameLayout;

import cl.ccu.skintears.R;
import cl.ccu.skintears.activities.ReconocimientoActivity;
import cl.ccu.skintears.activities.ContenidosActivity;
import cl.ccu.skintears.activities.EvaluacionesActivity;
import cl.ccu.skintears.activities.InicioActivity;
import cl.ccu.skintears.activities.CompartirImagenActivity;
import cl.ccu.skintears.activities.TratamientosActivity;

public abstract class AbstractDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle(getCustomTitle());
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.main_content);
        getLayoutInflater().inflate(getLayoutId(), frameLayout);
       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

// Seccion que pide confirmacion para salir de la Activity inicial
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_warning)
                    .setTitle("     SALIR !!!")
                    .setMessage("                Estás seguro?")
                    .setNegativeButton(android.R.string.cancel, null)//sin listener
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {//un listener que al pulsar, cierre la aplicacion
                        @Override
                        public void onClick(DialogInterface dialog, int which){
                            //Salir
                            AbstractDrawerActivity.this.finish();
                        }
                    })
                    .show();
            // Si el listener devuelve true, significa que el evento esta procesado, y nadie debe hacer nada mas
            return true;
        }
        //para las demas cosas, se reenvia el evento al listener habitual
        return super.onKeyDown(keyCode, event);

    }





    public abstract int getLayoutId();

    public abstract String getCustomTitle();

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.id_inicio) {
            launchActivity(InicioActivity.class);
        } else if (id == R.id.id_contenidos) {
            launchActivity(ContenidosActivity.class);
        } else if (id == R.id.id_tratamientos) {
            launchActivity(TratamientosActivity.class);
        } else if (id == R.id.id_evaluaciones) {
            launchActivity(EvaluacionesActivity.class);
        } else if (id == R.id.id_compartir) {
            launchActivity(CompartirImagenActivity.class);
        } else if (id == R.id.id_reconocimiento) {
            launchActivity(ReconocimientoActivity.class);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void launchActivity(Class _class) {
        //Avoid launch the same activity
        if (this.getClass() != _class) {
            startActivity(makePageIntent(_class));
            overridePendingTransition(0, 0);
            finish();
        }
    }

    public Intent makePageIntent(Class _class) {
        Intent intent = new Intent(this, _class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }
}
