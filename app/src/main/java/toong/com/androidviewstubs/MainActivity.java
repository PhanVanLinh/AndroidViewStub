package toong.com.androidviewstubs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewStub viewStub;
    private Button buttonShow;
    private Button buttonHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonShow = findViewById(R.id.buttonShow);
        buttonHide = findViewById(R.id.buttonHide);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showViewStub();
            }
        });

        buttonHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideViewStub();
            }
        });
    }

    private void showViewStub() {
        if (viewStub == null) {
            viewStub = findViewById(R.id.viewStub);

            // If you want to change data of ViewStub at runtime, you can do like this
            View inflatedView = viewStub.inflate();
            TextView textViewInViewStub = inflatedView.findViewById(R.id.textInViewStub);
            textViewInViewStub.setText("ABC");
        }
        viewStub.setVisibility(View.VISIBLE);
    }

    private void hideViewStub() {
        if (viewStub == null) {
            return;
        }
        viewStub.setVisibility(View.GONE);
    }
}
