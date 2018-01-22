
import javax.swing.JOptionPane;


class ObsługaBłędów {
    void błądzero () {
        JOptionPane.showMessageDialog (null,"Nie masz kasy ?!", "Błąd", JOptionPane.ERROR_MESSAGE);
    }
    void błąddanych () {
        JOptionPane.showMessageDialog (null,"Błędne dane !", "Błąd", JOptionPane.ERROR_MESSAGE);   
    }
}
