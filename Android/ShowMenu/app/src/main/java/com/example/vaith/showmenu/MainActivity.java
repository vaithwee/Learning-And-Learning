package com.example.vaith.showmenu;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.set:
            {
                Toast.makeText(MainActivity.this, "set button on click", Toast.LENGTH_SHORT).show();

                View root = this.getLayoutInflater().inflate(R.layout.layout_set, null);
                final PopupWindow popupWindow = new PopupWindow(root, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                View parentView = getLayoutInflater().inflate(R.layout.activity_main, null);
                int y = getSupportActionBar().getHeight();
                Rect frame = new Rect();
                getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
                y += frame.top;
                Log.d("mainactivity", y + " height");
                popupWindow.setOutsideTouchable(true);
                popupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
                popupWindow.showAtLocation(parentView, Gravity.RIGHT | Gravity.TOP, 0, y);

                Button close = (Button) root.findViewById(R.id.close);
                assert close != null;
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });

                break;
            }
        }
        return true;
    }
}
