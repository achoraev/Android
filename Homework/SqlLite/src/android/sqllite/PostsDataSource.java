package android.sqllite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class PostsDataSource extends ListActivity {

	// Database fields
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
			MySQLiteHelper.COLUMN_POST, MySQLiteHelper.COLUMN_DATE };

	public PostsDataSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Post createComment(String comment) {
		ContentValues values = new ContentValues();
		Date dateNow = new Date();
		values.put(MySQLiteHelper.COLUMN_POST, comment);
		values.put(MySQLiteHelper.COLUMN_DATE, dateNow.toString());
		long insertId = database.insert(MySQLiteHelper.TABLE_POSTS, null,
				values);
		Cursor cursor = database.query(MySQLiteHelper.TABLE_POSTS,
				allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Post newComment = cursorToComment(cursor);
		cursor.close();
		return newComment;
	}

	public void deleteComment(Post comment) {
		long id = comment.getId();				
		database.delete(MySQLiteHelper.TABLE_POSTS, MySQLiteHelper.COLUMN_ID
				+ " = " + id, null);
	}

	public List<Post> getAllComments() {
		List<Post> comments = new ArrayList<Post>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_POSTS,
				allColumns, null, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
		//while (!cursor.isBeforeFirst()) {
			Post comment = cursorToComment(cursor);
			comments.add(comment);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return comments;
	}

	private Post cursorToComment(Cursor cursor) {
		Post post = new Post();
		post.setId(cursor.getLong(0));
		post.setPost(cursor.getString(1));
		return post;
	}
}