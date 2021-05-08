package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Create");

        Intent receiveData = getIntent();
        int ranNum = receiveData.getIntExtra("randomNumber", 0);

        User user = new User(
                "MAD " + ranNum,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
                0,
                false
        );

        TextView nameText = findViewById(R.id.name);
        TextView descText = findViewById(R.id.description);
        Button followBtn = findViewById(R.id.follow);

        nameText.setText(user.getName());
        descText.setText(user.getDescription());
        followBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.isFollowed()) {
                    user.setFollowed(false);
                    followBtn.setText("Follow");
                    Toast.makeText(getApplicationContext(), "Unfollowed", LENGTH_SHORT ).show();

                }
                else {
                    user.setFollowed(true);
                    followBtn.setText("Unfollow");
                    Toast.makeText(getApplicationContext(), "Followed", LENGTH_SHORT ).show();
                }
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG, "Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "Resume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TAG, "Pause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG, "Stop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TAG, "Destroy");
    }
}