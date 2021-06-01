packageCALCU.CALU;
import android.app.Activity;import android.os.Bundle;import android.text.TextUtils;importandroid.view.View;
import android.view.View.OnClickListener;importandroid.widget.Button;
import android.widget.EditText;importandroid.widget.TextView;
        publicclassCALCULATORActivityextendsActivityimplementsOnClickListener{
        EditText input1;EditTextinput2;Buttonaddition;Button subtraction;Button multiplication;Button division;TextView tvResult;String oper = "";@Override
publicvoidonCreate(BundlesavedInstanceState){super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        input1 = (EditText) findViewById(R.id.etNum1);input2 = (EditText) findViewById(R.id.etNum2);addition = (Button) findViewById(R.id.btnAdd);subtraction=(Button)findViewById(R.id.btnSub);
        multiplication=(Button)findViewById(R.id.btnMult);division = (Button) findViewById(R.id.btnDiv);tvResult=(TextView)findViewById(R.id.tvResult);
// set a listeneraddition.setOnClickListener(this);subtraction.setOnClickListener(this);multiplication.setOnClickListener(this);division.setOnClickListener(this);
        }
@Override
publicvoidonClick(Viewv){
// TODO Auto-generated method stubfloatnum1=0;
        float num2 = 0;floatresult=0;
//checkifthefieldsareempty
        if(TextUtils.isEmpty(input1.getText().toString())
        ||TextUtils.isEmpty(input2.getText().toString())){return;
        }
//readEditTextandfillvariableswithnumbersnum1=Float.parseFloat(input1.getText().toString());num2=Float.parseFloat(input2.getText().toString());
//definesthebuttonthathasbeenclickedandperformsthecorrespondingoperation
//writeoperationintooper,wewilluseitlaterforoutputswitch(v.getId()){
        case R.id.btnAdd:oper="+";
        result = num1 + num2;break;
        case R.id.btnSub:oper="-";
        result = num1 - num2;break;
        case R.id.btnMult:oper="*";
        result = num1 * num2;break;
        case R.id.btnDiv:oper="/";
        result=num1/num2;

        break;default:
        break;
        }
//formtheoutputline
        tvResult.setText(num1+""+oper+""+num2+"="+result);}}
