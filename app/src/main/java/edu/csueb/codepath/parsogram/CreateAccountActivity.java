package edu.csueb.codepath.parsogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText etUsernameCreate;
    private EditText etPassowrdCreate;
    private Button btnCreatedAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        etUsernameCreate = findViewById(R.id.etUsernameCreate);
        etPassowrdCreate = findViewById(R.id.etPasswordCreate);
        btnCreatedAccount = findViewById(R.id.btnCreatedAccount);

        btnCreatedAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameCreated = etUsernameCreate.getText().toString();
                String passwordCreated = etPassowrdCreate.getText().toString();
                createAccountUser(usernameCreated, passwordCreated);
                goMainActivity();
            }
        });
    }

    private void createAccountUser(String username, String password) {
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Log.e("CreatedAccount", "Issue with login", e);
                    return;
                }
            }
        });
    }

    private void goMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}