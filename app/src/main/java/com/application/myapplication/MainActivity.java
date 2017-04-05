package com.application.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn1, btn2, btn3;
    TextView maintext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(this);

        btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(this);

        btn3 = (Button)findViewById(R.id.button3);
        btn3.setOnClickListener(this);

        maintext = (TextView) findViewById(R.id.maintext);
        registerForContextMenu(maintext);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo MenuInfo)
    {
        switch(view.getId()){
            case R.id.maintext:
                for (int i=0; i < 2; i++)
                {
                    Toast toast = Toast.makeText(this, R.string.toastCheating, Toast.LENGTH_LONG);
                    toast.show();
                }

                menu.add(0,1,0,"Жмакни");
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case 1:
                btn1.setVisibility(View.INVISIBLE);
                btn2.setVisibility(View.INVISIBLE);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick (View view){
         switch (view.getId()) {
            case R.id.button1:
                Intent intentScreamer1 = new Intent(this, ActivityScreamer.class);
                startActivity(intentScreamer1);
                break;
            case R.id.button2:
                Intent intentScreamer2 = new Intent(this, ActivityScreamerPetr.class);
                startActivity(intentScreamer2);
                break;
            case R.id.button3:
                Intent intentTrueDesision = new Intent(this, Activity2.class);
                startActivity(intentTrueDesision);
                break;
         }
    }


    @Override
    public void onBackPressed() {
        Toast toast = Toast.makeText(this, R.string.neverBack, Toast.LENGTH_LONG);
        toast.show();
    }
}
