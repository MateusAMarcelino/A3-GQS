/*
 * Classe DAO (Data Access Object) responsável por fornecer informações
 * sobre o sistema. Neste caso, os dados são simulados e não vêm de um banco.
 */

package dao;

import modelo.Sobre;

public class SobreDAO {

    /**
     * Construtor que recebe informações sobre o sistema.
     * Não está implementado, provavelmente deixado por engano.
     * @param sistema_de_Biblioteca Nome do sistema.
     * @param string Versão do sistema.
     * @param seu_Nome_Aqui Nome do(s) desenvolvedor(es).
     * @param sistema_desenvolvido_para_gerenciar_cadas Descrição do sistema.
     */
    public SobreDAO(String sistema_de_Biblioteca, String string, String seu_Nome_Aqui, String sistema_desenvolvido_para_gerenciar_cadas) {
        // Construtor não implementado. Pode ser removido ou finalizado futuramente.
    }

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
            "Desenvolvido por Mateus, Guilherme, Pedro e Lorenzo", // Autores
            "Sistema desenvolvido para gerenciar cadastros e empréstimos de ferramentas." // Descrição
        );
    }
}
