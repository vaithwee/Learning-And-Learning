package com.example.vaith.xml;

import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button show = (Button) findViewById(R.id.show);
        assert show != null;
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XmlResourceParser xrp = getResources().getXml(R.xml.books);
                try {
                    StringBuffer sb = new StringBuffer("");
                    while (xrp.getEventType() != XmlPullParser.END_DOCUMENT)
                    {
                        if (xrp.getEventType() == XmlPullParser.START_TAG)
                        {
                            String tagName = xrp.getName();
                            if (tagName.equals("book"))
                            {
                                String bookName = xrp.getAttributeValue(null, "price");
                                sb.append("价格：");
                                sb.append(bookName);
                                String bookPrice = xrp.getAttributeValue(1);
                                sb.append("  出版日期： ");
                                sb.append(bookPrice);
                                sb.append("  书名: ");
                                sb.append(xrp.nextText());
                            }
                            sb.append("\n");
                        }
                        xrp.next();
                    }
                    Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_SHORT).show();
                } catch (XmlPullParserException e)
                {
                    e.printStackTrace();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
