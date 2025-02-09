package com.project.my_todolist;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks;
    private static final String FILE_NAME = "task_file.json";
    private Gson gson;

    public TaskManager() {
        tasks = new ArrayList<>();
        // Реєстрація адаптера для LocalDate
        gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
    }

    public void AddTask(String title, String description, LocalDate deadline) {
        tasks.add(new Task(title, description, deadline, false));
    }

    public void SaveTask() {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTask() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            Type taskListType = new TypeToken<List<Task>>() {}.getType();
            // Перевірка, чи є дані у файлі
            if (reader.ready()) {
                tasks = gson.fromJson(reader, taskListType); // Завантаження завдань з файлу
            } else {
                tasks = new ArrayList<>(); // Якщо файл порожній, ініціалізуємо порожній список
            }
        } catch (FileNotFoundException e) {
            tasks = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            // Якщо сталася помилка синтаксису, ініціалізуємо порожній список
            tasks = new ArrayList<>();
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void MarkTasksComp(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).AsCompleted();
        }
    }

    public void EditTask(int index, String newTitle, String newDescription, LocalDate newDeadline) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setTitle(newTitle != null && !newTitle.isEmpty() ? newTitle : task.getTitle());
            task.setDescription(newDescription != null && !newDescription.isEmpty() ? newDescription : task.getDescription());
            task.setDeadline(newDeadline != null ? newDeadline : task.getDeadline());
        }
    }

    public void dispTask() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ". " + tasks.get(i));
        }
    }
}
