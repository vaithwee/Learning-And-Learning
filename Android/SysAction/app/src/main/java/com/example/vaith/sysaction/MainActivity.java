package com.example.vaith.sysaction;

import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int PICK_CONTACT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button choice = (Button) findViewById(R.id.choice);
        assert choice != null;
        choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("vnd.android.cursor.item/phone");
                startActivityForResult(intent, PICK_CONTACT);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case (PICK_CONTACT):
            {
                if (resultCode == Activity.RESULT_OK)
                {
                    Uri contactData = data.getData();
                    CursorLoader loader = new CursorLoader(this, contactData, null, null, null, null);
                    Cursor cursor = loader.loadInBackground();
                    if (cursor.moveToFirst())
                    {
                        String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                        String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        String phoneNumber = "此联系人未输入电话号码";
                        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);
                        if (phones.moveToFirst())
                        {
                            phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        }
                        phones.close();
                        TextView nametv = (TextView) findViewById(R.id.name);
                        nametv.setText(name);
                        TextView phonetv = (TextView) findViewById(R.id.phone);
                        phonetv.setText(phoneNumber);
                    }
                    cursor.close();
                }
            }
            break;
        }
    }
}
