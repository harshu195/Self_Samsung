package appsandmaps.temple.edu.self.BarFragments;


import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import appsandmaps.temple.edu.self.R;

public class GoalFragment extends Fragment {

    TextView tv;
    ProgressBar pBar;
    int pStatus = 0;
    private Handler handler = new Handler();

    public GoalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_goal, container, false);
        tv = (TextView) v.findViewById(R.id.tvGoal);
        pBar = (ProgressBar) v.findViewById(R.id.progressBarGoal);
        pBar.setSecondaryProgress(pBar.getMax());
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (pStatus <= 75) {
                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            pBar.setProgress(pStatus);
                            tv.setText("Goal \n" +pStatus + " %" );
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        // Just to display the progress slowly
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pStatus++;
                }
            }
        }).start();
        return  v;
    }
}