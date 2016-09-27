package mario.HoldemCalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class CalcActivity extends Activity  implements OnClickListener{
    /** Called when the activity is first created. */
	private ImageView nextview;
	public int karta;
	public int igrac1karta1;
	public int igrac1karta2;
	public int igrac2karta1;
	public int igrac2karta2;
	public int flop1;
	public int flop2;
	public int flop3;
	public int turn;
	public int river;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);
        
        karta = 1;
        setNextview(karta);
        
        
        
        //diamond listen
        View twodButton = findViewById(R.id.twod);
        View threedButton = findViewById(R.id.threed);
        View fourdButton = findViewById(R.id.fourd);
        View fivedButton = findViewById(R.id.fived);
        View sixdButton = findViewById(R.id.sixd);
        View sevendButton = findViewById(R.id.sevend);
        View eightdButton = findViewById(R.id.eightd);
        View ninedButton = findViewById(R.id.nined);
        View tendButton = findViewById(R.id.tend);
        View jackdButton = findViewById(R.id.jackd);
        View queendButton = findViewById(R.id.queend);
        View kingdButton = findViewById(R.id.kingd);
        View acedButton = findViewById(R.id.aced);
        
        twodButton.setOnClickListener(this);
        threedButton.setOnClickListener(this);
        fourdButton.setOnClickListener(this);
        fivedButton.setOnClickListener(this);
        sixdButton.setOnClickListener(this);
        sevendButton.setOnClickListener(this);
        eightdButton.setOnClickListener(this);
        ninedButton.setOnClickListener(this);
        tendButton.setOnClickListener(this);
        jackdButton.setOnClickListener(this);
        queendButton.setOnClickListener(this);
        kingdButton.setOnClickListener(this);
        acedButton.setOnClickListener(this);
        
        //heart listen
        
        View twohButton = findViewById(R.id.twoh);
        View threehButton = findViewById(R.id.threeh);
        View fourhButton = findViewById(R.id.fourh);
        View fivehButton = findViewById(R.id.fiveh);
        View sixhButton = findViewById(R.id.sixh);
        View sevenhButton = findViewById(R.id.sevenh);
        View eighthButton = findViewById(R.id.eighth);
        View ninehButton = findViewById(R.id.nineh);
        View tenhButton = findViewById(R.id.tenh);
        View jackhButton = findViewById(R.id.jackh);
        View queenhButton = findViewById(R.id.queenh);
        View kinghButton = findViewById(R.id.kingh);
        View acehButton = findViewById(R.id.aceh);
        
        twohButton.setOnClickListener(this);
        threehButton.setOnClickListener(this);
        fourhButton.setOnClickListener(this);
        fivehButton.setOnClickListener(this);
        sixhButton.setOnClickListener(this);
        sevenhButton.setOnClickListener(this);
        eighthButton.setOnClickListener(this);
        ninehButton.setOnClickListener(this);
        tenhButton.setOnClickListener(this);
        jackhButton.setOnClickListener(this);
        queenhButton.setOnClickListener(this);
        kinghButton.setOnClickListener(this);
        acehButton.setOnClickListener(this);
        
        //club listen
        
        View twocButton = findViewById(R.id.twoc);
        View threecButton = findViewById(R.id.threec);
        View fourcButton = findViewById(R.id.fourc);
        View fivecButton = findViewById(R.id.fivec);
        View sixcButton = findViewById(R.id.sixc);
        View sevencButton = findViewById(R.id.sevenc);
        View eightcButton = findViewById(R.id.eightc);
        View ninecButton = findViewById(R.id.ninec);
        View tencButton = findViewById(R.id.tenc);
        View jackcButton = findViewById(R.id.jackc);
        View queencButton = findViewById(R.id.queenc);
        View kingcButton = findViewById(R.id.kingc);
        View acecButton = findViewById(R.id.acec);
        
        twocButton.setOnClickListener(this);
        threecButton.setOnClickListener(this);
        fourcButton.setOnClickListener(this);
        fivecButton.setOnClickListener(this);
        sixcButton.setOnClickListener(this);
        sevencButton.setOnClickListener(this);
        eightcButton.setOnClickListener(this);
        ninecButton.setOnClickListener(this);
        tencButton.setOnClickListener(this);
        jackcButton.setOnClickListener(this);
        queencButton.setOnClickListener(this);
        kingcButton.setOnClickListener(this);
        acecButton.setOnClickListener(this);
        
        //pikovi slušanje
        
        View twosButton = findViewById(R.id.twos);
        View threesButton = findViewById(R.id.threes);
        View foursButton = findViewById(R.id.fours);
        View fivesButton = findViewById(R.id.fives);
        View sixsButton = findViewById(R.id.sixs);
        View sevensButton = findViewById(R.id.sevens);
        View eightsButton = findViewById(R.id.eights);
        View ninesButton = findViewById(R.id.nines);
        View tensButton = findViewById(R.id.tens);
        View jacksButton = findViewById(R.id.jacks);
        View queensButton = findViewById(R.id.queens);
        View kingsButton = findViewById(R.id.kings);
        View acesButton = findViewById(R.id.aces);
        
        twosButton.setOnClickListener(this);
        threesButton.setOnClickListener(this);
        foursButton.setOnClickListener(this);
        fivesButton.setOnClickListener(this);
        sixsButton.setOnClickListener(this);
        sevensButton.setOnClickListener(this);
        eightsButton.setOnClickListener(this);
        ninesButton.setOnClickListener(this);
        tensButton.setOnClickListener(this);
        jacksButton.setOnClickListener(this);
        queensButton.setOnClickListener(this);
        kingsButton.setOnClickListener(this);
        acesButton.setOnClickListener(this);
        
        //poništi
        View ponistiButton = findViewById(R.id.ponisti);
        ponistiButton.setOnClickListener(this);
    }
    
    
 
   
    @Override
	public void onClick(View v){
    	
    	switch (v.getId())
    	{
    	//ponisit
    	case R.id.ponisti:
    		Ponisti();
    	break;
    	//diamond case
    	case R.id.twod :
    		ImageView playerimage2 =  getNextview();
    		playerimage2.setImageDrawable((getResources().getDrawable(R.drawable.twod)));
    		View twodButton = findViewById(R.id.twod);
    		twodButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 2 ;
    		if (karta == 2)igrac1karta2 = 2;
    		if (karta == 3)igrac2karta1 = 2  ;
    		if (karta == 4)igrac2karta2 = 2 ;
    		if (karta == 5)flop1 = 2  ;
    		if (karta == 6)flop2 = 2  ;
    		if (karta == 7)flop3 = 2  ;
    		if (karta == 8)turn = 2  ;
    		if (karta == 9)river = 2  ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	case R.id.threed :
    		ImageView playerimage3 =  getNextview();
    		playerimage3.setImageDrawable((getResources().getDrawable(R.drawable.threed)));
    		View threedButton = findViewById(R.id.threed);
    		threedButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 6 ;
    		if (karta == 2)igrac1karta2 = 6;
    		if (karta == 3)igrac2karta1 = 6  ;
    		if (karta == 4)igrac2karta2 = 6 ;
    		if (karta == 5)flop1 = 6  ;
    		if (karta == 6)flop2 = 6  ;
    		if (karta == 7)flop3 = 6  ;
    		if (karta == 8)turn = 6 ;
    		if (karta == 9)river = 6  ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	case R.id.fourd :
    		ImageView playerimage4 =  getNextview();
    		playerimage4.setImageDrawable((getResources().getDrawable(R.drawable.fourd)));
    		View fourdButton = findViewById(R.id.fourd);
    		fourdButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 10 ;
    		if (karta == 2)igrac1karta2 = 10;
    		if (karta == 3)igrac2karta1 = 10  ;
    		if (karta == 4)igrac2karta2 = 10 ;
    		if (karta == 5)flop1 = 10 ;
    		if (karta == 6)flop2 = 10 ;
    		if (karta == 7)flop3 = 10 ;
    		if (karta == 8)turn = 10;
    		if (karta == 9)river = 10  ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	case R.id.fived :
    		ImageView playerimage5 =  getNextview();
    		playerimage5.setImageDrawable((getResources().getDrawable(R.drawable.fived)));
    		View fivedButton = findViewById(R.id.fived);
    		fivedButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 14 ;
    		if (karta == 2)igrac1karta2 = 14;
    		if (karta == 3)igrac2karta1 = 14  ;
    		if (karta == 4)igrac2karta2 = 14 ;
    		if (karta == 5)flop1 = 14  ;
    		if (karta == 6)flop2 = 14 ;
    		if (karta == 7)flop3 = 14 ;
    		if (karta == 8)turn = 14  ;
    		if (karta == 9)river = 14  ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	case R.id.sixd :
    		ImageView playerimage6 =  getNextview();
    		playerimage6.setImageDrawable((getResources().getDrawable(R.drawable.sixd)));
    		View sixdButton = findViewById(R.id.sixd);
    		sixdButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 18 ;
    		if (karta == 2)igrac1karta2 = 18;
    		if (karta == 3)igrac2karta1 = 18  ;
    		if (karta == 4)igrac2karta2 = 18 ;
    		if (karta == 5)flop1 = 18  ;
    		if (karta == 6)flop2 = 18  ;
    		if (karta == 7)flop3 = 18  ;
    		if (karta == 8)turn = 18  ;
    		if (karta == 9)river = 18  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.sevend :
    		ImageView playerimage7 =  getNextview();
    		playerimage7.setImageDrawable((getResources().getDrawable(R.drawable.sevend)));
    		View sevendButton = findViewById(R.id.sevend);
    		sevendButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 22 ;
    		if (karta == 2)igrac1karta2 = 22;
    		if (karta == 3)igrac2karta1 = 22  ;
    		if (karta == 4)igrac2karta2 = 22 ;
    		if (karta == 5)flop1 = 22  ;
    		if (karta == 6)flop2 = 22  ;
    		if (karta == 7)flop3 = 22  ;
    		if (karta == 8)turn = 22  ;
    		if (karta == 9)river = 22  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.eightd :
    		ImageView playerimage8 =  getNextview();
    		playerimage8.setImageDrawable((getResources().getDrawable(R.drawable.eightd)));
    		View eightdButton = findViewById(R.id.eightd);
    		eightdButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 26 ;
    		if (karta == 2)igrac1karta2 = 26;
    		if (karta == 3)igrac2karta1 = 26  ;
    		if (karta == 4)igrac2karta2 = 26 ;
    		if (karta == 5)flop1 = 26  ;
    		if (karta == 6)flop2 = 26  ;
    		if (karta == 7)flop3 = 26  ;
    		if (karta == 8)turn = 26  ;
    		if (karta == 9)river = 26  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.nined :
    		ImageView playerimage9 =  getNextview();
    		playerimage9.setImageDrawable((getResources().getDrawable(R.drawable.nined)));
    		View ninedButton = findViewById(R.id.nined);
    		ninedButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 30 ;
    		if (karta == 2)igrac1karta2 = 30;
    		if (karta == 3)igrac2karta1 = 30  ;
    		if (karta == 4)igrac2karta2 = 30 ;
    		if (karta == 5)flop1 = 30  ;
    		if (karta == 6)flop2 = 30  ;
    		if (karta == 7)flop3 = 30  ;
    		if (karta == 8)turn = 30  ;
    		if (karta == 9)river = 30  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.tend :
    		ImageView playerimage10 =  getNextview();
    		playerimage10.setImageDrawable((getResources().getDrawable(R.drawable.tend)));
    		View tendButton = findViewById(R.id.tend);
    		tendButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 34  ;
    		if (karta == 2)igrac1karta2 = 34  ;
    		if (karta == 3)igrac2karta1 = 34  ;
    		if (karta == 4)igrac2karta2 = 34 ;
    		if (karta == 5)flop1   =      34  ;
    		if (karta == 6)flop2   =      34  ;
    		if (karta == 7)flop3   =      34  ;
    		if (karta == 8)turn    =      34  ;
    		if (karta == 9)river   =      34  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.jackd :
    		ImageView playerimage11 =  getNextview();
    		playerimage11.setImageDrawable((getResources().getDrawable(R.drawable.jd)));
    		View jackdButton = findViewById(R.id.jackd);
    		jackdButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 38  ;
    		if (karta == 2)igrac1karta2 = 38  ;
    		if (karta == 3)igrac2karta1 = 38  ;
    		if (karta == 4)igrac2karta2 = 38 ;
    		if (karta == 5)flop1   =      38  ;
    		if (karta == 6)flop2   =      38  ;
    		if (karta == 7)flop3   =      38  ;
    		if (karta == 8)turn    =      38  ;
    		if (karta == 9)river   =      38  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.queend :
    		ImageView playerimage12 =  getNextview();
    		playerimage12.setImageDrawable((getResources().getDrawable(R.drawable.qd)));
    		View queendButton = findViewById(R.id.queend);
    		queendButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 42  ;
    		if (karta == 2)igrac1karta2 = 42  ;
    		if (karta == 3)igrac2karta1 = 42  ;
    		if (karta == 4)igrac2karta2 = 42 ;
    		if (karta == 5)flop1   =      42  ;
    		if (karta == 6)flop2   =      42  ;
    		if (karta == 7)flop3   =      42  ;
    		if (karta == 8)turn    =      42  ;
    		if (karta == 9)river   =      42  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.kingd :
    		ImageView playerimage13 =  getNextview();
    		playerimage13.setImageDrawable((getResources().getDrawable(R.drawable.kd)));
    		View kingdButton = findViewById(R.id.kingd);
    		kingdButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 46  ;
    		if (karta == 2)igrac1karta2 = 46  ;
    		if (karta == 3)igrac2karta1 = 46  ;
    		if (karta == 4)igrac2karta2 = 46 ;
    		if (karta == 5)flop1   =      46  ;
    		if (karta == 6)flop2   =      46  ;
    		if (karta == 7)flop3   =      46  ;
    		if (karta == 8)turn    =      46  ;
    		if (karta == 9)river   =      46  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.aced :
    		ImageView playerimage14 =  getNextview();
    		playerimage14.setImageDrawable((getResources().getDrawable(R.drawable.ad)));
    		View acedButton = findViewById(R.id.aced);
    		acedButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 50  ;
    		if (karta == 2)igrac1karta2 = 50  ;
    		if (karta == 3)igrac2karta1 = 50  ;
    		if (karta == 4)igrac2karta2 = 50 ;
    		if (karta == 5)flop1   =      50  ;
    		if (karta == 6)flop2   =      50  ;
    		if (karta == 7)flop3   =      50  ;
    		if (karta == 8)turn    =      50  ;
    		if (karta == 9)river   =      50  ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	//SRCA
    		
    	case R.id.twoh :
    		ImageView playerimage15 =  getNextview();
    		playerimage15.setImageDrawable((getResources().getDrawable(R.drawable.twoh)));
    		View twohButton = findViewById(R.id.twoh);
    		twohButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 3  ;
    		if (karta == 2)igrac1karta2 = 3  ;
    		if (karta == 3)igrac2karta1 = 3  ;
    		if (karta == 4)igrac2karta2 = 3 ;
    		if (karta == 5)flop1   =      3  ;
    		if (karta == 6)flop2   =      3  ;
    		if (karta == 7)flop3   =      3  ;
    		if (karta == 8)turn    =      3  ;
    		if (karta == 9)river   =      3  ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	case R.id.threeh :
    		ImageView playerimage16 =  getNextview();
    		playerimage16.setImageDrawable((getResources().getDrawable(R.drawable.threeh)));
    		View threehButton = findViewById(R.id.threeh);
    		threehButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 7  ;
    		if (karta == 2)igrac1karta2 = 7  ;
    		if (karta == 3)igrac2karta1 = 7  ;
    		if (karta == 4)igrac2karta2 = 7 ;
    		if (karta == 5)flop1   =      7  ;
    		if (karta == 6)flop2   =      7  ;
    		if (karta == 7)flop3   =      7  ;
    		if (karta == 8)turn    =      7  ;
    		if (karta == 9)river   =      7  ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	case R.id.fourh :
    		ImageView playerimage17 =  getNextview();
    		playerimage17.setImageDrawable((getResources().getDrawable(R.drawable.fourh)));
    		View fourhButton = findViewById(R.id.fourh);
    		fourhButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 11  ;
    		if (karta == 2)igrac1karta2 = 11  ;
    		if (karta == 3)igrac2karta1 = 11  ;
    		if (karta == 4)igrac2karta2 = 11 ;
    		if (karta == 5)flop1   =      11  ;
    		if (karta == 6)flop2   =      11  ;
    		if (karta == 7)flop3   =      11  ;
    		if (karta == 8)turn    =      11  ;
    		if (karta == 9)river   =      11  ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	case R.id.fiveh :
    		ImageView playerimage18 =  getNextview();
    		playerimage18.setImageDrawable((getResources().getDrawable(R.drawable.fiveh)));
    		View fivehButton = findViewById(R.id.fiveh);
    		fivehButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 15  ;
    		if (karta == 2)igrac1karta2 = 15  ;
    		if (karta == 3)igrac2karta1 = 15  ;
    		if (karta == 4)igrac2karta2 = 15 ;
    		if (karta == 5)flop1   =      15  ;
    		if (karta == 6)flop2   =      15  ;
    		if (karta == 7)flop3   =      15  ;
    		if (karta == 8)turn    =      15  ;
    		if (karta == 9)river   =      15  ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	case R.id.sixh :
    		ImageView playerimage19 =  getNextview();
    		playerimage19.setImageDrawable((getResources().getDrawable(R.drawable.sixh)));
    		View sixhButton = findViewById(R.id.sixh);
    		sixhButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 19  ;
    		if (karta == 2)igrac1karta2 = 19  ;
    		if (karta == 3)igrac2karta1 = 19  ;
    		if (karta == 4)igrac2karta2 = 19 ;
    		if (karta == 5)flop1   =      19  ;
    		if (karta == 6)flop2   =      19  ;
    		if (karta == 7)flop3   =      19  ;
    		if (karta == 8)turn    =      19  ;
    		if (karta == 9)river   =      19  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.sevenh:
    		ImageView playerimage20 =  getNextview();
    		playerimage20.setImageDrawable((getResources().getDrawable(R.drawable.sevenh)));
    		View sevenhButton = findViewById(R.id.sevenh);
    		sevenhButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 23  ;
    		if (karta == 2)igrac1karta2 = 23  ;
    		if (karta == 3)igrac2karta1 = 23  ;
    		if (karta == 4)igrac2karta2 = 23 ;
    		if (karta == 5)flop1   =      23  ;
    		if (karta == 6)flop2   =      23  ;
    		if (karta == 7)flop3   =      23  ;
    		if (karta == 8)turn    =      23  ;
    		if (karta == 9)river   =      23  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.eighth :
    		ImageView playerimage21=  getNextview();
    		playerimage21.setImageDrawable((getResources().getDrawable(R.drawable.eighth)));
    		View eighthButton = findViewById(R.id.eighth);
    		eighthButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 27  ;
    		if (karta == 2)igrac1karta2 = 27  ;
    		if (karta == 3)igrac2karta1 = 27  ;
    		if (karta == 4)igrac2karta2 = 27 ;
    		if (karta == 5)flop1   =      27  ;
    		if (karta == 6)flop2   =      27  ;
    		if (karta == 7)flop3   =      27  ;
    		if (karta == 8)turn    =      27  ;
    		if (karta == 9)river   =      27  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.nineh :
    		ImageView playerimage22 =  getNextview();
    		playerimage22.setImageDrawable((getResources().getDrawable(R.drawable.nineh)));
    		View ninehButton = findViewById(R.id.nineh);
    		ninehButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 31  ;
    		if (karta == 2)igrac1karta2 = 31  ;
    		if (karta == 3)igrac2karta1 = 31  ;
    		if (karta == 4)igrac2karta2 = 31 ;
    		if (karta == 5)flop1   =      31  ;
    		if (karta == 6)flop2   =      31  ;
    		if (karta == 7)flop3   =      31  ;
    		if (karta == 8)turn    =      31  ;
    		if (karta == 9)river   =      31  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.tenh :
    		ImageView playerimage23 =  getNextview();
    		playerimage23.setImageDrawable((getResources().getDrawable(R.drawable.tenh)));
    		View tenhButton = findViewById(R.id.tenh);
    		tenhButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 35  ;
    		if (karta == 2)igrac1karta2 = 35  ;
    		if (karta == 3)igrac2karta1 = 35  ;
    		if (karta == 4)igrac2karta2 = 35 ;
    		if (karta == 5)flop1   =      35  ;
    		if (karta == 6)flop2   =      35  ;
    		if (karta == 7)flop3   =      35  ;
    		if (karta == 8)turn    =      35  ;
    		if (karta == 9)river   =      35  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.jackh :
    		ImageView playerimage24 =  getNextview();
    		playerimage24.setImageDrawable((getResources().getDrawable(R.drawable.jh)));
    		View jackhButton = findViewById(R.id.jackh);
    		jackhButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 39  ;
    		if (karta == 2)igrac1karta2 = 39  ;
    		if (karta == 3)igrac2karta1 = 39  ;
    		if (karta == 4)igrac2karta2 = 39 ;
    		if (karta == 5)flop1   =      39  ;
    		if (karta == 6)flop2   =      39  ;
    		if (karta == 7)flop3   =      39  ;
    		if (karta == 8)turn    =      39  ;
    		if (karta == 9)river   =      39  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.queenh :
    		ImageView playerimage25 =  getNextview();
    		playerimage25.setImageDrawable((getResources().getDrawable(R.drawable.qh)));
    		View queenhButton = findViewById(R.id.queenh);
    		queenhButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 43  ;
    		if (karta == 2)igrac1karta2 = 43  ;
    		if (karta == 3)igrac2karta1 = 43  ;
    		if (karta == 4)igrac2karta2 = 43 ;
    		if (karta == 5)flop1   =      43  ;
    		if (karta == 6)flop2   =      43  ;
    		if (karta == 7)flop3   =      43  ;
    		if (karta == 8)turn    =      43  ;
    		if (karta == 9)river   =      43  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.kingh :
    		ImageView playerimage26 =  getNextview();
    		playerimage26.setImageDrawable((getResources().getDrawable(R.drawable.kh)));
    		View kinghButton = findViewById(R.id.kingh);
    		kinghButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 47  ;
    		if (karta == 2)igrac1karta2 = 47  ;
    		if (karta == 3)igrac2karta1 = 47  ;
    		if (karta == 4)igrac2karta2 = 47 ;
    		if (karta == 5)flop1   =      47  ;
    		if (karta == 6)flop2   =      47  ;
    		if (karta == 7)flop3   =      47  ;
    		if (karta == 8)turn    =      47  ;
    		if (karta == 9)river   =      47  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.aceh :
    		ImageView playerimage27 =  getNextview();
    		playerimage27.setImageDrawable((getResources().getDrawable(R.drawable.ah)));
    		View acehButton = findViewById(R.id.aceh);
    		acehButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 51  ;
    		if (karta == 2)igrac1karta2 = 51  ;
    		if (karta == 3)igrac2karta1 = 51  ;
    		if (karta == 4)igrac2karta2 = 51 ;
    		if (karta == 5)flop1   =      51  ;
    		if (karta == 6)flop2   =      51  ;
    		if (karta == 7)flop3   =      51  ;
    		if (karta == 8)turn    =      51  ;
    		if (karta == 9)river   =      51  ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	//TREF!!
    		
    	case R.id.twoc :
    		ImageView playerimage28 =  getNextview();
    		playerimage28.setImageDrawable((getResources().getDrawable(R.drawable.twoc)));
    		View twocButton = findViewById(R.id.twoc);
    		twocButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 1  ;
    		if (karta == 2)igrac1karta2 = 1  ;
    		if (karta == 3)igrac2karta1 = 1  ;
    		if (karta == 4)igrac2karta2 = 1 ;
    		if (karta == 5)flop1   =      1  ;
    		if (karta == 6)flop2   =      1  ;
    		if (karta == 7)flop3   =      1  ;
    		if (karta == 8)turn    =      1  ;
    		if (karta == 9)river   =      1  ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	case R.id.threec :
    		ImageView playerimage29 =  getNextview();
    		playerimage29.setImageDrawable((getResources().getDrawable(R.drawable.threec)));
    		View threecButton = findViewById(R.id.threec);
    		threecButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 5  ;
    		if (karta == 2)igrac1karta2 = 5  ;
    		if (karta == 3)igrac2karta1 = 5  ;
    		if (karta == 4)igrac2karta2 = 5 ;
    		if (karta == 5)flop1   =      5  ;
    		if (karta == 6)flop2   =      5  ;
    		if (karta == 7)flop3   =      5  ;
    		if (karta == 8)turn    =      5  ;
    		if (karta == 9)river   =      5  ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	case R.id.fourc :
    		ImageView playerimage30 =  getNextview();
    		playerimage30.setImageDrawable((getResources().getDrawable(R.drawable.fourc)));
    		View fourcButton = findViewById(R.id.fourc);
    		fourcButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 9  ;
    		if (karta == 2)igrac1karta2 = 9  ;
    		if (karta == 3)igrac2karta1 = 9  ;
    		if (karta == 4)igrac2karta2 = 9 ;
    		if (karta == 5)flop1   =      9  ;
    		if (karta == 6)flop2   =      9  ;
    		if (karta == 7)flop3   =      9  ;
    		if (karta == 8)turn    =      9  ;
    		if (karta == 9)river   =      9  ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	case R.id.fivec :
    		ImageView playerimage31 =  getNextview();
    		playerimage31.setImageDrawable((getResources().getDrawable(R.drawable.fivec)));
    		View fivecButton = findViewById(R.id.fivec);
    		fivecButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 13  ;
    		if (karta == 2)igrac1karta2 = 13  ;
    		if (karta == 3)igrac2karta1 = 13  ;
    		if (karta == 4)igrac2karta2 = 13 ;
    		if (karta == 5)flop1   =      13 ;
    		if (karta == 6)flop2   =      13 ;
    		if (karta == 7)flop3   =      13 ;
    		if (karta == 8)turn    =      13 ;
    		if (karta == 9)river   =      13 ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	case R.id.sixc :
    		ImageView playerimage32 =  getNextview();
    		playerimage32.setImageDrawable((getResources().getDrawable(R.drawable.sixc)));
    		View sixcButton = findViewById(R.id.sixc);
    		sixcButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 17  ;
    		if (karta == 2)igrac1karta2 = 17 ;
    		if (karta == 3)igrac2karta1 = 17  ;
    		if (karta == 4)igrac2karta2 = 17 ;
    		if (karta == 5)flop1   =      17 ;
    		if (karta == 6)flop2   =      17 ;
    		if (karta == 7)flop3   =      17 ;
    		if (karta == 8)turn    =      17 ;
    		if (karta == 9)river   =      17 ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.sevenc :
    		ImageView playerimage33 =  getNextview();
    		playerimage33.setImageDrawable((getResources().getDrawable(R.drawable.sevenc)));
    		View sevencButton = findViewById(R.id.sevenc);
    		sevencButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 21  ;
    		if (karta == 2)igrac1karta2 = 21  ;
    		if (karta == 3)igrac2karta1 = 21  ;
    		if (karta == 4)igrac2karta2 = 21 ;
    		if (karta == 5)flop1   =      21  ;
    		if (karta == 6)flop2   =      21  ;
    		if (karta == 7)flop3   =      21  ;
    		if (karta == 8)turn    =      21  ;
    		if (karta == 9)river   =      21  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.eightc :
    		ImageView playerimage34 =  getNextview();
    		playerimage34.setImageDrawable((getResources().getDrawable(R.drawable.eightc)));
    		View eightcButton = findViewById(R.id.eightc);
    		eightcButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 25  ;
    		if (karta == 2)igrac1karta2 = 25 ;
    		if (karta == 3)igrac2karta1 = 25  ;
    		if (karta == 4)igrac2karta2 = 25 ;
    		if (karta == 5)flop1   =      25 ;
    		if (karta == 6)flop2   =      25 ;
    		if (karta == 7)flop3   =      25 ;
    		if (karta == 8)turn    =      25 ;
    		if (karta == 9)river   =      25 ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.ninec :
    		ImageView playerimage35 =  getNextview();
    		playerimage35.setImageDrawable((getResources().getDrawable(R.drawable.ninec)));
    		View ninecButton = findViewById(R.id.ninec);
    		ninecButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 29  ;
    		if (karta == 2)igrac1karta2 = 29 ;
    		if (karta == 3)igrac2karta1 = 29  ;
    		if (karta == 4)igrac2karta2 = 29 ;
    		if (karta == 5)flop1   =     29  ;
    		if (karta == 6)flop2   =      29  ;
    		if (karta == 7)flop3   =      29 ;
    		if (karta == 8)turn    =      29 ;
    		if (karta == 9)river   =      29 ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.tenc :
    		ImageView playerimage36 =  getNextview();
    		playerimage36.setImageDrawable((getResources().getDrawable(R.drawable.tenc)));
    		View tencButton = findViewById(R.id.tenc);
    		tencButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 33  ;
    		if (karta == 2)igrac1karta2 = 33 ;
    		if (karta == 3)igrac2karta1 = 33  ;
    		if (karta == 4)igrac2karta2 = 33 ;
    		if (karta == 5)flop1   =      33 ;
    		if (karta == 6)flop2   =      33 ;
    		if (karta == 7)flop3   =      33 ;
    		if (karta == 8)turn    =      33 ;
    		if (karta == 9)river   =      33 ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.jackc :
    		ImageView playerimage37 =  getNextview();
    		playerimage37.setImageDrawable((getResources().getDrawable(R.drawable.jc)));
    		View jackcButton = findViewById(R.id.jackc);
    		jackcButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 37 ;
    		if (karta == 2)igrac1karta2 = 37 ;
    		if (karta == 3)igrac2karta1 = 37  ;
    		if (karta == 4)igrac2karta2 = 37 ;
    		if (karta == 5)flop1   =      37 ;
    		if (karta == 6)flop2   =      37 ;
    		if (karta == 7)flop3   =      37 ;
    		if (karta == 8)turn    =      37 ;
    		if (karta == 9)river   =      37 ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.queenc :
    		ImageView playerimage38 =  getNextview();
    		playerimage38.setImageDrawable((getResources().getDrawable(R.drawable.qc)));
    		View queencButton = findViewById(R.id.queenc);
    		queencButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 41  ;
    		if (karta == 2)igrac1karta2 = 41  ;
    		if (karta == 3)igrac2karta1 = 41  ;
    		if (karta == 4)igrac2karta2 = 41 ;
    		if (karta == 5)flop1   =      41  ;
    		if (karta == 6)flop2   =      41  ;
    		if (karta == 7)flop3   =      41  ;
    		if (karta == 8)turn    =      41  ;
    		if (karta == 9)river   =      41  ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.kingc :
    		ImageView playerimage39 =  getNextview();
    		playerimage39.setImageDrawable((getResources().getDrawable(R.drawable.kc)));
    		View kingcButton = findViewById(R.id.kingc);
    		kingcButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 45  ;
    		if (karta == 2)igrac1karta2 = 45 ;
    		if (karta == 3)igrac2karta1 = 45  ;
    		if (karta == 4)igrac2karta2 = 45 ;
    		if (karta == 5)flop1   =      45 ;
    		if (karta == 6)flop2   =      45 ;
    		if (karta == 7)flop3   =      45 ;
    		if (karta == 8)turn    =      45 ;
    		if (karta == 9)river   =      45 ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.acec :
    		ImageView playerimage40 =  getNextview();
    		playerimage40.setImageDrawable((getResources().getDrawable(R.drawable.ac)));
    		View acecButton = findViewById(R.id.acec);
    		acecButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 49  ;
    		if (karta == 2)igrac1karta2 = 49 ;
    		if (karta == 3)igrac2karta1 = 49  ;
    		if (karta == 4)igrac2karta2 = 49 ;
    		if (karta == 5)flop1   =      49  ;
    		if (karta == 6)flop2   =      49  ;
    		if (karta == 7)flop3   =      49;
    		if (karta == 8)turn    =      49 ;
    		if (karta == 9)river   =      49 ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	//PIKOVI
    		
    		
    	case R.id.twos :
    		ImageView playerimage41 =  getNextview();
    		playerimage41.setImageDrawable((getResources().getDrawable(R.drawable.twos)));
    		View twosButton = findViewById(R.id.twos);
    		twosButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 4  ;
    		if (karta == 2)igrac1karta2 = 4  ;
    		if (karta == 3)igrac2karta1 = 4  ;
    		if (karta == 4)igrac2karta2 = 4 ;
    		if (karta == 5)flop1   =      4  ;
    		if (karta == 6)flop2   =      4  ;
    		if (karta == 7)flop3   =      4  ;
    		if (karta == 8)turn    =      4  ;
    		if (karta == 9)river   =      4  ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	case R.id.threes :
    		ImageView playerimage42 =  getNextview();
    		playerimage42.setImageDrawable((getResources().getDrawable(R.drawable.threes)));
    		View threesButton = findViewById(R.id.threes);
    		threesButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 8 ;
    		if (karta == 2)igrac1karta2 = 8  ;
    		if (karta == 3)igrac2karta1 = 8  ;
    		if (karta == 4)igrac2karta2 = 8 ;
    		if (karta == 5)flop1   =      8  ;
    		if (karta == 6)flop2   =      8  ;
    		if (karta == 7)flop3   =     8  ;
    		if (karta == 8)turn    =      8  ;
    		if (karta == 9)river   =      8  ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	case R.id.fours :
    		ImageView playerimage43 =  getNextview();
    		playerimage43.setImageDrawable((getResources().getDrawable(R.drawable.fours)));
    		View foursButton = findViewById(R.id.fours);
    		foursButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 12  ;
    		if (karta == 2)igrac1karta2 = 12  ;
    		if (karta == 3)igrac2karta1 = 12  ;
    		if (karta == 4)igrac2karta2 = 12 ;
    		if (karta == 5)flop1   =      12  ;
    		if (karta == 6)flop2   =      12  ;
    		if (karta == 7)flop3   =      12  ;
    		if (karta == 8)turn    =      12 ;
    		if (karta == 9)river   =      12  ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	case R.id.fives :
    		ImageView playerimage44 =  getNextview();
    		playerimage44.setImageDrawable((getResources().getDrawable(R.drawable.fives)));
    		View fivesButton = findViewById(R.id.fives);
    		fivesButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 16  ;
    		if (karta == 2)igrac1karta2 = 16  ;
    		if (karta == 3)igrac2karta1 = 16  ;
    		if (karta == 4)igrac2karta2 = 16 ;
    		if (karta == 5)flop1   =      16  ;
    		if (karta == 6)flop2   =      16  ;
    		if (karta == 7)flop3   =      16  ;
    		if (karta == 8)turn    =      16  ;
    		if (karta == 9)river   =      16  ;
    		karta++;
    		setNextview(karta);
    		break;
    		
    	case R.id.sixs :
    		ImageView playerimage45 =  getNextview();
    		playerimage45.setImageDrawable((getResources().getDrawable(R.drawable.sixs)));
    		View sixsButton = findViewById(R.id.sixs);
    		sixsButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 20  ;
    		if (karta == 2)igrac1karta2 = 20 ;
    		if (karta == 3)igrac2karta1 = 20  ;
    		if (karta == 4)igrac2karta2 = 20 ;
    		if (karta == 5)flop1   =      20 ;
    		if (karta == 6)flop2   =      20 ;
    		if (karta == 7)flop3   =      20 ;
    		if (karta == 8)turn    =      20 ;
    		if (karta == 9)river   =      20 ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.sevens :
    		ImageView playerimage46 =  getNextview();
    		playerimage46.setImageDrawable((getResources().getDrawable(R.drawable.sevens)));
    		View sevensButton = findViewById(R.id.sevens);
    		sevensButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 24  ;
    		if (karta == 2)igrac1karta2 = 24 ;
    		if (karta == 3)igrac2karta1 = 24  ;
    		if (karta == 4)igrac2karta2 = 24 ;
    		if (karta == 5)flop1   =      24 ;
    		if (karta == 6)flop2   =      24 ;
    		if (karta == 7)flop3   =      24 ;
    		if (karta == 8)turn    =      24 ;
    		if (karta == 9)river   =      24 ; 
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.eights :
    		ImageView playerimage47 =  getNextview();
    		playerimage47.setImageDrawable((getResources().getDrawable(R.drawable.eights)));
    		View eightsButton = findViewById(R.id.eights);
    		eightsButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 28  ;
    		if (karta == 2)igrac1karta2 = 28 ;
    		if (karta == 3)igrac2karta1 = 28  ;
    		if (karta == 4)igrac2karta2 = 28 ;
    		if (karta == 5)flop1   =      28 ;
    		if (karta == 6)flop2   =      28 ;
    		if (karta == 7)flop3   =      28 ;
    		if (karta == 8)turn    =      28 ;
    		if (karta == 9)river   =      28 ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.nines :
    		ImageView playerimage48 =  getNextview();
    		playerimage48.setImageDrawable((getResources().getDrawable(R.drawable.nines)));
    		View ninesButton = findViewById(R.id.nines);
    		ninesButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 32 ;
    		if (karta == 2)igrac1karta2 = 32 ;
    		if (karta == 3)igrac2karta1 = 32  ;
    		if (karta == 4)igrac2karta2 = 32 ;
    		if (karta == 5)flop1   =      32 ;
    		if (karta == 6)flop2   =      32 ;
    		if (karta == 7)flop3   =      32 ;
    		if (karta == 8)turn    =      32 ;
    		if (karta == 9)river   =      32 ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.tens :
    		ImageView playerimage49 =  getNextview();
    		playerimage49.setImageDrawable((getResources().getDrawable(R.drawable.tens)));
    		View tensButton = findViewById(R.id.tens);
    		tensButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 36 ;
    		if (karta == 2)igrac1karta2 = 36 ;
    		if (karta == 3)igrac2karta1 = 36  ;
    		if (karta == 4)igrac2karta2 = 36 ;
    		if (karta == 5)flop1   =      36 ;
    		if (karta == 6)flop2   =      36 ;
    		if (karta == 7)flop3   =      36 ;
    		if (karta == 8)turn    =      36 ;
    		if (karta == 9)river   =      36 ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.jacks :
    		ImageView playerimage50 =  getNextview();
    		playerimage50.setImageDrawable((getResources().getDrawable(R.drawable.js)));
    		View jacksButton = findViewById(R.id.jacks);
    		jacksButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 40  ;
    		if (karta == 2)igrac1karta2 = 40 ;
    		if (karta == 3)igrac2karta1 = 40  ;
    		if (karta == 4)igrac2karta2 = 40 ;
    		if (karta == 5)flop1   =      40 ;
    		if (karta == 6)flop2   =      40 ;
    		if (karta == 7)flop3   =      40 ;
    		if (karta == 8)turn    =      40 ;
    		if (karta == 9)river   =      40 ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.queens :
    		ImageView playerimage51 =  getNextview();
    		playerimage51.setImageDrawable((getResources().getDrawable(R.drawable.qs)));
    		View queensButton = findViewById(R.id.queens);
    		queensButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 44 ;
    		if (karta == 2)igrac1karta2 = 44 ;
    		if (karta == 3)igrac2karta1 = 44  ;
    		if (karta == 4)igrac2karta2 = 44 ;
    		if (karta == 5)flop1   =      44 ;
    		if (karta == 6)flop2   =      44 ;
    		if (karta == 7)flop3   =      44 ;
    		if (karta == 8)turn    =      44 ;
    		if (karta == 9)river   =      44 ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.kings :
    		ImageView playerimage52 =  getNextview();
    		playerimage52.setImageDrawable((getResources().getDrawable(R.drawable.ks)));
    		View kingsButton = findViewById(R.id.kings);
    		kingsButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 48  ;
    		if (karta == 2)igrac1karta2 = 48 ;
    		if (karta == 3)igrac2karta1 = 48  ;
    		if (karta == 4)igrac2karta2 = 48 ;
    		if (karta == 5)flop1   =      48 ;
    		if (karta == 6)flop2   =      48 ;
    		if (karta == 7)flop3   =      48 ;
    		if (karta == 8)turn    =      48 ;
    		if (karta == 9)river   =      48 ;
    		karta++;
    		setNextview(karta);
    		break;
    	case R.id.aces :
    		ImageView playerimage53 =  getNextview();
    		playerimage53.setImageDrawable((getResources().getDrawable(R.drawable.as)));
    		View acesButton = findViewById(R.id.aces);
    		acesButton.setEnabled(false);
    		if (karta == 1)igrac1karta1 = 52  ;
    		if (karta == 2)igrac1karta2 = 52 ;
    		if (karta == 3)igrac2karta1 = 52  ;
    		if (karta == 4)igrac2karta2 = 52 ;
    		if (karta == 5)flop1   =      52 ;
    		if (karta == 6)flop2   =      52 ;
    		if (karta == 7)flop3   =      52 ;
    		if (karta == 8)turn    =      52 ;
    		if (karta == 9)river   =      52 ;
    		karta++;
    		setNextview(karta);
    		break;
    	}
    	
    	if (karta == 5)
    	{
    		IspisiVjerojatnostipoket();
    	}
    	
    	if (karta == 8)
    	{
    		IspisiVjerojatnostiflop();
    	}
 	
    
    	if (karta == 9)
    	{
    		IspisiVjerojatnostiturn();
    	}
    	   	
    	if (karta == 10)
    	{
    		IspisiVjerojatnostiriver();
    	}
    	
    }

    
  

	public void setNextview(int broj) {


		switch (broj)
		{
		case 1 :
		this.nextview = (ImageView) findViewById(R.id.player1card1);
		break;
		case 2 :
		this.nextview = (ImageView) findViewById(R.id.player1card2);
		break;
		case 3 :
		this.nextview = (ImageView) findViewById(R.id.player2card1);
		break;
		case 4 :
		this.nextview = (ImageView) findViewById(R.id.player2card2);
		break;
		case 5:
		this.nextview = (ImageView) findViewById(R.id.flop1);
		break;
		case 6:
		this.nextview = (ImageView) findViewById(R.id.flop2);
		break;
		case 7:
		this.nextview = (ImageView) findViewById(R.id.flop3);
		break;
		case 8:
		this.nextview = (ImageView) findViewById(R.id.turn);
		break;
		case 9:
		this.nextview = (ImageView) findViewById(R.id.river);
		break;
		
		
		}
	}



	public ImageView getNextview() {
		return nextview;
	}



    public void Ponisti(){
    	//okreni karte
    	ImageView a = (ImageView) findViewById(R.id.player1card1);
    	a.setImageDrawable((getResources().getDrawable(R.drawable.backcard)));
    	ImageView b = (ImageView) findViewById(R.id.player1card2);
    	b.setImageDrawable((getResources().getDrawable(R.drawable.backcard)));
    	ImageView c = (ImageView) findViewById(R.id.player2card1);
    	c.setImageDrawable((getResources().getDrawable(R.drawable.backcard)));
    	ImageView d = (ImageView) findViewById(R.id.player2card2);
    	d.setImageDrawable((getResources().getDrawable(R.drawable.backcard)));
    	ImageView e = (ImageView) findViewById(R.id.flop1);
    	e.setImageDrawable((getResources().getDrawable(R.drawable.backcard)));
    	ImageView f = (ImageView) findViewById(R.id.flop2);
    	f.setImageDrawable((getResources().getDrawable(R.drawable.backcard)));
    	ImageView g = (ImageView) findViewById(R.id.flop3);
    	g.setImageDrawable((getResources().getDrawable(R.drawable.backcard)));
    	ImageView h = (ImageView) findViewById(R.id.turn);
    	h.setImageDrawable((getResources().getDrawable(R.drawable.backcard)));
    	ImageView i = (ImageView) findViewById(R.id.river);
    	i.setImageDrawable((getResources().getDrawable(R.drawable.backcard)));
    	//ukljuci sve ponovo
    	//karo
    	View twodButton = findViewById(R.id.twod);
		twodButton.setEnabled(true);
		View threedButton = findViewById(R.id.threed);
		threedButton.setEnabled(true);
		View fourdButton = findViewById(R.id.fourd);
		fourdButton.setEnabled(true);
		View fivedButton = findViewById(R.id.fived);
		fivedButton.setEnabled(true);
		View sixdButton = findViewById(R.id.sixd);
		sixdButton.setEnabled(true);
		View sevendButton = findViewById(R.id.sevend);
		sevendButton.setEnabled(true);
		View eightdButton = findViewById(R.id.eightd);
		eightdButton.setEnabled(true);
		View ninedButton = findViewById(R.id.nined);
		ninedButton.setEnabled(true);
		View tendButton = findViewById(R.id.tend);
		tendButton.setEnabled(true);
		View jackdButton = findViewById(R.id.jackd);
		jackdButton.setEnabled(true);
		View queendButton = findViewById(R.id.queend);
		queendButton.setEnabled(true);
		View kingdButton = findViewById(R.id.kingd);
		kingdButton.setEnabled(true);
		View acedButton = findViewById(R.id.aced);
		acedButton.setEnabled(true);
		//ukljuci sve srca
		View twohButton = findViewById(R.id.twoh);
		twohButton.setEnabled(true);
		View threehButton = findViewById(R.id.threeh);
		threehButton.setEnabled(true);
		View fourhButton = findViewById(R.id.fourh);
		fourhButton.setEnabled(true);
		View fivehButton = findViewById(R.id.fiveh);
		fivehButton.setEnabled(true);
		View sixhButton = findViewById(R.id.sixh);
		sixhButton.setEnabled(true);
		View sevenhButton = findViewById(R.id.sevenh);
		sevenhButton.setEnabled(true);
		View eighthButton = findViewById(R.id.eighth);
		eighthButton.setEnabled(true);
		View ninehButton = findViewById(R.id.nineh);
		ninehButton.setEnabled(true);
		View tenhButton = findViewById(R.id.tenh);
		tenhButton.setEnabled(true);
		View jackhButton = findViewById(R.id.jackh);
		jackhButton.setEnabled(true);
		View queenhButton = findViewById(R.id.queenh);
		queenhButton.setEnabled(true);
		View kinghButton = findViewById(R.id.kingh);
		kinghButton.setEnabled(true);
		View acehButton = findViewById(R.id.aceh);
		acehButton.setEnabled(true);
		//ukljuci sve tref
		View twocButton = findViewById(R.id.twoc);
		twocButton.setEnabled(true);
		View threecButton = findViewById(R.id.threec);
		threecButton.setEnabled(true);
		View fourcButton = findViewById(R.id.fourc);
		fourcButton.setEnabled(true);
		View fivecButton = findViewById(R.id.fivec);
		fivecButton.setEnabled(true);
		View sixcButton = findViewById(R.id.sixc);
		sixcButton.setEnabled(true);
		View sevencButton = findViewById(R.id.sevenc);
		sevencButton.setEnabled(true);
		View eightcButton = findViewById(R.id.eightc);
		eightcButton.setEnabled(true);
		View ninecButton = findViewById(R.id.ninec);
		ninecButton.setEnabled(true);
		View tencButton = findViewById(R.id.tenc);
		tencButton.setEnabled(true);
		View jackcButton = findViewById(R.id.jackc);
		jackcButton.setEnabled(true);
		View queencButton = findViewById(R.id.queenc);
		queencButton.setEnabled(true);
		View kingcButton = findViewById(R.id.kingc);
		kingcButton.setEnabled(true);
		View acecButton = findViewById(R.id.acec);
		acecButton.setEnabled(true);
		//ukljuci sve pikove
		View twosButton = findViewById(R.id.twos);
		twosButton.setEnabled(true);
		View threesButton = findViewById(R.id.threes);
		threesButton.setEnabled(true);
		View foursButton = findViewById(R.id.fours);
		foursButton.setEnabled(true);
		View fivesButton = findViewById(R.id.fives);
		fivesButton.setEnabled(true);
		View sixsButton = findViewById(R.id.sixs);
		sixsButton.setEnabled(true);
		View sevensButton = findViewById(R.id.sevens);
		sevensButton.setEnabled(true);
		View eightsButton = findViewById(R.id.eights);
		eightsButton.setEnabled(true);
		View ninesButton = findViewById(R.id.nines);
		ninesButton.setEnabled(true);
		View tensButton = findViewById(R.id.tens);
		tensButton.setEnabled(true);
		View jacksButton = findViewById(R.id.jacks);
		jacksButton.setEnabled(true);
		View queensButton = findViewById(R.id.queens);
		queensButton.setEnabled(true);
		View kingsButton = findViewById(R.id.kings);
		kingsButton.setEnabled(true);
		View acesButton = findViewById(R.id.aces);
		acesButton.setEnabled(true);
    	karta = 1;
    	setNextview(karta);
    	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    	tv1.setText("");
    	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
    	tv2.setText("");
    }

    public void IspisiVjerojatnostipoket(){
    	
    	long key12;
 	    long key22;
 	    int brojpobjedaigraca1 =0;
	    int brojpobjedaigraca2 =0;
	    int izjednacenja =0;
	    int brruku = 0;
	   
	   
    	long key1 = mario.HoldemCalc.Evaluator.makeKey(Evaluator.formatCard8bit(igrac1karta1), igrac1karta2);
    	int rankruke1 = mario.HoldemCalc.Evaluator.getHandRank(key1);
	    	
    	
    	long key2 = mario.HoldemCalc.Evaluator.makeKey(Evaluator.formatCard8bit(igrac2karta1), igrac2karta2);
    	int rankruke2 = mario.HoldemCalc.Evaluator.getHandRank(key2);
    	
    	
    	 for (int i = 1;i<=52;i++)
  		   for (int j = 1 ;j<=52;j++)
  			   for(int k = 1 ;k<=52;k++)
  			   {
  				   if (i!=igrac1karta1 && i!= igrac1karta2 && 
  						   i!=igrac2karta1 && i!= igrac2karta2 && 
  						   j!=igrac1karta1 && j!= igrac1karta2 
  						   && j!=igrac2karta1 && j!= igrac2karta2
  						 && k!=igrac2karta1 && k!= igrac2karta2
  						   &&   i!=j && i!=k && j!=k)
  				   {
  					    key12 = mario.HoldemCalc.Evaluator.makeKey(key1, i);
  				    	key12 = mario.HoldemCalc.Evaluator.makeKey(key12, j);
  				    	key12 = mario.HoldemCalc.Evaluator.makeKey(key12, k);

 
  				    	key22 = mario.HoldemCalc.Evaluator.makeKey(key2, i);
  				    	key22 = mario.HoldemCalc.Evaluator.makeKey(key22, j);
  				    	key22 = mario.HoldemCalc.Evaluator.makeKey(key22, k);
  	
  					   
  				    	int rank1 = mario.HoldemCalc.Evaluator.getHandRank(key12);
  				    	int rank2 = mario.HoldemCalc.Evaluator.getHandRank(key22);
  				    	
  				    	if (rank1>rank2) brojpobjedaigraca1++;
  				    	if (rank1<rank2) brojpobjedaigraca2++;
  				    	if (rank1==rank2) izjednacenja++;
  				    	
  				    	brruku++;
  					   
  				   }
  			   }
    	 
       int postotak1 = (brojpobjedaigraca1*100)/brruku;
  	   int postotak2 = (brojpobjedaigraca2*100)/brruku;
  	   int postotak3 = (izjednacenja*100)/brruku;
  	  
  	
    	 

    	if      (rankruke1 < 1278)  // High Card
    	{
    		TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "% ");
    	}
        else if (rankruke1 < 4138) // One Pair  
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "%  \nImate jedan par.");
        }
        else if (rankruke1 < 4996)  // Two Pair 
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "%  \nImate dva para.");
        }
        else if (rankruke1 < 5854)  // Three of a Kind   
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "%  \nImate tris! ");
        }
        else if (rankruke1 < 5864) // Straight 
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "%  \nImate skalu !");
        }
        else if (rankruke1 < 7141)  // Flush   
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "% \nImate boju!!");
        }
        else if (rankruke1 < 7297)  // Full House
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "% \n Imate Full House!!");
        }
        else if (rankruke1 < 7453) // Four of a Kind    
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "% \nImate Poker!!!");
        }
        else if (rankruke1 < 7462 )                // Straight Flush 
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "%  \nImate skalu U BOJI !!!");
        }
    	
    	

    	if      (rankruke2 < 1278)  // High Card
    	{
    		TextView tv2 = (TextView) findViewById(R.id.rezultat2);
    		tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%");
    	}
        else if (rankruke2 < 4138) // One Pair  
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate jedan par.");
        }
        else if (rankruke2 < 4996)  // Two Pair 
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate dva para.");
        }
        else if (rankruke2 < 5854)  // Three of a Kind   
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate tris! ");
        }
        else if (rankruke2 < 5864) // Straight 
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate skalu !");
        }
        else if (rankruke2 < 7141)  // Flush   
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate boju!!");
        }
        else if (rankruke2 < 7297)  // Full House
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "% \nImate Full House!!");
        }
        else if (rankruke2 < 7453) // Four of a Kind    
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "%Izjednaèenje = " + postotak3 + "% \nImate Poker!!!");
        }
        else if (rankruke2 < 7462 )                // Straight Flush 
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate skalu U BOJI !!!");
        }
    	
    }
    
    public void IspisiVjerojatnostiflop(){
  	
    	long key12;
 	    long key22;
 	    int brojpobjedaigraca1 =0;
	    int brojpobjedaigraca2 =0;
	    int izjednacenja =0;
	    int brruku = 0;
	    
    	long key1 = mario.HoldemCalc.Evaluator.makeKey(Evaluator.formatCard8bit(igrac1karta1), igrac1karta2);
    	key1 = mario.HoldemCalc.Evaluator.makeKey(key1, flop1);
    	key1 = mario.HoldemCalc.Evaluator.makeKey(key1, flop2);
    	key1 = mario.HoldemCalc.Evaluator.makeKey(key1, flop3);
    	int rankruke1 = mario.HoldemCalc.Evaluator.getHandRank(key1);
	    		
    	long key2 = mario.HoldemCalc.Evaluator.makeKey(Evaluator.formatCard8bit(igrac2karta1), igrac2karta2);
    	key2 = mario.HoldemCalc.Evaluator.makeKey(key2, flop1);
    	key2 = mario.HoldemCalc.Evaluator.makeKey(key2, flop2);
    	key2 = mario.HoldemCalc.Evaluator.makeKey(key2, flop3);
    	int rankruke2 = mario.HoldemCalc.Evaluator.getHandRank(key2);
    		
    	 for (int i = 1;i<=52;i++)
  		   for (int j = 1 ;j<=52;j++)
  			   {
  				   if (i!=igrac1karta1 && i!= igrac1karta2 && i!=igrac2karta1 && i!= igrac2karta2 && j!=igrac1karta1 
  						   && j!= igrac1karta2 && j!=igrac2karta1 && j!= igrac2karta2
  						   && i!=flop1 && j!=flop1 
  						   && i!=flop2 && j!=flop2 
						   && i!= flop3 && j!=flop3 &&  i!=j)
  				   {
  					    key12 = mario.HoldemCalc.Evaluator.makeKey(key1, i);
  				    	key12 = mario.HoldemCalc.Evaluator.makeKey(key12, j);

 
  				    	key22 = mario.HoldemCalc.Evaluator.makeKey(key2, i);
  				    	key22 = mario.HoldemCalc.Evaluator.makeKey(key22, j);
  	
  					   
  				    	int rank1 = mario.HoldemCalc.Evaluator.getHandRank(key12);
  				    	int rank2 = mario.HoldemCalc.Evaluator.getHandRank(key22);
  				    	
  				    	if (rank1>rank2) brojpobjedaigraca1++;
  				    	if (rank1<rank2) brojpobjedaigraca2++;
  				    	if (rank1==rank2) izjednacenja++;
  				    	
  				    	brruku++;
  					   
  				   }
  			   }
    	 
       int postotak1 = (brojpobjedaigraca1*100)/brruku;
  	   int postotak2 = (brojpobjedaigraca2*100)/brruku;
  	   int postotak3 = (izjednacenja*100)/brruku;
  	  
  	
    	 

    	if      (rankruke1 < 1278)  // High Card
    	{
    		TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "% ");
    	}
        else if (rankruke1 < 4138) // One Pair  
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "%  \nImate jedan par.");
        }
        else if (rankruke1 < 4996)  // Two Pair 
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "%  \nImate dva para.");
        }
        else if (rankruke1 < 5854)  // Three of a Kind   
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "%  \nImate tris! ");
        }
        else if (rankruke1 < 5864) // Straight 
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "%  \nImate skalu !");
        }
        else if (rankruke1 < 7141)  // Flush   
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "% \nImate boju!!");
        }
        else if (rankruke1 < 7297)  // Full House
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "% \n Imate Full House!!");
        }
        else if (rankruke1 < 7453) // Four of a Kind    
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "% \nImate Poker!!!");
        }
        else if (rankruke1 < 7462 )                // Straight Flush 
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "%  \nImate skalu U BOJI !!!");
        }
    	
    	

    	if      (rankruke2 < 1278)  // High Card
    	{
    		TextView tv2 = (TextView) findViewById(R.id.rezultat2);
    		tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%");
    	}
        else if (rankruke2 < 4138) // One Pair  
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate jedan par.");
        }
        else if (rankruke2 < 4996)  // Two Pair 
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate dva para.");
        }
        else if (rankruke2 < 5854)  // Three of a Kind   
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate tris! ");
        }
        else if (rankruke2 < 5864) // Straight 
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate skalu !");
        }
        else if (rankruke2 < 7141)  // Flush   
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate boju!!");
        }
        else if (rankruke2 < 7297)  // Full House
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "% \nImate Full House!!");
        }
        else if (rankruke2 < 7453) // Four of a Kind    
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "%Izjednaèenje = " + postotak3 + "% \nImate Poker!!!");
        }
        else if (rankruke2 < 7462 )                // Straight Flush 
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate skalu U BOJI !!!");
        }
    }

    public void IspisiVjerojatnostiturn()
    {
    	
    	long key12;
 	    long key22;
 	    int brojpobjedaigraca1 =0;
	    int brojpobjedaigraca2 =0;
	    int izjednacenja =0;
	    int brruku = 0;
	   
	   
    	long key1 = mario.HoldemCalc.Evaluator.makeKey(Evaluator.formatCard8bit(igrac1karta1), igrac1karta2);
    	key1 = mario.HoldemCalc.Evaluator.makeKey(key1, flop1);
    	key1 = mario.HoldemCalc.Evaluator.makeKey(key1, flop2);
    	key1 = mario.HoldemCalc.Evaluator.makeKey(key1, flop3);
    	key1 = mario.HoldemCalc.Evaluator.makeKey(key1, turn);
    	int rankruke1 = mario.HoldemCalc.Evaluator.getHandRank(key1);
	    	
    	
    	long key2 = mario.HoldemCalc.Evaluator.makeKey(Evaluator.formatCard8bit(igrac2karta1), igrac2karta2);
    	key2 = mario.HoldemCalc.Evaluator.makeKey(key2, flop1);
    	key2 = mario.HoldemCalc.Evaluator.makeKey(key2, flop2);
    	key2 = mario.HoldemCalc.Evaluator.makeKey(key2, flop3);
    	key2 = mario.HoldemCalc.Evaluator.makeKey(key2, turn);
    	int rankruke2 = mario.HoldemCalc.Evaluator.getHandRank(key2);
    	
    	
    	 for (int i = 1;i<=52;i++)
  			   {
  				   if (i!=igrac1karta1 && i!= igrac1karta2 && i!=igrac2karta1 && i!= igrac2karta2 &&
  						    i!=flop1 && i!=flop2  && i!= flop3 )
  				   {
  					    key12 = mario.HoldemCalc.Evaluator.makeKey(key1, i);
  				    	

 
  				    	key22 = mario.HoldemCalc.Evaluator.makeKey(key2, i);
  				    	
  	
  					   
  				    	int rank1 = mario.HoldemCalc.Evaluator.getHandRank(key12);
  				    	int rank2 = mario.HoldemCalc.Evaluator.getHandRank(key22);
  				    	
  				    	if (rank1>rank2) brojpobjedaigraca1++;
  				    	if (rank1<rank2) brojpobjedaigraca2++;
  				    	if (rank1==rank2) izjednacenja++;
  				    	
  				    	brruku++;
  					   
  				   }
  			   }
    	 
       int postotak1 = (brojpobjedaigraca1*100)/brruku;
  	   int postotak2 = (brojpobjedaigraca2*100)/brruku;
  	   int postotak3 = (izjednacenja*100)/brruku;
  	  
  	
    	 

    	if      (rankruke1 < 1278)  // High Card
    	{
    		TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "% ");
    	}
        else if (rankruke1 < 4138) // One Pair  
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "%  \nImate jedan par.");
        }
        else if (rankruke1 < 4996)  // Two Pair 
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "%  \nImate dva para.");
        }
        else if (rankruke1 < 5854)  // Three of a Kind   
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "%  \nImate tris! ");
        }
        else if (rankruke1 < 5864) // Straight 
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "%  \nImate skalu !");
        }
        else if (rankruke1 < 7141)  // Flush   
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "% \nImate boju!!");
        }
        else if (rankruke1 < 7297)  // Full House
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "% \n Imate Full House!!");
        }
        else if (rankruke1 < 7453) // Four of a Kind    
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "% \nImate Poker!!!");
        }
        else if (rankruke1 < 7462 )                // Straight Flush 
        {
        	TextView tv1 = (TextView) findViewById(R.id.rezultat1);
    		tv1.setText( "Pobjeda = " + postotak1 + "% Izjednaèenje = " + postotak3 + "%  \nImate skalu U BOJI !!!");
        }
    	
    	

    	if      (rankruke2 < 1278)  // High Card
    	{
    		TextView tv2 = (TextView) findViewById(R.id.rezultat2);
    		tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%");
    	}
        else if (rankruke2 < 4138) // One Pair  
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate jedan par.");
        }
        else if (rankruke2 < 4996)  // Two Pair 
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate dva para.");
        }
        else if (rankruke2 < 5854)  // Three of a Kind   
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate tris! ");
        }
        else if (rankruke2 < 5864) // Straight 
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate skalu !");
        }
        else if (rankruke2 < 7141)  // Flush   
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate boju!!");
        }
        else if (rankruke2 < 7297)  // Full House
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "% \nImate Full House!!");
        }
        else if (rankruke2 < 7453) // Four of a Kind    
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "%Izjednaèenje = " + postotak3 + "% \nImate Poker!!!");
        }
        else if (rankruke2 < 7462 )                // Straight Flush 
        {
        	TextView tv2 = (TextView) findViewById(R.id.rezultat2);
        	tv2.setText( "Pobjeda = " + postotak2 + "% Izjednaèenje = " + postotak3 + "%  \nImate skalu U BOJI !!!");
        }
    	
    	
    }
    
   
   public void IspisiVjerojatnostiriver()
   {
	
	   
   	long key1 = mario.HoldemCalc.Evaluator.makeKey(Evaluator.formatCard8bit(igrac1karta1), igrac1karta2);
   	key1 = mario.HoldemCalc.Evaluator.makeKey(key1, flop1);
   	key1 = mario.HoldemCalc.Evaluator.makeKey(key1, flop2);
   	key1 = mario.HoldemCalc.Evaluator.makeKey(key1, flop3);
   	key1 = mario.HoldemCalc.Evaluator.makeKey(key1, turn);
   	key1 = mario.HoldemCalc.Evaluator.makeKey(key1,river);
   	int rankruke1 = mario.HoldemCalc.Evaluator.getHandRank(key1);
	    	
   	
   	long key2 = mario.HoldemCalc.Evaluator.makeKey(Evaluator.formatCard8bit(igrac2karta1), igrac2karta2);
   	key2 = mario.HoldemCalc.Evaluator.makeKey(key2, flop1);
   	key2 = mario.HoldemCalc.Evaluator.makeKey(key2, flop2);
   	key2 = mario.HoldemCalc.Evaluator.makeKey(key2, flop3);
   	key2 = mario.HoldemCalc.Evaluator.makeKey(key2, turn);
   	key2 = mario.HoldemCalc.Evaluator.makeKey(key2, river);
   	int rankruke2 = mario.HoldemCalc.Evaluator.getHandRank(key2);
   	
   	
   	if (rankruke1>rankruke2) {
   		
   		TextView tv1 = (TextView) findViewById(R.id.rezultat1);
		tv1.setText( "Pobjeda = 100" + "% Izjednaèenje = 0%");
		TextView tv2 = (TextView) findViewById(R.id.rezultat2);
		tv2.setText( "Pobjeda = 0" + "% Izjednaèenje = 0%");
   	}
	if (rankruke1<rankruke2){
   		
   		TextView tv1 = (TextView) findViewById(R.id.rezultat1);
		tv1.setText( "Pobjeda = 0" + "% Izjednaèenje = 0%");
		TextView tv2 = (TextView) findViewById(R.id.rezultat2);
		tv2.setText( "Pobjeda = 100" + "% Izjednaèenje = 0%");
   	};
	if (rankruke1==rankruke2) {
   		
   		TextView tv1 = (TextView) findViewById(R.id.rezultat1);
		tv1.setText( "Pobjeda = 0" + "% Izjednaèenje = 100%");
		TextView tv2 = (TextView) findViewById(R.id.rezultat2);
		tv2.setText( "Pobjeda = 0" + "% Izjednaèenje = 100%");
   	};
   }  
}