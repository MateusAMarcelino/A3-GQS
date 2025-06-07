package visao;

import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TesteFrmMenuPrincipal {

    @Test
    void testMenuItemCadastroDeFerramentasActionPerformed() throws Exception {
        //Criação da janela
        JFrame frame = new FrmMenuPrincipal();
        frame.setVisible(true);
        frame.setSize(400, 300);

        JMenuBar menuBar = frame.getJMenuBar();
        assertNotNull(menuBar, "A JMenuBar deve existir no MenuPrincipal");

        JMenuItem itemCadastrar = null;

        //Percorre os menus dos itens em JMenuBar
        for (int i = 0; i < menuBar.getMenuCount(); i++) {
            JMenu menu = menuBar.getMenu(i);
            if (menu == null) {
                continue;
            }

            for (int j = 0; j < menu.getItemCount(); j++) {
                JMenuItem item = menu.getItem(j);
                if (item != null && "Cadastro De Ferramentas".equalsIgnoreCase(item.getText())) {
                    itemCadastrar = item;
                    break;
                }
            }
            if (itemCadastrar != null) {
                break;
            }
        }

        assertNotNull(itemCadastrar, "O item 'Cadastro De Ferramentas' deve estar presente na MenuBar.");

        //Simulação do clique
        itemCadastrar.doClick();

        //Verifica se FrmGerenciarAmigo foi aberto
        boolean encontrou = false;
        for (Window w : Window.getWindows()) {
            if (w instanceof FrmCadastrarFerramenta && w.isVisible()) {
                encontrou = true;
                break;
            }
        }

        assertTrue(encontrou, "A janela FrmCadastrarFerramenta deve estar visivel.");
    }
    
        @Test
    void testMenuItemCadastroDeAmigosActionPerformed() throws Exception {
        //Criação da janela
        JFrame frame = new FrmMenuPrincipal();
        frame.setVisible(true);
        frame.setSize(400, 300);

        JMenuBar menuBar = frame.getJMenuBar();
        assertNotNull(menuBar, "A JMenuBar deve existir no MenuPrincipal");

        JMenuItem itemCadastrar = null;

        //Percorre os menus dos itens em JMenuBar
        for (int i = 0; i < menuBar.getMenuCount(); i++) {
            JMenu menu = menuBar.getMenu(i);
            if (menu == null) {
                continue;
            }

            for (int j = 0; j < menu.getItemCount(); j++) {
                JMenuItem item = menu.getItem(j);
                if (item != null && "Cadastro De Amigos".equalsIgnoreCase(item.getText())) {
                    itemCadastrar = item;
                    break;
                }
            }
            if (itemCadastrar != null) {
                break;
            }
        }

        assertNotNull(itemCadastrar, "O item 'Cadastro De Amigos' deve estar presente na MenuBar.");

        //Simulação do clique
        itemCadastrar.doClick();

        //Verifica se FrmGerenciarAmigo foi aberto
        boolean encontrou = false;
        for (Window w : Window.getWindows()) {
            if (w instanceof FrmCadastrarAmigo && w.isVisible()) {
                encontrou = true;
                break;
            }
        }

        assertTrue(encontrou, "A janela FrmCadastrarAmigo deve estar visivel.");
    }
    

    @Test
    void testMenuItemEmprestimoDeFerramentasActionPerformed() throws Exception {
        //Criação da janela
        JFrame frame = new FrmMenuPrincipal();
        frame.setVisible(true);
        frame.setSize(400, 300);

        JMenuBar menuBar = frame.getJMenuBar();
        assertNotNull(menuBar, "A JMenuBar deve existir no MenuPrincipal");

        JMenuItem itemEmprestimos = null;

        //Percorre os menus dos itens em JMenuBar
        for (int i = 0; i < menuBar.getMenuCount(); i++) {
            JMenu menu = menuBar.getMenu(i);
            if (menu == null) {
                continue;
            }

            for (int j = 0; j < menu.getItemCount(); j++) {
                JMenuItem item = menu.getItem(j);
                if (item != null && "Emprestimo De Ferramentas".equalsIgnoreCase(item.getText())) {
                    itemEmprestimos = item;
                    break;
                }
            }
            if (itemEmprestimos != null) {
                break;
            }
        }

        assertNotNull(itemEmprestimos, "O item 'Emprestimo De Ferramentas' deve estar presente na MenuBar.");

        //Simulação do clique
        itemEmprestimos.doClick();

        //Verifica se FrmGerenciarAmigo foi aberto
        boolean encontrou = false;
        for (Window w : Window.getWindows()) {
            if (w instanceof FrmEmprestimoDeFerramentas && w.isVisible()) {
                encontrou = true;
                break;
            }
        }

        assertTrue(encontrou, "A janela FrmEmprestimoDeFerramentas deve estar visivel.");
    }

    @Test
    void testMenuItemDevolverFerramentasActionPerformed() throws Exception {
        //Criação da janela
        JFrame frame = new FrmMenuPrincipal();
        frame.setVisible(true);
        frame.setSize(400, 300);

        JMenuBar menuBar = frame.getJMenuBar();
        assertNotNull(menuBar, "A JMenuBar deve existir no MenuPrincipal");

        JMenuItem itemEmprestimos = null;

        //Percorre os menus dos itens em JMenuBar
        for (int i = 0; i < menuBar.getMenuCount(); i++) {
            JMenu menu = menuBar.getMenu(i);
            if (menu == null) {
                continue;
            }

            for (int j = 0; j < menu.getItemCount(); j++) {
                JMenuItem item = menu.getItem(j);
                if (item != null && "Devolver Ferramentas".equalsIgnoreCase(item.getText())) {
                    itemEmprestimos = item;
                    break;
                }
            }
            if (itemEmprestimos != null) {
                break;
            }
        }

        assertNotNull(itemEmprestimos, "O item 'Devolver Ferramentas' deve estar presente na MenuBar.");

        //Simulação do clique
        itemEmprestimos.doClick();

        //Verifica se FrmGerenciarAmigo foi aberto
        boolean encontrou = false;
        for (Window w : Window.getWindows()) {
            if (w instanceof FrmDevolverFerramentas && w.isVisible()) {
                encontrou = true;
                break;
            }
        }

        assertTrue(encontrou, "A janela FrmDevolverFerramentas deve estar visivel.");
    }

    @Test
    void testMenuItemGerenciadorDeAmigosActionPerformed() throws Exception {
        //Criação da janela
        JFrame frame = new FrmMenuPrincipal();
        frame.setVisible(true);
        frame.setSize(400, 300);

        JMenuBar menuBar = frame.getJMenuBar();
        assertNotNull(menuBar, "A JMenuBar deve existir no MenuPrincipal");

        JMenuItem itemGerenciar = null;

        //Percorre os menus dos itens em JMenuBar
        for (int i = 0; i < menuBar.getMenuCount(); i++) {
            JMenu menu = menuBar.getMenu(i);
            if (menu == null) {
                continue;
            }

            for (int j = 0; j < menu.getItemCount(); j++) {
                JMenuItem item = menu.getItem(j);
                if (item != null && "Gerenciador de Amigos".equalsIgnoreCase(item.getText())) {
                    itemGerenciar = item;
                    break;
                }
            }
            if (itemGerenciar != null) {
                break;
            }
        }

        assertNotNull(itemGerenciar, "O item 'Gerenciador de Amigos' deve estar presente na MenuBar.");

        //Simulação do clique
        itemGerenciar.doClick();

        //Verifica se FrmGerenciarAmigo foi aberto
        boolean encontrou = false;
        for (Window w : Window.getWindows()) {
            if (w instanceof FrmGerenciadorAmigo && w.isVisible()) {
                encontrou = true;
                break;
            }
        }

        assertTrue(encontrou, "A janela FrmGerenciadorAmigo deve estar visivel.");
    }

    @Test
    void testMenuItemGerenciamentoDeFerramentasActionPerformed() throws Exception {
        //Criação da janela
        JFrame frame = new FrmMenuPrincipal();
        frame.setVisible(true);
        frame.setSize(400, 300);

        JMenuBar menuBar = frame.getJMenuBar();
        assertNotNull(menuBar, "A JMenuBar deve existir no MenuPrincipal");

        JMenuItem itemGerenciar = null;

        //Percorre os menus dos itens em JMenuBar
        for (int i = 0; i < menuBar.getMenuCount(); i++) {
            JMenu menu = menuBar.getMenu(i);
            if (menu == null) {
                continue;
            }

            for (int j = 0; j < menu.getItemCount(); j++) {
                JMenuItem item = menu.getItem(j);
                if (item != null && "Gerenciamento De Ferramentas".equalsIgnoreCase(item.getText())) {
                    itemGerenciar = item;
                    break;
                }
            }
            if (itemGerenciar != null) {
                break;
            }
        }

        assertNotNull(itemGerenciar, "O item 'Gerenciamento De Ferramentas' deve estar presente na MenuBar.");

        //Simulação do clique
        itemGerenciar.doClick();

        //Verifica se FrmGerenciarAmigo foi aberto
        boolean encontrou = false;
        for (Window w : Window.getWindows()) {
            if (w instanceof FrmGerenciadorAmigo && w.isVisible()) {
                encontrou = true;
                break;
            }
        }

        assertTrue(encontrou, "A janela FrmGerenciamentoDeFerramentas deve estar visivel.");
    }

    @Test
    void testMenuItemGerenciarEmprestimosActionPerformed() throws Exception {
        //Criação da janela
        JFrame frame = new FrmMenuPrincipal();
        frame.setVisible(true);
        frame.setSize(400, 300);

        JMenuBar menuBar = frame.getJMenuBar();
        assertNotNull(menuBar, "A JMenuBar deve existir no MenuPrincipal");

        JMenuItem itemGerenciar = null;

        //Percorre os menus dos itens em JMenuBar
        for (int i = 0; i < menuBar.getMenuCount(); i++) {
            JMenu menu = menuBar.getMenu(i);
            if (menu == null) {
                continue;
            }

            for (int j = 0; j < menu.getItemCount(); j++) {
                JMenuItem item = menu.getItem(j);
                if (item != null && "Gerenciar Emprestimos".equalsIgnoreCase(item.getText())) {
                    itemGerenciar = item;
                    break;
                }
            }
            if (itemGerenciar != null) {
                break;
            }
        }

        assertNotNull(itemGerenciar, "O item 'Gerenciar Emprestimos' deve estar presente na MenuBar.");

        //Simulação do clique
        itemGerenciar.doClick();

        //Verifica se FrmGerenciarAmigo foi aberto
        boolean encontrou = false;
        for (Window w : Window.getWindows()) {
            if (w instanceof FrmRelatorioEmprestimo && w.isVisible()) {
                encontrou = true;
                break;
            }
        }

        assertTrue(encontrou, "A janela FrmRelatorioEmprestimo deve estar visivel.");
    }

}
