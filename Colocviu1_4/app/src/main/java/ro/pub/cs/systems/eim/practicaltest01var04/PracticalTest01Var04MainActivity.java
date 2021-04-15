package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    private Button navigate_to_second_activity;
    private Button display_information;
    private TextView display_information_text;
    private EditText name;
    private CheckBox name_check;
    private EditText group;
    private CheckBox group_check;
    String displayText="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        navigate_to_second_activity = (Button) findViewById(R.id.navigate_to_second_activity);

        display_information_text = (TextView) findViewById(R.id.display_information_text);

        display_information = (Button) findViewById(R.id.display_information);
        display_information.setOnClickListener(buttonClickListener);

        name = (EditText) findViewById(R.id.name);
        name.setOnClickListener(buttonClickListener);

        name_check = (CheckBox) findViewById(R.id.name_check);
        name_check.setOnClickListener(buttonClickListener);

        group = (EditText) findViewById(R.id.group);
        group.setOnClickListener(buttonClickListener);

        group_check = (CheckBox) findViewById(R.id.group_check);
        group_check.setOnClickListener(buttonClickListener);


        if (savedInstanceState != null) {
            {
                if (savedInstanceState.containsKey(Constants.USERNAME_EDIT_TEXT)) {
                    EditText usernameEditText = (EditText) findViewById(R.id.name);
                    usernameEditText.setText(savedInstanceState.getString(Constants.USERNAME_EDIT_TEXT));
                }
                if (savedInstanceState.containsKey(Constants.GROUP_EDIT_TEXT)) {
                    EditText passwordEditText = (EditText) findViewById(R.id.group);
                    passwordEditText.setText(savedInstanceState.getString(Constants.GROUP_EDIT_TEXT));
                }
                if (savedInstanceState.containsKey(Constants.REMEMBER_NAME)) {
                    CheckBox rememberMeCheckbox = (CheckBox) findViewById(R.id.name_check);
                    rememberMeCheckbox.setChecked(savedInstanceState.getBoolean(Constants.REMEMBER_NAME));
                }
                if (savedInstanceState.containsKey(Constants.REMEMBER_GROUP)) {
                    CheckBox rememberMeCheckbox = (CheckBox) findViewById(R.id.group_check);
                    rememberMeCheckbox.setChecked(savedInstanceState.getBoolean(Constants.REMEMBER_GROUP));
                }
            }
        }
    }


    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            String nume = name.getText().toString();
            String grupa = group.getText().toString();

            if(view.getId() == R.id.display_information && name_check.isChecked()) {
                displayText = displayText + nume;
            }

            if(view.getId() == R.id.display_information && group_check.isChecked()) {
                displayText = displayText + grupa;
            }

            display_information_text.setText(displayText);
            displayText="";

        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if (group_check.isChecked() && name_check.isChecked()) {
            savedInstanceState.putString(Constants.USERNAME_EDIT_TEXT, name.getText().toString());
            savedInstanceState.putString(Constants.GROUP_EDIT_TEXT, group.getText().toString());
            savedInstanceState.putBoolean(Constants.REMEMBER_NAME, name_check.isChecked());
            savedInstanceState.putBoolean(Constants.REMEMBER_GROUP, group_check.isChecked());
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(Constants.USERNAME_EDIT_TEXT)) {
            EditText usernameEditText = (EditText)findViewById(R.id.name);
            usernameEditText.setText(savedInstanceState.getString(Constants.USERNAME_EDIT_TEXT));
        }
        if (savedInstanceState.containsKey(Constants.GROUP_EDIT_TEXT)) {
            EditText passwordEditText = (EditText)findViewById(R.id.group);
            passwordEditText.setText(savedInstanceState.getString(Constants.GROUP_EDIT_TEXT));
        }
        if (savedInstanceState.containsKey(Constants.REMEMBER_NAME)) {
            CheckBox rememberMeCheckBox = (CheckBox) findViewById(R.id.name_check);
            rememberMeCheckBox.setChecked(savedInstanceState.getBoolean(Constants.REMEMBER_NAME));
        }
        if (savedInstanceState.containsKey(Constants.REMEMBER_GROUP)) {
            CheckBox rememberMeCheckBox = (CheckBox) findViewById(R.id.group_check);
            rememberMeCheckBox.setChecked(savedInstanceState.getBoolean(Constants.REMEMBER_GROUP));
        }
    }


}