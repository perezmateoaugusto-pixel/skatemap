package com.example.localizadordeskateparks;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.localizadordeskateparks.ui.CerrarFragment;
import com.example.localizadordeskateparks.ui.ExplorarFragment;
import com.example.localizadordeskateparks.ui.ListaFragment;
import com.google.android.material.navigation.NavigationView;


public class Menu_Principal_Activity extends AppCompatActivity {

    DrawerLayout dlayMenu;
    NavigationView nvMenu;
    ImageView ivMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_princiapl);

        dlayMenu = findViewById(R.id.dlayMenu);
        nvMenu = findViewById(R.id.nvMenu);
        ivMenu = findViewById(R.id.ivMenu);


        ivMenu.setOnClickListener(v -> {
            dlayMenu.openDrawer(GravityCompat.START);
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flayContenedor, new ExplorarFragment())
                    .commit();
        }

        // 📌 EVENTOS DEL MENÚ
        nvMenu.setNavigationItemSelectedListener(item -> {

            Fragment fragment = null;

            if (item.getItemId() == R.id.Inicio) {
                fragment = new ExplorarFragment();

            } else if (item.getItemId() == R.id.ListaSkateparks) {
                fragment = new ListaFragment();

            } else if (item.getItemId() == R.id.CerrarSesion) {
                finish(); // cierra sesión
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flayContenedor, fragment)
                        .commit();
            }

            dlayMenu.closeDrawer(GravityCompat.START);
            return true;
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dlayMenu), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}





