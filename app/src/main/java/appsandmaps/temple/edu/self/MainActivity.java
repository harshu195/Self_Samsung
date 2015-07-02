package appsandmaps.temple.edu.self;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.container1,fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            image1 = (ImageView)findViewById(R.id.imageButton1);
            image2 = (ImageView)findViewById(R.id.imageButton7);
            image3 = (ImageView)findViewById(R.id.imageButton3);
            image4 = (ImageView)findViewById(R.id.imageButton4);
            image5 = (ImageView)findViewById(R.id.imageButton5);
            image6 = (ImageView)findViewById(R.id.imageButton6);

            image1.setOnClickListener(new View.OnClickListener() {


                public void onClick(View arg0) {

                    PlaceholderFragment fragment = new PlaceholderFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container1, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                }
            });

            image2.setOnClickListener(new View.OnClickListener() {


                public void onClick(View arg0) {

               Toast.makeText(MainActivity.this,"NULL",Toast.LENGTH_SHORT).show();

                }
            });

            image3.setOnClickListener(new View.OnClickListener() {


                public void onClick(View arg0) {

                    Toast.makeText(MainActivity.this,"NULL",Toast.LENGTH_SHORT).show();

                }
            });

            image4.setOnClickListener(new View.OnClickListener() {


                public void onClick(View arg0) {

                    Toast.makeText(MainActivity.this,"NULL",Toast.LENGTH_SHORT).show();

                }
            });

            image5.setOnClickListener(new View.OnClickListener() {


                public void onClick(View arg0) {

                    AppFragment fragment = new AppFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container1, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                }
            });

            image6.setOnClickListener(new View.OnClickListener() {


                public void onClick(View arg0) {

                    Toast.makeText(MainActivity.this,"NULL",Toast.LENGTH_SHORT).show();

                }
            });

        }
    }





    public static class MyArrayAdapter extends BaseAdapter {

        Context c;
        LayoutInflater in = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int colValue = 12;
        int[] imageId4 = {
                R.drawable.app2,
                R.drawable.app3,
                R.drawable.app4,
                R.drawable.app5,
                R.drawable.app6,
                R.drawable.app7,
                R.drawable.app8,
                R.drawable.app9,

        };

        public MyArrayAdapter(Context c) {

            this.c = c;
        }




        @Override
        public int getCount() {
            //MainActivity activity = (MainActivity) getActivity();
            // return Integer.valueOf(activity.getData());
            int var = colValue * colValue;
            return var;
        }


        @Override
        public Object getItem(int position) {
            return imageId4[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View row = convertView;

            if (convertView == null) {

                convertView = in.inflate(R.layout.holder, null);
                ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView2);


                imageView.setBackgroundResource(imageId4[position]);
                ((FrameLayout) convertView).addView(imageView);

            }
                /*TextView tv = new TextView(c);
                tv.setText(String.valueOf(position + 1));
                tv.setTextSize(25);

                ((FrameLayout) convertView).addView(tv);*/

                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(c, String.valueOf(position + 1), Toast.LENGTH_SHORT).show();
                    }
                });


            return convertView;


        }
    }


    public static class AppFragment extends Fragment  {
        public String data;

        public AppFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_app, container, false);

            ImageButton image = (ImageButton)rootView.findViewById(R.id.imageView7);

            image.setOnClickListener(new View.OnClickListener() {


                public void onClick(View arg0) {
                    Log.d("This is working","jkdsjdskjsdjkdskjhsd");
                }
            });

            return rootView;
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }



}
