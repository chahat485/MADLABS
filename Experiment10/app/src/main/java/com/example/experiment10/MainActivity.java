package save.sd;importjava.io.File;
        importjava.io.FileInputStream;import java.io.FileNotFoundException;import java.io.FileOutputStream;importjava.io.IOException;
import java.io.InputStreamReader;import java.io.OutputStreamWriter;importandroid.app.Activity;importandroid.os.Bundle;
import android.os.Environment;importandroid.view.View;import android.widget.Button;import android.widget.EditText;import android.widget.TextView;importandroid.widget.Toast;
        publicclassSavedatasdcardActivityextendsActivity{
/**Calledwhentheactivityisfirstcreated.*/Buttonsave,load;
        EditText message;TextView t1;String Message1;@Override
publicvoidonCreate(BundlesavedInstanceState){super.onCreate(savedInstanceState);setContentView(R.layout.main);

        save=(Button) findViewById(R.id.button1);load=(Button) findViewById(R.id.button2);message=(EditText) findViewById(R.id.editText1);t1=(TextView) findViewById(R.id.textView1);save.setOnClickListener(new View.OnClickListener(){publicvoidonClick(Viewv){
//Getmessagefromuserstoreinmessage1variableMessage1=message.getText().toString();
        try{
//Create anewfoldercalledMyDirectory inSDCardFile sdcard=Environment.getExternalStorageDirectory();File directory=newFile(sdcard.getAbsolutePath()+"/MyDirectory");directory.mkdirs();
//Createanewfilenametextfile.txtinsideMyDirectoryFilefile=newFile(directory,"textfile.txt");
//Create File Outputstream to read the fileFileOutputStream fou=new FileOutputStream(file);OutputStreamWriterosw=newOutputStreamWriter(fou);try{
//write a user data to fileosw.append(Message1);osw.flush();
        osw.close();Toast.makeText(getBaseContext(),"DataSaved",Toast.LENGTH_LONG).show();
        }catch(IOException e){e.printStackTrace();
        }
        }catch(FileNotFoundExceptione){e.printStackTrace();
        }
        }
        });
        load.setOnClickListener(new View.OnClickListener(){publicvoidonClick(Viewv){
        try{
        File sdcard=Environment.getExternalStorageDirectory();File directory=newFile(sdcard.getAbsolutePath()+"/MyDirectory");
        File file=new File(directory,"textfile.txt");FileInputStream fis=new FileInputStream(file);InputStreamReaderisr=newInputStreamReader(fis);char[]data=newchar[100];
        String final_data="";intsize;
        try{

        while((size=isr.read(data))>0)
        {
//readadatafromfile
        Stringread_data=String.copyValueOf(data,0,size);final_data+=read_data;
        data=newchar[100];
        }
//display the data in outputToast.makeText(getBaseContext(),"Message:"+final_data,Toast.LENGTH_LONG).show();
        }catch(IOException e){e.printStackTrace();
        }}catch(FileNotFoundExceptione){e.printStackTrace();
        }}});}}

