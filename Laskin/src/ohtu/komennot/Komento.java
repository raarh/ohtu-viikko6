/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author arto
 */
public abstract class Komento {
    protected Sovelluslogiikka sovelluslogiikka;
    protected JTextField tuloskentta;
    protected JTextField syottokentta;
    protected int arvo;
    public Komento(Sovelluslogiikka s,JTextField tuloskentta,JTextField syottokentta){
        this.sovelluslogiikka = s;
        this.tuloskentta = tuloskentta;
        this.syottokentta = syottokentta;
    }
    private void processSyote(){
        int arvo = 0;
 
        try {
            arvo = Integer.parseInt(this.syottokentta.getText());
        } catch (Exception e) {
            return;
        }
        this.arvo = arvo;
    }
    protected void paivitaKentat(){
        int laskunTulos = sovelluslogiikka.tulos();
         
        syottokentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }
    public void suorita(){
       this.processSyote();
    }
    public abstract void peru();
}
