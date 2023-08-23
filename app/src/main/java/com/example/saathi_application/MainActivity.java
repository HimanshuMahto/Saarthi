package com.example.saathi_application;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.saathi_application.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    public static final int main=0x7f030004;
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        replaceFragment(new homeFragment());
        activityMainBinding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId()==R.id.home){
                replaceFragment(new homeFragment());
            }
            else if(item.getItemId()==R.id.history){
                replaceFragment(new historyFragment());
            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, fragment);
        fragmentTransaction.commit();
    }
}