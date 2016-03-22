package projectOxford;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Faces {
	public static void main(String[] args) {
		String base64Img = null;
		byte[] bytes = null, base64Bytes = null;
		String imgBinaryString = null;
		String base64ImgBinaryString = null;
		try {
			URL url = new URL("http://www.businessstudynotes.com/wp-content/uploads/2015/09/Role-of-Group.jpg");
								//"http://www.huntresearchgroup.org.uk/images/group/group_photo_2010.jpg");
			BufferedImage image = ImageIO.read(url);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", baos);
			bytes = baos.toByteArray();
			StringBuilder sb = new StringBuilder();
		    for (byte by : bytes)
		        sb.append(Integer.toBinaryString(by & 0xFF));
		    imgBinaryString = sb.toString();
		    
		    base64Img = Base64.getEncoder().encodeToString(bytes);
			base64Bytes = base64Img.getBytes("UTF-8");
			sb = new StringBuilder();
			for (byte by : base64Bytes) {
				sb.append(Integer.toBinaryString(by & 0xFF));
	        }
			base64ImgBinaryString = sb.toString();
		    
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Download issue");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ImageIO issue");
			e.printStackTrace();
		}
		
		if(base64Img != null) {
			HttpClient httpclient = HttpClients.createDefault();

			try {
			    URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/face/v1.0/detect");

			    builder.setParameter("returnFaceId", "false");
			    builder.setParameter("returnFaceLandmarks", "false");
			    builder.setParameter("returnFaceAttributes", "age,gender");

			    String key = getKey();
			    
			    URI uri = builder.build();
			    HttpPost request = new HttpPost(uri);
			    request.setHeader("Content-Type", "application/octet-stream");//"application/json");
			    request.setHeader("Ocp-Apim-Subscription-Key", key);

			    System.out.println(imgBinaryString);
//			    StringEntity reqEntity = new StringEntity(base64ImgBinaryString );
////			    		new StringEntity("{ \"url\":\"http://www.huntresearchgroup.org.uk/images/group/group_photo_2010.jpg\" }");
//			    request.setEntity(reqEntity);
			    
			    ByteArrayEntity reqEntity = new ByteArrayEntity(bytes, ContentType.APPLICATION_OCTET_STREAM);
			    request.setEntity(reqEntity);

			    HttpResponse response = httpclient.execute(request);
			    HttpEntity entity = response.getEntity();

			    if (entity != null) {
			            System.out.println(EntityUtils.toString(entity));
//			            return JsonParser.parse(EntityUtils.toString(entity));
			    }
			} catch (URISyntaxException | IOException e) {
			        System.out.println(e.getMessage());
			}
		}
		
		System.exit(0);
		
	}
	
	private static String getKey() {
		
		String text = "";
		Scanner scanner = null;
		try {
			scanner = new Scanner( new File("FacesAPIKey.txt"), "UTF-8" );
			text = scanner.useDelimiter("\\A").next();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return text;
	
	}
}
