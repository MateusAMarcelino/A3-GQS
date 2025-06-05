package dao;

import modelo.Sobre;

public class SobreDAO {

    public SobreDAO() {
        // Construtor funcionando normalmente
    }

    public Sobre getInformacoesSobre() {
        return new Sobre(
                "Sistema de Empréstimos",
                "2.0",
                "Desenvolvido por Matheus, Guilherme, Pedro e Lorenzo",
                "Sistema desenvolvido para gerenciar cadastros e empréstimos de ferramentas."
        );
    }
}
