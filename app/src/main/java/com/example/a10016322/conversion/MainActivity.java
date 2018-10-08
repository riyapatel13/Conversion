package com.example.a10016322.conversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spin1, spin2;
    ArrayList<String> lengthList;
    TextView equal, answer;
    EditText input;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin1 = (Spinner)(findViewById(R.id.spinner1_id));
        spin2 = (Spinner)(findViewById(R.id.spinner2_id));
        equal = (TextView) (findViewById(R.id.textView_id));
        answer = (TextView) (findViewById(R.id.answer_id));
        input = (EditText) (findViewById(R.id.input_id));
        convert = (Button)(findViewById(R.id.button_id));

        lengthList = new ArrayList<>();
        lengthList.add("miles");
        lengthList.add("hops");
        lengthList.add("steps");
        lengthList.add("baby crawls");

        ArrayAdapter<String> lengthAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, lengthList);
        spin1.setAdapter(lengthAdapter);
        spin2.setAdapter(lengthAdapter);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int in = Integer.parseInt(input.getText().toString());
                int ans;
                if(spin1.getSelectedItem().toString().equals("miles"))
                {
                    if(spin2.getSelectedItem().toString().equals("hops"))
                        ans = in*5000;
                    else if(spin2.getSelectedItem().toString().equals("steps"))
                        ans = in*15000;
                    else if(spin2.getSelectedItem().toString().equals("baby crawls"))
                        ans = in*45000;
                    else if(spin2.getSelectedItem().toString().equals("miles"))
                        ans = in;
                    answer.setText(ans);
                }
                if(spin1.getSelectedItem().toString().equals("hops"))
                {
                    if(spin2.getSelectedItem().toString().equals("hops"))
                    {
                        ans = in;
                        answer.setText(ans);
                    }
                    if(spin2.getSelectedItem().toString().equals("steps"))
                    {
                        ans = in*3;
                        answer.setText(ans);
                    }
                    if(spin2.getSelectedItem().toString().equals("baby crawls"))
                    {
                        ans = in*9;
                        answer.setText(ans);
                    }
                    if(spin2.getSelectedItem().toString().equals("miles"))
                    {
                        ans = in/5000;
                        answer.setText(ans);
                    }
                }
                if(spin1.getSelectedItem().toString().equals("steps"))
                {
                    if(spin2.getSelectedItem().toString().equals("hops"))
                    {
                        ans = in/3;
                        answer.setText(ans);
                    }
                    if(spin2.getSelectedItem().toString().equals("steps"))
                    {
                        ans = in;
                        answer.setText(ans);
                    }
                    if(spin2.getSelectedItem().toString().equals("baby crawls"))
                    {
                        ans = in*3;
                        answer.setText(ans);
                    }
                    if(spin2.getSelectedItem().toString().equals("miles"))
                    {
                        ans = in/15000;
                        answer.setText(ans);
                    }
                }
                if(spin1.getSelectedItem().toString().equals("baby crawls"))
                {
                    if(spin2.getSelectedItem().toString().equals("hops"))
                    {
                        ans = in/9;
                        answer.setText(ans);
                    }
                    if(spin2.getSelectedItem().toString().equals("steps"))
                    {
                        ans = in/3;
                        answer.setText(ans);
                    }
                    if(spin2.getSelectedItem().toString().equals("baby crawls"))
                    {
                        ans = in;
                        answer.setText(ans);
                    }
                    if(spin2.getSelectedItem().toString().equals("miles"))
                    {
                        ans = in/45000;
                        answer.setText(ans);
                    }
                }
            }
        });
    }
}
// if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
//5000 hops = 1 mile
//3 steps = 1 hop
//1 step = 3 baby crawls