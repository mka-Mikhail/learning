package lesson4.homework.formatting;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Formatting {
    public static void main(String[] args) {
        double value = 123487655.67;
        System.out.printf("$%,.2f\n", value);
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator(',');
        DecimalFormat df = new DecimalFormat("###,###.##", symbols);
        System.out.println("$" + df.format(value));
        System.out.println("$" + NumberFormat.getNumberInstance(new Locale.Builder().setLanguage("en").setRegion("US").build()).format(value));
    }
}
