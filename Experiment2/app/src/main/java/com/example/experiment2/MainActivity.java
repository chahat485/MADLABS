import android.app.Activity;import android.graphics.Color;import android.graphics.Typeface;importandroid.os.Bundle;
        importandroid.view.View;import android.widget.Button;importandroid.widget.TextView;
        publicclassAndroidActivityextendsActivity{floatfont=24;
        int i=1;@Override
publicvoidonCreate(BundlesavedInstanceState){super.onCreate(savedInstanceState);setContentView(R.layout.main);
        finalTextViewt1=(TextView)findViewById(R.id.textView1);Button b1 = (Button) findViewById(R.id.button1);b1.setOnClickListener(newView.OnClickListener(){
        publicvoidonClick(Viewview){

        t1.setTextSize(font);font=font+4;if(font==40)
        font=20;
        }
        });
        Button b2 = (Button) findViewById(R.id.button2);b2.setOnClickListener(newView.OnClickListener(){publicvoidonClick(Viewview){
        switch(i)
        {
        case 1:t1.setTextColor(Color.parseColor("#0000FF"));break;
        case 2:t1.setTextColor(Color.parseColor("#00FF00"));break;
        case 3:t1.setTextColor(Color.parseColor("#FF0000"));break;
        case 4:t1.setTextColor(Color.parseColor("#800000"));break;
        }i++;
        if(i==5)i=1;
        }
        });
        }
        }

