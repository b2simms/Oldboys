package com.example.bsimmons.manion_ver2;

import android.content.Context;
import android.content.res.Configuration;
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
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private final String PROFILE = "Profile";
    private final String CLAIMS_HISTORY = "Claims History";
    private final String BENEFIT_COVERAGE = "Benefit Coverage";
    private final String DOCUMENTS = "Documents";
    private final String WELCOME = "Welcome";
    private final String EDIT_CONTACT_INFO = "Edit Contact Info";

    //SUBMENUS
    String[] submenu_profile = {"Overview","Contact/Employer","Dependents/Beneficiaries"};
    //String[] submenu_claimshistory = {"My Claim History"};
    //String[] submenu_benefitcoverage = {"Class","Available Benefits","Waived Benefits"};

    private final int ICONS[] = {R.drawable.icon_accountoutline,
            R.drawable.icon_wordpress,
            R.drawable.icon_xbox,
            R.drawable.icon_library};

    private Button submenu_button;
    private PopupMenu popup;
    private String tag = "";

    private final String NAME = "Manion Wilkins & Associates Ltd";
    private final int HEADER_IMAGE = R.drawable.manion_image;

    private Toolbar toolbar;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DrawerLayout Drawer;

    private ActionBarDrawerToggle mDrawerToggle;
    private RelativeLayout submenu_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);

        mRecyclerView.setHasFixedSize(true);

        mAdapter = new Adapter_MainMenu(new String[]{PROFILE,CLAIMS_HISTORY,BENEFIT_COVERAGE,DOCUMENTS},ICONS,NAME,HEADER_IMAGE,this);

        mRecyclerView.setAdapter(mAdapter);

        final GestureDetector mGestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
            @Override public boolean onDoubleTap(MotionEvent e){
                return true;
            }
            @Override public boolean onDoubleTapEvent(MotionEvent e){
                return true;
            }
            @Override public boolean onSingleTapConfirmed(MotionEvent e){
                return true;
            }

        });


        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());


                if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
                    Drawer.closeDrawers();

                    // update the main content by replacing fragments
                    FragmentManager fragmentManager = getSupportFragmentManager();

                    Fragment objFrag = null;

                    submenu_bar = (RelativeLayout) findViewById(R.id.submenu_bar);
                    submenu_bar.setVisibility(View.VISIBLE);

                    TextView title = (TextView) findViewById(R.id.nav_bar_title);

                    switch (recyclerView.getChildAdapterPosition(child)) {
                        case 1:
                            tag = PROFILE;
                            title.setText(tag);
                            setSubmenuOptions(submenu_profile);
                            setSubmenuTitle(submenu_profile[0]);
                            submenu_bar.setVisibility(View.VISIBLE);
                            objFrag = new Fragment_Profile_Overview();

                            fragmentManager.beginTransaction()
                                    .replace(R.id.container, objFrag, tag)
                                    .addToBackStack(tag)
                                    .commit();
                            break;
                        case 2:
                            tag = CLAIMS_HISTORY;
                            title.setText(tag);
                            submenu_bar.setVisibility(View.GONE);
                            objFrag = new Fragment_ClaimHistory();

                            fragmentManager.beginTransaction()
                                    .replace(R.id.container, objFrag, tag)
                                    .addToBackStack(tag)
                                    .commit();
                            break;
                        case 3:
                            tag = BENEFIT_COVERAGE;
                            title.setText(tag);
                            submenu_bar.setVisibility(View.GONE);
                            objFrag = new Fragment_BenefitCoverage();

                            fragmentManager.beginTransaction()
                                    .replace(R.id.container, objFrag, tag)
                                    .addToBackStack(tag)
                                    .commit();
                            break;
                        case 4:
                            submenu_bar.setVisibility(View.GONE);
                            title.setText(DOCUMENTS);
                            fragmentManager.beginTransaction()
                                    .replace(R.id.container, new Fragment_Documents(), DOCUMENTS)
                                    .addToBackStack(tag)
                                    .commit();
                            break;
                        default:
                            break;
                    }
                    return false;
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {


            }


            public void onRequestDisallowInterceptTouchEvent(boolean b) {

            }
        });


        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.openDrawer,R.string.closeDrawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                View view = getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

        };
        Drawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        setSubmenuButton();

        submenu_bar = (RelativeLayout) findViewById(R.id.submenu_bar);
        submenu_bar.setVisibility(View.GONE);
        submenu_bar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                submenu_button.performClick();
            }
        });

        FragmentManager fmanager = getSupportFragmentManager();
        fmanager.beginTransaction()
                .replace(R.id.container,new Fragment_Welcome(), tag)
                .commit();

        TextView title = (TextView) findViewById(R.id.nav_bar_title);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawer.openDrawer(findViewById(R.id.RecyclerView));
                Log.d("Debug","Open Nav Drawer FROM nav_bar_main_title");
            }
        });

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {

            @Override
            public void onBackStackChanged() {
                Fragment f = getSupportFragmentManager().findFragmentById(R.id.container);
                if (f != null) {
                    updateSubmenuAndTitle(f);
                }
            }
        });


    } //***  end OnCreate  ***

