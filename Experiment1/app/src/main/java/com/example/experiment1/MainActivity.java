packagelayout.ne;
import android.app.Activity;import android.os.Bundle;importandroid.view.View;
import android.view.View.OnClickListener;importandroid.widget.Button;
import android.widget.EditText;importandroid.widget.Toast;
        publicclassLAYOUTActivityextendsActivity{
/**Calledwhentheactivityisfirstcreated.*/

        EditTexttxtData1,txtData2;float num1,num2,result1,result2;@Override
publicvoidonCreate(BundlesavedInstanceState){super.onCreate(savedInstanceState);setContentView(R.layout.main);
        Buttonadd=(Button)findViewById(R.id.button1);add.setOnClickListener(new OnClickListener() {publicvoidonClick(Viewv){
        try
        {
        txtData1 = (EditText) findViewById(R.id.edittext1);txtData2 =(EditText)findViewById(R.id.edittext2);num1 = Float.parseFloat(txtData1.getText().toString());num2 = Float.parseFloat(txtData2.getText().toString());result1=num1+num2;
        Toast.makeText(getBaseContext(),"ANSWER:"+result1,Toast.LENGTH_SHORT).show();
        }
        catch(Exceptione)
        {
        Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        }
        });
        Button sub = (Button) findViewById(R.id.button3);sub.setOnClickListener(new OnClickListener() {publicvoidonClick(Viewv){
        try
        {
        txtData1 = (EditText) findViewById(R.id.edittext1);txtData2=(EditText)findViewById(R.id.edittext2);num1 = Float.parseFloat(txtData1.getText().toString());num2 = Float.parseFloat(txtData2.getText().toString());result2=num1-num2;
        Toast.makeText(getBaseContext(),"ANSWER:"+result2,Toast.LENGTH_SHORT).show();
        }
        catch(Exceptione)
        {
        Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        }
        });
        Buttonclear=(Button)findViewById(R.id.button2);

        clear.setOnClickListener(newOnClickListener(){publicvoidonClick(Viewv){
        try
        {
        txtData1.setText("");txtData2.setText("");
        }
        catch(Exceptione)
        {
        Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        }});
        }
        }

