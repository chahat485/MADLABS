package Basic.primitive;importandroid.app.Activity;
import android.content.Context;import android.graphics.Canvas;import android.graphics.Color;import android.graphics.Paint;importandroid.os.Bundle;importandroid.view.View;
        publicclassBasicprimitiveActivityextendsActivity{
/**Calledwhentheactivityisfirstcreated.*/@Override
publicvoidonCreate(BundlesavedInstanceState){super.onCreate(savedInstanceState);setContentView(newmyview(this));
        }
        privateclassmyviewextendsView
        {publicmyview(Contextcontext){super(context);
        }
@Override
protectedvoidonDraw(Canvascanvas)
        {
        super.onDraw(canvas);Paint paint=new Paint();paint.setTextSize(40);
        paint.setColor(Color.GREEN);

        canvas.drawText("Circle", 55, 30, paint);paint.setColor(Color.RED);canvas.drawCircle(100, 150,100, paint);paint.setColor(Color.GREEN);canvas.drawText("Rectangle",255,30,paint);paint.setColor(Color.YELLOW);canvas.drawRect(250, 50,400,350, paint);paint.setColor(Color.GREEN);canvas.drawText("SQUARE", 55, 430, paint);paint.setColor(Color.BLUE);canvas.drawRect(50, 450,150,550, paint);paint.setColor(Color.GREEN);canvas.drawText("LINE", 255, 430, paint);paint.setColor(Color.CYAN);canvas.drawLine(250,500,350,500,paint);
        }
        }
        }

