//*AlarmActivity.java*//
AlarmActivityusestheAlarmManagertosetthealarmandsendnotificationonalarmtrigger.
        package com.javapapers.androidalarmclock;importandroid.app.Activity;
import android.app.AlarmManager;import android.app.PendingIntent;import android.content.Intent;importandroid.os.Bundle;
import android.util.Log;importandroid.view.View;
import android.widget.TextView;import android.widget.TimePicker;import android.widget.ToggleButton;importjava.util.Calendar;
        publicclassAlarmActivityextendsActivity{AlarmManageralarmManager;
private PendingIntent pendingIntent;private TimePicker alarmTimePicker;private static AlarmActivity inst;privateTextViewalarmTextView;
        publicstaticAlarmActivityinstance(){returninst;
        }
@Override
public void onStart() {super.onStart();
        inst=this;
        }
@Override
protectedvoidonCreate(BundlesavedInstanceState){super.onCreate(savedInstanceState);setContentView(R.layout.activity_my);

        alarmTimePicker = (TimePicker)findViewById(R.id.alarmTimePicker);
        alarmTextView = (TextView) findViewById(R.id.alarmText);ToggleButton alarmToggle = (ToggleButton)findViewById(R.id.alarmToggle);
        alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        }
public void onToggleClicked(View view) {if (((ToggleButton) view).isChecked()) {Log.d("MyActivity","AlarmOn");
        Calendarcalendar=Calendar.getInstance();calendar.set(Calendar.HOUR_OF_DAY,alarmTimePicker.getCurrentHour());calendar.set(Calendar.MINUTE,alarmTimePicker.getCurrentMinute());
        IntentmyIntent=newIntent(AlarmActivity.this,AlarmReceiver.class);
        pendingIntent=PendingIntent.getBroadcast(AlarmActivity.this,0,
        myIntent,0);
        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(),pendingIntent);
        } else {alarmManager.cancel(pendingIntent);setAlarmText("");Log.d("MyActivity","AlarmOff");
        }
        }
        publicvoidsetAlarmText(StringalarmText){alarmTextView.setText(alarmText);
        }
        }

