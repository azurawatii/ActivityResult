package com.taruc.activityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //declare view
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialise the view
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        //set onclick listener to button
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {

        //explicit intent
        Intent intent = new Intent(this, SecondActivity.class);
      //  startActivity(intent);
        startActivityForResult(intent, 0);
    }

    //callback methods

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0)
        {
            if (data !=  null)
            {
                textView.setText(data.getStringExtra("key"));
            }
        }
    }
}
