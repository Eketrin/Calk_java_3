package com.example.calk_3;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Unit_test {
    private MainActivity mainActivity;
    @Before
    public void setUp() {
        mainActivity = new MainActivity();
        mainActivity.onCreate(null); // Инициализируем активность
    }
    @Test
    public void testClickResult_Addition() {
        mainActivity.oldNumber = "5";
        mainActivity.operator = "+";
        mainActivity.inputText.setText("3");
        mainActivity.clickResult(null);
        assertEquals("8.0", mainActivity.inputText.getText().toString());
    }
    @Test
    public void testClickResult_Subtraction() {
        mainActivity.oldNumber = "10";
        mainActivity.operator = "-";
        mainActivity.inputText.setText("4");
        mainActivity.clickResult(null);
        assertEquals("6.0", mainActivity.inputText.getText().toString());
    }
    @Test
    public void testClickProcent_NoOperator() {
        mainActivity.inputText.setText("200");
        mainActivity.clickProcent(null);
        assertEquals("2.0", mainActivity.inputText.getText().toString());
    }
    @Test
    public void testClickProcent_WithOperator() {
        mainActivity.oldNumber = "100";
        mainActivity.operator = "+";
        mainActivity.inputText.setText("50");
        mainActivity.clickProcent(null);
        assertEquals("150.0", mainActivity.inputText.getText().toString());
    }
}
