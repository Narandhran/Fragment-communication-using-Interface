package com.neemshade.gitsample;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import layout.FragmentOne;
import layout.FragmentTwo;

public class MainActivity extends AppCompatActivity implements interfaceInstance {

    String fragOne_string;

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

    public void sendDatafromFragOne(String str) {
//        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
//        fragOne_string = str;
//        Toast.makeText(getApplicationContext(), fragOne_string, Toast.LENGTH_SHORT).show();
        FragmentTwo fragmentTwo = new FragmentTwo();
        Bundle args = new Bundle();
        args.putString("value", str);
        fragmentTwo.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction
                .addToBackStack(null)
                .replace(R.id.fragment_container, fragmentTwo)
                .commit();

    }

}
