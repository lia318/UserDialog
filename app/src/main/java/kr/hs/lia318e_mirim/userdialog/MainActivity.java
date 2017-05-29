package kr.hs.lia318e_mirim.userdialog;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but = (Button) findViewById(R.id.but);
        but.setOnClickListener(this);
    } // end of onCreate

    @Override
    public void onClick(View v) {
        View dlgV = View.inflate(getApplicationContext(), R.layout.dialog, null);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        // 익명 class가 아니다.
        // getApplicationContext() 문맥 객체 참조값을 써도 된다.

        dialog.setTitle("Input User Information");
        dialog.setIcon(R.drawable.got7_jinyoung_icon);
        dialog.setView(dlgV);
        dialog.setPositiveButton("Ok", null);
        dialog.setNegativeButton("CANCEL", null);

    } // end of onClick
} // end of MainActivity