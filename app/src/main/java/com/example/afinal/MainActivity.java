package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Integer [] uni={R.drawable.j1,R.drawable.j2,R.drawable.j3,R.drawable.j4,
            R.drawable.j5,R.drawable.j6};
    ImageView pic;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.grid);
        pic=findViewById(R.id.image);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(),"item"+uni[i],Toast.LENGTH_SHORT).show();
                pic.setImageResource(uni[i]);
            }
        });

        gridView.setAdapter( new ImageAdapter(this));

    }
    public class ImageAdapter extends BaseAdapter{
        Context context;

        public ImageAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return uni.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            pic=new ImageView(context);
            pic.setImageResource(uni[i]);

            return pic;
        }
    }
}