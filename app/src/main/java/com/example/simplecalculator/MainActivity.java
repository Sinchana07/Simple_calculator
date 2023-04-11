package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    Button badd,bsub,bmul,bdiv;
    Button bclr,beq,bdot;
    EditText txtr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Take button input on b1
        b1=(Button) findViewById(R.id.button1);
        //set on click listener
        b1.setOnClickListener(this);

        //Take button input on b1
        b2=(Button) findViewById(R.id.button2);
        //set on click listener
        b2.setOnClickListener(this);

        //Take button input on b1
        b3=(Button) findViewById(R.id.button3);
        //set on click listener
        b3.setOnClickListener(this);

        //Take button input on b1
        b4=(Button) findViewById(R.id.button4);
        //set on click listener
        b4.setOnClickListener(this);

        //Take button input on b1
        b5=(Button) findViewById(R.id.button5);
        //set on click listener
        b5.setOnClickListener(this);

        //Take button input on b1
        b6=(Button) findViewById(R.id.button6);
        //set on click listener
        b6.setOnClickListener(this);

        //Take button input on b1
        b7=(Button) findViewById(R.id.button7);
        //set on click listener
        b7.setOnClickListener(this);

        //Take button input on b1
        b8=(Button) findViewById(R.id.button8);
        //set on click listener
        b8.setOnClickListener(this);

        //Take button input on b1
        b9=(Button) findViewById(R.id.button9);
        //set on click listener
        b9.setOnClickListener(this);

        //Take button input on b1
        b0=(Button) findViewById(R.id.button0);
        //set on click listener
        b0.setOnClickListener(this);

        //Take button input on b1
        badd=(Button) findViewById(R.id.buttonpl);
        //set on click listener
        badd.setOnClickListener(this);

        //Take button input on b1
        bsub=(Button) findViewById(R.id.buttonmin);
        //set on click listener
        bsub.setOnClickListener(this);

        //Take button input on b1
        bmul=(Button) findViewById(R.id.buttonmul);
        //set on click listener
        bmul.setOnClickListener(this);

        //Take button input on b1
        bdiv=(Button) findViewById(R.id.buttondiv);
        //set on click listener
        bdiv.setOnClickListener(this);

        //Take button input on b1
        bdot=(Button) findViewById(R.id.buttonpt);
        //set on click listener
        bdot.setOnClickListener(this);

        //Take button input on b1
        beq=(Button) findViewById(R.id.buttoneq);
        //set on click listener
        beq.setOnClickListener(this);

        //Take button input on b1
        bclr=(Button) findViewById(R.id.buttoncl);
        //set on click listener
        bclr.setOnClickListener(this);

        //Edit text-set it to empty
        txtr=(EditText) findViewById(R.id.edit_txt);
        txtr.setText("");



    }

    @Override
    public void onClick(View v) {
        if(v.equals(b1))
            txtr.append("1");

        if(v.equals(b2))
            txtr.append("2");

        if(v.equals(b3))
            txtr.append("3");

        if(v.equals(b4))
            txtr.append("4");

        if(v.equals(b5))
            txtr.append("5");

        if(v.equals(b6))
            txtr.append("6");

        if(v.equals(b7))
            txtr.append("7");

        if(v.equals(b8))
            txtr.append("8");

        if(v.equals(b9))
            txtr.append("9");

        if(v.equals(b0))
            txtr.append("0");

        if(v.equals(badd))
            txtr.append("+");

        if(v.equals(bsub))
            txtr.append("-");

        if(v.equals(bmul))
            txtr.append("*");

        if(v.equals(bdiv))
            txtr.append("/");

        if(v.equals(bclr))
            txtr.setText("");

        if(v.equals(bdot))
            txtr.append(".");

        if(v.equals(beq))
        {
            try {
                String result=txtr.getText().toString();
                if(result.contains("/"))
                {
                    divide(result);
                }
                else if(result.contains("*"))
                    multiply(result);
                else if(result.contains(("+")))
                    addition(result);
                else if(result.contains(("-")))
                    subtract(result);
                    
            }
            catch(Exception e)
            {
                displayInvalidMessage("Invalid input");
            }
        }



    }

    private void addition(String result) {

        String[] opnds=result.split(Pattern.quote("+"));
        if(opnds.length==2)
        {
            double op1=Double.parseDouble(opnds[0]);
            double op2=Double.parseDouble(opnds[1]);
            double res=op1+op2;
            //result is in double format take the value and convert to string
            txtr.setText(String.valueOf(res));
        }
        else
        {
            displayInvalidMessage("Invalid input");
        }
    }

    private void subtract(String result) {
        //split with respect to operator -
        String[] opnds=result.split("-");
        if(opnds.length==2)
        {
            double op1=Double.parseDouble(opnds[0]);
            double op2=Double.parseDouble(opnds[1]);
            double res=op1-op2;
            //result is in double format take the value and convert to string
            txtr.setText(String.valueOf(res));
        }
        else
        {
            displayInvalidMessage("Invalid input");
        }
    }

    private void multiply(String result) {
        String[] opnds=result.split(Pattern.quote("*"));
        if(opnds.length==2)
        {
            double op1=Double.parseDouble(opnds[0]);
            double op2=Double.parseDouble(opnds[1]);
            double res=op1*op2;
            //result is in double format take the value and convert to string
            txtr.setText(String.valueOf(res));
        }
        else
        {
            displayInvalidMessage("Invalid input");
        }
    }

    private void divide(String result) {
        String[] opnds=result.split("/");
        if(opnds.length==2)
        {
            double op1=Double.parseDouble(opnds[0]);
            double op2=Double.parseDouble(opnds[1]);
            double res=op1/op2;
            //result is in double format take the value and convert to string
            txtr.setText(String.valueOf(res));
        }
        else
        {
            displayInvalidMessage("Invalid input");
        }
        
    }
    private void displayInvalidMessage(String msg) {
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }
}