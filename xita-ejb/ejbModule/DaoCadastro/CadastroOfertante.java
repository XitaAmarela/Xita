package DaoCadastro;

import java.util.List;

import Model.Ofertante;

public interface CadastroOfertante {
	public Ofertante cadastrarOfertante(Ofertante ofertante);
	public List<Ofertante> listarOfertante();
	public void removerOfertante(Ofertante ofertante);
	public void removerOfertante(Long id);
}
