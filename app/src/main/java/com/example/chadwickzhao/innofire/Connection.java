package com.example.chadwickzhao.innofire;

import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chadwickzhao on 24/08/16.
 * The connection between application and restful server
 */
public class Connection {
    private static final String BASE_URI = "http://13.75.147.164:8080/WebApplication3/webresources";

    public static String createUser(user u) {
        final String methodPath = "/com.innofire.user";
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        // Making HTTP request
        try {
            //get instance of Gson class
            Gson gson = new Gson();
            //convert course entity to string json by calling toJson method
            String stringCourseJson = gson.toJson(u);
            url = new URL(BASE_URI + methodPath);
            //open the connection
            conn = (HttpURLConnection) url.openConnection();
            //set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            //set the connection method to POST
            conn.setRequestMethod("POST");
            //set the output to true
            conn.setDoOutput(true);
            //set length of the data you are sending
            conn.setFixedLengthStreamingMode(stringCourseJson.getBytes().length);
            //add HTTP headers to set your respond type to json
            conn.setRequestProperty("Content-Type", "application/json");
            //send the POST out
            PrintWriter out = new PrintWriter(conn.getOutputStream());
            out.print(stringCourseJson);
            out.close();
            //Read the response
            Scanner inStream = new Scanner(conn.getInputStream());
            //read the input steream and store it as string
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }





    public static String createGroup(Group1 g) {
        final String methodPath = "/com.innofire.group1";
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        // Making HTTP request
        try {
            //get instance of Gson class
            Gson gson = new Gson();
            //convert course entity to string json by calling toJson method
            String stringCourseJson = gson.toJson(g);
            url = new URL(BASE_URI + methodPath);
            //open the connection
            conn = (HttpURLConnection) url.openConnection();
            //set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            //set the connection method to POST
            conn.setRequestMethod("POST");
            //set the output to true
            conn.setDoOutput(true);
            //set length of the data you are sending
            conn.setFixedLengthStreamingMode(stringCourseJson.getBytes().length);
            //add HTTP headers to set your respond type to json
            conn.setRequestProperty("Content-Type", "application/json");
            //send the POST out
            PrintWriter out = new PrintWriter(conn.getOutputStream());
            out.print(stringCourseJson);
            out.close();
            //Read the response
            Scanner inStream = new Scanner(conn.getInputStream());
            //read the input steream and store it as string
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }






    public static String findAll() {
        final String methodPath = "/com.relaxationplace.gym"; //initialize
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        try {
            url = new URL("http://13.75.147.164:8080/WebApplication5/webresources" + methodPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            Scanner inStream = new Scanner(conn.getInputStream());
            while (inStream.hasNextLine()) {

                textResult += inStream.nextLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }

        return textResult;
    }


    @Nullable
    public static List<Gym> findallgym() {
        final String methodPath = "/com.relaxationplace.gym"; //initialize
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        Gson gson = new Gson();
        BufferedReader reader = null;
        try {
            url = new URL("http://13.75.147.164:8080/WebApplication5/webresources" + methodPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");

            InputStream stream = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line ="";
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }

            String finalJson = buffer.toString();

            //  JSONObject parentObject = new JSONObject(finalJson);
            JSONArray parentArray = new JSONArray(finalJson);

            List<Gym> gyms = new ArrayList<>();

            gson = new Gson();

            for(int i=0; i<parentArray.length(); i++) {
                JSONObject finalObject = parentArray.getJSONObject(i);
                /**
                 * below single line of code from Gson saves you from writing the json parsing yourself which is commented below
                 */
                Gym g = gson.fromJson(finalObject.toString(), Gym.class);
//
                gyms.add(g);
            }
            return gyms;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return null;
    }




    @Nullable
    public static List<Spa> findallspa() {
        final String methodPath = "/com.relaxationplace.spa"; //initialize
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        Gson gson = new Gson();
        BufferedReader reader = null;
        try {
            url = new URL("http://13.75.147.164:8080/WebApplication5/webresources" + methodPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");

            InputStream stream = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line ="";
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }

            String finalJson = buffer.toString();

            //  JSONObject parentObject = new JSONObject(finalJson);
            JSONArray parentArray = new JSONArray(finalJson);

            List<Spa> spas = new ArrayList<>();

            gson = new Gson();

            for(int i=0; i<parentArray.length(); i++) {
                JSONObject finalObject = parentArray.getJSONObject(i);
                /**
                 * below single line of code from Gson saves you from writing the json parsing yourself which is commented below
                 */
                Spa s = gson.fromJson(finalObject.toString(), Spa.class);

                spas.add(s);
            }
            return spas;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return null;
    }



    @Nullable
    public static List<Park1> findallpark() {
        final String methodPath = "/com.relaxationplace.park1"; //initialize
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        Gson gson = new Gson();
        BufferedReader reader = null;
        try {
            url = new URL("http://13.75.147.164:8080/WebApplication5/webresources" + methodPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");

            InputStream stream = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line ="";
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }

            String finalJson = buffer.toString();

            //  JSONObject parentObject = new JSONObject(finalJson);
            JSONArray parentArray = new JSONArray(finalJson);

            List<Park1> park1s = new ArrayList<>();

            gson = new Gson();

            for(int i=0; i<parentArray.length(); i++) {
                JSONObject finalObject = parentArray.getJSONObject(i);
                /**
                 * below single line of code from Gson saves you from writing the json parsing yourself which is commented below
                 */
                Park1 p = gson.fromJson(finalObject.toString(), Park1.class);
//                    movieModel.setMovie(finalObject.getString("movie"));
//                    movieModel.setYear(finalObject.getInt("year"));
//                    movieModel.setRating((float) finalObject.getDouble("rating"));
//                    movieModel.setDirector(finalObject.getString("director"));
//
//                    movieModel.setDuration(finalObject.getString("duration"));
//                    movieModel.setTagline(finalObject.getString("tagline"));
//                    movieModel.setImage(finalObject.getString("image"));
//                    movieModel.setStory(finalObject.getString("story"));
//
//                    List<MovieModel.Cast> castList = new ArrayList<>();
//                    for(int j=0; j<finalObject.getJSONArray("cast").length(); j++){
//                        MovieModel.Cast cast = new MovieModel.Cast();
//                        cast.setName(finalObject.getJSONArray("cast").getJSONObject(j).getString("name"));
//                        castList.add(cast);
//                    }
//                    movieModel.setCastList(castList);
                // adding the final object in the list
                park1s.add(p);
            }
            return park1s;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return null;
    }




    public static List<user> findbycompany(String companyname) {
        final String methodPath = "/com.innofire.user/findByCompany/"+ companyname; //initialize
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        Gson gson = new Gson();
        BufferedReader reader = null;
        try {
            url = new URL(BASE_URI + methodPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");

            InputStream stream = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line ="";
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }

            String finalJson = buffer.toString();

          //  JSONObject parentObject = new JSONObject(finalJson);
            JSONArray parentArray = new JSONArray(finalJson);

            List<user> users = new ArrayList<>();

            gson = new Gson();

            for(int i=0; i<parentArray.length(); i++) {
                JSONObject finalObject = parentArray.getJSONObject(i);
                /**
                 * below single line of code from Gson saves you from writing the json parsing yourself which is commented below
                 */
                user u = gson.fromJson(finalObject.toString(), user.class);

                users.add(u);
            }
            return users;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return null;
    }



    public static List<user> getbyUsername(String Username) {
        final String methodPath = "/com.innofire.user/findbyusername1o/"+ Username; //initialize
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        Gson gson = new Gson();
        BufferedReader reader = null;
        try {
            url = new URL(BASE_URI + methodPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");

            InputStream stream = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line ="";
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }

            String finalJson = buffer.toString();

            //  JSONObject parentObject = new JSONObject(finalJson);
            JSONArray parentArray = new JSONArray(finalJson);

            List<user> users = new ArrayList<>();

            gson = new Gson();

            for(int i=0; i<parentArray.length(); i++) {
                JSONObject finalObject = parentArray.getJSONObject(i);
                /**
                 * below single line of code from Gson saves you from writing the json parsing yourself which is commented below
                 */
                user u = gson.fromJson(finalObject.toString(), user.class);

                users.add(u);
            }
            return users;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return null;
    }




    public static String check(String username, String password){
        final String methodPath = "/com.innofire.user/findbyusernameandpassword/"+ username + "/" + password; //initialize
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        try {
            url = new URL(BASE_URI + methodPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            Scanner inStream = new Scanner(conn.getInputStream());
            while (inStream.hasNextLine()) {

                textResult += inStream.nextLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }

    public static String checktheSleeping(String username, String date){
        final String methodPath = "/com.innofire.sleepinghours/checkthesleepinghour/"+ username + "/" + date; //initialize
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        try {
            url = new URL(BASE_URI + methodPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            Scanner inStream = new Scanner(conn.getInputStream());
            while (inStream.hasNextLine()) {

                textResult += inStream.nextLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }


    public static String selectbygroup(int id){
        final String methodPath = "/com.innofire.stresslevelreport/findByGroupId/"+ id; //initialize
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        try {
            url = new URL(BASE_URI + methodPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            Scanner inStream = new Scanner(conn.getInputStream());
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }
    public static String checkTheManager(String username){
        final String methodPath = "/com.innofire.user/findbyusernameandpassword/"+ username; //initialize
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        try {
            url = new URL(BASE_URI + methodPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            Scanner inStream = new Scanner(conn.getInputStream());
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }

    public static String findthegroupidingroup(String username) {
        final String methodPath = "/com.innofire.group1/findByUsername/" + username; //initialize
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        try {
            url = new URL(BASE_URI + methodPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            Scanner inStream = new Scanner(conn.getInputStream());
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }

    public static String createGroupnow(Group1 g) {
        final String methodPath = "/com.innofire.caffeineintake";
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        // Making HTTP request
        try {
            //get instance of Gson class
            // Gson gson = new Gson();
            final GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Group1.class, new Group1Serialiser());
            gsonBuilder.setPrettyPrinting();
            final Gson gson = gsonBuilder.create();
            String stringCourseJson = gson.toJson(g);
            url = new URL(BASE_URI + methodPath);
            //open the connection
            conn = (HttpURLConnection) url.openConnection();
            //set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            //set the connection method to POST
            conn.setRequestMethod("POST");
            //set the output to true
            conn.setDoInput(true);
            conn.setDoOutput(true);
            //set length of the data you are sending
            conn.setFixedLengthStreamingMode(stringCourseJson.getBytes().length);
            //add HTTP headers to set your respond type to json
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            //send the POST out
            PrintWriter out = new PrintWriter(conn.getOutputStream());
            out.print(stringCourseJson);
            out.close();
            Scanner inStream = new Scanner(conn.getInputStream());

            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }



    public static String createRp(Caffeineintake c) {
        final String methodPath = "/com.innofire.caffeineintake";
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        // Making HTTP request
        try {
            //get instance of Gson class
           // Gson gson = new Gson();
            final GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Caffeineintake.class, new CaffeineintakeSerialiser());
            gsonBuilder.setPrettyPrinting();
            final Gson gson = gsonBuilder.create();

            String stringCourseJson = gson.toJson(c);
            url = new URL(BASE_URI + methodPath);
            //open the connection
            conn = (HttpURLConnection) url.openConnection();
            //set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            //set the connection method to POST
            conn.setRequestMethod("POST");
            //set the output to true
            conn.setDoInput(true);
            conn.setDoOutput(true);
            //set length of the data you are sending
            conn.setFixedLengthStreamingMode(stringCourseJson.getBytes().length);
            //add HTTP headers to set your respond type to json
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            //send the POST out
            PrintWriter out = new PrintWriter(conn.getOutputStream());
            out.print(stringCourseJson);
            out.close();

            Scanner inStream = new Scanner(conn.getInputStream());

            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }


    public static String createSleepRp(Sleepinghours s) {
        final String methodPath = "/com.innofire.sleepinghours";
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        // Making HTTP request
        try {
            //get instance of Gson class
            // Gson gson = new Gson();
            final GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Caffeineintake.class, new CaffeineintakeSerialiser());
            gsonBuilder.setPrettyPrinting();
            final Gson gson = gsonBuilder.create();

            String stringCourseJson = gson.toJson(s);
            url = new URL(BASE_URI + methodPath);
            //open the connection
            conn = (HttpURLConnection) url.openConnection();
            //set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            //set the connection method to POST
            conn.setRequestMethod("POST");
            //set the output to true
            conn.setDoInput(true);
            conn.setDoOutput(true);
            //set length of the data you are sending
            conn.setFixedLengthStreamingMode(stringCourseJson.getBytes().length);
            //add HTTP headers to set your respond type to json
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            //send the POST out
            PrintWriter out = new PrintWriter(conn.getOutputStream());
            out.print(stringCourseJson);
            out.close();

            Scanner inStream = new Scanner(conn.getInputStream());

            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }

    public static String createWorkRp(Workinghours w) {
        final String methodPath = "/com.innofire.workinghours";
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        // Making HTTP request
        try {
            //get instance of Gson class
            // Gson gson = new Gson();

            final GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Caffeineintake.class, new CaffeineintakeSerialiser());
            gsonBuilder.setPrettyPrinting();
            final Gson gson = gsonBuilder.create();

            String stringCourseJson = gson.toJson(w);
            url = new URL(BASE_URI + methodPath);
            //open the connection
            conn = (HttpURLConnection) url.openConnection();
            //set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            //set the connection method to POST
            conn.setRequestMethod("POST");
            //set the output to true
            conn.setDoInput(true);
            conn.setDoOutput(true);
            //set length of the data you are sending
            conn.setFixedLengthStreamingMode(stringCourseJson.getBytes().length);
            //add HTTP headers to set your respond type to json
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            //send the POST out
            PrintWriter out = new PrintWriter(conn.getOutputStream());
            out.print(stringCourseJson);
            out.close();

            Scanner inStream = new Scanner(conn.getInputStream());

            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }


    public static List<CaffeineintakeTest> getCaffeinbyusername(String username, String dateString) {
        final String methodPath = "/com.innofire.caffeineintake/findbyusername/"+ username + "/" + dateString; //initialize
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        Gson gson = new Gson();
        BufferedReader reader = null;
        try {
            url = new URL(BASE_URI + methodPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");

            InputStream stream = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line ="";
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }

            String finalJson = buffer.toString();
           // JSONObject parentObject = new JSONObject(finalJson);
           // JSONObject caffeineObject = parentObject.getJSONObject("caffeinetake");
           // JSONArray parentArray = parentObject.getJSONArray("caffeineintake");



            JSONArray parentArray = new JSONArray(finalJson);
            List<CaffeineintakeTest> caffeineintakeTests = new ArrayList<>();

            gson = new Gson();

            for(int i=0; i<parentArray.length(); i++) {
                JSONObject finalObject = parentArray.getJSONObject(i);
                /**
                 * below single line of code from Gson saves you from writing the json parsing yourself which is commented below
                 */
                CaffeineintakeTest caffeineintakeTest = gson.fromJson(finalObject.toString(), CaffeineintakeTest.class);

                caffeineintakeTests.add(caffeineintakeTest);
            }
            return caffeineintakeTests;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return null;
    }



    public static List<StresslevelReportTest> getbyUsernameofStress(String username) {
        final String methodPath = "/com.innofire.stresslevelreport/findbyusername1/"+ username; //initialize
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        Gson gson = new Gson();
        BufferedReader reader = null;
        try {
            url = new URL(BASE_URI + methodPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");

            InputStream stream = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line ="";
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }

            String finalJson = buffer.toString();

            //  JSONObject parentObject = new JSONObject(finalJson);
            JSONArray parentArray = new JSONArray(finalJson);

            List<StresslevelReportTest> stresslevelReportTests= new ArrayList<>();

            gson = new Gson();

            for(int i=0; i<parentArray.length(); i++) {
                JSONObject finalObject = parentArray.getJSONObject(i);
                /**
                 * below single line of code from Gson saves you from writing the json parsing yourself which is commented below
                 */
                StresslevelReportTest stresslevelReportTest = gson.fromJson(finalObject.toString(), StresslevelReportTest.class);

                stresslevelReportTests.add(stresslevelReportTest);
            }
            return stresslevelReportTests;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return null;
    }



    public static List<StresslevelReportTest> getStreebyGroupid(int groupid) {
        final String methodPath = "/com.innofire.stresslevelreport/findbyusername/"+ groupid; //initialize
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        Gson gson = new Gson();
        BufferedReader reader = null;
        try {
            url = new URL(BASE_URI + methodPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");

            InputStream stream = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line ="";
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }

            String finalJson = buffer.toString();

            //  JSONObject parentObject = new JSONObject(finalJson);
            JSONArray parentArray = new JSONArray(finalJson);

            List<StresslevelReportTest> stresslevelReportTests= new ArrayList<>();

            gson = new Gson();

            for(int i=0; i<parentArray.length(); i++) {
                JSONObject finalObject = parentArray.getJSONObject(i);
                /**
                 * below single line of code from Gson saves you from writing the json parsing yourself which is commented below
                 */
                StresslevelReportTest stresslevelReportTest = gson.fromJson(finalObject.toString(), StresslevelReportTest.class);

                stresslevelReportTests.add(stresslevelReportTest);
            }
            return stresslevelReportTests;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return null;
    }

    public static List<Duration> getDurationofSleep(String username, String date) {
        final String methodPath = "/com.innofire.sleepinghours/findbyusername/"+ username + "/" + date; //initialize
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        Gson gson = new Gson();
        BufferedReader reader = null;
        try {
            url = new URL(BASE_URI + methodPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");

            InputStream stream = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line ="";
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }

            String finalJson = buffer.toString();



            JSONArray parentArray = new JSONArray(finalJson);
            List<Duration> durations = new ArrayList<>();

            gson = new Gson();

            for(int i=0; i<parentArray.length(); i++) {
                JSONObject finalObject = parentArray.getJSONObject(i);
                /**
                 * below single line of code from Gson saves you from writing the json parsing yourself which is commented below
                 */
                Duration duration = gson.fromJson(finalObject.toString(), Duration.class);

                durations.add(duration);
            }
            return durations;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return null;
    }



    public static List<GetthegroupID> getbyUsernameofGroupid(String username) {
        final String methodPath = "/com.innofire.group1/findByUsername1/"+ username; //initialize
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        Gson gson = new Gson();
        BufferedReader reader = null;
        try {
            url = new URL(BASE_URI + methodPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");

            InputStream stream = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line ="";
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }

            String finalJson = buffer.toString();

            //  JSONObject parentObject = new JSONObject(finalJson);
            JSONArray parentArray = new JSONArray(finalJson);

            List<GetthegroupID> getthegroupIDs= new ArrayList<>();

            gson = new Gson();

            for(int i=0; i<parentArray.length(); i++) {
                JSONObject finalObject = parentArray.getJSONObject(i);
                /**
                 * below single line of code from Gson saves you from writing the json parsing yourself which is commented below
                 */
                GetthegroupID getthegroupID = gson.fromJson(finalObject.toString(), GetthegroupID.class);

                getthegroupIDs.add(getthegroupID);
            }
            return getthegroupIDs;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return null;
    }




}
