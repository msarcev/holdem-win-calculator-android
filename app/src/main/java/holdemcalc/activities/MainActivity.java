package holdemcalc.activities;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import holdemcalc.R;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        View infoButton = findViewById(R.id.info_button);
        View gameButton = findViewById(R.id.new_button);
        infoButton.setOnClickListener(this);
        gameButton.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v)
    {
    	switch (v.getId())
    	{
            case R.id.new_button :
                Intent j = new Intent(this, CalcActivity.class);
                startActivity(j);
                break;
            case R.id.info_button :
                Intent i = new Intent(this, InfoActivity.class );
                startActivity(i);
                break;
    	}
    }
}