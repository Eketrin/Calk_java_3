package com.example.calk_3;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
/** @noinspection ALL*/
public class MainActivity extends AppCompatActivity {

    String oldNumber;
    String operator = "";
    EditText inputText;
    Boolean isNew = true; // Флаг для определения, является ли текущее число новым

    // вот это уже было тут
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Инициализация поля ввода
        inputText = findViewById(R.id.InputText);
    }
    // Метод для обработки нажатий кнопок с числами
    public void clicKNumber(View view) {
        // Если это новое число, очищаем поле ввода
        if (isNew) {
            inputText.setText("");
        }
        isNew = false; // Устанавливаем флаг, что текущее число не новое
        String number = inputText.getText().toString();
        // Добавляем число к текущему значению
        number = appendNumber(view.getId(), number);
        inputText.setText(number); // Обновляем поле ввода
    }
    // Метод для добавления числа в строку
    private String appendNumber(int viewId, String currentNumber) {
        // Проверяем идентификатор кнопки и добавляем соответствующее число
        if (viewId == R.id.Zero) {
            return currentNumber + "0";
        } else if (viewId == R.id.One) {
            return currentNumber + "1";
        } else if (viewId == R.id.Two) {
            return currentNumber + "2";
        } else if (viewId == R.id.Three) {
            return currentNumber + "3";
        } else if (viewId == R.id.Four) {
            return currentNumber + "4";
        } else if (viewId == R.id.Five) {
            return currentNumber + "5";
        } else if (viewId == R.id.Six) {
            return currentNumber + "6";
        } else if (viewId == R.id.Seven) {
            return currentNumber + "7";
        } else if (viewId == R.id.Eight) {
            return currentNumber + "8";
        } else if (viewId == R.id.Nine) {
            return currentNumber + "9";
        } else if (viewId == R.id.PlusMinus) {
            return toggleSign(currentNumber); // Переключение знака числа
        } else if (viewId == R.id.Point) {
            return addDot(currentNumber); // Добавление десятичной точки
        }
        return currentNumber; // Возвращаем текущее число, если ничего не добавлено
    }
    // Метод для переключения знака числа
    private String toggleSign(String number) {
        if (numberIsZero(number)) {
            return "0"; // Если число равно нулю, возвращаем "0"
        } else {
            return String.valueOf(Double.parseDouble(number) * -1); // Переключаем знак
        }
    }
    // Метод для добавления десятичной точки
    private String addDot(String number) {
        if (!dotIsPresent(number)) {
            return number + "."; // Добавляем точку, если её нет
        }
        return number; // Возвращаем текущее число, если точка уже присутствует
    }
    // Метод для проверки, является ли число нулем
    public boolean numberIsZero(String number) {
        return number.equals("0") || number.equals("");
    }
    // Метод для проверки, есть ли десятичная точка в числе
    public boolean dotIsPresent(String number) {
        return number.indexOf(".") != -1;
    }
    // Метод для обработки операций
    public void Operations(View view) {
        isNew = true; // Устанавливаем флаг, что следующее число будет новым
        oldNumber = inputText.getText().toString(); // Сохраняем текущее число
        setOperator(view.getId()); // Устанавливаем оператор
    }
    // Метод для установки оператора
    private void setOperator(int viewId) {
        if (viewId == R.id.Plus) {
            operator = "+"; // Устанавливаем оператор сложения
        } else if (viewId == R.id.Minus) {
            operator = "-"; // Устанавливаем оператор вычитания
        } else if (viewId == R.id.Delenie) {
            operator = "/"; // Устанавливаем оператор деления
        } else if (viewId == R.id.Umnojenie) {
            operator = "*"; // Устанавливаем оператор умножения
        }
    }
    // Метод для вычисления результата
    public void clickResult(View view) {
        String newNumber = inputText.getText().toString(); // Получаем новое число
        Double result = calculateResult(oldNumber, newNumber, operator); // Вычисляем результат
        inputText.setText(result.toString()); // Отображаем результат
    }
    // Метод для выполнения вычислений
    private Double calculateResult(String oldNum, String newNum, String operator) {
        Double result = 0.0; // Переменная для хранения результата
        Double oldNumber = Double.parseDouble(oldNum); // Преобразуем старое число
        Double newNumber = Double.parseDouble(newNum); // Преобразуем новое число

        // Выполняем вычисления в зависимости от оператора
        if (operator.equals("+")) {
            result = oldNumber + newNumber;
        } else if (operator.equals("-")) {
            result = oldNumber - newNumber;
        } else if (operator.equals("/")) {
            result = oldNumber / newNumber;
        } else if (operator.equals("*")) {
            result = oldNumber * newNumber;
        }
        return result; // Возвращаем результат
    }
    // Метод для сброса калькулятора
    public void acClick(View view) {
        inputText.setText("0"); // Сбрасываем поле ввода
        oldNumber = ""; // Очищаем старое число
        isNew = true; // Устанавливаем флаг для нового числа
    }
    // Метод для вычисления процентов
    public void clickProcent(View view) {
        String number = inputText.getText().toString(); // Получаем текущее число
        if (operator.isEmpty()) { // Если оператор не установлен
            double temp = Double.parseDouble(number) / 100; // Вычисляем процент
            inputText.setText(String.valueOf(temp)); // Отображаем результат
        } else {
            Double result = calculate(oldNumber, number, operator); // Вычисляем процент в зависимости от оператора
            inputText.setText(result.toString()); // Отображаем результат
            operator = ""; // Сбрасываем оператор
        }
    }
    // Метод для вычисления процентов в зависимости от оператора
    public static Double calculate(String oldNum, String newNum, String operator) {
        Double result = 0.0; // Переменная для хранения результата
        Double oldNumber = Double.parseDouble(oldNum); // Преобразуем старое число
        Double newNumber = Double.parseDouble(newNum); // Преобразуем новое число

        // Выполняем вычисления процентов в зависимости от оператора
        if (operator.equals("+")) {
            result = oldNumber + newNumber * oldNumber / 100;
        } else if (operator.equals("-")) {
            result = oldNumber - newNumber * oldNumber / 100;
        } else if (operator.equals("/")) {
            result = oldNumber / newNumber * 100;
        } else if (operator.equals("*")) {
            result = oldNumber * newNumber / 100;
        }
        return result; // Возвращаем результат
    }
}
