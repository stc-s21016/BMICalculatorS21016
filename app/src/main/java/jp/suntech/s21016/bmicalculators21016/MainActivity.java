package jp.suntech.s21016.bmicalculators21016;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.bt1);
        Button button1 = findViewById(R.id.bt2);

        bmicalculators21016 listner = new bmicalculators21016();

        button.setOnClickListener(listner);
        button1.setOnClickListener(listner);
    }

    private class bmicalculators21016 implements View.OnClickListener {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {
            EditText input  = findViewById(R.id.et_old);
            EditText input1 = findViewById(R.id.et_height);
            EditText input2 = findViewById(R.id.et_weight);
            TextView output = findViewById(R.id.tv_u);
            TextView output1 = findViewById(R.id.tv_ans);
            TextView output2 = findViewById(R.id.tv_ap);
            TextView output3 = findViewById(R.id.tv_utekisei);
            TextView output4 = findViewById(R.id.tv_kgg);
            String inputStr = input.getText().toString();
            String inputStr1 = input1.getText().toString();
            String inputStr2 = input2.getText().toString();
            float inputd  = Float.parseFloat(inputStr);
            float inputd1 = Float.parseFloat(inputStr1);
            float inputd2 = Float.parseFloat(inputStr2);
            float BMI = inputd2 / (inputd1/100 * inputd1/100);
            float Gaup = inputd2*1000 / (inputd1 * inputd1) * 10;
            float roreru = inputd2 / (inputd1 * inputd1 * inputd1) * 10000000;
            float roreruteki = (inputd1/100 * inputd1/100 * inputd1/100) * 13;
            float BMIteki = (inputd1/100 * inputd1/100) * 22;
            String BMIans = String.format("%f",BMIteki);
            String roraruans = String.format("%f", roreruteki);



            int id = view.getId();
            switch (id) {
                case R.id.bt2:
                    input.setText("");
                    input1.setText("");
                    input2.setText("");
                    break;
                case R.id.bt1:
                    if(inputd <= 15) {
                        Dialog DialogFragment = new Dialog();
                        DialogFragment.show(getSupportFragmentManager(), "Dialog");
                        output.setText(R.string.tv_Bmi_u_y);
                        if(inputd <= 15 && inputd >= 7){
                           if(roreru < 100) {
                               output1.setText(R.string.tv_Bmi_answer_y_r);
                               output1.setTextColor(Color.rgb(135,206,235));
                           }
                           else if (roreru >= 100 && roreru < 115) {
                               output1.setText(R.string.tv_Bmi_answer_yg_r);
                               output1.setTextColor(Color.rgb(173,216,230));
                           }
                           else if (roreru >= 115 && roreru < 145) {
                               output1.setText(R.string.tv_Bmi_answer_n_r);
                               output1.setTextColor(Color.rgb(50,205,50));
                           }
                           else if (roreru >= 145 && roreru < 160) {
                               output1.setText(R.string.tv_Bmi_answer_f1_r);
                               output1.setTextColor(Color.rgb(50,205,50));
                           }                                                             
                           else{
                               output1.setText(R.string.tv_Bmi_answer_f2_r);
                               output1.setTextColor(Color.rgb(255,255,0));
                           }
                           output2.setText(R.string.tv_Bmi_u_Ap_y);
                           output3.setText(roraruans);
                           output4.setText(R.string.tv_kg);       
                        }
                        if(inputd <= 6){
                           if(Gaup < 14) {
                           output1.setText(R.string.tv_Bmi_answer_y_y);
                           output1.setTextColor(Color.rgb(135,206,235));
                           }
                           else if (Gaup >= 15 && Gaup < 17) {                             
                               output1.setText(R.string.tv_Bmi_answer_n_y);
                               output1.setTextColor(Color.rgb(50,205,50));
                           }
                           else{
                               output1.setText(R.string.tv_Bmi_answer_f1_y);
                               output1.setTextColor(Color.rgb(255,255,0));
                           }
                           if(inputd < 6 && inputd >= 3){output3.setText("14～16.5");}
                           else if(inputd >= 2){output3.setText("15～17");}
                           else if(inputd >= 1){output3.setText("15.5～17.5");}
                           else{output3.setText("16～18");}
                           output2.setText(R.string.tv_Bmi_u_Ap_y_y);
                        }
                    }
                    else{
                        output.setText(R.string.tv_Bmi_u);
                            if(BMI < 18.5) {
                            output1.setText(R.string.tv_Bmi_answer_y);
                            output1.setTextColor(Color.rgb(135,206,235));
                            }
                            else if (BMI >= 18.5 && BMI < 25) {
                                output1.setText(R.string.tv_Bmi_answer_n);
                                output1.setTextColor(Color.rgb(50,205,50));
                            }
                            else if (BMI >= 25 && BMI < 30) {
                                output1.setText(R.string.tv_Bmi_answer_f1);
                                output1.setTextColor(Color.rgb(255,255,0));
                            }
                            else if (BMI >= 30 && BMI < 35) {
                                output1.setText(R.string.tv_Bmi_answer_f2);
                                output1.setTextColor(Color.rgb(255,215,0));
                            }
                            else if (BMI >= 35 && BMI < 40) {
                                output1.setText(R.string.tv_Bmi_answer_f3);
                                output1.setTextColor(Color.rgb(255,165,0));
                            }
                            else {
                                output1.setText(R.string.tv_Bmi_answer_f4);
                                output1.setTextColor(Color.rgb(255,69,0));
                            }
                        output2.setText(R.string.tv_Bmi_u_Ap);
                        output3.setText(BMIans);
                        output4.setText(R.string.tv_kg);
                    }
                    break;
            }
        }
    }
}