package driver.auth;

import java.net.*;
import java.io.*;
import java.util.Base64;

public class Auth {
    public static final String USERNAME = "ssalvi@ncsu.edu";
    public static final String PASSWORD = "cadillac2396";
    public static final String SUBDOMAIN = "https://zcctcviewer.zendesk.com";
    public static int responseCode = 0;

    public String requestResponse(String url, String urlParams){

        HttpURLConnection connection = null;
        String finalUrl = SUBDOMAIN + url;

        try{
            URL urlObject = new URL(finalUrl + urlParams);
            connection = (HttpURLConnection) urlObject.openConnection();
            connection.setRequestProperty("Accept","application/json");

            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD.toCharArray());
                }
            });

            byte[] message = (USERNAME+ ":" + PASSWORD).getBytes("UTF-8");
            String encoded = Base64.getEncoder().encodeToString(message);
            connection.setRequestProperty("Authorization", "Basic " + encoded);

            connection.setDoOutput(true);
            connection.setRequestMethod("GET");

            //Get response
            responseCode = connection.getResponseCode();
            if (responseCode < 300 && responseCode > 199)
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = reader.readLine()) != null)
                    response.append(inputLine);
                reader.close();

                return response.toString();
            }
            else
                return displayErrorMessage(responseCode);

        } catch (MalformedURLException e) {
            return "There is an issue with the generated URL";
        } catch (IOException e) {
            return "There was an issue while performing input/output operations";
        } catch (Exception e){
            return "Could not establish a secure connection. Please try again after sometime..!! :(";
        } finally{
            if(connection != null){
                connection.disconnect();
            }
        }
    }

    private String displayErrorMessage(int responseCode) {
        switch(responseCode)
        {
            case 400:
                return "Bad Request - the HTTP request that was sent to the server has invalid syntax";
            case 401:
                return "Unauthorized - the user trying to access the resource has not been authenticated";
            case 403:
                return "Forbidden - there is some issue with the server. please try again after sometime..!!";
            case 404:
                return "Not Found - very few people reach this page..!!";
            case 500:
                return "Internal Server Error - the server cannot process the request for an unknown reason";
            case 503:
                return "Service Unavailable - the server is overloaded or under maintenance";
            case 504:
                return "Gateway Timeout -  the server is a not receiving a response from the backend servers within the allowed time period";
            default:
                return "This is new..!! Please try again after sometime..!!";
        }
    }
}
