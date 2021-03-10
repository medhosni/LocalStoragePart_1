package tn.esprit.localstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText login;
    private EditText pwd;

    private Button show;
    private Button save;
    private Button clear;

    public SharedPreferences sp;
    public static  String sharedString ="mainActivity";

    String Slogin ="login";
    String Spwd ="pwd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp =getSharedPreferences(sharedString,MODE_PRIVATE);

        login = findViewById(R.id.login);
        pwd = findViewById(R.id.pwd);

        save = findViewById(R.id.save);
        show = findViewById(R.id.show);
        clear = findViewById(R.id.clear);
        //******************
/*
        login.setText(sp.getString(Slogin,""));
        pwd.setText(sp.getString(Spwd,""));
  */      //******************
        save.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sp.edit();

            editor.putString(Slogin,login.getText().toString());
            editor.putString(Spwd,pwd.getText().toString());

            editor.commit();

        });

        show.setOnClickListener(view -> {
            login.setText(sp.getString(Slogin,""));
            pwd.setText(sp.getString(Spwd,""));
        });

        clear.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sp.edit();

            editor.clear();

            editor.commit();
        });


    }
}