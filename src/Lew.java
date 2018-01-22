
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


class Lew {
    double kasa, kurs;
   void przeliczNaLewy() throws IOException{
        try{
            
        Connection connect = Jsoup.connect("https://internetowykantor.pl/kurs-lewa-bulgarskiego/");
        Document document = connect.get();
        Elements kurspobrany = document.select("span.kurs.kurs_sprzedazy");
        String kursformatowany = kurspobrany.text().replace(",", ".");
        kurs = Double.parseDouble(kursformatowany);
            
JOptionPane.showMessageDialog (null,"Kurs lewa wynosi: " + kurs, "Stawka kursu", JOptionPane.INFORMATION_MESSAGE);
kasa = Double.parseDouble(JOptionPane.showInputDialog (null,"Podaj ile masz złotych:", "Wprowadź dane", JOptionPane.QUESTION_MESSAGE));
if (kasa != 0){
double wynik=kasa/kurs;
wynik *= 100;                 //Można też zaokrąglić tak: String swynik = String.format("%.2f", wynik);
wynik = Math.round(wynik);   //Ale wynik będzie wtedy ze znakiem "," a nie z "."
wynik /= 100;                   
JOptionPane.showMessageDialog (null,"To jest: " + wynik + " lewów", "Wynik", JOptionPane.INFORMATION_MESSAGE);
String komunikat1 = "Po przewalutowaniu, bedziesz miał: " + wynik + " lewów";
String komunikat2 ="Masz: " + kasa + " złotych \nStawka kursu wynosi: " + kurs +
        "\nPo przewalutowaniu, bedziesz miał: " + wynik + " lewów";
System.out.println(komunikat1);
        int odp = JOptionPane.showConfirmDialog(null, "Czy chcesz zapisać informacje o konwertacji do pliku ?"
                + " \n(Jeśli tak - do wymyślonej nazwy pliku dodaj końcówkę '.txt')",
                "Potwierdź", JOptionPane.YES_NO_OPTION);
        if (odp == JOptionPane.YES_OPTION)
        {
            JFileChooser file = new JFileChooser();
            if (file.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                File plik = file.getSelectedFile();
                try
                {
                    PrintWriter print = new PrintWriter(plik);
                    Scanner skaner = new Scanner(komunikat2);
                    while (skaner.hasNext())
                            print.println(skaner.nextLine() + "\n");
                    print.close();
                    JOptionPane.showMessageDialog(null, "Poprawnie zapisano plik ! \nW miejsccu: " + plik, "Potwierdzenie", JOptionPane.INFORMATION_MESSAGE);
                } 
                catch (FileNotFoundException ex)
                {
                    Logger.getLogger(Lew.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if (odp == JOptionPane.NO_OPTION){}
} 
else {
    ObsługaBłędów błądzero = new ObsługaBłędów();
    błądzero.błądzero();
}
        } catch (NumberFormatException ime) {
        //ime.printStackTrace();
        ObsługaBłędów błąddanych = new ObsługaBłędów();
        błąddanych.błąddanych();
        }

    }
   void przeliczNaZł() throws IOException{
        try{
            
        Connection connect = Jsoup.connect("https://internetowykantor.pl/kurs-lewa-bulgarskiego/");
        Document document = connect.get();
        Elements kurspobrany = document.select("span.kurs.kurs_kupna");
        String kursformatowany = kurspobrany.text().replace(",", ".");
        kurs = Double.parseDouble(kursformatowany);
            
JOptionPane.showMessageDialog (null,"Kurs lewa wynosi " + kurs, "Stawka kursu", JOptionPane.INFORMATION_MESSAGE);
kasa = Double.parseDouble(JOptionPane.showInputDialog (null,"Podaj ile masz lewów:", "Wprowadź dane", JOptionPane.QUESTION_MESSAGE));
if (kasa != 0){
double wynik=kasa*kurs;
wynik *= 100;                 //Można też zaokrąglić tak: String swynik = String.format("%.2f", wynik);
wynik = Math.round(wynik);   //Ale wynik będzie wtedy ze znakiem "," a nie z "."
wynik /= 100;                   
JOptionPane.showMessageDialog (null,"To jest " + wynik + " złotych", "Wynik", JOptionPane.INFORMATION_MESSAGE);
String komunikat1 = "Po przewalutowaniu, bedziesz miał: " + wynik + " złotych";
String komunikat2 ="Masz: " + kasa + " lewów \nStawka kursu wynosi: " + kurs +
        "\nPo przewalutowaniu, bedziesz miał: " + wynik + " złotych";
System.out.println(komunikat1);
        int odp = JOptionPane.showConfirmDialog(null, "Czy chcesz zapisać informacje o konwertacji do pliku ?"
                + " \n(Jeśli tak - do wymyślonej nazwy pliku dodaj końcówkę '.txt')",
                "Potwierdź", JOptionPane.YES_NO_OPTION);
        if (odp == JOptionPane.YES_OPTION)
        {
            JFileChooser file = new JFileChooser();
            if (file.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                File plik = file.getSelectedFile();
                try
                {
                    PrintWriter print = new PrintWriter(plik);
                    Scanner skaner = new Scanner(komunikat2);
                    while (skaner.hasNext())
                            print.println(skaner.nextLine() + "\n");
                    print.close();
                    JOptionPane.showMessageDialog(null, "Poprawnie zapisano plik ! \nW miejsccu: " + plik, "Potwierdzenie", JOptionPane.INFORMATION_MESSAGE);
                } 
                catch (FileNotFoundException ex)
                {
                    Logger.getLogger(Lew.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if (odp == JOptionPane.NO_OPTION){}
} 
else {
    ObsługaBłędów błądzero = new ObsługaBłędów();
    błądzero.błądzero();
}
        } catch (NumberFormatException ime) {
        //ime.printStackTrace();
        ObsługaBłędów błąddanych = new ObsługaBłędów();
        błąddanych.błąddanych();
        }
    }
}
