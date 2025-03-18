package com.example.gorkan_module;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class PendingMaintainanceOrderFragment extends Fragment {
    public static RecyclerView rvPendings;
    public static MaintenancePendingOrdersAdapter maintenanceAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_pending_maintainance_order, container, false);
        rvPendings = view.findViewById(R.id.rvMPendings);
        rvPendings.setLayoutManager(new LinearLayoutManager(view.getContext()));
        PendingMaintainanceOrderFragment.maintenanceAdapter = new MaintenancePendingOrdersAdapter(MainActivity.requests,view.getContext());
        rvPendings.setAdapter(maintenanceAdapter);
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                // Prevent full swipe, reveal the buttons without removing the item
                maintenanceAdapter.showButtons(viewHolder.getAdapterPosition());
                maintenanceAdapter.notifyItemChanged(viewHolder.getAdapterPosition()); // Reset the swipe state
            }

            @Override
            public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                //adapter.hideButtons(viewHolder.getAdapterPosition());
            }

            @Override
            public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
                // Only allow partial swipe to reveal buttons (e.g., 0.3f means 30% of the item width)
                return 0.3f;
            }
            /*
            @Override
            public float getSwipeEscapeVelocity(float defaultValue) {
                return super.getSwipeEscapeVelocity(defaultValue) * 2; // Slow down the swipe speed
            }

            @Override
            public float getSwipeVelocityThreshold(float defaultValue) {
                return super.getSwipeVelocityThreshold(defaultValue) * 2; // Slow down the swipe release velocity
            }*/
        };


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rvPendings);
        // Attach swipe actions
        return  view;

    }
}