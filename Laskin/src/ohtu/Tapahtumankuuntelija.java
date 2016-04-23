package ohtu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import ohtu.komennot.*;

 
public class Tapahtumankuuntelija implements ActionListener {
    //private JButton plus;
    //private JButton miinus;
    private JButton nollaa;
    private JButton undo;
    //private JTextField tuloskentta;
    //private JTextField syotekentta;
    private Sovelluslogiikka sovellus;
    HashMap<Object,Komento> komennot;
    LinkedList<Komento> edellinen;
    
    
    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = new Sovelluslogiikka();
        //this.plus = plus;
        //this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;
        //this.tuloskentta = tuloskentta;
        //this.syotekentta = syotekentta;
        this.komennot = new HashMap<>();
        this.komennot.put(plus,new PlusKomento(sovellus,tuloskentta,syotekentta));
        this.komennot.put(miinus,new MiinusKomento(sovellus,tuloskentta,syotekentta));
        this.komennot.put(nollaa,new NollausKomento(sovellus,tuloskentta,syotekentta));
        this.edellinen = new LinkedList<>();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {

        Komento komento = komennot.get(ae.getSource());
        
        if(komento != null){
            komento.suorita();
            edellinen.push(komento);
        }else {
            Komento peruttava = edellinen.pop();
            System.out.println(peruttava.getClass().toString());
            peruttava.peru();
        }

        nollaa.setEnabled(sovellus.tulos()!=0);
        undo.setEnabled(edellinen.size() > 0);

    }
 
}