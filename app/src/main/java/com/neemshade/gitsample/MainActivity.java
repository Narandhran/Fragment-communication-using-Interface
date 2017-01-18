package com.neemshade.gitsample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import layout.FragmentOne;
import layout.FragmentTwo;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         final Button fragOneButton = (Button) findViewById(R.id.click_FragOne);
         fragOneButton.setText("Fragment-1");
        fragOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragOneButton.getText() == "Fragment-1"){
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_container,new FragmentOne()).commit();
                    fragOneButton.setText("Fragment-2");
                    Toast.makeText(getApplicationContext(),"if" + fragOneButton.getText(), Toast.LENGTH_SHORT).show();
                }
                else{
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_container,new FragmentTwo()).commit();
                    fragOneButton.setText("Fragment-1");
                    Toast.makeText(getApplicationContext(), "else" + fragOneButton.getText(), Toast.LENGTH_SHORT).show();

                }

            }
        });

    }


}
