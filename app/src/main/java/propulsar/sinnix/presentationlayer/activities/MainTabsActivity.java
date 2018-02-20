package propulsar.sinnix.presentationlayer.activities;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import propulsar.sinnix.R;
import propulsar.sinnix.presentationlayer.fragments.AgendaFragment;
import propulsar.sinnix.presentationlayer.fragments.SpeakersFragment;

public class MainTabsActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    TabLayout tabLayout;

    private static final int SINNIX=0;
    private static final int AGENDA=1;
    private static final int NETWORKING=2;
    private static final int SPEAKERS=3;
    private static final int PERFIL=4;
    boolean doubleBackToExitPressedOnce = false;

    AgendaFragment agendaFragment;
    SpeakersFragment speakersFragment;

    // -------------------------------------------- //
    // ---------------- LIFE CYCLE ---------------- //
    // -------------------------------------------- //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tabs);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        try {
            for(int i=0; i<tabLayout.getTabCount();i++){
                if(i==SINNIX){setTabIcon(i,R.drawable.ic_propulsar, R.color.textColorWhite);}
                if(i==AGENDA){setTabIcon(i,R.drawable.ic_mi_agenda, R.color.textColorWhite);}
                if(i==NETWORKING){setTabIcon(i,R.drawable.ic_networking, R.color.textColorWhite);}
                if(i==SPEAKERS){setTabIcon(i,R.drawable.ic_speakers, R.color.textColorWhite);}
                if(i==PERFIL){setTabIcon(i,R.drawable.ic_perfil, R.color.textColorWhite);}
            }
        }catch (Exception e){e.printStackTrace();}

    }

    /**
     * A placeholder fragment containing a simple view.
     */

    public static class PlaceholderFragment extends Fragment{
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment(){

        }

        public static PlaceholderFragment newInstance(int sectionNumber){
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_main_tabs,container,false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            return rootView;
        }
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter{

        public SectionsPagerAdapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {

            if(position==SINNIX){ agendaFragment = AgendaFragment.newInstance(); return agendaFragment;}
            if(position==AGENDA){ agendaFragment = AgendaFragment.newInstance(); return agendaFragment;}
            if(position==NETWORKING){agendaFragment = AgendaFragment.newInstance(); return agendaFragment; }
            if(position==SPEAKERS){ speakersFragment = SpeakersFragment.newInstance(); return speakersFragment;}
            if(position==PERFIL) {speakersFragment = SpeakersFragment.newInstance(); return speakersFragment;}
            return PlaceholderFragment.newInstance(position+1);
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

    // -------------------------------------------- //
    // --------------- OWN METHODS ---------------- //
    // -------------------------------------------- //

    private void setTabIcon(int tab, int icon, int color){
        tabLayout.getTabAt(tab).setIcon(icon);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            tabLayout.getTabAt(tab).getIcon().setTint(ResourcesCompat.getColor(getResources(),color,null));
        }else{
            Drawable originalDrawable = tabLayout.getTabAt(tab).getIcon();
            Drawable wrappedDrawable = DrawableCompat.wrap(originalDrawable);
            DrawableCompat.setTintList(wrappedDrawable, ColorStateList.valueOf(ResourcesCompat.getColor(getResources(),color,null)));
            tabLayout.getTabAt(tab).setIcon(wrappedDrawable);
        }
    }
}
