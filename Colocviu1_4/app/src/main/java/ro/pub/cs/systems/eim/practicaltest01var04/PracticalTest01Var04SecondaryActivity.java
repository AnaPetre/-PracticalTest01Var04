package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {

    private Button okButton, cancelButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        okButton = (Button)findViewById(R.id.okButton);
        cancelButton = (Button)findViewById(R.id.cancelButton);


        okButton.setOnClickListener(buttonClickListener);
        cancelButton.setOnClickListener(buttonClickListener);

        Intent intent = getIntent();
    }


    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.okButton:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.cancelButton:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }
}