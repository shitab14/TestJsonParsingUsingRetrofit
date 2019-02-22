package com.mr_mir.testjsonparsingusingretrofit;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating a retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        //creating the api interface
        Api api = retrofit.create(Api.class);

        //now making the call object
        //Here we are using the api method that we created inside the api interface
        Call<List<Data>> call1 = api.getPhysicianSampleList();
        Call<List<Data>> call2 = api.getProductGroupList();
        Call<List<Data>> call3 = api.getGiftList();
        Call<List<Data>> call4 = api.getLiteratureList();

        //then finally we are making the call using enqueue()
        //it takes callback interface as an argument
        //and callback is having two methods onRespnose() and onFailure
        //if the request is successfull we will get the correct response and onResponse will be executed
        //if there is some error we will get inside the onFailure() method
        call1.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {

                //In this point we got our hero list
                //thats damn easy right ;)
                List<Data> PhysicianSampleList = response.body();

                //now we can do whatever we want with this list
                Toast.makeText(getApplicationContext(),"WORKS FINE",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Tag", t.getMessage());
                //Toast.makeText(getApplicationContext(),"NOT FINE",Toast.LENGTH_LONG).show();

            }

        });


    }
}
