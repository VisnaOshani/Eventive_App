package Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventive.R;

import java.util.ArrayList;

import Models.AddGuest;

public class guestAdapter extends RecyclerView.Adapter<guestAdapter.guestAdapterViewHolder> {

    private ArrayList<AddGuest> arrayList;

    public guestAdapter(ArrayList<AddGuest> arrayList) {
        this.arrayList = arrayList;
    }

    /*@NonNull
    @Override
    public guestAdapter.guestAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        guestAdapter.guestAdapterViewHolder 1 = null;
        return 1;
    }*/

    @NonNull
    @Override
    public guestAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull guestAdapter.guestAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class guestAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView fName;
        TextView lName;
        TextView people;
        TextView addGuest;
        TextView mobGuest;
        TextView emailGuest;


        public guestAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            fName = itemView.findViewById(R.id.fNameO);
            lName = itemView.findViewById(R.id.lNameO);
            people = itemView.findViewById(R.id.peopleO);
            addGuest = itemView.findViewById(R.id.addGuestO);
            mobGuest = itemView.findViewById(R.id.mobGuestO);
            emailGuest = itemView.findViewById(R.id.emailGuestO);


        }
    }
}