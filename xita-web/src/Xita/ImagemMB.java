package Xita;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import Dao.ImagemProdutoDAO;
import Model.ImagemProduto;


@ManagedBean
public class ImagemMB {
	@EJB
	private ImagemProdutoDAO cadastroFoto;
	
	public StreamedContent getImage() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
			String fotoId = context.getExternalContext().getRequestParameterMap().get("fotoId");
			if (fotoId.equals("")) {
				return null;
			}
			ImagemProduto f = cadastroFoto.buscarPorId(new Long(fotoId));
			return new DefaultStreamedContent(new ByteArrayInputStream(f.getContent()), f.getTipo());
		}
	}


}