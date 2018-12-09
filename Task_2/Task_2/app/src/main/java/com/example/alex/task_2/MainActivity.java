package com.example.alex.task_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.alex.task_2.dialogues.ExitDialog;
import com.example.alex.task_2.interfaces.ExitDialogHandler;

public class MainActivity extends Activity implements ExitDialogHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Регистрируем меню для меню опций (с тремя точками в правом-верхнем углу)
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;
    }

    // вызывается при выборе элементов меню опций
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.editor:
                Intent editor_intent = new Intent(this, Editor.class);
                startActivity(editor_intent);
                return true;
            case R.id.editor2:
                Intent editor_intent2 = new Intent(this, Editor2.class);
                startActivity(editor_intent2);
                return true;
            case R.id.close:
                ExitDialog exit_dialog = new ExitDialog();
                exit_dialog.show(this.getFragmentManager(), "dialog");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onExit(){
        Toast toast = Toast.makeText(getApplicationContext(), "Bye!", Toast.LENGTH_SHORT);
        toast.show();
        this.finishAndRemoveTask();
    }
}

