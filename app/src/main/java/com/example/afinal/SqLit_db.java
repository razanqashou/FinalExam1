package com.example.afinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SqLit_db extends AppCompatActivity {
    EditText id , name , salary;
    Button add, view , delete;
   DatabaseHelper databaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq_lit_db);
        databaseHelper=new DatabaseHelper(this);
        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        salary=findViewById(R.id.salary);
        add=findViewById(R.id.add);
        view=findViewById(R.id.view);
        delete=findViewById(R.id.deleted);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID=id.getText().toString();
                String NAME = name.getText().toString();
                Integer SALARY= Integer.parseInt(salary.getText().toString());
                databaseHelper.AddStudent(ID,NAME,SALARY);
                id.setText("");
                name.setText("");
                salary.setText("");
                Toast.makeText(SqLit_db.this,"successful add",Toast.LENGTH_SHORT).show();

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cur =databaseHelper.ViewStudent();
                StringBuffer buffer = new StringBuffer();
                while (cur.moveToNext()) {

                    buffer.append("ID :" + cur.getString(0) + "\n");
                    buffer.append("Name : " + cur.getString(1) + "\n");
                    buffer.append("Salary :" + cur.getString(2) + "\n\n");
                }
                AlertDialog.Builder builder= new AlertDialog.Builder(SqLit_db.this);
                builder.setCancelable(true);
                builder.setTitle(" STUDENT INFO");
                builder.setMessage(buffer.toString());
                builder.show();
                Toast.makeText(SqLit_db.this,"successful view",Toast.LENGTH_SHORT).show();


            }


        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID=id.getText().toString();
                databaseHelper.DeleteStudent(ID);
                id.setText("");
                name.setText("");
                salary.setText("");
                Toast.makeText(SqLit_db.this,"successful DELETE",Toast.LENGTH_SHORT).show();


            }
        });

    }
}