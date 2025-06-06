package visao;

public class FrmMenuPrincipalFake extends FrmMenuPrincipal {

    private boolean encerrarChamado = false;

    @Override
    protected void encerrarAplicacao() {
        // Simula a chamada sem encerrar a aplicação
        encerrarChamado = true;
    }

    public boolean isEncerrarChamado() {
        return encerrarChamado;
    }
}