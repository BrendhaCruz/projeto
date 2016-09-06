package les.projeto.quebra_galho.view;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import les.projeto.quebra_galho.Fragments.OrcamentoFragment;
import les.projeto.quebra_galho.Fragments.TutorialFragment;
import les.projeto.quebra_galho.R;


public class TutorialActivity extends AppCompatActivity {


    private int id;
    private int pos;
    private String url;
    private String videos[][] = {
            {"https://www.youtube.com/watch?v=aeuZF6a5IaY", "https://www.youtube.com/watch?v=h4CbjZP5B_A", "https://www.youtube.com/watch?v=OYyIysnI9jY", "https://www.youtube.com/watch?v=nAbVcA7FNu4"},
            {"https://www.youtube.com/watch?v=H8uZuvBT04g", "https://www.youtube.com/watch?v=mSShZOeCzUs", "https://www.youtube.com/watch?v=N2D3OOP4AcM", "https://www.youtube.com/watch?v=n2v1AJIc5EQ"},
            {"https://www.youtube.com/watch?v=lnQXQROph4E", "https://www.youtube.com/watch?v=oj1Farv1ozk", "https://www.youtube.com/watch?v=duJbwMpICDA", "https://www.youtube.com/watch?v=iSEoV6nmDPk"},
            {"https://www.youtube.com/watch?v=D6ULLJq9Cu4", "https://www.youtube.com/watch?v=vgYMmlIoN4E", "https://www.youtube.com/watch?v=FY71PqOv5iI", "https://www.youtube.com/watch?v=iAcsKap1BRI"},
            {"https://www.youtube.com/watch?v=EYJDzqQRWME", "https://www.youtube.com/watch?v=y9I0sfAsQpQ", "https://www.youtube.com/watch?v=bodY2AlaAbY", "https://www.youtube.com/watch?v=wK6UWp4CCqM"},
            {"https://www.youtube.com/watch?v=XR7SUs35-f4", "https://www.youtube.com/watch?v=MNFCB7Ru3-0", "https://www.youtube.com/watch?v=nTHlUsxeEfw", "https://www.youtube.com/watch?v=zsRNJDAskUM"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutoriais_description);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        id = getIntent().getIntExtra("id", 1);
        pos = getIntent().getIntExtra("pos", 1);

        url = getUrl(id-1, pos);



        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        PagerAdapter pagerAdapter =
                new PagerAdapter(getSupportFragmentManager(), TutorialActivity.this);
        viewPager.setAdapter(pagerAdapter);


        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        // Iterate over all tabs and set the custom view
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));
        }

    }

    private String getUrl(int id, int pos) {
        return videos[id][pos];

    }


    @Override
    public void onResume() {
        super.onResume();
    }


    class PagerAdapter extends FragmentPagerAdapter {

        String tabTitles[] = new String[] {"Tutorial", "Ajuda"};
        Context context;

        public PagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    TutorialFragment frag = new TutorialFragment();
                    Bundle b = new Bundle();
                    b.putString("url", url);
                    frag.setArguments(b);
                    return frag;
                case 1:
                    return new OrcamentoFragment();
            }

            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }

        public View getTabView(int position) {
            View tab = LayoutInflater.from(TutorialActivity.this).inflate(R.layout.activity_tutoriais, null);
            TextView tv = (TextView) tab.findViewById(R.id.custom_text);
            tv.setText(tabTitles[position]);
            return tab;
        }

    }
}
