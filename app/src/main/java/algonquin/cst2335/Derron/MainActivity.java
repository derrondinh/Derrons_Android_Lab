package algonquin.cst2335.Derron;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Derron Dinh
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {
    /**
     * This holds the text at the centre of the screen
     */
    private TextView tv = null;
    /**
     * This holds the edit text of the password
     */
    private EditText et = null;
    /**
     * This holds the button to check the password and begin the password checker
     */
    private Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(clk -> {
            String password = et.getText().toString();

            checkPasswordComplexity(password);
        });
    }

    /**
     * This function should check if this String has an upper case, lower case,
     * a number, and a special symbol
     *
     * @param pw The String object that we are checking
     * @return Return true if the password passes the complexity checker
     */
    boolean checkPasswordComplexity(String pw) {
        boolean foundUpperCase = false;
        boolean foundLowerCase = false;
        boolean foundNumber = false;
        boolean foundSpecial = false;
        char currentChar = ' ';

        for (int c = 0; c < pw.length(); c++) {
            currentChar = pw.charAt(c);
            if (Character.isUpperCase(currentChar)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(currentChar)) {
                foundLowerCase = true;
            } else if (Character.isDigit(currentChar)) {
                foundNumber = true;
            } else if (isSpecialCharacter(currentChar)) {
                foundSpecial = true;

            }
        }


        if (!foundUpperCase) {

            Toast.makeText(MainActivity.this, "Need an upper case letter in the password", Toast.LENGTH_SHORT).show();
            tv.setText("YOU SHALL NOT PASS!");
            et.setHint("Try again!");
            return false;
        } else if (!foundLowerCase) {
            Toast.makeText(MainActivity.this, "Need a lower case letter in the password", Toast.LENGTH_SHORT).show();
            tv.setText("YOU SHALL NOT PASS!");
            et.setHint("Try again!");
            return false;
        } else if (!foundNumber) {
            Toast.makeText(MainActivity.this, "Need a number in the password", Toast.LENGTH_SHORT).show();
            tv.setText("YOU SHALL NOT PASS!");
            et.setHint("Try again!");
            return false;
        } else if (!foundSpecial) {
            Toast.makeText(MainActivity.this, "Need a special character in the password", Toast.LENGTH_SHORT).show();
            tv.setText("YOU SHALL NOT PASS!");
            et.setHint("Try again!");
            return false;
        } else {
                tv.setText("Your password meets the requirements");
                et.setHint("");
            return true;
        }
    }
    /**
     * This function will check for special characters
     * @param c the String object that we are using to check for special characters
     * @return returns true or false if the password contains a special character
     */
    boolean isSpecialCharacter ( char c )
    {
        switch (c) {
            case '#':
            case '?':
            case '*':
            case '$':
            case '%':
            case '^':
            case '&':
            case '!':
            case '@':
                return true;
            default:
                return false;
        }
    }
}