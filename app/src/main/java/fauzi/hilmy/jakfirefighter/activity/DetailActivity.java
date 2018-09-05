package fauzi.hilmy.jakfirefighter.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fauzi.hilmy.jakfirefighter.R;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.txtDetailName)
    TextView txtDetailName;
    @BindView(R.id.txtDetailWilayah)
    TextView txtDetailWilayah;
    @BindView(R.id.txtDetailAlamat)
    TextView txtDetailAlamat;
    @BindView(R.id.btnCall)
    Button btnCall;

    public static final String E_NAME = "name";
    public static final String E_PHONE = "phone";
    public static final String E_WILAYAH = "wilayah";
    public static final String E_ALAMAT = "alamat";
    public static final String E_JABATAN = "jabatan";

    String nama, phone, wilayah, alamat, jabatan;
    @BindView(R.id.txtDetailJabatan)
    TextView txtDetailJabatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        nama = getIntent().getStringExtra(E_NAME);
        phone = getIntent().getStringExtra(E_PHONE);
        wilayah = getIntent().getStringExtra(E_WILAYAH);
        alamat = getIntent().getStringExtra(E_ALAMAT);
        jabatan = getIntent().getStringExtra(jabatan);

        if (phone == null) {
            btnCall.setVisibility(View.GONE);
        } else {
            btnCall.setVisibility(View.VISIBLE);
            btnCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + phone));
                    if (callIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(callIntent);
                    }
                }
            });

        }

        txtDetailName.setText(nama);
        txtDetailWilayah.setText(wilayah);
        txtDetailAlamat.setText(alamat);
        txtDetailJabatan.setText(jabatan);
    }
}
