package com.mantra.eyn.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mantra.eyn.ApiCallInterfaces.BikeApiClient;
import com.mantra.eyn.ApiCallInterfaces.CarApiClient;
import com.mantra.eyn.ApiCallInterfaces.ElectronicApiClient;
import com.mantra.eyn.ApiCallInterfaces.JobApiClient;
import com.mantra.eyn.ApiCallInterfaces.MobileApiClient;
import com.mantra.eyn.ApiCallInterfaces.PropertyApiClient;
import com.mantra.eyn.BikesResponseClasses.BikeResponseClass;
import com.mantra.eyn.BikesResponseClasses.DataClass;
import com.mantra.eyn.CarResponseClasses.DataCarClasses;
import com.mantra.eyn.CarResponseClasses.ResponseCarClasses;
import com.mantra.eyn.ClickListeners.BikeClickListener;
import com.mantra.eyn.ClickListeners.CarClickListener;
import com.mantra.eyn.ClickListeners.ElectronicsClickListener;
import com.mantra.eyn.ClickListeners.JobClickListener;
import com.mantra.eyn.ClickListeners.MobileClickListener;
import com.mantra.eyn.ClickListeners.PropertyClickListener;
import com.mantra.eyn.ElectronicsResponseClasses.DataElectronicClasses;
import com.mantra.eyn.ElectronicsResponseClasses.ResponseElectronicClasses;
import com.mantra.eyn.JobsReponseClasses.DataJobClasses;
import com.mantra.eyn.JobsReponseClasses.ResponseJobClasses;
import com.mantra.eyn.MobilesResponseClasses.DataMobileClasses;
import com.mantra.eyn.MobilesResponseClasses.ResponseMobileClasses;
import com.mantra.eyn.Networks.Network;
import com.mantra.eyn.PropertiesResponseClasses.DataPropertyClasses;
import com.mantra.eyn.PropertiesResponseClasses.ResponsePropertyClasses;
import com.mantra.eyn.R;
import com.mantra.eyn.ViewAdatpers.BikesViewAdapter;
import com.mantra.eyn.ViewAdatpers.CarViewAdapter;
import com.mantra.eyn.ViewAdatpers.ElectronicsViewAdapter;
import com.mantra.eyn.ViewAdatpers.JobsViewAdapter;
import com.mantra.eyn.ViewAdatpers.MobileViewAdapter;
import com.mantra.eyn.ViewAdatpers.PropertyViewAdapter;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrowseCategoryDisplayer extends AppCompatActivity implements CarClickListener, BikeClickListener,
        PropertyClickListener, JobClickListener, MobileClickListener, ElectronicsClickListener {
    private RecyclerView rv;
    private int position;
    private Animation topAnim, bottomAnim;
    private TextView tvCategoryName;
    private CarViewAdapter carViewAdapter;
    private ProgressBar pb;
    private BikesViewAdapter bikeViewAdapter;
    private JobsViewAdapter jobsViewAdapter;
    private ElectronicsViewAdapter electronicsViewAdapter;
    private MobileViewAdapter mobileViewAdapter;
    private PropertyViewAdapter propertyViewAdapter;
    private List<DataClass> bikeDataClassList = new ArrayList<>();
    private List<DataCarClasses> dataCarClassesArrayList = new ArrayList<>();
    private List<DataElectronicClasses> dataElectronicClassesArrayList = new ArrayList<>();
    private List<DataJobClasses> dataJobClassesArrayList = new ArrayList<>();
    private List<DataPropertyClasses> dataPropertyClassesArrayList = new ArrayList<>();
    private List<DataMobileClasses> dataMobileClassesArrayList = new ArrayList<>();

    /*When an Activity first call or launched then onCreate(Bundle savedInstanceState) method
    is responsible to create the activity.*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_category_displayer);
        initViews();
        getIntents();
        checkPosition();
    }

    private void initViews() {
        rv = findViewById(R.id.RVBC);
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        tvCategoryName = findViewById(R.id.tvCategoryNameBC);
        pb = findViewById(R.id.ProgressBarBC);
    }

    private void checkPosition() {
        if (position == 0) {
            tvCategoryName.setText(R.string.cars);
            setCarRecyclerView();
            setCarAdapter();
        }
        if (position == 1) {
            tvCategoryName.setText(R.string.property);
            setPropertyRecyclerView();
            setPropertyAdapter();
        }
        if (position == 2) {
            tvCategoryName.setText(R.string.mobiles);
            setMobileRecyclerView();
            setMobileAdapter();
        }
        if (position == 3) {
            tvCategoryName.setText(R.string.jobs);
            setJobsRecyclerView();
            setJobsAdapter();
        }
        if (position == 4) {
            tvCategoryName.setText(R.string.bikes);
            setBikesRecyclerView();
            setBikesAdapter();
        }
        if (position == 5) {
            tvCategoryName.setText(R.string.electronics);
            setElectronicsRecyclerView();
            setElectronicsAdapter();
        }
    }

    private void setElectronicsAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        electronicsViewAdapter = new ElectronicsViewAdapter(dataElectronicClassesArrayList, this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(electronicsViewAdapter);
        rv.setAnimation(topAnim);
    }

    private void setElectronicsRecyclerView() {
        ElectronicApiClient apiClient = Network.getInstance().create(ElectronicApiClient.class);
        apiClient.getApit().enqueue(new Callback<ResponseElectronicClasses>() {
            @Override
            public void onResponse(Call<ResponseElectronicClasses> call, Response<ResponseElectronicClasses> response) {
                if (response.body() != null) {
                    dataElectronicClassesArrayList = response.body().getData();
                    electronicsViewAdapter.updateData(dataElectronicClassesArrayList);
                    pb.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(Call<ResponseElectronicClasses> call, Throwable t) {

            }
        });
    }

    private void setBikesAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        bikeViewAdapter = new BikesViewAdapter(bikeDataClassList, this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(bikeViewAdapter);
        rv.setAnimation(topAnim);
    }

    private void setBikesRecyclerView() {
        BikeApiClient apiClient = Network.getInstance().create(BikeApiClient.class);
        apiClient.getApi().enqueue(new Callback<BikeResponseClass>() {
            @Override
            public void onResponse(Call<BikeResponseClass> call, Response<BikeResponseClass> response) {
                if (response.body() != null) {
                    bikeDataClassList = response.body().getData();
                    bikeViewAdapter.updateData(bikeDataClassList);
                    pb.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(Call<BikeResponseClass> call, Throwable t) {

            }
        });
    }

    private void setJobsAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        jobsViewAdapter = new JobsViewAdapter(dataJobClassesArrayList, this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(jobsViewAdapter);
        rv.setAnimation(topAnim);
    }

    private void setJobsRecyclerView() {
        JobApiClient apiClient = Network.getInstance().create(JobApiClient.class);
        apiClient.getApit().enqueue(new Callback<ResponseJobClasses>() {
            @Override
            public void onResponse(Call<ResponseJobClasses> call, Response<ResponseJobClasses> response) {
                if (response.body() != null) {
                    dataJobClassesArrayList = response.body().getData();
                    jobsViewAdapter.updateData(dataJobClassesArrayList);
                    pb.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(Call<ResponseJobClasses> call, Throwable t) {

            }
        });
    }

    private void setMobileAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mobileViewAdapter = new MobileViewAdapter(dataMobileClassesArrayList, this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(mobileViewAdapter);
    }

    private void setMobileRecyclerView() {
        MobileApiClient apiClient = Network.getInstance().create(MobileApiClient.class);
        apiClient.getApit().enqueue(new Callback<ResponseMobileClasses>() {
            @Override
            public void onResponse(Call<ResponseMobileClasses> call, Response<ResponseMobileClasses> response) {
                if (response.body() != null) {
                    dataMobileClassesArrayList = response.body().getData();
                    mobileViewAdapter.updateData(dataMobileClassesArrayList);
                    pb.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(Call<ResponseMobileClasses> call, Throwable t) {

            }
        });
    }

    private void setPropertyAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        propertyViewAdapter = new PropertyViewAdapter(dataPropertyClassesArrayList, this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(propertyViewAdapter);
    }

    private void setPropertyRecyclerView() {
        PropertyApiClient apiClient = Network.getInstance().create(PropertyApiClient.class);
        apiClient.getApit().enqueue(new Callback<ResponsePropertyClasses>() {
            @Override
            public void onResponse(Call<ResponsePropertyClasses> call, Response<ResponsePropertyClasses> response) {
                if (response.body() != null) {
                    dataPropertyClassesArrayList = response.body().getData();
                    propertyViewAdapter.updateData(dataPropertyClassesArrayList);
                    pb.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(Call<ResponsePropertyClasses> call, Throwable t) {

            }
        });
    }

    private void setCarAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        carViewAdapter = new CarViewAdapter(dataCarClassesArrayList, this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(carViewAdapter);
    }

    private void setCarRecyclerView() {
        CarApiClient apiClient = Network.getInstance().create(CarApiClient.class);
        apiClient.getApit().enqueue(new Callback<ResponseCarClasses>() {
            @Override
            public void onResponse(Call<ResponseCarClasses> call, Response<ResponseCarClasses> response) {
                if (response.body() != null) {
                    dataCarClassesArrayList = response.body().getData();
                    carViewAdapter.updateData(dataCarClassesArrayList);
                    pb.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<ResponseCarClasses> call, Throwable t) {

            }
        });
    }


    private void getIntents() {
        if (getIntent() != null) {
            position = getIntent().getIntExtra("position", 0);
        }
    }

    @Override
    public void onClick(DataCarClasses dataCarClasses) {
        try {
            Intent intent = new Intent(BrowseCategoryDisplayer.this, ItemDetails.class);
            intent.putExtra("price", dataCarClasses.getPrice().getValue().getDisplay());
            intent.putExtra("title", dataCarClasses.getTitle());
            intent.putExtra("extras", dataCarClasses.getMainInfo());
            intent.putExtra("image1", dataCarClasses.getImages().get(0).getUrl());
            intent.putExtra("image2", dataCarClasses.getImages().get(1).getUrl());
            intent.putExtra("town", dataCarClasses.getLocationsResolved().getADMINLEVEL3Name());
            intent.putExtra("city", dataCarClasses.getLocationsResolved().getADMINLEVEL1Name());
            intent.putExtra("description", dataCarClasses.getDescription());
            startActivity(intent);
        } catch (Exception e) {
            Toasty.info(BrowseCategoryDisplayer.this, "Failed to fetch results, try again!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(DataClass dataClass) {
        try {
            Intent intent = new Intent(BrowseCategoryDisplayer.this, ItemDetails.class);
            intent.putExtra("price", dataClass.getPrice().getValue().getDisplay());
            intent.putExtra("title", dataClass.getTitle());
            intent.putExtra("extras", dataClass.getMainInfo());
            intent.putExtra("image1", dataClass.getImages().get(0).getUrl());
            intent.putExtra("image2", dataClass.getImages().get(1).getUrl());
            intent.putExtra("town", dataClass.getLocationsResolved().getADMINLEVEL3Name());
            intent.putExtra("city", dataClass.getLocationsResolved().getADMINLEVEL1Name());
            intent.putExtra("description", dataClass.getDescription());
            startActivity(intent);
        } catch (Exception e) {
            Toasty.info(BrowseCategoryDisplayer.this, "Failed to fetch results, try again!", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onClick(DataPropertyClasses dataPropertyClasses) {
        try {
            Intent intent = new Intent(BrowseCategoryDisplayer.this, ItemDetails.class);
            intent.putExtra("price", dataPropertyClasses.getPrice().getValue().getDisplay());
            intent.putExtra("title", dataPropertyClasses.getTitle());
//            intent.putExtra("extras", dataPropertyClasses.getMainInfo());
            intent.putExtra("image1", dataPropertyClasses.getImages().get(0).getUrl());
            intent.putExtra("image2", dataPropertyClasses.getImages().get(1).getUrl());
            intent.putExtra("town", dataPropertyClasses.getLocationsResolved().getADMINLEVEL3Name());
            intent.putExtra("city", dataPropertyClasses.getLocationsResolved().getADMINLEVEL1Name());
            intent.putExtra("description", dataPropertyClasses.getDescription());
            startActivity(intent);
        } catch (Exception e) {
            Toasty.info(BrowseCategoryDisplayer.this, "Failed to fetch results, try again!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(DataJobClasses dataJobClasses) {
        try {
            Intent intent = new Intent(BrowseCategoryDisplayer.this, ItemDetails.class);
//            intent.putExtra("price", dataJobClasses.getPrice().getValue().getDisplay());
            intent.putExtra("title", dataJobClasses.getTitle());
//            intent.putExtra("extras", dataPropertyClasses.getMainInfo());
            intent.putExtra("image1", dataJobClasses.getImages().get(0).getUrl());
            intent.putExtra("image2", dataJobClasses.getImages().get(1).getUrl());
            intent.putExtra("town", dataJobClasses.getLocationsResolved().getADMINLEVEL3Name());
            intent.putExtra("city", dataJobClasses.getLocationsResolved().getADMINLEVEL1Name());
            intent.putExtra("description", dataJobClasses.getDescription());
            startActivity(intent);
        } catch (Exception e) {
            Toasty.info(BrowseCategoryDisplayer.this, "Failed to fetch results, try again!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(DataMobileClasses dataMobileClasses) {
        try {
            Intent intent = new Intent(BrowseCategoryDisplayer.this, ItemDetails.class);
            intent.putExtra("price", dataMobileClasses.getPrice().getValue().getDisplay());
            intent.putExtra("title", dataMobileClasses.getTitle());
            intent.putExtra("extras", dataMobileClasses.getLocationsResolved().getCOUNTRYName());
            intent.putExtra("image1", dataMobileClasses.getImages().get(0).getUrl());
            intent.putExtra("image2", dataMobileClasses.getImages().get(1).getUrl());
            intent.putExtra("town", dataMobileClasses.getLocationsResolved().getADMINLEVEL3Name());
            intent.putExtra("city", dataMobileClasses.getLocationsResolved().getADMINLEVEL1Name());
            intent.putExtra("description", dataMobileClasses.getDescription());
            startActivity(intent);
        } catch (Exception e) {
            Toasty.info(BrowseCategoryDisplayer.this, "Failed to fetch results, try again!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(DataElectronicClasses dataElectronicClasses) {
        try {
            Intent intent = new Intent(BrowseCategoryDisplayer.this, ItemDetails.class);
            intent.putExtra("price", dataElectronicClasses.getPrice().getValue().getDisplay());
            intent.putExtra("title", dataElectronicClasses.getTitle());
            intent.putExtra("extras", dataElectronicClasses.getLocationsResolved().getCOUNTRYName());
            intent.putExtra("image1", dataElectronicClasses.getImages().get(0).getUrl());
            intent.putExtra("image2", dataElectronicClasses.getImages().get(1).getUrl());
            intent.putExtra("town", dataElectronicClasses.getLocationsResolved().getADMINLEVEL3Name());
            intent.putExtra("city", dataElectronicClasses.getLocationsResolved().getADMINLEVEL1Name());
            intent.putExtra("description", dataElectronicClasses.getDescription());
            startActivity(intent);
        } catch (Exception e) {
            Toasty.info(BrowseCategoryDisplayer.this, "Failed to fetch results, try again!", Toast.LENGTH_LONG).show();
        }
    }
}