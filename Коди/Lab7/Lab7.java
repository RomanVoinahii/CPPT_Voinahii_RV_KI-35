public interface Numbers
{
    int getDecValue();
    void PrintInfo();
}
public class BinaryNumbers implements Numbers
{
    private String number;
    private int value;


    public BinaryNumbers(String number, int value) {
        this.number = number;
        this.value = value;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int getDecValue() {
        return value;
    }

    @Override
    public void PrintInfo() {
        System.out.println("Number in binary: " + number + ",\tvalue in dec: " + value);
    }
}



public class HexNumbers implements Numbers
{
    private String number;
    private int value;


    public HexNumbers(String number, int value) {
        this.number = number;
        this.value = value;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int getDecValue() {
        return value;
    }

    @Override
    public void PrintInfo() {
        System.out.println("Number in hex: " + number + ",\tvalue in dec: " + value);
    }
}

import java.util.ArrayList;
import java.util.List;

public class Plural<T extends Numbers> // створюєм параметризований клас, який параметром може прийняти тільки той об'єкт, який реалізовує інтерфейс
{
    private final List<T> numbers;

    /**
     * Constructor
     */
    public Plural() // створєм список об'єктів
    {
        this.numbers = new ArrayList<>();
    }

    /**
     * Method to find max area building
     * @return max
     */
    public T FindMax() //метод для пошуку максимального об'єкта
    {
        if (numbers.isEmpty())
        {
            return null;
        }
        else
        {
            T max = numbers.get(0);
            for (int i = 1; i < numbers.size(); i++)
            {
                if (numbers.get(i).getDecValue() > max.getDecValue())
                {
                    max = numbers.get(i);
                }
            }
            return max;
        }
    }

    /**
     * Method to add item
     * @param item
     */
    public void AddItem(T item)
    { // метод для додавання об'єктів
        numbers.add(item);
        var index = numbers.indexOf(item);
        System.out.print("Element was added: index - " + index + "; ");
        item.PrintInfo();
    }

    /**
     * Method to delete item
     * @param i
     */
    public void DeleteItem(int i)
    {// метод для видалення об'єктів
        System.out.print("Element on index " + i + " was deleted: ");
        numbers.get(i).PrintInfo();
        numbers.remove(i);
    }

    /**
     * Method to PrintAllItems
     */
    public void PrintAllItems()
    {// метод для виводу всіх об'єктів на екран
        for (T el : numbers)
        {
            el.PrintInfo();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Plural<? super Numbers> plural = new Plural<>();

        plural.AddItem(new HexNumbers("14D", 333));
        plural.AddItem(new BinaryNumbers("1 0110 0100 0011", 5699));
        plural.AddItem(new HexNumbers("593A", 22842));
        plural.AddItem(new HexNumbers("19BD", 6589));
        plural.AddItem(new BinaryNumbers("11 1101 1000", 984));
        plural.AddItem(new HexNumbers("E2F4", 58100));
        plural.AddItem(new BinaryNumbers("11 0101 1000", 856));
        plural.AddItem(new BinaryNumbers("10 0101 0111", 599));
        plural.AddItem(new HexNumbers("15C1", 5569));
        plural.AddItem(new BinaryNumbers("10 1001 1101", 669));

        var max = plural.FindMax();
        System.out.println("Max element is: " );
        max.PrintInfo();
    }
}
