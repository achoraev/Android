package android.sqllite;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PostAdapter extends ArrayAdapter<Post>{
	private Context context;
	private int resourseId;
	private List<Post> dataList;
	private TextView username,post,date;
	
	public PostAdapter(Context context, int resource, List<Post> objects) {
		super(context, resource, objects);
		this.context = context;
		resourseId = resource;
		this.dataList = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = ((Activity)context).getLayoutInflater();
		View rowView = inflater.inflate(resourseId, parent, false);
		username = (TextView) rowView.findViewById(R.id.text_username);
		post = (TextView) rowView.findViewById(R.id.text_post);
		date = (TextView) rowView.findViewById(R.id.text_date);
		post.setText(dataList.get(position).getUsername());
		post.setText(dataList.get(position).getPost());
		post.setText(dataList.get(position).getDateCreated().toString());
		
		return rowView;
	}

}