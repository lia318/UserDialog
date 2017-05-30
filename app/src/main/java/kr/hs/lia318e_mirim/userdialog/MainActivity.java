package kr.hs.lia318e_mirim.userdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textName, textEmail;
    EditText editName, editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but = (Button) findViewById(R.id.but);
        but.setOnClickListener(this);
        textName = (TextView) findViewById(R.id.text_name);
        textEmail = (TextView) findViewById(R.id.text_email);
        // id : activity_main.xml에서 지정된 것 사용
    } // end of onCreate

    @Override
    public void onClick(View v) {
        final View dlgV = View.inflate(getApplicationContext(), R.layout.dialog, null); // dialog.xml를 이용
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        // 익명 class가 아니다.
        // getApplicationContext() 문맥 객체 참조값을 써도 된다.

        dialog.setTitle("Input User Information");
        dialog.setIcon(R.drawable.got7_jinyoung_icon);
        dialog.setView(dlgV);

        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { // onClick이라는 추상 메소드 구현
                editName = (EditText) dlgV.findViewById(R.id.edit_name);
                editEmail = (EditText) dlgV.findViewById(R.id.edit_email);
                textName.setText(editName.getText());
                textEmail.setText(editEmail.getText());
                // 만들어지는 동시에 View dlgv 앞에 final 생성됨
                // final를 사용하고 싶지 않다면 View dlgv를 전역변수로 선언할 것
            }
        });
        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = new Toast(MainActivity.this);
                View toastV = View.inflate(MainActivity.this, R.layout.toast, null);
                TextView textToast = (TextView) toastV.findViewById(R.id.text_toast);
                textToast.setText("최소됨");
                toast.setView(toastV);
                toast.show();
            }
        });
        dialog.show();
    } // end of onClick
} // end of MainActivity