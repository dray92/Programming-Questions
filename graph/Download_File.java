package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Download_File {
	/**
     * Downloads files and returns string representation
     * @param url to download from
     * @return	string representation
     * @throws Exception
     */
    public static String downloadFile(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                    connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            response.append(inputLine + "\n");

        in.close();

        return response.toString();
    }
}
