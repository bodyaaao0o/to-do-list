package com.project.my_todolist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class TaskInputGUI extends JFrame {
    private JTextField titleField;
    private JTextArea descriptionArea;
    private JTextField deadlineField;
    private TaskManager taskManager;

    public TaskInputGUI() {
        taskManager = new TaskManager();

        // Налаштування фрейму
        setTitle("Додати завдання");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Заголовок
        JLabel titleLabel = new JLabel("Заголовок:");
        titleLabel.setBounds(10, 10, 100, 25);
        add(titleLabel);

        titleField = new JTextField();
        titleField.setBounds(120, 10, 250, 25);
        add(titleField);

        // Опис
        JLabel descriptionLabel = new JLabel("Опис:");
        descriptionLabel.setBounds(10, 40, 100, 25);
        add(descriptionLabel);

        descriptionArea = new JTextArea();
        descriptionArea.setBounds(120, 40, 250, 60);
        add(descriptionArea);

        // Дедлайн
        JLabel deadlineLabel = new JLabel("Дедлайн (yyyy-MM-dd):");
        deadlineLabel.setBounds(10, 110, 200, 25);
        add(deadlineLabel);

        deadlineField = new JTextField();
        deadlineField.setBounds(120, 110, 250, 25);
        add(deadlineField);

        // Кнопка додавання
        JButton addButton = new JButton("Додати");
        addButton.setBounds(10, 150, 360, 25);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String description = descriptionArea.getText();
                LocalDate deadline = LocalDate.parse(deadlineField.getText());
                taskManager.AddTask(title, description, deadline);
                taskManager.SaveTask();
                JOptionPane.showMessageDialog(null, "Завдання додано!");
            }
        });
        add(addButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TaskInputGUI gui = new TaskInputGUI();
            gui.setVisible(true);
        });
    }
}
