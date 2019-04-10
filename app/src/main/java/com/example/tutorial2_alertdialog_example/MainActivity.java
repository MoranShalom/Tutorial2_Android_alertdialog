package com.example.tutorial2_alertdialog_example;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnShowAlertDialog;

    // AlertDialog view
    private AlertDialog AlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnShowAlertDialog = ( Button) findViewById(R.id.btnShowAlertDialog);

        btnShowAlertDialog.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                // create an AlertDialog
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                //set an Icon for the AlertDialog
                mBuilder.setIcon(android.R.drawable.sym_def_app_icon);
                //set a title for the AlertDialog
                mBuilder.setTitle(R.string.alert_title);
                // set a message to the user on the AlertDialog
                mBuilder.setMessage(R.string.alert_message);
                //by default the user can dismiss the alertDialog by tuching the app screen
                //but, if we wont the user to exit the alert Dialog only from the dismiss button,
                // we will write this line
                mBuilder.setCancelable(false);


                // set a buttons for the AlertDialog
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); //  dismiss is to hide or get rid of dialog

                        //create a Toast message for the user
                        Toast.makeText(MainActivity.this,
                                getString(R.string.Toast_message),
                                Toast.LENGTH_SHORT).show();

                    }
                });

                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
                    }
                });

                mBuilder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog= mBuilder.create();
                AlertDialog.show();


            }
        });


    }
}
