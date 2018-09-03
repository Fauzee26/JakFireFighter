package fauzi.hilmy.jakfirefighter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fauzi.hilmy.jakfirefighter.R;
import fauzi.hilmy.jakfirefighter.api.ApiClient;
import fauzi.hilmy.jakfirefighter.api.ApiInterface;
import fauzi.hilmy.jakfirefighter.model.DataItem;
import fauzi.hilmy.jakfirefighter.model.ResponsePemadam;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static fauzi.hilmy.jakfirefighter.activity.DetailActivity.E_ALAMAT;
import static fauzi.hilmy.jakfirefighter.activity.DetailActivity.E_JABATAN;
import static fauzi.hilmy.jakfirefighter.activity.DetailActivity.E_NAME;
import static fauzi.hilmy.jakfirefighter.activity.DetailActivity.E_PHONE;
import static fauzi.hilmy.jakfirefighter.activity.DetailActivity.E_WILAYAH;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    JakAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);

        loadData();
    }

    private void loadData() {
        ApiInterface apiInterface = ApiClient.getInstance();
        Call<ResponsePemadam> call = apiInterface.getPemadamStaf();
        call.enqueue(new Callback<ResponsePemadam>() {
            @Override
            public void onResponse(Call<ResponsePemadam> call, Response<ResponsePemadam> response) {
                if (response.body().getStatus().equalsIgnoreCase("success")) {
                    List<DataItem> dataItems = response.body().getData();
                    getSupportActionBar().setSubtitle(response.body().getDinas());

                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    adapter = new JakAdapter(MainActivity.this, dataItems);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setHasFixedSize(true);
                }
            }

            @Override
            public void onFailure(Call<ResponsePemadam> call, Throwable t) {

            }
        });
    }

    private class JakAdapter extends RecyclerView.Adapter<JakAdapter.MyViewHolder> {

        private Context context;
        private List<DataItem> dataItems;

        public JakAdapter(Context context, List<DataItem> dataitem) {
            this.context = context;
            this.dataItems = dataitem;
        }

        @NonNull
        @Override
        public JakAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull JakAdapter.MyViewHolder holder, final int position) {
            final DataItem item = dataItems.get(position);
            holder.txtNama.setText(item.getNama());
            holder.txtAlamat.setText(item.getAlamat());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, DetailActivity.class)
                            .putExtra(E_NAME, item.getNama())
                            .putExtra(E_ALAMAT, item.getAlamat())
                            .putExtra(E_JABATAN, item.getJabatan())
                            .putExtra(E_PHONE, item.getPhone())
                            .putExtra(E_WILAYAH, item.getWilayah());
                    context.startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return dataItems.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView txtNama, txtAlamat;

            MyViewHolder(View itemView) {
                super(itemView);
                txtNama = itemView.findViewById(R.id.txtNama);
                txtAlamat = itemView.findViewById(R.id.txtAlamat);
            }
        }
    }
}
