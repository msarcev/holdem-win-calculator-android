

package mario.HoldemCalc;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        //rukovanje klikova na gumove
        View infoButton = findViewById(R.id.info_button );
        View exitButton = findViewById(R.id.exit_button );
        View gameButton = findViewById(R.id.new_button );
        infoButton.setOnClickListener(this);
        exitButton.setOnClickListener(this);
        gameButton.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v)
    {
    	switch (v.getId())
    	{
    	case R.id.info_button :
    		Intent i = new Intent(this, InfoActivity.class );
    		startActivity(i);
    		break;
    	case R.id.exit_button :
    		this.finish();
    		break;
    	case R.id.new_button :
    		Intent j = new Intent(this, CalcActivity.class);
    		startActivity(j);
    		break;
    	}
    }
}