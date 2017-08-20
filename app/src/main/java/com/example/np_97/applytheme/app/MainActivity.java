package com.example.np_97.applytheme.app;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import com.example.np_97.applytheme.R;
import com.example.np_97.applytheme.adapter.RecyclerAdapter;
import com.example.np_97.applytheme.model.Landscape;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP){
//            //i WILL CALL SOME MATERIAL DESIGN API HERE
//        }
//        else
//        {
//            //For below api level 21
//        }

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Home page!");

        //toolbar.setSubtitle("Folks ");
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setTitle("Welcome");
//        toolbar.setSubtitle("Folks !");
//        toolbar.setLogo(R.drawable.parvez);
//        toolbar.setNavigationIcon(R.drawable.signature);

        // Compatibility by Java Code
//        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
//            toolbar.setElevation(10f);
//        }


   toolbar.inflateMenu(R.menu.menu_main);
      setUpRecyclerView();




//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){
//            @Override
//            public boolean onMenuItemClick(MenuItem item){
//                // switch case
//
//                    String msg="";
//
//                    switch (item.getItemId()){
//                        case R.id.discard:
//                            msg="Delete ";
//                            break;
//
//                        case R.id.search:
//                            msg="Search ";
//                            break;
//
//                        case R.id.settings:
//                            msg="Settings ";
//                            break;
//
//                        case R.id.edit:
//                            msg="Edit ";
//                            break;
//
//                        case R.id.exit:
//                            msg="Exit ";
//                            break;
//
//                    }
//                    Toast.makeText(MainActivity.this, msg + " Clicked",Toast.LENGTH_SHORT).show();
//                    return true;
//            }
//        });


    }


    private void setUpRecyclerView() {
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        RecyclerAdapter adapter=new RecyclerAdapter(this, Landscape.getData());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mlinearLayoutManagerVertical=new LinearLayoutManager(this);
        mlinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mlinearLayoutManagerVertical);

        recyclerView.setItemAnimator(new DefaultItemAnimator());  //Even if we don't use it code will work

    }


}
