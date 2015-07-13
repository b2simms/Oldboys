package com.example.bsimmons.manion_ver2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    //First We Declare Titles And Icons For Our Navigation Drawer List View
    //This Icons And Titles Are holded in an Array as you can see

    String TITLES[] = {"Profile","Claims History","Benefit Coverage","Update Info","Documents"};
    ArrayList<String> SUBMENU = new ArrayList();
    int ICONS[] = {R.drawable.icon_accountoutline,
            R.drawable.icon_wordpress,
            R.drawable.icon_xboxcontroller,
            R.drawable.icon_calendarcheck,
            R.drawable.icon_library};

    Button button1;
    PopupMenu popup;

    //Similarly we Create a String Resource for the name and email in the header view
    //And we also create a int resource for profile picture in the header view

    String NAME = "Manion Wilkins & Associates Ltd";
    int PROFILE = R.drawable.manion_image;

    private Toolbar toolbar;                              // Declaring the Toolbar Object

    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    DrawerLayout Drawer;                                  // Declaring DrawerLayout

    ActionBarDrawerToggle mDrawerToggle;                  // Declaring Action Bar Drawer Toggle




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    /* Assinging the toolbar object ot the view
    and setting the the Action bar to our toolbar
     */
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);




        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView); // Assigning the RecyclerView Object to the xml View

        mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size

        mAdapter = new MyAdapter(TITLES,ICONS,NAME,PROFILE,this);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
        // And passing the titles,icons,header view name, header view email,
        // and header view profile picture

        mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView

        final GestureDetector mGestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });


        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());


                if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
                    Drawer.closeDrawers();
                    Toast.makeText(MainActivity.this, "The Item Clicked is: " + recyclerView.getChildAdapterPosition(child), Toast.LENGTH_SHORT).show();

                    // update the main content by replacing fragments
                    FragmentManager fragmentManager = getSupportFragmentManager();



                    Fragment objFrag = null;
                    objFrag = new fragment_profile();

                    String tag = "";

                    TextView title = (TextView) findViewById(R.id.nav_bar_title);

                    switch (recyclerView.getChildAdapterPosition(child)) {
                        case 1:
                            tag = "Profile";
                            title.setText(tag);
                            objFrag = new fragment_profile();
                            fragmentManager.beginTransaction()
                                    .replace(R.id.container, objFrag, tag)
                                    .commit();
                            break;
                        case 2:
                            tag = "Claims History";
                            objFrag = new fragment_claimsHistory();

                            fragmentManager.beginTransaction()
                                    .replace(R.id.container, objFrag, tag)
                                    .commit();
                            break;
                        case 3:
                            tag = "Benefit Coverage";
                            objFrag = new Fragment_BenefitCoverage();

                            fragmentManager.beginTransaction()
                                    .replace(R.id.container, objFrag, tag)
                                    .commit();
                            break;
                        case 4:
                            tag = "Submit Claim";
                            objFrag = new fragment_submitClaim();

                            fragmentManager.beginTransaction()
                                    .replace(R.id.container, objFrag, tag)
                                    .commit();
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        default: break;
                    }
                    return false;
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {


            }


            public void onRequestDisallowInterceptTouchEvent(boolean b){

            }
        });


        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager

        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager


        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.openDrawer,R.string.closeDrawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }

        }; // Drawer Toggle Object Made
        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State

        setSubmenuButton();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void setSubmenuButton(){

        button1 = (Button) findViewById(R.id.submenu_button);

        //Creating the instance of PopupMenu
        popup = new PopupMenu(MainActivity.this, button1);

        popup.getMenu().add(Menu.NONE,0,0,"General Information");
        popup.getMenu().add(Menu.NONE,1,1,"Contact Information");
        popup.getMenu().add(Menu.NONE,2,2,"Employer");
        popup.getMenu().add(Menu.NONE,3,3,"Dependents");
        popup.getMenu().add(Menu.NONE,4,4,"Life Insurance Beneficiaries");
        //Inflating the Popup using xml file
        popup.getMenuInflater()
                .inflate(R.menu.submenu, popup.getMenu());


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //PUT popup HERE TO DYNAMICALLY CHANGE THE ITEMS IN LIST

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                MainActivity.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();

                        TextView submenuText = (TextView) findViewById(R.id.submenu_text);
                        submenuText.setText(item.getTitle());

                        try {

                            Fragment next_transition = null;

                            switch (item.getItemId()) {
                                case 0:
                                    next_transition = new Fragment_Profile_GeneralInfo();
                                    break;
                                case 1:
                                    next_transition = new Fragment_Profile_ContactInfo();
                                    break;
                                case 2:
                                    next_transition = new Fragment_Profile_Employer();
                                    break;
                                case 3:
                                    next_transition = new Fragment_Profile_Dependants();
                                    break;
                                case 4:
                                    next_transition = new Fragment_Profile_LifeInsur();
                                    break;
                                default:
                                    break;
                            }

                            FragmentManager fm = getSupportFragmentManager();
                            fm.beginTransaction()
                                    .replace(R.id.container, next_transition)
                                    .commit();

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }


                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        }); //closing the setOnClickListener method

    }
}