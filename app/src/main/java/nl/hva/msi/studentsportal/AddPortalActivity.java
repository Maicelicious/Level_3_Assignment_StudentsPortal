package nl.hva.msi.studentsportal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPortalActivity extends AppCompatActivity {

    String mTitle;
    String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);

        Button addPortalReminderButton = findViewById(R.id.addPortalButton);
        final EditText title = findViewById(R.id.titleInput);
        final EditText url = findViewById(R.id.urlInput);


        // Adds a onclick Listener to move to the MainView again
        addPortalReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTitle = title.getText().toString();
                mUrl = url.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("url", mUrl);
                intent.putExtra("title", mTitle);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
