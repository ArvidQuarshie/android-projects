package bhouse.travellist_starterproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by imaya on 6/4/16.
 */
// 1
public class TravelListAdapter extends RecyclerView.Adapter<TravelListAdapter.ViewHolder> {

    Context mContext;
    OnItemClickListener mItemClickListener;

    // 2
    public TravelListAdapter(Context context) {
        this.mContext = context;
    }
    // 3
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public LinearLayout placeHolder;
        public LinearLayout placeNameHolder;
        public TextView placeName;
        public ImageView placeImage;

        public ViewHolder(View itemView) {
            super(itemView);
            placeHolder = (LinearLayout) itemView.findViewById(R.id.mainHolder);
            placeName = (TextView) itemView.findViewById(R.id.placeName);
            placeNameHolder = (LinearLayout) itemView.findViewById(R.id.placeNameHolder);
            placeImage = (ImageView) itemView.findViewById(R.id.placeImage);

            placeHolder.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(itemView, getPosition());
            }

        }
    }
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    // 1
    @Override
    public int getItemCount() {
        return new PlaceData().placeList().size();
    }

    // 2
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_places, parent, false);
        return new ViewHolder(view);
    }

    // 3
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Place place = new PlaceData().placeList().get(position);
        holder.placeName.setText(place.name);
        Picasso.with(mContext).load(place.getImageResourceId(mContext)).into(holder.placeImage);
    }
}