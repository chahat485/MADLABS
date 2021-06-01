packagegps.location;
//importandroid.R;
import android.app.Activity;import android.os.Bundle;import android.view.View;import android.widget.Button;importandroid.widget.Toast;
        publicclassGPSlocationActivityextendsActivity{
/**Calledwhentheactivityisfirstcreated.*/ButtonbtnShowLocation;
        GPStrace gps;@Override
public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);setContentView(R.layout.main);btnShowLocation=(Button)findViewById(R.id.show_Location);btnShowLocation.setOnClickListener(newView.OnClickListener(){@Override
publicvoidonClick(Viewv){
//TODOAuto-generatedmethodstub
        gps=newGPStrace(GPSlocationActivity.this);if(gps.canGetLocation()){
        double latitude=gps.getLatitude();doublelongitude=gps.getLongtiude();
        Toast.makeText(getApplicationContext(),"YourLocationis
        \nLat:"+latitude+"\nLong:"+longitude,Toast.LENGTH_LONG).show();
        }
        else
        {
        gps.showSettingAlert();
        }
        }});}})
        packagegps.location;
        import android.app.AlertDialog;import android.app.Service;importandroid.content.Context;
        importandroid.content.DialogInterface;importandroid.content.Intent;
        importandroid.location.Location;
        import android.location.LocationListener;importandroid.location.LocationManager;

        import android.os.Bundle;importandroid.os.IBinder;
        importandroid.provider.Settings;
        publicclassGPStraceextendsServiceimplementsLocationListener{
private final Context context;boolean isGPSEnabled=false;boolean canGetLocation=false;boolean isNetworkEnabled=false;Locationlocation;
        double latitude;doublelongtitude;
        privatestaticfinallongMIN_DISTANCE_CHANGE_FOR_UPDATES=10;private static final long MIN_TIME_BW_UPDATES=1000*60*1;protectedLocationManagerlocationManager;
        publicGPStrace(Contextcontext)
        {
        this.context=context;getLocation();
        }
        publicLocationgetLocation()
        {
        try{locationManager=(LocationManager)
        context.getSystemService(LOCATION_SERVICE);isGPSEnabled=locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        isNetworkEnabled=locationManager.isProviderEnabled(LocationManager.NETWORK_PROVI
        DER);
        if(!isGPSEnabled&&!isNetworkEnabled){
        }else{this.canGetLocation=true;if(isNetworkEnabled){
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,MIN_TIME_BW_UPDATES,MIN_DISTANCE_CHANGE_FOR_UPDATES,this);
        }
        if(locationManager!=null){location=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
        ;
        if(location !=null){latitude=location.getLatitude();longtitude=location.getLongitude();
        }}}

        if(isGPSEnabled){if(location==null){
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,MIN_TIME_B
        W_UPDATES,MIN_DISTANCE_CHANGE_FOR_UPDATES,this);
        if(locationManager!=null){location=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(location!=null){latitude=location.getLatitude();longtitude=location.getLongitude();
        }}}}}
        catch(Exceptione)
        {
        e.printStackTrace();
        }
        returnlocation;
        }
public void stopUsingGPS(){if(locationManager!=null){locationManager.removeUpdates(GPStrace.this);
        }}
public double getLatitude(){if(location!=null){latitude=location.getLatitude();
        }
        returnlatitude;
        }
public double getLongtiude(){if(location!=null){longtitude=location.getLatitude();
        }
        returnlongtitude;
        }
public boolean canGetLocation(){returnthis.canGetLocation;
        }
public void showSettingAlert(){AlertDialog.Builder alertDialog=newAlertDialog.Builder(context);alertDialog.setTitle("GPSissettings");
        alertDialog.setMessage("GPSisnotenabled.Doyouwanttogotosettingmenu?");
        alertDialog.setPositiveButton("settings",newDialogInterface.OnClickListener(){@Override
publicvoidonClick(DialogInterfacedialog,intwhich){

        Intent intent=newIntent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);context.startActivity(intent);
        }});
        alertDialog.setNegativeButton("cancel",newDialogInterface.OnClickListener() {@Override
publicvoidonClick(DialogInterfacedialog,intwhich){
// TODO Auto-generated method stubdialog.cancel();
        }
        });
        alertDialog.show();
        }
@Override
publicvoidonLocationChanged(Locationlocation){
//TODOAuto-generatedmethodstub
        }
@Override
publicvoidonProviderDisabled(Stringprovider){
//TODOAuto-generatedmethodstub
        }
@Override
publicvoidonProviderEnabled(Stringprovider){
//TODOAuto-generatedmethodstub
        }
@Override
publicvoidonStatusChanged(Stringprovider,intstatus,Bundleextras){
//TODOAuto-generatedmethodstub
        }
@Override
publicIBinderonBind(Intentintent){
// TODO Auto-generated method stubreturnnull;
        }}
        10)	Gotomanifest.xmlfileandaddthecodebelow
<uses-permissionandroid:name="android.permission.ACCESS_FINE_LOCATION"/>
<uses-permissionandroid:name="android.permission.INTERNET"/>
        •	Nowgotomain.xmlandrightclick.selectrunasoptionandselectrunconfiguration
        •	Androidoutputispresentintheandroidemulatorasshowninbelow.

