package com.example.checkloginmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Interface{

    EditText edEmail,edPass;
    TextView tvThongBao;
    Button btnCheck;
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edEmail = findViewById(R.id.edEmail);
        edPass = findViewById(R.id.edPass);
        tvThongBao = findViewById(R.id.tvThongBao);
        btnCheck = findViewById(R.id.btnCheck);
        presenter = new Presenter(this);

        tvThongBao.setVisibility(View.GONE);//đầu tiên mình sẽ cho ẩn textview thông báo đi
        //khi nào check mới hiện thông báo

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin();
            }
        });
    }

    private void checkLogin() {

        String email = edEmail.getText().toString().trim();
        String pass = edPass.getText().toString().trim();

        User user = new User(email,pass);
        presenter.login(user);
    }

    @Override
    public void loginThanhCong() {
        tvThongBao.setVisibility(View.VISIBLE);
        tvThongBao.setText("Email và pass đúng định dạng");
        tvThongBao.setTextColor(getResources().getColor(R.color.teal_700));
    }

    @Override
    public void loginThatBai() {
        tvThongBao.setVisibility(View.VISIBLE);
        tvThongBao.setText("Email và pass không đúng định dạng");
        tvThongBao.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
    }
}