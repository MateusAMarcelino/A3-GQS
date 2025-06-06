package visao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FrmMenuPrincipalTest {

    @Test
    void testIsEmTesteFalse() {
        // Como "modoTeste" não está definido, deve ser false
        FrmMenuPrincipal frm = new FrmMenuPrincipal();
        assertFalse(frm.isEmTeste());
    }

    @Test
    void testIsEmTesteTrue() {
        System.setProperty("modoTeste", "true");
        FrmMenuPrincipal frm = new FrmMenuPrincipal();
        assertTrue(frm.isEmTeste());
    }

    @Test
    void testEncerrarAplicacaoFoiChamadoFake() {
        FrmMenuPrincipalFake fakeFrm = new FrmMenuPrincipalFake();
        fakeFrm.encerrarAplicacao();
        assertTrue(fakeFrm.isEncerrarChamado());
    }
}
