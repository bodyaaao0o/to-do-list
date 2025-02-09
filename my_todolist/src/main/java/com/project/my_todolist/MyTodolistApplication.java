package com.project.my_todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

@SpringBootApplication
public class MyTodolistApplication {

	public static void main(String[] args) {
		TaskManager taskManager = new TaskManager();
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		// Завантажуємо завдання при запуску програми
		taskManager.loadTask();

		while (running) {
			System.out.println("1. Додати завдання");
			System.out.println("2. Відобразити завдання");
			System.out.println("3. Позначити завдання як виконане");
			System.out.println("4. Редагувати завдання");
			System.out.println("5. Вийти");
			System.out.print("Оберіть опцію: ");

			int option = scanner.nextInt();
			scanner.nextLine(); // очищення буфера

			switch (option) {
				case 1:
					System.out.print("Введіть заголовок завдання: ");
					String title = scanner.nextLine();
					System.out.print("Введіть опис завдання: ");
					String description = scanner.nextLine();
					System.out.print("Введіть дедлайн (yyyy-MM-dd): ");
					try {
						LocalDate deadline = LocalDate.parse(scanner.nextLine());
						taskManager.AddTask(title, description, deadline);
						taskManager.SaveTask(); // Зберігаємо завдання після додавання
					} catch (DateTimeParseException e) {
						System.out.println("Невірний формат дати. Спробуйте ще раз.");
					}
					break;

				case 2:
					System.out.println("Список завдань:");
					taskManager.dispTask();
					break;

				case 3:
					System.out.print("Введіть номер завдання, яке потрібно позначити як виконане: ");
					int taskIndex = scanner.nextInt();
					if (taskIndex >= 0 && taskIndex < taskManager.getAllTasks().size()) {
						taskManager.MarkTasksComp(taskIndex);
						taskManager.SaveTask(); // Зберігаємо завдання після позначення як виконане
					} else {
						System.out.println("Невірний номер завдання.");
					}
					break;

				case 4:
					System.out.print("Введіть номер завдання, яке потрібно редагувати: ");
					int editIndex = scanner.nextInt();
					if (editIndex >= 0 && editIndex < taskManager.getAllTasks().size()) {
						scanner.nextLine(); // очищення буфера
						System.out.print("Введіть новий заголовок: ");
						String newTitle = scanner.nextLine();
						System.out.print("Введіть новий опис: ");
						String newDescription = scanner.nextLine();
						System.out.print("Введіть новий дедлайн (yyyy-MM-dd): ");
						try {
							LocalDate newDeadline = LocalDate.parse(scanner.nextLine());
							taskManager.EditTask(editIndex, newTitle, newDescription, newDeadline);
							taskManager.SaveTask(); // Зберігаємо завдання після редагування
						} catch (DateTimeParseException e) {
							System.out.println("Невірний формат дати. Спробуйте ще раз.");
						}
					} else {
						System.out.println("Невірний номер завдання.");
					}
					break;

				case 5:
					running = false;
					break;

				default:
					System.out.println("Невірна опція. Спробуйте ще раз.");
			}
		}

		scanner.close();
		System.out.println("Програма завершена.");
	}
}
