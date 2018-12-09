package com.example.alex.task_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class Editor2 extends Activity {

    private ActionMode mActionMode;

    // Реализация обработчика меню действий
    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {

        // Вызывается при переходе в режим действий; при вызове startActionMode()
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // загружаем разметку для меню
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu_editor, menu);
            return true;
        }

        // вызывается каждый раз при показе меню
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // true - меню было обновлено
        }

        // вызывается при выборе элемента меню
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.copy:
                    return true;
                case R.id.paste:
                    return true;
                case R.id.delete:
                    return true;
                default:
                    return false;
            }
        }

        // вызывается при выходе из режима действий
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        View editor = findViewById(R.id.editor);

        // регистрируем обработчик линного нажатия для элемента управления
        editor.setOnLongClickListener(new View.OnLongClickListener() {
            // Called when the user long-clicks on someView
            public boolean onLongClick(View view) {
                if (mActionMode != null) {
                    return false;
                }

                // вызов обработчика меню действий
                mActionMode = startActionMode(mActionModeCallback);
                view.setSelected(true);
                return true;
            }
        });
    }


}

