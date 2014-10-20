package android.sqllite;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.impl.entity.StrictContentLengthStrategy;

import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity implements OnClickListener {

	private PostsDataSource datasource;
	public Button addButton, deleteButton;
	public EditText inputField;
	List<String> comments = new ArrayList<String>();
	ArrayList<Post> posts = new ArrayList<Post>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// ListView listView = (ListView) findViewById(R.id.list);
		// MySQLiteHelper pref = new MySQLiteHelper(this);
		// Cursor cursor = pref.getVals();
		// startManagingCursor(cursor);
		// String[] from = new String[] {"username", "post", "dateCreated"};
		// int[] to = new int []{R.id.text_username, R.id.text_post,
		// R.id.text_date};
		// SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
		// R.layout.post_row, cursor, from, to);
		// listView.setAdapter(adapter);

		inputField = (EditText) findViewById(R.id.input);
		addButton = (Button) findViewById(R.id.add);
		deleteButton = (Button) findViewById(R.id.delete);
		addButton.setOnClickListener(this);
		deleteButton.setOnClickListener(this);

		datasource = new PostsDataSource(this);
		datasource.open();

//		ListView listView = (ListView) findViewById(R.id.);
//		PostAdapter postAdapter = new PostAdapter(this, R.layout.post_row,
//				posts);
//		listView.setAdapter(postAdapter);

		List<Post> values = datasource.getAllComments();

		ArrayAdapter<Post> adapter = new ArrayAdapter<Post>(this,
				android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);

	}

	public void onClick(View view) {
		@SuppressWarnings("unchecked")
		ArrayAdapter<Post> adapter = (ArrayAdapter<Post>) getListAdapter();
		Post post = null;
		switch (view.getId()) {
		case R.id.add:
			AddComment(adapter);
			Toast.makeText(this, "Post Added", Toast.LENGTH_SHORT).show();
			break;
		case R.id.delete:
			if (getListAdapter().getCount() > 0) {
				post = (Post) getListAdapter().getItem(adapter.getCount() - 1);
				long id = post.getId();
				datasource.deleteComment(post);
				adapter.remove(post);
				Toast.makeText(this, "Delete post with id: " + id,
						Toast.LENGTH_SHORT).show();
			}
			break;
		}
		adapter.notifyDataSetChanged();
	}

	private void AddComment(ArrayAdapter<Post> adapter) {
		Post post;
		comments.add(inputField.getText().toString());
		post = datasource.createComment(inputField.getText().toString());
		adapter.add(post);
	}

	@Override
	protected void onResume() {
		super.onResume();
		datasource.open();
	}

	@Override
	protected void onPause() {
		super.onPause();
		datasource.close();
	}
}