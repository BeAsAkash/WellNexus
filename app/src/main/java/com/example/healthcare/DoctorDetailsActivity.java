package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Mohan Gupta ","Hospital Address : Guna","Exp : 1yrs","Mobile No. : 9610008666","500"},
                    {"Doctor Name : Md. Vineet Harsh Goyal ","Hospital Address : Kota ","Exp : 5yrs","Mobile No. : 9914173314","900"},
                    {"Doctor Name : Akash Kumar ","Hospital Address : Lucknow","Exp : 10yrs","Mobile No. : 8318603270","1000"},
                    {"Doctor Name :  Harshit Yadav","Hospital Address : Mathura","Exp : 8yrs","Mobile No. : 9874465231","800"},
                    {"Doctor Name : Arin Raghuwanshi","Hospital Address : Varanasi","Exp : 4yrs","Mobile No. :9638855221 ","300"},
            };

    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Yash Gupta ","Hospital Address : Kota","Exp : 1yrs","Mobile No. : 9610008666","500"},
                    {"Doctor Name : Vineet  Goyal ","Hospital Address : Guna ","Exp : 5yrs","Mobile No. : 9914173314","700"},
                    {"Doctor Name : Akash Singh ","Hospital Address :Varansi","Exp : 10yrs","Mobile No. : 8318603270","900"},
                    {"Doctor Name : Manan Jain","Hospital Address : Lucknow","Exp : 8yrs","Mobile No. : 9874465231","800"},
                    {"Doctor Name : Dev Gaur","Hospital Address : Mathura","Exp : 4yrs","Mobile No. :9638855221 ","400"},
            };

    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Ram Singh ","Hospital Address : Guna","Exp : 1yrs","Mobile No. : 9610008666","500"},
                    {"Doctor Name :Shankar Sharma","Hospital Address : Kota ","Exp : 5yrs","Mobile No. : 9914173314","900"},
                    {"Doctor Name : Virat Kholi ","Hospital Address : Lucknow","Exp : 10yrs","Mobile No. : 8318603270","1000"},
                    {"Doctor Name :  Harsh Prajapati","Hospital Address : Mathura","Exp : 8yrs","Mobile No. : 9874465231","800"},
                    {"Doctor Name : Shankar Gupta","Hospital Address : Varanasi","Exp : 4yrs","Mobile No. :9638855221 ","300"},
            };

    private String[][] doctor_details4=
            {
                    {"Doctor Name : Mukesh Verma ","Hospital Address : Guna","Exp : 1yrs","Mobile No. : 9610008666","600"},
                    {"Doctor Name : Harsh Sharma","Hospital Address : Kota ","Exp : 5yrs","Mobile No. : 9914173314","900"},
                    {"Doctor Name : Shiwangita Singh","Hospital Address : Lucknow","Exp : 10yrs","Mobile No. : 8318603270","1000"},
                    {"Doctor Name : Ashutosh Mishra","Hospital Address : Mathura","Exp : 8yrs","Mobile No. : 9874465231","800"},
                    {"Doctor Name : Akash Sharma","Hospital Address : Varanasi","Exp : 4yrs","Mobile No. :9638855221 ","700"},
            };

    private String[][] doctor_details5=
            {
                    {"Doctor Name : Abdul Likhitkar","Hospital Address : Guna","Exp : 1yrs","Mobile No. : 9610008666","700"},
                    {"Doctor Name : Mukesh Chandra ","Hospital Address : Kota ","Exp : 5yrs","Mobile No. : 9914173314","900"},
                    {"Doctor Name : Md. David Sharma ","Hospital Address : Lucknow","Exp : 10yrs","Mobile No. : 8318603270","1000"},
                    {"Doctor Name : Shiwangita Sharma","Hospital Address : Mathura","Exp : 8yrs","Mobile No. : 9874465231","800"},
                    {"Doctor Name : Vineet Likhitkar","Hospital Address : Varanasi","Exp : 4yrs","Mobile No. :9638855221 ","900"},
            };

    TextView tv;
    Button btn;
    String[][] doctor_details ={};

    HashMap<String,String> item;
    ArrayList list;

    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonDDBack);

        Intent it=getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details=doctor_details1;
        else
        if(title.compareTo("Dietitian")==0)
            doctor_details=doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons_Fees"+ doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

    }
}