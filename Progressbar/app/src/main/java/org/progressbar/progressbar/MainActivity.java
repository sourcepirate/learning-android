package org.progressbar.progressbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.progressBar) GoalProgressBar progressBar;

    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        progressBar.setGoal(70);

        if (savedInstanceState == null) {
            resetProgress();
        }
    }

    @OnClick(R.id.resetProgressBtn)
    public void resetProgress() {
        int prog = random.nextInt(100);
        progressBar.setProgress(prog);
    }
}