package com.example.lenovo.unittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements MainView{

    private EditText et_width,et_height, et_lenght;
    private TextView tv_result;
    private Button bt_calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_width = (EditText) findViewById(R.id.et_width);
        et_height = (EditText) findViewById(R.id.et_height);
        et_lenght = (EditText) findViewById(R.id.et_length);
        bt_calculate = (Button) findViewById(R.id.bt_calculate);
        tv_result = (TextView) findViewById(R.id.tv_result);

        final MainPresenter presenter = new MainPresenter(this);

        bt_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String length = et_lenght.getText().toString().trim();
                String  width = et_width.getText().toString().trim();
                String height = et_height.getText().toString().trim();

                boolean isEmptyFields = false;
                if (TextUtils.isEmpty(length)){
                    isEmptyFields = true;
                    et_lenght.setError("Field ini tidak boleh kosong");
                }

                if (TextUtils.isEmpty(width)){
                    isEmptyFields = true;
                    et_width.setError("Field ini tidak boleh kosong");

                }

                if (TextUtils.isEmpty(height)){
                    isEmptyFields = true;
                    et_height.setError("Field ini tidak boleh kosong");
                }

                if (!isEmptyFields){
                    double l = Double.parseDouble(length);
                    double w = Double.parseDouble(width);
                    double h = Double.parseDouble(height);

                    presenter.HitungVolume(l , w , h);
                }

            }
        });
    }

    @Override
    public void tampilVolume(MainModel model) {
        tv_result.setText(String .valueOf(model.getVolume()));
    }
}
