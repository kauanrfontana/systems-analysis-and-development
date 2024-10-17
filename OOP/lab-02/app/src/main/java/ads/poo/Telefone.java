
package ads.poo;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class Telefone {
    private String rotulo;
    private String valor;

    public Telefone(String rotulo, String valor) {
        this.rotulo = rotulo;
        this.valor = valor;
    }


    public String toString() {
        return String.format("%s: %s", this.rotulo, formatPhone(this.valor));
    }

    private String formatPhone(String valor) {
        MaskFormatter mask = null;
        String result = "";
       
        try {
            mask = new MaskFormatter("*## (##) # ####-####");
            mask.setValueContainsLiteralCharacters(false);
            mask.setPlaceholderCharacter('_');
            result = mask.valueToString(valor);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return result;
    }
}
