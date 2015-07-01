package Xita;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
@ManagedBean
@ViewScoped
public class UploadMB implements Serializable {
	private static final long serialVersionUID = 1616539422376403150L;
	private UploadedFile arquivo;
	private ImagemMB imagemMB  = new ImagemMB();
	
	public void handleFileUpload(FileUploadEvent event) {
        this.arquivo = event.getFile();
    }
	
	public UploadedFile getArquivo() {
		UploadedFile arquivoAux = arquivo;
		arquivo = null;
		return arquivoAux;
	}
	public void setArquivo(UploadedFile arquivo) throws IOException {
		this.getImage();
		this.arquivo = arquivo;
	}
	public StreamedContent getImage() throws IOException{
		return imagemMB.getImage();
	}
}