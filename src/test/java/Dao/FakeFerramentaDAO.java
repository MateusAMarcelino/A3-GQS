package modelo;

import java.util.*;

public class FakeFerramentaDAO extends dao.FerramentaDAO {
    private Map<Integer, Ferramenta> bancoSimulado = new HashMap<>();

    @Override
    public boolean InsertFerramentaDB(Ferramenta ferramenta) {
        bancoSimulado.put(ferramenta.getIdFerramentas(), ferramenta);
        return true;
    }

    @Override
    public Ferramenta RecuperaFerramentaDB(int id) {
        return bancoSimulado.getOrDefault(id, new Ferramenta(0, null, null, 0));
    }

    @Override
    public boolean UpdateFerramentaDB(Ferramenta ferramenta) {
        if (bancoSimulado.containsKey(ferramenta.getIdFerramentas())) {
            bancoSimulado.put(ferramenta.getIdFerramentas(), ferramenta);
            return true;
        }
        return false;
    }

    @Override
    public boolean DeleteFerramentaDB(int id) {
        return bancoSimulado.remove(id) != null;
    }

    @Override
    public int MaiorIdFerramentas() {
        return bancoSimulado.keySet().stream().max(Integer::compareTo).orElse(0);
    }

    // CalcularSoma já é estático, então não precisa mudar
}
