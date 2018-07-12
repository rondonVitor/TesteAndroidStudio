package com.example.cliente.teste;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

public class ProdutoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RelativeLayout cl11;
    RelativeLayout cl12;
 RelativeLayout pl11;
    RelativeLayout pl12;
    RelativeLayout pl13;
    RelativeLayout pl14;
    RelativeLayout pl15;
    RelativeLayout pl16;
    RelativeLayout pl17;
    RelativeLayout pl18;
    RelativeLayout pl19;
RelativeLayout al11;
    RelativeLayout al12;
    RelativeLayout al13;
    RelativeLayout al14;
    RelativeLayout al15;

    TextView c11;
    TextView c12;
TextView p11;
    TextView p12;
    TextView p13;
    TextView p14;
    TextView p15;
    TextView p16;
    TextView p17;
    TextView p18;
    TextView p19;
 TextView a11;
    TextView a12;
    TextView a13;
    TextView a14;
    TextView a15;



    TabHost tabHost;
    Conteudo conteudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TabHost host = (TabHost) findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Centrais");
        spec.setContent(R.id.Centrais);
        spec.setIndicator("Centrais");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Placas");
        spec.setContent(R.id.Placas);
        spec.setIndicator("Placas");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Acessórios");
        spec.setContent(R.id.Acessórios);
        spec.setIndicator("Acessórios");
        host.addTab(spec);

        Bundle params = getIntent().getExtras();
        conteudo = (Conteudo) params.getSerializable("conteudo");


        cl11 = findViewById(R.id.clayout11);
        p11 = findViewById(R.id.pcod11);
        p15 = findViewById(R.id.pcod15);
        p16 = findViewById(R.id.pcod16);
        p17 = findViewById(R.id.pcod17);
        p18 = findViewById(R.id.pcod18);
        p19 = findViewById(R.id.pcod19);

        int soma = conteudo.Tdigital + conteudo.Tanalogico + conteudo.Tgsm + conteudo.Tip;

        if (soma > 97) {
            cl11.setVisibility(View.GONE);
        }

        if (conteudo.Tdigital > 30) {
            p11.setText("cod: 4400336     quantidade: 2");
        }

        if (conteudo.Ranalogico >144) {
            p15.setText("cod: 4400326     quantidade: 10");
        } else if (conteudo.Ranalogico >128) {
            p15.setText("cod: 4400326     quantidade: 9");
        } else if (conteudo.Ranalogico >112) {
            p15.setText("cod: 4400326     quantidade: 8");
        } else if (conteudo.Ranalogico >96) {
            p15.setText("cod: 4400326     qunatidade: 7");
        } else if (conteudo.Ranalogico >80) {
            p15.setText("cod: 4400326     qunatidade: 6");
        } else if (conteudo.Ranalogico >64) {
            p15.setText("cod: 4400326     quantidade: 5");
        } else if (conteudo.Ranalogico >48) {
            p15.setText("cod: 4400326     quantidade: 4");
        } else if (conteudo.Ranalogico >32) {
            p15.setText("cod: 4400326     quantidade: 3");
        } else if (conteudo.Ranalogico >16) {
            p15.setText("cod: 4400326     quantidade: 2");
        } else if (conteudo.Ranalogico >= 1) {
            p15.setText("cod: 4400326     quantidade: 1");
        }

        if (conteudo.Rdigital >36) {
            p16.setText("cod: 4400330     quantidade: 4");
        } else if (conteudo.Rdigital >24) {
            p16.setText("cod: 4400330     quantidade: 3");
        } else if (conteudo.Rdigital >12) {
            p16.setText("cod: 4400330     quantidade: 2");
        } else if (conteudo.Rdigital >=1) {
            p16.setText("cod: 4400330     quantidade: 1");
        }

        if (conteudo.Ranalogico > 156) {
            p17.setText("cod: 4400331     quantidade: 14");
        } else if (conteudo.Ranalogico >144 ) {
            p17.setText("cod: 4400331     quantidade: 13");
        }  else if (conteudo.Ranalogico >132 || conteudo.Rdigital > 44 ) {
            p17.setText("cod: 4400331     quantidade: 12");
        } else if (conteudo.Ranalogico >120 || conteudo.Rdigital >40) {
            p17.setText("cod: 4400331     quantidade: 11");
        } else if (conteudo.Ranalogico >108 || conteudo.Rdigital >36) {
            p17.setText("cod: 4400331     qunatidade: 10");
        } else if (conteudo.Ranalogico >96 || conteudo.Rdigital >32) {
            p17.setText("cod: 4400331     qunatidade: 9");
        } else if (conteudo.Ranalogico >84 || conteudo.Rdigital >28) {
            p17.setText("cod: 4400331     quantidade: 8");
        } else if (conteudo.Ranalogico >72 || conteudo.Rdigital >24) {
            p17.setText("cod: 4400331     quantidade: 7");
        } else if (conteudo.Ranalogico >60 || conteudo.Rdigital >20) {
            p17.setText("cod: 4400331     quantidade: 6");
        } else if (conteudo.Ranalogico >48 || conteudo.Rdigital >16) {
            p17.setText("cod: 4400331     quantidade: 5");
        } else if (conteudo.Ranalogico >36 || conteudo.Rdigital >12) {
            p17.setText("cod: 4400331     quantidade: 4");
        }  else if (conteudo.Ranalogico >24 || conteudo.Rdigital >8) {
            p17.setText("cod: 4400331     quantidade: 3");
        } else if (conteudo.Ranalogico >12 || conteudo.Rdigital >4) {
            p17.setText("cod: 4400331     quantidade: 2");
        } else if (conteudo.Ranalogico >=1 || conteudo.Rdigital >=1) {
            p17.setText("cod: 4400331     quantidade: 1");
        }

        if(conteudo.Tanalogico >16) {
            p18.setText("cod: 4400327     quantidade: 3");
        } else if(conteudo.Tanalogico >8) {
            p18.setText("cod: 4400327     quantidade: 2");
        } else if (conteudo.Tanalogico >=1){
            p18.setText("cod: 4400327     quantidade: 1");
        }

        if (conteudo.Tgsm >20) {
            p19.setText("cod: 4400334     quantidade: 6");
        } else if (conteudo.Tgsm > 16) {
            p19.setText("cod: 4400334     quantidade: 5");
        } else if (conteudo.Tgsm > 12) {
            p19.setText("cod: 4400334     quantidade: 4");
        }  else if (conteudo.Tgsm >8) {
            p19.setText("cod: 4400334     quantidade: 3");
        }  else if (conteudo.Tgsm >4) {
            p19.setText("cod: 4400334     quantidade: 2");
        }  else if (conteudo.Tgsm >=1) {
            p19.setText("cod: 4400334     quantidade: 1");
        }




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.produto, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.simular) {
            Intent it = new Intent(this, PrimeiraActivity.class);
            it.putExtra("conteudo", conteudo);
            startActivity(it);
            finish();
        } else if (id == R.id.simulacoesSalvas) {

        } else if (id == R.id.produtos) {
            Intent it = new Intent(this, ProdutoActivity.class);
            it.putExtra("conteudo", conteudo);
            startActivity(it);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
