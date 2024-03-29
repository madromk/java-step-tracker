import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                handleStepsInput(scanner, stepTracker);
            } else if (command == 2) {
                handlePrintStatistics(scanner, stepTracker, converter);
            } else if (command == 3) {
                System.out.println("Введите новую цель:");
                int target = scanner.nextInt();
                stepTracker.setTarget(target);
                System.out.println("Цель сохранена");
            } else if (command == 0) {
                System.out.println("Приложение закрыто");
                break;
            } else {
                System.out.println("Такой команды нет");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Добро пожаловать в Счётчик калорий. Выберете команду для продолжения:");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }

    public static void handleStepsInput(Scanner scanner, StepTracker stepTracker) {
        System.out.println("Введите название месяца:");
        String nameMonth = scanner.next();
        System.out.println("Введите день месяца:");
        int dayMonth = scanner.nextInt();
        System.out.println("Введите количество шагов:");
        int stepsDay = scanner.nextInt();
        stepTracker.MonthData(nameMonth, dayMonth, stepsDay);
    }

    public static void handlePrintStatistics(Scanner scanner, StepTracker stepTracker, Converter converter) {
        System.out.println("За какой месяц вы хотите получить статистику ?");
        String nameMonth = scanner.next();
        if (stepTracker.monthToData.containsKey(nameMonth)) {
            stepTracker.printStepsByMonth(nameMonth);
            stepTracker.printStepsStat(nameMonth);
            converter.printDistanceAndCalories(nameMonth, stepTracker);
            stepTracker.printBestSeries(nameMonth);
        } else {
            System.out.println("Неверный формат введенных данных. Повторите попытку");
        }
    }
}

