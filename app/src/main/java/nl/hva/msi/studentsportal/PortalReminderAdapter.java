package nl.hva.msi.studentsportal;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import static nl.hva.msi.studentsportal.MainActivity.CONST_URL;

public class PortalReminderAdapter extends RecyclerView.Adapter<PortalReminderAdapter.ViewHolder> {

    private List<PortalReminder> mPortalReminderList;
    private LayoutInflater mInflater;
    private Context mContext;


    public PortalReminderAdapter(List<PortalReminder> portalReminders, Context context) {
        this.mPortalReminderList = portalReminders;
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView portalTextView;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            portalTextView = itemView.findViewById(R.id.portalTextView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            portalTextView.setClickable(true);
        }
    }


    @NonNull
    @Override
    public PortalReminderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PortalReminderAdapter.ViewHolder viewHolder, int i) {
        final PortalReminder portalReminder = mPortalReminderList.get(i);
        viewHolder.portalTextView.setText(portalReminder.getmUrl());

        viewHolder.portalTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebView(portalReminder.getmUrl());
            }
        });

    }

    private void openWebView(String getmUrl) {
        Intent intent = new Intent(mContext, WebViewActivity.class);
        intent.putExtra(CONST_URL, getmUrl);
        Log.d("Url OpenWebView", getmUrl);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return mPortalReminderList.size();
    }
}
