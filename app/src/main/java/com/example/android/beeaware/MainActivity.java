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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
    }

    // This method starts the quiz and renders question_worker.xml
    public void startQuiz(View view) {
        setContentView(R.layout.question_worker);
    }

    public void answerQuestionWorker(View view) {
        EditText workerField = (EditText) findViewById(R.id.worker_field);
        String worker = workerField.getText().toString();
        if (worker.equalsIgnoreCase("worker")) {
            Toast.makeText(this, getString(R.string.right_answer_confirmation), Toast.LENGTH_SHORT).show();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException ex) {
//            };
            setContentView(R.layout.question_queen);
        } else {
            Toast.makeText(this, getString(R.string.wrong_answer_confirmation), Toast.LENGTH_SHORT).show();
        }
    }

    public void answerQuestionQueen(View view) {
        EditText queenField = (EditText) findViewById(R.id.queen_field);
        String queen = queenField.getText().toString();
        if (queen.equalsIgnoreCase("queen")) {
            Toast.makeText(this, getString(R.string.right_answer_confirmation), Toast.LENGTH_SHORT).show();
            setContentView(R.layout.question_drone);
        } else {
            Toast.makeText(this, getString(R.string.wrong_answer_confirmation), Toast.LENGTH_SHORT).show();
        }
    }

    public void answerQuestionDrone(View view) {
        EditText droneField = (EditText) findViewById(R.id.drone_field);
        String drone = droneField.getText().toString();
        if (drone.equalsIgnoreCase("drone")) {
            Toast.makeText(this, getString(R.string.right_answer_confirmation), Toast.LENGTH_SHORT).show();
            setContentView(R.layout.question_linden);
        } else {
            Toast.makeText(this, getString(R.string.wrong_answer_confirmation), Toast.LENGTH_SHORT).show();
        }
    }

    public void answerQuestionLinden(View view) {
        RadioButton lindenRadioButton = (RadioButton) findViewById(linden_radio_button);
        if (lindenRadioButton.isChecked()) {
            Toast.makeText(this, getString(R.string.right_answer_confirmation), Toast.LENGTH_SHORT).show();
            setContentView(R.layout.question_body_parts);
        } else {
            Toast.makeText(this, getString(R.string.wrong_answer_confirmation), Toast.LENGTH_SHORT).show();
        }
    }

    public void answerQuestionBodyParts(View view) {
        CheckBox rightBodyPartsCheckBox1 = (CheckBox) findViewById(right_body_parts_1);
        CheckBox rightBodyPartsCheckBox2 = (CheckBox) findViewById(right_body_parts_2);
        if (rightBodyPartsCheckBox1.isChecked() && rightBodyPartsCheckBox2.isChecked()) {
            Toast.makeText(this, getString(R.string.right_answer_confirmation), Toast.LENGTH_SHORT).show();
            setContentView(R.layout.end);
        } else {
            Toast.makeText(this, getString(R.string.wrong_answer_confirmation), Toast.LENGTH_SHORT).show();
        }
    }

    public void goToQuestionQueen(View view) {
        setContentView(R.layout.question_queen);
    }

    public void goToQuestionDrone(View view) {
        setContentView(R.layout.question_drone);
    }

    public void goToQuestionLinden(View view) {
        setContentView(R.layout.question_linden);
    }

    public void goToQuestionBodyParts(View view) {
        setContentView(R.layout.question_body_parts);
    }

    public void goToEnd(View view) {
        setContentView(R.layout.end);
    }
}