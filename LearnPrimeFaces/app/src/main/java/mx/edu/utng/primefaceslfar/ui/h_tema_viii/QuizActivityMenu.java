package mx.edu.utng.primefaceslfar.ui.h_tema_viii;

import android.content.Intent;
import android.os.Bundle;
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
public class QuizActivityMenu extends AppCompatActivity{
    List<Question> quesList;
    int score=0;
    int qid=30;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button butNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        DbHelper db=new DbHelper(this);
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.txv_question);
        rda=(RadioButton)findViewById(R.id.rab_a);
        rdb=(RadioButton)findViewById(R.id.rab_b);
        rdc=(RadioButton)findViewById(R.id.rab_c);
        butNext=(Button)findViewById(R.id.btn_nextQuestion);

        Toast.makeText(QuizActivityMenu.this," son "+DbHelper.holaadios,Toast.LENGTH_SHORT).show();
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp=(RadioGroup)findViewById(R.id.rag_panel);

                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());
                if(currentQ.getANSWER().equals(answer.getText()))
                {
                    score++;
                    Log.d("score", "Your score"+score);
                }


                if(qid<35){
                    currentQ=quesList.get(qid);
                    setQuestionView();
                }else{
                    Intent intent = new Intent(QuizActivityMenu.this, ResultActivityMenu.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }
    private void setQuestionView()
    {

            txtQuestion.setText(currentQ.getQUESTION());
            rda.setText(currentQ.getOPTA());
            rdb.setText(currentQ.getOPTB());
            rdc.setText(currentQ.getOPTC());
            qid++;


    }
}
