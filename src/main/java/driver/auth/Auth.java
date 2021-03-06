package driver.auth;

import java.net.*;
import java.io.*;
import java.util.Base64;
import java.util.Properties;

public class Auth {

    public static int responseCode = 0;

    private static String userName = "";
    private static String password = "";
    private static String subDomain = "";

    InputStream inputStream;

    /**
     * This method gets the credentials (username, password, subdomain) from the properties file
     */
    public void getCredentials(){

        try {
            Properties prop = new Properties();
            String propFileName = "cred.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            userName = prop.getProperty("username");
            password = prop.getProperty("password");
            subDomain = prop.getProperty("domain");

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }

    /**
     * This method is used to send a connection request and get ticket details as and when required
     * @param url - part of the url that decides what data will be returned back by the api call
     * @param urlParams - parameters to specify/add condition on the data that is being retrieved
     * @return return either the data that was requested or the error response that was received
     */
    public String requestResponse(String url, String urlParams){

        HttpURLConnection connection = null;
        String finalUrl = subDomain + url;

        try{
            URL urlObject = new URL(finalUrl + urlParams);
            connection = (HttpURLConnection) urlObject.openConnection();
            connection.setRequestProperty("Accept","application/json");

            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password.toCharArray());
                }
            });

            byte[] message = (userName+ ":" + password).getBytes("UTF-8");
            String encoded = Base64.getEncoder().encodeToString(message);
            connection.setRequestProperty("Authorization", "Basic " + encoded);

            connection.setDoOutput(true);
            connection.setRequestMethod("GET");

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

    /**
     * This method is used to return an error message based on the received error code
     * @param responseCode - HttpRequest reponse which decides the actual cause of error
     * @return error response based on the response code that was recceived
     */
    public static String displayErrorMessage(int responseCode) {
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
                return "This is new..!! Sorry for the convenience Please try again after sometime..!!";
        }
    }
}
