package ir.jalambadani.openalpr;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.jalambadani.openalpr.alpr.response.AlprResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

/**
 * created by: Morteza
 * company: mobin
 * package: ir.jalambadani.openalpr
 * project name:  openalpr
 * 02 February 2019
 **/

public class TestOpenALPR {

    private static final String secret_key = "sk_dd8db7eda4946b1815948b6c";

    public static AlprResponse alpr(byte[] data) {



        try {
            // Encode file bytes to base64
            byte[] encoded = Base64.getEncoder().encode(data);

            // Setup the HTTPS connection to api.openalpr.com
            URL url = new URL("https://api.openalpr.com/v2/recognize_bytes?recognize_vehicle=1&country=eu&secret_key=" + secret_key);
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            http.setRequestMethod("POST"); // PUT is another valid option
            http.setFixedLengthStreamingMode(encoded.length);
            http.setDoOutput(true);

            // Send our Base64 content over the stream
            try(OutputStream os = http.getOutputStream()) {
                os.write(encoded);
            }

            int status_code = http.getResponseCode();
            if (status_code == 200)
            {
                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        http.getInputStream()));
                String json_content = "";
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    json_content += inputLine;
                }
                in.close();

                return
                        new ObjectMapper(  ).readValue( json_content , AlprResponse.class);
            }
            else
            {
                System.out.println("Got non-200 response: " + status_code);
            }


        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Bad URL");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to open connection");
        }
        System.out.println("error occurred");

        return null;
    }
}