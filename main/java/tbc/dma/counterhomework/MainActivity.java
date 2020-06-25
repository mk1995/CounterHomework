package tbc.dma.counterhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView textView;
    private Button btnCount;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UI();

    }

    public void UI() {
        textView = findViewById(R.id.textView);
        btnCount = findViewById(R.id.btnCount);
        editText = findViewById(R.id.editText);
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countUp();
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("key_name", textView.getText().toString());
        savedInstanceState.putInt("count", mCount);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText("" + savedInstanceState.getString("key_name"));
        mCount = savedInstanceState.getInt("count");
    }

    public void countUp () {
        mCount++;
        if (textView != null)
            textView.setText(Integer.toString(mCount));
    }
}
