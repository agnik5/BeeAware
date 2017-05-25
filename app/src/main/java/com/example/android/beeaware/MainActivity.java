package com.example.android.beeaware;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.beeaware.R.id.linden_radio_button;
import static com.example.android.beeaware.R.id.right_body_parts_1;
import static com.example.android.beeaware.R.id.right_body_parts_2;
import static com.example.android.beeaware.R.id.wrong_body_parts_1;
import static com.example.android.beeaware.R.id.wrong_body_parts_2;

/**
 * This app is a quiz about bees using EditText, RadioGroup, RadioButton, CheckBox
 */
public class MainActivity extends AppCompatActivity {

    //This initializes variable to count the score
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
    }

    /**
     * This method starts the quiz and renders question_worker.xml.
     * This method is called when 'Start Quiz' button is clicked.
     */
    public void startQuiz(View view) {
        setContentView(R.layout.question_worker);
    }

    /**
     * This method checks answer for question_worker, updates the score and renders question_queen.xml
     * This method is called when 'Submit Answer' button is clicked.
     */
    public void answerQuestionWorker(View view) {
        //Find proper EditText by its ID and get the answer as String
        EditText workerField = (EditText) findViewById(R.id.worker_field);
        String worker = workerField.getText().toString();
        //Check if answer is correct.
        if (worker.equalsIgnoreCase("worker")) {
            //Display proper Toast, update the score and render xml for next question if answer is correct.
            score +=1;
            Toast.makeText(this, getString(R.string.right_answer_confirmation), Toast.LENGTH_SHORT).show();
            setContentView(R.layout.question_queen);
        } else {
            //Display proper Toast if answer is incorrect.
            Toast.makeText(this, getString(R.string.wrong_answer_confirmation), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method checks answer for question_queen, updates the score and renders question_drone.xml
     * This method is called when 'Submit Answer' button is clicked.
     */
    public void answerQuestionQueen(View view) {
        //Find proper EditText by its ID and get the answer as String
        EditText queenField = (EditText) findViewById(R.id.queen_field);
        String queen = queenField.getText().toString();
        //Check if answer is correct.
        if (queen.equalsIgnoreCase("queen")) {
            //Display proper Toast, update the score and render xml for next question if answer is correct.
            score +=1;
            Toast.makeText(this, getString(R.string.right_answer_confirmation), Toast.LENGTH_SHORT).show();
            setContentView(R.layout.question_drone);
        } else {
            //Display proper Toast if answer is incorrect.
            Toast.makeText(this, getString(R.string.wrong_answer_confirmation), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method checks answer for question_drone, updates the score and renders question_linden.xml
     * This method is called when 'Submit Answer' button is clicked.
     */
    public void answerQuestionDrone(View view) {
        //Find proper EditText by its ID and get the answer as String
        EditText droneField = (EditText) findViewById(R.id.drone_field);
        String drone = droneField.getText().toString();
        //Check if answer is correct.
        if (drone.equalsIgnoreCase("drone")) {
            //Display proper Toast, update the score and render xml for next question if answer is correct.
            score +=1;
            Toast.makeText(this, getString(R.string.right_answer_confirmation), Toast.LENGTH_SHORT).show();
            setContentView(R.layout.question_linden);
        } else {
            //Display proper Toast if answer is incorrect.
            Toast.makeText(this, getString(R.string.wrong_answer_confirmation), Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * This method checks answer for question_linden, updates the score and renders question_body_parts.xml
     * This method is called when 'Submit Answer' button is clicked.
     */
    public void answerQuestionLinden(View view) {
        //Find proper RadioButton by its ID
        RadioButton lindenRadioButton = (RadioButton) findViewById(linden_radio_button);
        //Find out if user chose the right answer by checking this RadioButton
        if (lindenRadioButton.isChecked()) {
            //Display proper Toast, update the score and render xml for next question if answer is correct.
            score +=1;
            Toast.makeText(this, getString(R.string.right_answer_confirmation), Toast.LENGTH_SHORT).show();
            setContentView(R.layout.question_body_parts);
        } else {
            //Display proper Toast if answer is incorrect.
            Toast.makeText(this, getString(R.string.wrong_answer_confirmation), Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * This method checks answer for question_body_parts, updates the score and renders end.xml
     * This method is called when 'Submit Answer' button is clicked.
     */
    public void answerQuestionBodyParts(View view) {
        //Find proper CheckBoxes by their IDs
        CheckBox rightBodyPartsCheckBox1 = (CheckBox) findViewById(right_body_parts_1);
        CheckBox rightBodyPartsCheckBox2 = (CheckBox) findViewById(right_body_parts_2);
        CheckBox wrongBodyPartsCheckBox1 = (CheckBox) findViewById(wrong_body_parts_1);
        CheckBox wrongBodyPartsCheckBox2 = (CheckBox) findViewById(wrong_body_parts_2);
        //Find out if user chose the right answer by checking only two proper CheckBoxes
        if (rightBodyPartsCheckBox1.isChecked() && rightBodyPartsCheckBox2.isChecked() && !wrongBodyPartsCheckBox1.isChecked() && !wrongBodyPartsCheckBox2.isChecked()) {
            //Update the score, display proper Toast with total score and render next xml.
            score +=1;
            Toast.makeText(this, getString(R.string.right_answer_confirmation) + " Your total score is: " + score + " / 5", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.end);
        } else {
            //Display proper Toast if answer is incorrect.
            Toast.makeText(this, getString(R.string.wrong_answer_confirmation), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * These methods render xml file for next question when 'Skip question' button is clicked.
     */
    public void goToQuestionQueen(View view) {
        setContentView(R.layout.question_queen);
        Toast.makeText(this, getString(R.string.skip_information), Toast.LENGTH_SHORT).show();
    }

    public void goToQuestionDrone(View view) {
        setContentView(R.layout.question_drone);
        Toast.makeText(this, getString(R.string.skip_information), Toast.LENGTH_SHORT).show();
    }

    public void goToQuestionLinden(View view) {
        setContentView(R.layout.question_linden);
        Toast.makeText(this, getString(R.string.skip_information), Toast.LENGTH_SHORT).show();
    }

    public void goToQuestionBodyParts(View view) {
        setContentView(R.layout.question_body_parts);
        Toast.makeText(this, getString(R.string.skip_information), Toast.LENGTH_SHORT).show();
    }

    //This method additionally shows total score
    public void goToEnd(View view) {
        setContentView(R.layout.end);
        Toast.makeText(this, getString(R.string.skip_information) + " Your total score is: " + score + " / 5", Toast.LENGTH_SHORT).show();
    }
}