//    @Override
//    public void onResume(){
//        super.onResume();
//        // Hide status bar
//        View decorView = getWindow().getDecorView();
//        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
//
//    }


    private void updateSubmenuAndTitle(Fragment f) {
        String fragClassName = f.getClass().getSimpleName();
        TextView title = (TextView) findViewById(R.id.nav_bar_title);

        if(fragClassName.equals("Fragment_Profile_Overview") || fragClassName.equals("Fragment_Profile_ContactANDEmployer")
                || fragClassName.equals("Fragment_Profile_DependantsANDBeneficiaries")){
            submenu_bar.setVisibility(View.VISIBLE);
        }else{
            submenu_bar.setVisibility(View.GONE);
        }

        switch(fragClassName){
        case "Fragment_Profile_Overview":
            title.setText(PROFILE);
            setSubmenuTitle(submenu_profile[0]);
            setSubmenuOptions(submenu_profile);
            break;
        case "Fragment_Profile_ContactANDEmployer":
            title.setText(PROFILE);
            setSubmenuTitle(submenu_profile[1]);
            setSubmenuOptions(submenu_profile);
            break;
        case "Fragment_Profile_DependantsANDBeneficiaries":
            title.setText(PROFILE);
            setSubmenuTitle(submenu_profile[2]);
            setSubmenuOptions(submenu_profile);
            break;
        case "Fragment_ClaimHistory":
            title.setText(CLAIMS_HISTORY);
            break;
        case "Fragment_BenefitCoverage":
                title.setText(BENEFIT_COVERAGE);
                break;
        case "Fragment_Documents":
            title.setText(DOCUMENTS);
            break;
        case "Fragment_Profile_EditContactInfo":
            //title.setText(EDIT_CONTACT_INFO);
            break;

        default:
            title.setText(WELCOME);
            break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            FragmentManager fm = getSupportFragmentManager();
            fm.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            tag = WELCOME;
            TextView title = (TextView) findViewById(R.id.nav_bar_title);
            title.setText(tag);
            fm.beginTransaction()
                    .replace(R.id.container,new Fragment_Welcome(), tag)
                    .commit();
            return true;
        }
        if(id == R.id.profile_icon){
            tag = PROFILE;
            submenu_bar.setVisibility(View.VISIBLE);

            TextView title = (TextView) findViewById(R.id.nav_bar_title);
            title.setText(tag);
            setSubmenuOptions(submenu_profile);
            setSubmenuTitle(submenu_profile[0]);

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, new Fragment_Profile_Overview(), tag)
                    .addToBackStack(tag)
                    .commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setSubmenuButton();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setSubmenuButton();
        }
    }


    public void setSubmenuButton() {

        submenu_button = (Button) findViewById(R.id.submenu_button);

        submenu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        try {
                            Fragment next_transition = null;
                            Fragment[] fragments_main = null;

                            //TRANSITION FRAGMENTS
                            Fragment[] fragments_profile = {new Fragment_Profile_Overview(), new Fragment_Profile_ContactANDEmployer(),
                                    new Fragment_Profile_DependantsANDBeneficiaries()};
                            Fragment[] fragments_claimshistory = {new Fragment_ClaimHistory()};
                            Fragment[] fragments_benefitcoverage = {new Fragment_BenefitCoverage()};


                            //MAIN FRAGMENTS
                            if (tag.equalsIgnoreCase(PROFILE)) {
                                fragments_main = fragments_profile;
                            } else if (tag.equalsIgnoreCase(CLAIMS_HISTORY)) {
                                fragments_main = fragments_claimshistory;
                            } else if (tag.equalsIgnoreCase(BENEFIT_COVERAGE)) {
                                fragments_main = fragments_benefitcoverage;
                            }

                            setSubmenuTitle((String) item.getTitle());
                            next_transition = fragments_main[item.getItemId()];

                            FragmentManager fm = getSupportFragmentManager();
                            fm.beginTransaction()
                                    .replace(R.id.container, next_transition, tag)
                                    .addToBackStack(tag)
                                    .commit();

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        return true;
                    }
                });

                popup.show();
            }
        });
    }

    public void setSubmenuOptions(String[] s) {

        popup = new PopupMenu(MainActivity.this, submenu_button);

        for(int i=0;i<s.length;i++){
            popup.getMenu().add(Menu.NONE,i,i,s[i]);
        }
        popup.getMenuInflater()
                .inflate(R.menu.submenu, popup.getMenu());
    }

    public void setSubmenuTitle(String title){
        TextView submenuText = (TextView) findViewById(R.id.submenu_text);
        submenuText.setText(title);
    }


    public void doNothing(View v){
        //DO NOT DELETE
        //do nothing onClick of claim header
    }



}