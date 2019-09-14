package Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventive.Add_Budgets;
import com.example.eventive.R;
import java.util.ArrayList;
import Models.Fbudget;

public class budgetAdapter extends RecyclerView.Adapter<budgetAdapter.budgetAdapterViewHolder> {

    private ArrayList<Fbudget> arrayList;
    private OnBudgetListener vBudgetListener;

   //private budgetAdapterViewHolder.OnBudgetListener vonBudgetListner;

    public budgetAdapter(ArrayList<Fbudget> arrayList, OnBudgetListener onBudgetListener){
        this.arrayList = arrayList;
        this.vBudgetListener = onBudgetListener;
    }

    @NonNull
    @Override
    public budgetAdapter.budgetAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.budget_list,parent,false);
        return new budgetAdapterViewHolder(v, vBudgetListener);
    }

    @Override
    public void onBindViewHolder(@NonNull budgetAdapterViewHolder holder, int i) {
        Fbudget object =arrayList.get(i);
        holder.note.setText(object.getNote());
        holder.type.setText( object.getType());
        holder.balance.setText( object.getBalance() );

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void filterList(ArrayList<Fbudget> filteredList) {
        arrayList = filteredList;
        notifyDataSetChanged();
    }


    public static class budgetAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView note;
        TextView type;
        TextView balance;
        OnBudgetListener onBudgetListener;

        public budgetAdapterViewHolder(@NonNull View itemView, OnBudgetListener onBudgetListener){
            super(itemView);
            note = itemView.findViewById(R.id.tv_note);
            type = itemView.findViewById(R.id.tv_type);
            balance = itemView.findViewById(R.id.tv_balance);

            this.onBudgetListener = onBudgetListener;
            itemView.setOnClickListener(this);
    }

      @Override
        public void onClick(View view) {
            onBudgetListener.onBudgetClick(getAdapterPosition());
        }

    }

    public interface OnBudgetListener{
        void onBudgetClick(int position);
    }

}
