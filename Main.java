import java.util.Scanner;

class Author {
    private String name;
    private String surname;
    private String birthdate;

    public Author() {
        this.name = "";
        this.surname = "";
        this.birthdate = "";
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя автора: ");
        this.name = sc.nextLine();
        System.out.print("Введите фамилию автора: ");
        this.surname = sc.nextLine();
        System.out.print("Введите дату рождения (DD.MM.YYYY): ");
        this.birthdate = sc.nextLine();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void print() {
        System.out.println("Автор: " + name + " " + surname + ", Дата рождения: " + birthdate);
    }
}

class Category {
    private String name;
    private String description;

    public Category() {
        this.name = "";
        this.description = "";
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите название категории: ");
        this.name = sc.nextLine();
        System.out.print("Введите описание категории: ");
        this.description = sc.nextLine();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.println("Категория: " + name + ", Описание: " + description);
    }
}

class Book {
    private String title;
    private Author author;
    private Category category;
    private int year;
    private int copiesAvailable;
    private static int bookCount = 0;

    public Book() {
        this.title = "";
        this.author = new Author();
        this.category = new Category();
        this.year = 0;
        this.copiesAvailable = 0;
    }

    public static int getBookCount() {
        return bookCount;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите название книги: ");
        this.title = sc.nextLine();

        this.author.input();
        this.category.input();

        System.out.print("Введите год издания: ");
        while (true) {
            try {
                this.year = Integer.parseInt(sc.nextLine());
                if (this.year < 1000 || this.year > 2024) {
                    System.out.println("Ошибка: Неверный год издания! Год должен быть между 1000 и 2024.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите корректный год.");
            }
        }

        System.out.print("Введите количество доступных копий: ");
        while (true) {
            try {
                this.copiesAvailable = Integer.parseInt(sc.nextLine());
                if (this.copiesAvailable < 0) {
                    System.out.println("Ошибка: Количество копий не может быть отрицательным.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите корректное количество.");
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public int getYear() {
        return year;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void decreaseCopies() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    public void increaseCopies() {
        copiesAvailable++;
    }

    public void print() {
        System.out.println("Книга: " + title + ", Год: " + year + ", Доступных копий: " + copiesAvailable);
        author.print();
        category.print();
    }

    public static void increaseBookCount() {
        bookCount++;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        bookCount--;
    }
}

class Reader {
    private String name;
    private String surname;
    private String cardNumber;

    public Reader() {
        this.name = "";
        this.surname = "";
        this.cardNumber = "";
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя читателя: ");
        this.name = sc.nextLine();
        System.out.print("Введите фамилию читателя: ");
        this.surname = sc.nextLine();
        System.out.print("Введите номер читательского билета: ");
        this.cardNumber = sc.nextLine();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void print() {
        System.out.println("Читатель: " + name + " " + surname + ", Номер карты: " + cardNumber);
    }
}

class BookIssue {
    private Book book;
    private Reader reader;
    private String issueDate;
    private String dueDate;

    public BookIssue(Book book, Reader reader, String issueDate, String dueDate) {
        this.book = book;
        this.reader = reader;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public void print() {
        System.out.println("Выдача книги: ");
        book.print();
        reader.print();
        System.out.println("Дата выдачи: " + issueDate + ", Срок возврата: " + dueDate);
    }
}

// Вспомогательный класс для поиска книги по названию
class BookSearch {
    public static Book searchBookByTitle(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Создаем массив книг
        Book[] books = new Book[5]; // Пример: 5 книг
        int bookIndex = 0;

        // Добавляем книги в массив
        while (bookIndex < books.length) {
            Book dynamicBook = new Book();
            dynamicBook.input(); // Вводим данные о книге
            Book.increaseBookCount(); // Увеличиваем счетчик книг
            books[bookIndex++] = dynamicBook;

            System.out.print("Хотите добавить еще одну книгу? (y/n): ");
            String response = sc.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                break;
            }
        }

        // Создание и ввод данных о читателе
        Reader dynamicReader = new Reader();
        dynamicReader.input();

        // Ввод данных о выдаче книги
        System.out.print("Введите дату выдачи (DD.MM.YYYY): ");
        String issueDate = sc.nextLine();
        System.out.print("Введите срок возврата (DD.MM.YYYY): ");
        String dueDate = sc.nextLine();

        // Поиск книги по названию
        System.out.print("Введите название книги для поиска: ");
        String searchTitle = sc.nextLine();
        Book foundBook = BookSearch.searchBookByTitle(books, searchTitle);
        if (foundBook != null) {
            // Создание записи о выдаче книги
            BookIssue issue = new BookIssue(foundBook, dynamicReader, issueDate, dueDate);
            issue.print();  // Выводим информацию о выдаче
        } else {
            System.out.println("Книга с таким названием не найдена.");
        }

        // Вывод общего количества книг
        System.out.println("Общее количество книг в системе: " + Book.getBookCount());
    }
}
