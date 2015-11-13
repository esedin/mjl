package com.yard42.l.java.rest;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softcomputer.csf.sws.service.rest.dto.AuthenticationRequest;
import com.softcomputer.csf.sws.service.rest.dto.AuthenticationResult;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestTask().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            new HttpRequestTask().execute();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, AuthenticationResult> {
        @Override
        protected AuthenticationResult doInBackground(Void... params) {
            try {
                JSONObject jsonRequest = new JSONObject();
                AuthenticationRequest request = new AuthenticationRequest();
                request.setDomain("ISD");
                request.setId("esed");
                request.setPassword("djlrf58u");
                request.setSystem("SOFTLAB");
                request.setTerminalId("TERMINALID");

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);

                HttpEntity<AuthenticationRequest> entity = new HttpEntity<AuthenticationRequest>(request, headers);
                final String url = "http://iesedin:8080/csf/web-sws/rest/authenticate";
                RestTemplate restTemplate = new RestTemplate();

                List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
                messageConverters.add(new MappingJackson2HttpMessageConverter());
                messageConverters.add(new StringHttpMessageConverter());

                restTemplate.setMessageConverters(messageConverters);

                ResponseEntity<AuthenticationResult> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, AuthenticationResult.class);


                return responseEntity.getBody();
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(AuthenticationResult loginResult) {
            TextView greetingIdText = (TextView) findViewById(R.id.id_value);
            TextView greetingContentText = (TextView) findViewById(R.id.content_value);

            greetingIdText.setText(loginResult.getInitials());
        }

    }
}
