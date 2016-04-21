package mx.edu.utng.primefaceslfar.ui.c_tema_iii;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import mx.edu.utng.primefaceslfar.R;
import mx.edu.utng.primefaceslfar.database.DbHelper;
import mx.edu.utng.primefaceslfar.database.Question;

/**
 * Created by Luis Arevalo on 29/03/2016.
 */
public class QuizActivityButton extends AppCompatActivity {
    List<Question> quesList;
    int score = 0;
    int qid = 10;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button butNext;

    TextView time;
    private final int TIEMPO_ESPERA = 60000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        DbHelper db = new DbHelper(this);
        quesList = db.getAllQuestions();
        currentQ = quesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.txv_question);
        final RadioGroup grp = (RadioGroup) findViewById(R.id.rag_panel);
        grp.clearCheck();
        rda = (RadioButton) findViewById(R.id.rab_a);
        rdb = (RadioButton) findViewById(R.id.rab_b);
        rdc = (RadioButton) findViewById(R.id.rab_c);
        butNext = (Button) findViewById(R.id.btn_nextQuestion);

        time = (TextView) findViewById(R.id.txv_time);
        esperar();

        //Toast.makeText(QuizActivityButton.this," son "+DbHelper.holaadios,Toast.LENGTH_SHORT).show();
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                if (!(rda.isChecked() || rdb.isChecked() || rdc.isChecked())) {
                    Toast.makeText(QuizActivityButton.this, "No has contestado la pregunta", Toast.LENGTH_SHORT).show();
                } else {
                    Log.d("yourans", currentQ.getANSWER() + " " + answer.getText());
                    if (currentQ.getANSWER().equals(answer.getText())) {
                        score++;
                        Log.d("score", "Your score" + score);
                    }


                    if (qid < 15) {
                        currentQ = quesList.get(qid);
                        setQuestionView();
                    } else {
                        Intent intent = new Intent(QuizActivityButton.this, ResultActivityButton.class);
                        Bundle b = new Bundle();
                        b.putInt("score", score); //Your score
                        intent.putExtras(b); //Put your score to your next Intent
                        startActivity(intent);
                        finish();
                    }
                }
                grp.clearCheck();
            }
        });
    }


    public void esperar() {
        new CountDownTimer(TIEMPO_ESPERA, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("Tiempo: " + (millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                time.setText("");

                finish();

            }
        }.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }

    private void setQuestionView() {

        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        qid++;


    }
}
