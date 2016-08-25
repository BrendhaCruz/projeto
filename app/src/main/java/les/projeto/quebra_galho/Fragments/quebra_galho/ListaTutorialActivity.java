package les.projeto.quebra_galho.Fragments.quebra_galho;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import les.projeto.quebra_galho.Fragments.quebra_galho.Fragments.ListaAlvenariaFragment;
import les.projeto.quebra_galho.Fragments.quebra_galho.Fragments.ListaCarpintariaFragment;
import les.projeto.quebra_galho.Fragments.quebra_galho.Fragments.ListaDiversosFragment;
import les.projeto.quebra_galho.Fragments.quebra_galho.Fragments.ListaEletricoFragment;
import les.projeto.quebra_galho.Fragments.quebra_galho.Fragments.ListaHidraulicoFragment;
import les.projeto.quebra_galho.Fragments.quebra_galho.Fragments.ListaMecanicoFragment;
import les.projeto.quebra_galho.R;

public class ListaTutorialActivity extends AppCompatActivity {
    private int categoria;
    private Categoria c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutoriais_main);
        categoria = getIntent().getIntExtra("categoria", 1);

        getCategoria();

        Log.d("Categoria id ", c.id + "create");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        PagerAdapter pagerAdapter =
                new PagerAdapter(getSupportFragmentManager(), c);
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

    private void getCategoria() {
        if(categoria == 1){
            c = Categoria.ELETRICO;
        } else if (categoria == 2){
            c = Categoria.HIDRAULICO;
        }
        else if (categoria == 3){
            c = Categoria.CARTPINTARIA;
        }
        else if (categoria == 4){
            c = Categoria.MECANICO;
        }
        else if (categoria == 5){
            c = Categoria.ALVENARIA;
        }
        else if (categoria == 6){
            c = Categoria.DIVERSOS;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        categoria = getIntent().getIntExtra("categoria", 1);
        getCategoria();
        Log.d("Categoria id ", c.id + "resume");
    }


    class PagerAdapter extends FragmentPagerAdapter {

        String tabTitles[] = new String[] {c.titulo};
//        Context context;
        Categoria cat;

        public PagerAdapter(FragmentManager fm, Categoria c) {
            super(fm);
//            this.context = context;
            this.cat = c;
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        @Override
        public Fragment getItem(int position) {

            switch (cat.id) {
                case 1:
                    return new ListaEletricoFragment();
                case 2:
                    return new ListaHidraulicoFragment();
                case 3:
                    return new ListaMecanicoFragment();
                case 4:
                    return new ListaCarpintariaFragment();
                case 5:
                    return new ListaAlvenariaFragment();
                case 6:
                    return new ListaDiversosFragment();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }

        public View getTabView(int position) {
            View tab = LayoutInflater.from(ListaTutorialActivity.this).inflate(R.layout.activity_tutoriais, null);
            TextView tv = (TextView) tab.findViewById(R.id.custom_text);
            tv.setText(tabTitles[position]);
            return tab;
        }

    }

    public enum Categoria{
        ELETRICO(1, "Tutoriais Eletricos"), HIDRAULICO(2, "Tutoriais Hidraulicos"), CARTPINTARIA(3, "Tutoriais de Carpintaria"),
        MECANICO(4, "Tutoriais Mecanicos"), ALVENARIA(5, "Tutoriais de Alvenaria"), DIVERSOS(6, "Tutoriais Diversos");

        private  int id;
        private String titulo;

        private Categoria(int id, String titulo){
            this.id = id;
            this.titulo = titulo;
        }

    }
}
