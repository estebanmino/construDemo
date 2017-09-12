package com.app.construapp.construdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView lessonsListView;
    private BaseAdapter lessonsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Lesson> lessonList = new ArrayList<>();

        Lesson lesson_1 = new Lesson();
        lesson_1.setName("Lección 1");
        lesson_1.setDescription("Descripción 1");

        Lesson lesson_2 = new Lesson();
        lesson_2.setName("Lección 2");
        lesson_2.setDescription("Descripción 2");

        lessonList.add(lesson_2);
        lessonList.add(lesson_1);

        lessonsListView = (ListView) findViewById(R.id.lesson_list);

        lessonsAdapter = new LessonAdapter(this, lessonList);
        lessonsListView.setAdapter(lessonsAdapter);

        lessonsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_LONG).show();
                Lesson lesson = (Lesson) lessonsAdapter.getItem(position);
                Log.i("OBJECT",lesson.getName());
                startActivity(LessonActivity.getIntent(MainActivity.this, lesson.getName(),
                        lesson.getDescription()));
            }
        });

    }
}
