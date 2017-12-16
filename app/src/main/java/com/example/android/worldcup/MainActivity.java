package com.example.android.worldcup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int argScore = 0;
    int argShot = 0;
    int yellowcardArg = 0;
    int redcardArg = 0;
    int fraScore = 0;
    int fraShot = 0;
    int yellowcardFra = 0;
    int redcardFra = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Fruit of football. Goal for Argentina.
     */
    public void addgoalforArgentina(View v) {
        argScore = argScore + 1;
        argShot = argShot + 1;
        displayForArgentina(argScore);
        displayshotsForArgentina(argShot);
    }

    /**
     * You can not score without shooting. Shoot for Argentina.
     */
    public void addshotforArgentina(View v) {
        argShot = argShot + 1;
        displayshotsForArgentina(argShot);
    }

    /**
     * Tension is high at the final.
     */
    public void addyellowcardforArgentina(View v) {
        yellowcardArg = yellowcardArg + 1;
        displayyellowcardForArgentina(yellowcardArg);
    }

    /**
     * Argentina will continue with one less player and can not play with less than 8 players.
     */
    public void addredcardforArgentina(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ops");
        builder.setMessage("Argentina can not continue with 7 player").setCancelable(true);
        AlertDialog alert = builder.create();
        redcardArg = redcardArg + 1;
        if (redcardArg < 4) {
            alert.dismiss();
            displayredcardForArgentina(redcardArg);
        } else {
            alert.show();
            displayForArgentina(0);
            displayForFrance(0);
            displayshotsForFrance(0);
            displayshotsForArgentina(0);
            displayyellowcardForArgentina(0);
            displayyellowcardForFrance(0);
            displayredcardForArgentina(0);
            displayredcardForFrance(0);
        }
    }

    /**
     * Oh la la! Goal for France.
     */
    public void addgoalforFrance(View v) {
        fraScore = fraScore + 1;
        fraShot = fraShot + 1;
        displayForFrance(fraScore);
        displayshotsForFrance(fraShot);
    }

    /**
     * You can not score without shooting. Shoot for France.
     */
    public void addshotforFrance(View v) {
        fraShot = fraShot + 1;
        displayshotsForFrance(fraShot);
    }

    /**
     * Tension is high at the final.
     */
    public void addyellowcardforFrance(View v) {
        yellowcardFra = yellowcardFra + 1;
        displayyellowcardForFrance(yellowcardFra);

    }

    /**
     * France will continue with one less player and can not play with less than 8 players.
     */

    public void addredcardforFrance(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ops");
        builder.setMessage("France can not continue with 7 player").setCancelable(true);
        AlertDialog alert = builder.create();
        redcardFra = redcardFra + 1;
        if (redcardFra < 4) {
            alert.dismiss();
            displayredcardForFrance(redcardFra);
        } else {
            alert.show();
            displayForArgentina(0);
            displayForFrance(0);
            displayshotsForFrance(0);
            displayshotsForArgentina(0);
            displayyellowcardForArgentina(0);
            displayyellowcardForFrance(0);
            displayredcardForArgentina(0);
            displayredcardForFrance(0);
        }
    }

    /**
     * Displays the given score for Argentina.
     */
    public void displayForArgentina(int score) {
        TextView scoreView = (TextView) findViewById(R.id.argScore);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the shots for Argentina.
     */
    public void displayshotsForArgentina(int shot) {
        TextView scoreView = (TextView) findViewById(R.id.argShot);
        scoreView.setText(String.valueOf(shot));
    }

    /**
     * Displays the yellow cards for Argentina.
     */
    public void displayyellowcardForArgentina(int card) {
        TextView scoreView = (TextView) findViewById(R.id.yellowcardArg);
        scoreView.setText(String.valueOf(card));
    }

    /**
     * Displays the red cards for Argentina.
     */
    public void displayredcardForArgentina(int card) {
        TextView scoreView = (TextView) findViewById(R.id.redcardArg);
        scoreView.setText(String.valueOf(card));
    }

    /**
     * Restart the game.
     */

    public void resetScore(View v) {
        argScore = 0;
        argShot = 0;
        yellowcardArg = 0;
        redcardArg = 0;
        fraScore = 0;
        fraShot = 0;
        yellowcardFra = 0;
        redcardFra = 0;
        displayForArgentina(0);
        displayForFrance(0);
        displayshotsForFrance(0);
        displayshotsForArgentina(0);
        displayyellowcardForArgentina(0);
        displayyellowcardForFrance(0);
        displayredcardForArgentina(0);
        displayredcardForFrance(0);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("argScore", argScore);
        outState.putInt("fraScore", fraScore);
        outState.putInt("yellowcardArg", yellowcardArg);
        outState.putInt("yellowcardFra", yellowcardFra);
        outState.putInt("redcardFra", redcardFra);
        outState.putInt("redcardArg", redcardArg);
        outState.putInt("argShot", argShot);
        outState.putInt("fraShot", fraShot);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        argScore = savedInstanceState.getInt("argScore");
        fraScore = savedInstanceState.getInt("fraScore");
        yellowcardFra = savedInstanceState.getInt("yellowcardFra");
        redcardFra = savedInstanceState.getInt("redcardFra");
        yellowcardArg = savedInstanceState.getInt("yellowcardArg");
        redcardArg = savedInstanceState.getInt("redcardArg");
        argShot = savedInstanceState.getInt("argShot");
        fraShot = savedInstanceState.getInt("fraShot");
        displayForArgentina(argScore);
        displayForFrance(fraScore);
        displayshotsForFrance(fraShot);
        displayshotsForArgentina(argShot);
        displayyellowcardForArgentina(yellowcardArg);
        displayyellowcardForFrance(yellowcardFra);
        displayredcardForArgentina(redcardArg);
        displayredcardForFrance(redcardFra);
    }

    /**
     * Displays the given score for France.
     */

    public void displayForFrance(int score) {
        TextView scoreView = findViewById(R.id.fraScore);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the shots for France.
     */
    public void displayshotsForFrance(int shot) {
        TextView scoreView = (TextView) findViewById(R.id.fraShot);
        scoreView.setText(String.valueOf(shot));
    }

    /**
     * Displays the yellow cards for France.
     */
    public void displayyellowcardForFrance(int card) {
        TextView scoreView = (TextView) findViewById(R.id.yellowcardFra);
        scoreView.setText(String.valueOf(card));
    }

    /**
     * Displays the red cards for France.
     */
    public void displayredcardForFrance(int card) {
        TextView scoreView = (TextView) findViewById(R.id.redcardFra);
        scoreView.setText(String.valueOf(card));
    }

}

