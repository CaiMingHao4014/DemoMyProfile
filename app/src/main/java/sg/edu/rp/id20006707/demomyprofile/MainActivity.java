package sg.edu.rp.id20006707.demomyprofile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView etName, etGpa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etGpa = findViewById(R.id.etGpa);

    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString("name", etName.getText().toString());
        prefsEditor.putFloat("gpa", Float.parseFloat(etGpa.getText().toString()));
        prefsEditor.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String name = prefs.getString("name", "Unknown");
        float gpa = prefs.getFloat("gpa", 0f);
        etName.setText(name);
        etGpa.setText(String.valueOf(gpa));

    }

}