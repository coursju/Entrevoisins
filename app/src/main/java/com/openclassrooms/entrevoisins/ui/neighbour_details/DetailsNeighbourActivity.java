package com.openclassrooms.entrevoisins.ui.neighbour_details;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsNeighbourActivity extends AppCompatActivity {

    @BindView(R.id.details_avatar)
    ImageView detailsAvatar;
    @BindView(R.id.details_header_name)
    TextView detailsHeaderName;
    @BindView(R.id.details_name)
    TextView detailsName;
    @BindView(R.id.details_location)
    TextView detailsLocation;
    @BindView(R.id.details_phone)
    TextView detailsPhone;
    @BindView(R.id.details_web)
    TextView detailsWeb;
    @BindView(R.id.details_aboutme_text)
    TextView detailsAboutMeText;
    @BindView(R.id.add_neighbour_favorites)
    FloatingActionButton addFavorite;
    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;


    private Neighbour neighbour;
    String fragment;
    int position;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_neighbour);
        ButterKnife.bind(this);
         this.position = getIntent().getExtras().getInt("position");
         this.fragment = getIntent().getExtras().getString("fragment");

         Log.e("fragment = ", fragment);

         this.neighbour = fragmentType(fragment, position);



        //toolbar
        toolbar.setBackgroundColor(Color.TRANSPARENT);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        updateView();

        // Ajouter/ Enlever favories
        this.addFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFavorite(neighbour)){
                    DI.getNeighbourApiService().deleteFavorite(neighbour);
                    addFavorite.setColorFilter(Color.GRAY);
                    Toast.makeText(getApplicationContext(),R.string.remove_favorite,Toast.LENGTH_SHORT).show();

                }else{DI.getNeighbourApiService().createFavorite(neighbour);
                    addFavorite.setColorFilter(Color.MAGENTA);
                    Toast.makeText(getApplicationContext(),R.string.add_favorite,Toast.LENGTH_SHORT).show();

                }
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home : {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Met a jour les elements de la page
     */
    private void updateView(){
        Glide.with(detailsAvatar.getContext())
                .load(neighbour.getAvatarUrl())
                //.apply(RequestOptions.circleCropTransform())
                .into(detailsAvatar);
        this.detailsHeaderName.setText(neighbour.getName());
        this.detailsName.setText(neighbour.getName());
        this.detailsLocation.setText(neighbour.getAddress());
        this.detailsPhone.setText(neighbour.getPhoneNumber());
        this.detailsWeb.setText(neighbour.getWeb());
        this.detailsAboutMeText.setText(neighbour.getAboutMe());
        this.addFavorite.setColorFilter((isFavorite(neighbour)?Color.MAGENTA : Color.GRAY));
    }

    /**
     * Teste si l' élement dans le Detail est favorie ou pas
     * @param neighbour
     * @return
     */
    private boolean isFavorite(Neighbour neighbour){
        if(DI.getNeighbourApiService().getFavorites().contains(neighbour)){
            return true;
        }else{return false;}
    }

    /**
     * Methode pour savoir de quelle liste provient le neighbour
     * @param fragment
     * @param position
     * @return
     */
    private Neighbour fragmentType(String fragment, int position){
        switch(fragment) {

            case "Neighbour":
                Log.e(".........", "ca entre");
                return DI.getNeighbourApiService().getNeighbours().get(position);

            case "Favorite":
                return DI.getNeighbourApiService().getFavorites().get(position);

            default:
                return null;

        }

    }

}
