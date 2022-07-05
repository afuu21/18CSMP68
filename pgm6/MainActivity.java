package com.example.project6;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.disp);
    }

    public void parsexml(View V) {
        try {
            InputStream is = getAssets().open("city.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(is);
            StringBuilder sB = new StringBuilder();
            sB.append("XML DATA");
            sB.append("\n-----------------");
            NodeList nodeList = document.getElementsByTagName("place");
            for(int i=0; i<nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if(node.getNodeType() == node.ELEMENT_NODE) {
                    Element element =(Element) node;
                    sB.append("\nName: ").append(getValue("name",element));
                    sB.append("\nLatitude: ").append(getValue("lat",element));
                    sB.append("\nLongitude: ").append(getValue("long", element));
                    sB.append("\nTemperature: ").append(getValue("temp",element));
                    sB.append("\nHumidity: ").append(getValue("hum",element));
                }
            }
            display.setText(sB.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this,"Error Parsing XML", Toast.LENGTH_SHORT).show();

        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void parsejson(View V) {
        String json;
        StringBuilder sB = new StringBuilder();
        try {
            InputStream is = getAssets().open("city.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            json = new String(buffer, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(json);
            sB.append("JSON DATA");
            sB.append("\n-----------------");
            for(int i=0; i<jsonArray.length(); i++) {
                JSONObject jo = jsonArray.getJSONObject(i);
                sB.append("\nName").append(jo.getString("name"));
                sB.append("\nLatitude").append(jo.getString("lat"));
                sB.append("\nLongitude").append(jo.getString("long"));
                sB.append("\nTemperature").append(jo.getString("temp"));
                sB.append("\nHumidity").append(jo.getString("hum"));
            }
            display.setText(sB.toString());
            is.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Erro in finding file", Toast.LENGTH_SHORT).show();
        }
    }
    private String getValue(String tag, Element element) {
        return element.getElementsByTagName(tag).item(0).getChildNodes().item(0).getNodeValue();
    }
}
