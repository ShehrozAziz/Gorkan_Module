package com.example.gorkan_module;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Toast;

public class ConfirmedOrdersFragment extends Fragment {
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    int numRows = 18;
    int numCols = 30;
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_confirmed_orders, container, false);
        gridLayout1 = view.findViewById(R.id.gridLayout1);
        gridLayout2 = view.findViewById(R.id.gridLayout2);
        context = view.getContext();
        gridLayout1.setColumnCount(numCols);
        gridLayout2.setColumnCount(numCols);
        addImageButtons(numRows, numCols);
        addImageButtons2((int) (numRows * 1.5),numCols);
        return view;
    }
    private void addImageButtons(int rows, int cols) {
        int numberOfSets = rows / 4;
        int totalRowsWithAdditions = rows + numberOfSets;
        for (int i = 1; i < totalRowsWithAdditions + 1 ; i++) {
            if (i % 5 == 0 ) {
                if(i>totalRowsWithAdditions-2)
                {
                    continue;
                }
                for (int j = 0; j < cols; j++) {
                    ImageButton imageButton = new ImageButton(context);
                    if (j == 0) {
                        imageButton.setImageResource(R.drawable.ic_gate_2);
                    } else {
                        imageButton.setImageResource(R.drawable.ic_grave);
                        imageButton.setVisibility(View.INVISIBLE);
                    }
                    imageButton.setBackgroundResource(android.R.color.transparent); // Transparent background
                    imageButton.setPadding(0, 0, 0, 0);
                    GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                    params.width = 60;  // Set width for each button
                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT; // Set height for each button

                    int additionaltop = 0;
                    int additionalend = 0;
                    params.setMargins(4, 0 + additionaltop, 4 + additionalend, 0);

                    imageButton.setLayoutParams(params);
                    int finalI = i;
                    int finalJ = j;
                    gridLayout1.addView(imageButton);
                }
            }
            else
            {
                for (int j = 0; j < cols; j++) {
                    ImageButton imageButton = new ImageButton(context);
                    imageButton.setImageResource(R.drawable.ic_grave); // Replace with your image
                    imageButton.setBackgroundResource(android.R.color.transparent); // Transparent background
                    imageButton.setPadding(0, 0, 0, 0);
                    GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                    params.width = 60;  // Set width for each button
                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT; // Set height for each button
                    int additionaltop = 0;
                    int additionalend = 0;
                    if(j%10==0 && j!=0)
                    {
                        if(j<cols-4)
                        {
                            additionalend = 60;
                        }
                    }
                    if(j==cols-1)
                    {
                        additionalend = 60;
                    }
                    params.setMargins(4, 6 + additionaltop, 4 +additionalend, 0);
                    imageButton.setLayoutParams(params);
                    // Set an onClickListener for each button
                    int finalI = i;
                    int finalJ = j;
                    imageButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            smallclickongrave();
                        }
                    });
                    imageButton.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            longclickongrave(finalI*finalJ);
                            return false;
                        }
                    });
                    gridLayout1.addView(imageButton);
                }
            }

        }
    }
    private void addImageButtons2(int rows, int cols) {
        int numberOfSets = rows / 4;
        int totalRowsWithAdditions = rows + numberOfSets;
        for (int i = 1; i < totalRowsWithAdditions + 1 ; i++) {
            if (i % 7 == 0 ) {
                if(i>totalRowsWithAdditions-3)
                {
                    continue;
                }
                for (int j = 0; j < cols; j++) {
                    ImageButton imageButton = new ImageButton(context);
                    if (j == cols-1) {
                        imageButton.setImageResource(R.drawable.ic_gate_2);
                        imageButton.setRotation(180);
                    } else {
                        imageButton.setImageResource(R.drawable.ic_grave);
                        imageButton.setVisibility(View.INVISIBLE);
                    }
                    imageButton.setBackgroundResource(android.R.color.transparent); // Transparent background
                    imageButton.setPadding(0, 0, 0, 0);
                    // Set layout parameters (optional: adjust size)
                    GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                    params.width = 36;  // Set width for each button
                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT; // Set height for each button
                    int additionaltop = 0;
                    int additionalend = 0;
                    params.setMargins(4, 0 + additionaltop, 4 + additionalend, 0);
                    imageButton.setLayoutParams(params);
                    int finalI = i;
                    int finalJ = j;
                    gridLayout2.addView(imageButton);
                }
            }
            else
            {
                for (int j = 1; j < cols + 1; j++) {
                    ImageButton imageButton = new ImageButton(context);
                    imageButton.setImageResource(R.drawable.ic_grave_small); // Replace with your image
                    imageButton.setBackgroundResource(android.R.color.transparent); // Transparent background
                    imageButton.setPadding(0, 0, 0, 0);
                    GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                    params.width = 36;
                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    int additionaltop = 0;
                    int additionalend = 0;
                    if(j%15==0 && j!=0)
                    {
                        if(j<cols-7)
                        {
                            additionalend = 60;
                        }
                    }
                    params.setMargins(4, 4 + additionaltop, 4 +additionalend, 0);

                    imageButton.setLayoutParams(params);
                    int finalI = i;
                    int finalJ = j;
                    imageButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            smallclickongrave();
                        }
                    });
                    imageButton.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            longclickongrave(finalI*finalJ);
                            return false;
                        }
                    });
                    gridLayout2.addView(imageButton);
                }
            }
        }
    }
    public void smallclickongrave()
    {
        Toast.makeText(context, "Long Press For Grave Info Panel", Toast.LENGTH_SHORT).show();
    }
    public void longclickongrave(int id)
    {
        Toast.makeText(context, "Long Press on Grave " + id, Toast.LENGTH_SHORT).show();
    }

}