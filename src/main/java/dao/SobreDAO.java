/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import modelo.Sobre;

public class SobreDAO {

    public SobreDAO(String sistema_de_Biblioteca, String string, String seu_Nome_Aqui, String sistema_desenvolvido_para_gerenciar_cadas) {
    }

    public SobreDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Sobre getInformacoesSobre() {
        // Aqui simula acesso a dados.
        return new Sobre(
                "Sistema de Empréstimos",
                "2.0",
                "Desenvolvido por Matheus, Guilherme, Pedro e Lorenzo",
                "Sistema desenvolvido para gerenciar cadastros e empréstimos de ferramentas."
        );
    }
}
