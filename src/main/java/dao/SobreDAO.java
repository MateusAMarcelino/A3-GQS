/*
 * Classe DAO (Data Access Object) responsável por fornecer informações
 * sobre o sistema. Neste caso, os dados são simulados e não vêm de um banco.
 */

package dao;

import modelo.Sobre;

public class SobreDAO {

    /**
     * Construtor padrão da classe.
     * Atualmente lança uma exceção indicando que ainda não é suportado.
     */
    public SobreDAO() {
        throw new UnsupportedOperationException("Not supported yet."); 
        // Exceção gerada automaticamente por template; necessário implementar.
    }

    /**
     * Método que retorna as informações sobre o sistema.
     * Simula o acesso aos dados, retornando um objeto Sobre preenchido com dados fixos.
     * @return Objeto da classe Sobre com nome, versão, autores e descrição do sistema.
     */
    public Sobre getInformacoesSobre() {
        return new Sobre(
            "Sistema de Empréstimos",                      // Nome do sistema
            "2.0",                                          // Versão do sistema
            "Desenvolvido por Matheus, Guilherme, Pedro e Lorenzo", // Autores
            "Sistema desenvolvido para gerenciar cadastros e empréstimos de ferramentas." // Descrição
        );
    }
}
