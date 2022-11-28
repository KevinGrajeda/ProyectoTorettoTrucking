package com.example.proyectotorettotrucking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MenuActivity extends AppCompatActivity {

    TabLayout menu;
    ViewPager2 viewsContainer;
    FragmentControler menuCtrl;

    //* Agregado para el top menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Asociar con activity menu
        getMenuInflater().inflate(R.menu.top_menu, menu);

        return true;
    }
    //* listeners para eñ top menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent navegacion = null;
        switch (id){
            case R.id.btnLogout:
                salir();
                break;
        }
        if (navegacion != null){
            startActivity(navegacion);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        menu = findViewById(R.id.bottom_Tab);
        viewsContainer = findViewById(R.id.views_container);

        menuCtrl = new FragmentControler(getSupportFragmentManager(),getLifecycle());
        viewsContainer.setAdapter(menuCtrl);
        viewsContainer.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                menu.selectTab(menu.getTabAt(position));
            }
        });
        menu.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewsContainer.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        findViewById(R.id.btnAgregar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewsContainer.setCurrentItem(3);
            }
        });
        //* Agregado por Arturo Mares para tener en esta clase la funcionalidad del logout


    }
    //* Función para hacer logout
    public void salir(){
        SharedPreferences preferences = getSharedPreferences("usr.dat",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
        Intent logout = new Intent(this,MainActivity.class);
        logout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(logout);
        this.finish();
    }
}