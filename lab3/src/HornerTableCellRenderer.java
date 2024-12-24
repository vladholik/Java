package src;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class HornerTableCellRenderer implements TableCellRenderer {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private boolean needle = false;
    private DecimalFormat formatter =
            (DecimalFormat) NumberFormat.getInstance();

    public HornerTableCellRenderer() {
        formatter.setMaximumFractionDigits(10);
        formatter.setGroupingUsed(false);
        DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);

        panel.add(label);

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    public Component getTableCellRendererComponent(JTable table,
                                                   Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        String formattedDouble = formatter.format(value);

        label.setText(formattedDouble);
        if (needle) {
            double actual_value = Double.parseDouble(formattedDouble);
            long closet_int_value = Math.round(actual_value);
            if (isPrime(Math.abs(closet_int_value)) &&
                Math.abs(actual_value - closet_int_value) < 0.1){
                panel.setBackground(Color.GREEN);
            }
            
            else {
                panel.setBackground(Color.WHITE);
            }
        }

        if (value instanceof Double) {
            double number = Double.parseDouble(formattedDouble);
            FlowLayout alignment;
            if (number > 0) {
                alignment = new FlowLayout(FlowLayout.RIGHT);
            }
            else
            if (number < 0){
                alignment = new FlowLayout(FlowLayout.LEFT);
            }
            else{
                alignment = new FlowLayout(FlowLayout.CENTER);
            }

            panel.setLayout(alignment);
        }
        return panel;
    }

    public void setNeedle(boolean needle) {
        this.needle = needle;
    }

    private boolean isPrime(long x) {

        if (x == 0 || x == 1) {
            return false;
        }

        for (long i = 2; i <= (long) Math.round(Math.sqrt(x)); i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}
