/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.komennot;

import javax.swing.JButton;
import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author arto
 */
public class PlusKomento extends Komento{
    public PlusKomento(Sovelluslogiikka s,JTextField tuloskentta, JTextField syottokentta){
       super(s,tuloskentta,syottokentta);
    }
    
    @Override
    public void suorita() {
        super.suorita();
        sovelluslogiikka.plus(super.arvo);
        super.paivitaKentat();

    }
    @Override
    public void peru(){
        sovelluslogiikka.miinus(super.arvo);
        super.paivitaKentat();
    }
    
}
