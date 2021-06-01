packagemulti.threading;
//importyour.first.R;import android.app.Activity;import android.os.Bundle;import android.os.Handler;importandroid.view.View;
        importandroid.widget.TextView;
public class MultiThreadingActivity extends Activity {privateTextViewtvOutput;
    private static final int t1 = 1;private static final int t2 = 2;private static final int t3 = 3;@Override
    publicvoidonCreate(BundlesavedInstanceState){super.onCreate(savedInstanceState);setContentView(R.layout.main);
        tvOutput=(TextView)findViewById(R.id.textView1);
    }
    public void fetchData(View v) {tvOutput.setText("Mainthread");thread1.start();thread2.start();thread3.start();
    }
    Threadthread1=newThread(newRunnable(){@Override
            publicvoidrun(){
        for (int i = 0; i < 5; i++) {try{
            Thread.sleep(1000);
        }catch(InterruptedExceptione){e.printStackTrace();
        }
            handler.sendEmptyMessage(t1);
        }

    }
    });
    Threadthread2=newThread(newRunnable(){@Override
            publicvoidrun(){
        for (int i = 0; i < 5; i++) {try{
            Thread.sleep(1000);
        }catch(InterruptedExceptione){e.printStackTrace();
        }
            handler.sendEmptyMessage(t2);
        }
    }
    });
    Threadthread3=newThread(newRunnable(){@Override
            publicvoidrun(){
        for (int i = 0; i < 5; i++) {try{
            Thread.sleep(1000);
        }catch(InterruptedExceptione){e.printStackTrace();
        }
            handler.sendEmptyMessage(t3);
        }
    }
    });
    Handlerhandler=newHandler(){
        publicvoidhandleMessage(android.os.Messagemsg){if(msg.what==t1){
            tvOutput.append("\nInthread1");
        }
            if(msg.what == t2) {tvOutput.append("\nInthread2");
            }
            if(msg.what == t3) {tvOutput.append("\nInthread3");
            }
        }};
}

