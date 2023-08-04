package recursos;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class FiltroTextField extends DocumentFilter{

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        // Permitir números y el punto decimal
        if (string.matches("\\d*\\.?\\d*")) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        // Permitir números y el punto decimal
        if (text.matches("\\d*\\.?\\d*")) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
    
}
