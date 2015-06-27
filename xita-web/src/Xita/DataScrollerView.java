package Xita;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
 
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DataScrollerView implements Serializable {
     
    private List<Produtos> cars;
         
    @ManagedProperty("#{carService}")
    private ProdutoService service;
     
    @PostConstruct
    public void init() {
        cars = service.createCars(5);
    }
 
    public List<Produtos> getCars() {
        return cars;
    }
 
    public void setService(ProdutoService service) {
        this.service = service;
    }
}
