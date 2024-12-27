import java.util.Scanner;

class Author {
    private String name;
    private String surname;
    private String birthdate;

    // Конструктор по умолчанию
    public Author() {
        this.name = "";
        this.surname = "";
        this.birthdate = "";
    }

    // Метод для ввода данных автора
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя автора: ");
        this.name = sc.nextLine();
        System.out.print("Введите фамилию автора: ");
        this.surname = sc.nextLine();
        System.out.print("Введите дату рождения (DD.MM.YYYY): ");
        this.birthdate = sc.nextLine();
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    // Метод для вывода данных автора
    public void print() {
        System.out.println("Автор: " + name + " " + surname + ", Дата рождения: " + birthdate);
    }
}

class Category {
    private String name;
    private String description;

    // Конструктор по умолчанию
    public Category() {
        this.name = "";
        this.description = "";
    }

    // Метод для ввода данных категории
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите название категории: ");
        this.name = sc.nextLine();
        System.out.print("Введите описание категории: ");
        this.description = sc.nextLine();
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Метод для вывода данных категории
    public void print() {
        System.out.println("Категория: " + name + ", Описание: " + description);
    }
}