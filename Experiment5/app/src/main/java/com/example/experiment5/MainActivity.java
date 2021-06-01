packageemployee.detail;
//importandroid.R;
        importandroid.app.Activity;
import android.app.AlertDialog.Builder;importandroid.content.Context;
        importandroid.database.Cursor;
        importandroid.database.sqlite.SQLiteDatabase;importandroid.os.Bundle;

        importandroid.view.View;
import android.view.View.OnClickListener;importandroid.widget.Button;
        importandroid.widget.EditText;
        publicclassEmployeedetailActivityextendsActivityimplementsOnClickListener{
        EditTexteditEmpid,editName,editsalary;
        Button btnAdd,btnDelete,btnModify,btnView,btnViewAll;SQLiteDatabasedb;
/**Calledwhentheactivityisfirstcreated.*/@Override
publicvoidonCreate(BundlesavedInstanceState)
        {
        super.onCreate(savedInstanceState);setContentView(R.layout.main);editEmpid=(EditText)findViewById(R.id.editEmpid);editName=(EditText)findViewById(R.id.editName);editsalary=(EditText)findViewById(R.id.editsalary);btnAdd=(Button)findViewById(R.id.btnAdd);btnDelete=(Button)findViewById(R.id.btnDelete);btnModify=(Button)findViewById(R.id.btnModify);btnView=(Button)findViewById(R.id.btnView);btnViewAll=(Button)findViewById(R.id.btnViewAll);btnAdd.setOnClickListener(this);btnDelete.setOnClickListener(this);btnModify.setOnClickListener(this);btnView.setOnClickListener(this);btnViewAll.setOnClickListener(this);db=openOrCreateDatabase("EmployeeDB", Context.MODE_PRIVATE,null);
        db.execSQL("CREATETABLEIFNOTEXISTSemployee(empidVARCHAR,name
        VARCHAR,salaryVARCHAR);");
        }
        publicvoidonClick(Viewview)
        {
        if(view==btnAdd)
        {
        if(editEmpid.getText().toString().trim().length()==0||editName.getText().toString().trim().length()==0||editsalary.getText().toString().trim().length()==0)
        {
        showMessage("Error","Pleaseenterallvalues");return;
        }
        db.execSQL("INSERT INTO employeeVALUES('"+editEmpid.getText()+"','"+editName.getText()+

        "','"+editsalary.getText()+"');");showMessage("Success","Recordadded");clearText();
        }
        if(view==btnDelete)
        {
        if(editEmpid.getText().toString().trim().length()==0)
        {
        showMessage("Error","PleaseenterEmployeeid");return;
        }
        Cursorc=db.rawQuery("SELECT*FROMemployeeWHEREempid='"+editEmpid.getText()+"'", null);if(c.moveToFirst())
        {
        db.execSQL("DELETE FROM employee WHEREempid='"+editEmpid.getText()+"'");showMessage("Success","RecordDeleted");
        }
        else
        {
        showMessage("Error","InvalidEmployeeid");
        }
        clearText();
        }
        if(view==btnModify)
        {
        if(editEmpid.getText().toString().trim().length()==0)
        {
        showMessage("Error","PleaseenterEmployeeid");return;
        }
        Cursorc=db.rawQuery("SELECT*FROMemployeeWHEREempid='"+editEmpid.getText()+"'", null);if(c.moveToFirst())
        {
        db.execSQL("UPDATE employee SETname='"+editName.getText()+"',salary='"+editsalary.getText()+"' WHERE empid='"+editEmpid.getText()+"'");showMessage("Success","RecordModified");
        }
        else
        {
        showMessage("Error","InvalidRollno");
        }
        clearText();
        }

        if(view==btnView)
        {
        if(editEmpid.getText().toString().trim().length()==0)
        {
        showMessage("Error","PleaseenterEmployeeid");return;
        }
        Cursorc=db.rawQuery("SELECT*FROMemployeeWHEREempid='"+editEmpid.getText()+"'", null);if(c.moveToFirst())
        {
        editName.setText(c.getString(1));editsalary.setText(c.getString(2));
        }
        else
        {
        showMessage("Error","InvalidEmployeeid");clearText();
        }
        }
        if(view==btnViewAll)
        {
        Cursorc=db.rawQuery("SELECT*FROMemployee",null);if(c.getCount()==0)
        {
        showMessage("Error","Norecordsfound");return;
        }
        StringBufferbuffer=newStringBuffer();while(c.moveToNext())
        {
        buffer.append("Employee id: "+c.getString(0)+"\n");buffer.append("Name: "+c.getString(1)+"\n");buffer.append("salary:"+c.getString(2)+"\n\n");
        }
        showMessage("EmployeedetailsDetails",buffer.toString());
        }
        }
        publicvoidshowMessage(Stringtitle,Stringmessage)
        {
        Builder builder=new Builder(this);builder.setCancelable(true);builder.setTitle(title);builder.setMessage(message);builder.show();
        }
        publicvoidclearText()

        {
        editEmpid.setText("");editName.setText("");editsalary.setText("");editEmpid.requestFocus();
        }
        }

