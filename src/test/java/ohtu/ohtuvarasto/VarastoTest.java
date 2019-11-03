package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void toStringToimii() {
        String merkkijono = varasto.toString();
        assertEquals("saldo = 0.0, vielä tilaa 10.0", merkkijono);
    }
    
    @Test
    public void negatiivinenLisaaminenEiOnnistu() {
        varasto.lisaaVarastoon(-100);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenOttaminenEiOnnistu() {
        varasto.otaVarastosta(-100);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
   
    @Test
    public void varastoonLaitetaanLiikaaToimii() {
        varasto.lisaaVarastoon(20);
        // pitäisi olla saldoa tilavuuden verran 10, ylimäärä poistuu
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void varastostaOtetaanLiikaaToimii() {
        varasto.lisaaVarastoon(10);
        double saatu = varasto.otaVarastosta(20);
        // pitäisi palauttaa vain saldon verran eli 10
        assertEquals(10, saatu, vertailuTarkkuus);
    }
    
    @Test
    public void tyhjaVarastoEiTilavuutta() {
        Varasto tyhjaVarasto = new Varasto(0.0);
        assertEquals(0, tyhjaVarasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriKahdellaParametrillaTilavuusOikein() {
        Varasto uusiVarasto = new Varasto(50, 0);
        assertEquals(50, uusiVarasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriKahdellaParametrillaSaldoOikein() {
        Varasto uusiVarasto = new Varasto(50, 10);
        assertEquals(10, uusiVarasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriKahdellaParametrillaTyhjaVarasto() {
        Varasto uusiVarasto = new Varasto(0, 0);
        assertEquals(0, uusiVarasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriKahdellaParametrillaSaldoYliTilavuus() {
        Varasto uusiVarasto = new Varasto(10, 20);
        // saldon pitäisi olla vain asetetun tilavuuden verran
        assertEquals(10, uusiVarasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriKahdellaParametrillaNegSaldoNolla() {
        Varasto uusiVarasto = new Varasto(10, -50);
        // saldon pitäisi olla nyt vain nolla
        assertEquals(0, uusiVarasto.getSaldo(), vertailuTarkkuus);
    }
    
    //muutos
    
   
}