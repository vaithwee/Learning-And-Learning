package com.example.vaith.contactprovider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList<String> names = new ArrayList<String>();
                final  ArrayList<ArrayList<String>> details = new ArrayList<>();
                Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
                while (cursor.moveToNext() && names.size() < 10)
                {
                    String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    names.add(name);

                    Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactId, null, null);
                    ArrayList<String> detail = new ArrayList<String>();
                    while (phones.moveToNext())
                    {
                        String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        detail.add("电话号码：" + phoneNumber);
                    }
                    phones.close();
                    Cursor emails = getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID + "=" + contactId, null, null);
                    while (emails.moveToNext())
                    {
                        String emailAddress = emails.getString(emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                        detail.add("邮件地址:" + emailAddress);
                    }
                    emails.close();
                    details.add(detail);

                }
                cursor.close();

                View resultDialog = getLayoutInflater().inflate(R.layout.result, null);
                ExpandableListView listView = (ExpandableListView) resultDialog.findViewById(R.id.list);
                ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
                    @Override
                    public int getGroupCount() {
                        return names.size();
                    }

                    @Override
                    public int getChildrenCount(int i) {
                        return details.get(i).size();
                    }

                    @Override
                    public Object getGroup(int i) {
                        return names.get(i);
                    }

                    @Override
                    public Object getChild(int i, int i1) {
                        return details.get(i).get(i1);
                    }

                    @Override
                    public long getGroupId(int i) {
                        return i;
                    }

                    @Override
                    public long getChildId(int i, int i1) {
                        return i1;
                    }

                    @Override
                    public boolean hasStableIds() {
                        return true;
                    }


                    private TextView getTextView()
                    {
                        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);
                        TextView textView = new TextView(MainActivity.this);
                        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                        textView.setPadding(36,0,0,0);
                        textView.setTextSize(20);
                        return textView;
                    }

                    @Override
                    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                        TextView textView = getTextView();
                        textView.setText(getGroup(i).toString());
                        return textView;
                    }

                    @Override
                    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                        TextView textView = getTextView();
                        textView.setText(getChild(i, i1).toString());
                        return textView;
                    }

                    @Override
                    public boolean isChildSelectable(int i, int i1) {
                        return false;
                    }
                };
                listView.setAdapter(adapter);
                new AlertDialog.Builder(MainActivity.this).setView(resultDialog).setPositiveButton("sure", null).show();
            }



        });

        Button add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ((EditText)findViewById(R.id.name)).getText().toString();
                String phone = ((EditText)findViewById(R.id.phone)).getText().toString();
                String email = ((EditText)findViewById(R.id.email)).getText().toString();
                ContentValues values = new ContentValues();
                Uri uri = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, values);
                long rawContactId = ContentUris.parseId(uri);
                values.clear();
                values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
                values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
                values.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, name);
                getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
                values.clear();
                values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
                values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
                values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, phone);
                values.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
                getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);

                values.clear();
                values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
                values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE);
                values.put(ContactsContract.CommonDataKinds.Email.DATA, email);
                values.put(ContactsContract.CommonDataKinds.Email.TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK);
                getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
                Toast.makeText(MainActivity.this, "add success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
