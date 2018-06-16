package mahdi.farshid.customnotificationpanel;


import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private Toolbar toolbar;
    private float toolbarHeight, toolbarAndPanelHeight;
    private RecyclerView recyclerView;
    private List<Data>mylists=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.CoordinatorLayout);
        relativeLayout = (RelativeLayout) findViewById(R.id.panel);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);

        initArrays();

        Adapter adapter=new Adapter(this,mylists);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,5);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        ViewTreeObserver viewTreeObserver = relativeLayout.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    relativeLayout.setY((-relativeLayout.getHeight()) + (toolbar.getHeight() + toolbar.getHeight() / 2));
                    toolbarHeight = toolbar.getHeight() + toolbar.getHeight() / 2;
                    toolbarAndPanelHeight = relativeLayout.getHeight() + (toolbar.getHeight() + toolbar.getHeight() / 2) - 10;
                }
            });
        }

        coordinatorLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        if (event.getY() < toolbarAndPanelHeight && event.getY() > toolbarHeight) {
                            relativeLayout.setY(event.getY() - relativeLayout.getHeight());
                        }
                        return true;
                    case MotionEvent.ACTION_DOWN:
                        return true;
                    case MotionEvent.ACTION_UP:
                        if ((toolbarAndPanelHeight/2)>event.getY()) {
                            relativeLayout.setY((-relativeLayout.getHeight()) + (toolbar.getHeight() + toolbar.getHeight() / 2));
                        }
                        if ((toolbarAndPanelHeight/2)<event.getY()) {
                            relativeLayout.setY(toolbarHeight-10);
                        }
                        return true;
                }
                return false;

            }

        });

    }

    void initArrays(){
        Data data1=new Data();
        data1.setImage(R.mipmap.ic_wifi);
        data1.setTitle("WI-FI");
        mylists.add(data1);

        Data data2=new Data();
        data2.setImage(R.mipmap.ic_airplane);
        data2.setTitle("airplace");
        mylists.add(data2);

        Data data3=new Data();
        data3.setImage(R.mipmap.ic_battery);
        data3.setTitle("battery");
        mylists.add(data3);

        Data data4=new Data();
        data4.setImage(R.mipmap.ic_bluetooth);
        data4.setTitle("bluetooth");
        mylists.add(data4);

        Data data5=new Data();
        data5.setImage(R.mipmap.ic_flashlight);
        data5.setTitle("flashlight");
        mylists.add(data5);

        Data data6=new Data();
        data6.setImage(R.mipmap.ic_location);
        data6.setTitle("location");
        mylists.add(data6);
    }
}
