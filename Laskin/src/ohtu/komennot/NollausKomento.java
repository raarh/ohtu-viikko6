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
public class NollausKomento extends Komento{
    public NollausKomento(Sovelluslogiikka s,JTextField tuloskentta,JTextField syottokentta){
       super(s,tuloskentta,syottokentta);
    }
    
     @Override
    public void suorita() {
        super.suorita();
        sovelluslogiikka.nollaa();
        super.paivitaKentat();

    }
    @Override
    public void peru(){
        this.sovelluslogiikka.plus(super.arvo);
        super.paivitaKentat();
    }
}

    
