package com.naveen.prac;

import java.io.BufferedInputStream;
import org.jaudiotagger.audio.mp3.MP3FileReader;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.net.URL;
import java.net.URLConnection;
import java.util.Queue;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


 class kid 
{
	public static void main(String[] args) throws NumberFormatException, IOException, JSONException
	{
		
		//BufferedReader mp3br=new BufferedReader(new InputStreamReader("/home/naveen/Downloads/"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String inp=br.readLine();
		String urli =URLEncoder.encode(inp, "UTF-8");
		URL url = new URL("https://ajax.googleapis.com/ajax/services/search/images?" +
                "v=1.0&q="+urli+"%20album%20art%20hd");
URLConnection connection = url.openConnection();

String line;
StringBuilder builder = new StringBuilder();
BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
while((line = reader.readLine()) != null) {
builder.append(line);
}

JSONObject json = new JSONObject(builder.toString());
Iterator it=json.keys();

JSONObject jso=json.getJSONObject("responseData");
JSONArray array = jso.getJSONArray("results");
for(int i = 0 ; i < array.length() ; i++){
    System.out.println(array.getJSONObject(i).getString("tbUrl"));
}
FileOutputStream fout = null;
BufferedInputStream in = null;
String filename="/home/naveen/Downloads/nav.jpg";
try {
    in = new BufferedInputStream(new URL(array.getJSONObject(0).getString("tbUrl")).openStream());
    fout = new FileOutputStream(filename);

    final byte data[] = new byte[1024];
    int count;
    while ((count = in.read(data, 0, 1024)) != -1) {
        fout.write(data, 0, count);
    }
}
catch(Exception e)
{
	System.out.println(e.getMessage());
}
finally {
    if (in != null) {
        in.close();
    }
    if (fout != null) {
        fout.close();
    }
}
	}
	
	
	
}