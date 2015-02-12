package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.json";
	private EditText bodyText;
	private ListView oldTweetsList;
<<<<<<< HEAD:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
	private ArrayList<NormalTweetModel> tweets;
	private ArrayAdapter<NormalTweetModel> adapter;
=======
	private ArrayList<String> tweets;
	private ArrayAdapter<String> adapter;
>>>>>>> 3e33e49167ef1501002f8234f57d3398d3662e97:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
<<<<<<< HEAD:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
				NormalTweetModel tweet = new NormalTweetModel(text);
				saveInFile(tweet);
				tweets.add(tweet);
				adapter.notifyDataSetChanged();
=======
				tweets.add(text);
				adapter.notifyDataSetChanged();
				saveInFile(text, new Date(System.currentTimeMillis()));
				

>>>>>>> 3e33e49167ef1501002f8234f57d3398d3662e97:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
			}
		});
	}



	@Override
	protected void onStart() {
		
		User u = new Reader();
		
		ArrayList<User> array = new ArrayList<User>();
		
		
		try{
		u.setUsername("joe");
		} catch (Exception e){
		
		}
		
		
		super.onStart();
		tweets = loadFromFile();
<<<<<<< HEAD:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
		adapter = new ArrayAdapter<NormalTweetModel>(this,
=======
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
>>>>>>> 3e33e49167ef1501002f8234f57d3398d3662e97:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

<<<<<<< HEAD:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
	private ArrayList<NormalTweetModel> loadFromFile() {
		ArrayList<NormalTweetModel> tweets = new ArrayList<NormalTweetModel>();
=======
	private ArrayList<String> loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		Gson gson= new Gson();
>>>>>>> 3e33e49167ef1501002f8234f57d3398d3662e97:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
		try {
			
			FileInputStream fis = openFileInput(FILENAME);
<<<<<<< HEAD:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(NormalTweetModel.fromJSON(line));
				line = in.readLine();
			}
=======
			// Based on http://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html
			 Type listType = new TypeToken<ArrayList<String>>() {}.getType();
			 InputStreamReader isr = new InputStreamReader(fis);
			tweets = gson.fromJson(isr,listType);
			fis.close();
>>>>>>> 3e33e49167ef1501002f8234f57d3398d3662e97:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
		return tweets;
	}
	
	private void saveInFile(NormalTweetModel tweet) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			fos.write((tweet.toJSON() + "\n").getBytes());
=======
		if (tweets==null){
			tweets = new ArrayList<String>();
			
		}
		
		return tweets;
	}
	
	private void saveInFile(String text, Date date)
	{
		Gson gson= new Gson();
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			gson.toJson(tweets,osw);
			fos.write(new String(date.toString() + " | " + text)
					.getBytes());
>>>>>>> 3e33e49167ef1501002f8234f57d3398d3662e97:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}