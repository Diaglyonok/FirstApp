package com.application.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity implements View.OnClickListener {

    EditText answ1,answ2,answ3;
    Button next, help,check;
    TextView quest1, quest2, quest3;
    String trueAnsw1 = "порт", trueAnsw2 = "19", trueAnsw3 = "до середины";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        answ1 = (EditText)findViewById(R.id.answ1);
        answ2 = (EditText)findViewById(R.id.answ2);
        answ3 = (EditText)findViewById(R.id.answ3);

        next = (Button) findViewById(R.id.next2);
        next.setOnClickListener(this);
        help = (Button) findViewById(R.id.help);
        help.setOnClickListener(this);
        check = (Button) findViewById(R.id.check);
        check.setOnClickListener(this);

        quest1 = (TextView) findViewById(R.id.quest1);
        registerForContextMenu(quest1);
        quest2 = (TextView) findViewById(R.id.quest2);
        registerForContextMenu(quest2);
        quest3 = (TextView) findViewById(R.id.quest3);
        registerForContextMenu(quest3);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo MenuInfo)
    {
        Toast toast;
        switch(view.getId()){
            case R.id.quest1:
                toast = Toast.makeText(this, R.string.toastHelp1, Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.quest2:
                toast = Toast.makeText(this, R.string.toastHelp2, Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.quest3:
                toast = Toast.makeText(this, R.string.toastHelp3, Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.help:
                Toast toast = Toast.makeText(this, R.string.toastHelp, Toast.LENGTH_LONG );
                toast.show();
                break;
            case R.id.next2:
                Intent intent = new Intent(this, Activity4.class);
                startActivity(intent);
                break;
            case R.id.check:
                if (!answ1.getText().toString().equals("") && !answ1.getText().toString().equals("") && !answ1.getText().toString().equals(""))
                {
                    if (trueAnsw1.equals(answ1.getText().toString()))
                        answ1.setBackgroundColor(getResources().getColor(R.color.green));

                    else
                        answ1.setBackgroundColor(getResources().getColor(R.color.red));

                    if (trueAnsw2.equals(answ2.getText().toString()))
                        answ2.setBackgroundColor(getResources().getColor(R.color.green));

                    else
                        answ2.setBackgroundColor(getResources().getColor(R.color.red));


                    if (trueAnsw3.equals(answ3.getText().toString()))
                        answ3.setBackgroundColor(getResources().getColor(R.color.green));

                    else
                        answ3.setBackgroundColor(getResources().getColor(R.color.red));

                    if (trueAnsw1.equals(answ1.getText().toString()) && trueAnsw2.equals(answ2.getText().toString()) && trueAnsw3.equals(answ3.getText().toString())){
                        help.setVisibility(View.INVISIBLE);
                        check.setVisibility(View.INVISIBLE);
                        next.setVisibility(View.VISIBLE);
                    }

                }
                else{
                    Toast toast2 = Toast.makeText(this, R.string.toastEmpty, Toast.LENGTH_LONG);
                    toast2.show();
                }

                break;


        }

    }

    @Override
    public void onBackPressed() {
        Toast toast = Toast.makeText(this, R.string.neverBack, Toast.LENGTH_LONG);
        toast.show();
    }
}
