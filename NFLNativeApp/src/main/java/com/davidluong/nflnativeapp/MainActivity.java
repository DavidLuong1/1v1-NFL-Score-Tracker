package com.davidluong.nflnativeapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This activity keeps track of the scores for 2 NFL teams.
 */
public class MainActivity extends AppCompatActivity {

    // Tracks the score for Team A
    int scoreTeamA = 0;

    // Tracks the score for Team B
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimpSlifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    /**
     * @ Extra point: Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * @ Field goal: Increase the score for Team A by 3 points.
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    /**
     * @ Touch down: Increase the score for Team A by 6 points.
     */
    public void addThreeForTeamA(View v) {
        scoreTeamA = scoreTeamA + 6;
        displayForTeamA(scoreTeamA);
    }

    /**
     * @ Extra point: Increase the score for Team B by 1 points.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * @ Field goal: Increase the score for Team B by 3 points.
     */
    public void addTwoForTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    /**
     * @ Touchdown: Increase the score for Team B by 6 points.
     */
    public void addThreeForTeamB(View v) {
        scoreTeamB = scoreTeamB + 6;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Resets the score for both teams back to 0.

     public void resetScore(View v) {
     scoreTeamA = 0;
     scoreTeamB = 0;
     displayForTeamA(scoreTeamA);
     displayForTeamB(scoreTeamB);
     }
     */

    /**
     * Displays the winning team
     */
    public void declareWinner(View view) {
        Context context = getApplicationContext();
        CharSequence text = "The winner is: ";
        int duration = Toast.LENGTH_SHORT;

        TextView scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewA.setText(String.valueOf(scoreTeamA));

        TextView scoreViewB = (TextView) findViewById(R.id.team_b_score);
        scoreViewB.setText(String.valueOf(scoreTeamB));

        int scoreA = Integer.parseInt(scoreViewA.getText().toString());
        int scoreB = Integer.parseInt(scoreViewB.getText().toString());

        if(scoreA > scoreB){
            Toast scorePopUp = Toast.makeText(context, text+"THE PACKERS.", duration);
            scorePopUp.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 875);
            scorePopUp.show();
        }
        else if(scoreA < scoreB){
            Toast scorePopUp = Toast.makeText(context, text+"THE FALCONS.", duration);
            scorePopUp.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 875);
            scorePopUp.show();
        }
        else if(scoreA == scoreB){
            Toast scorePopUp = Toast.makeText(context, "OVERTIME !", duration);
            scorePopUp.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 875);
            scorePopUp.show();

            Button btn = (Button) findViewById(R.id.scoreBtn);
            btn.setText("OT Final Score");
        }
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));

        Context context = getApplicationContext();
        CharSequence text = "Packers (+" + score + ")";
        int duration = Toast.LENGTH_SHORT;

        Toast scorePopUp = Toast.makeText(context, text, duration);
        scorePopUp.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 800);
        scorePopUp.show();
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));

        Context context = getApplicationContext();
        CharSequence text = "Falcons (+" + score + ")";
        int duration = Toast.LENGTH_SHORT;

        Toast scorePopUp = Toast.makeText(context, text, duration);
        scorePopUp.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 800);
        scorePopUp.show();
    }
}

