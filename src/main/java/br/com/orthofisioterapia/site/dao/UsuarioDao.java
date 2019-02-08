package br.com.orthofisioterapia.site.dao;

import br.com.orthofisioterapia.site.domain.TipoSexo;
import br.com.orthofisioterapia.site.domain.Usuario;

import java.util.List;

public interface UsuarioDao {

	void salvar(Usuario usuario);
	
	void editar(Usuario usuario);
	
	void excluir(Long id);
	
	Usuario getId(Long id);
	
	List<Usuario> getTodos();

	List<Usuario> getBySexo(TipoSexo sexo);

	List<Usuario> getByNome(String nome);
}
