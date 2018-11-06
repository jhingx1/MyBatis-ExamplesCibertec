package web.managedbean;


import dao.impl.DaoTutorialesImpl;
import dto.Tutoriales;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import mybatis.mapper.TutorialesMapper;
import parainfo.convert.DeString;

@ManagedBean(name = "mbTutoriales")
@RequestScoped
public class ManagedBeanTutoriales {

    private List<Tutoriales> list;
    private Tutoriales tutoriales = new Tutoriales();
    TutorialesMapper tutorialesMapper = new DaoTutorialesImpl();

    private String message;
    private String ids;
    
    private Integer mensaje;

    public ManagedBeanTutoriales() {

    }

    // gettter y setter
    public List<Tutoriales> getList() {
        list = tutorialesMapper.tutorialesQry();

        return list;
    }

    public Tutoriales getTutoriales() {
        return tutoriales;
    }

    public void setTutoriales(Tutoriales tutoriales) {
        this.tutoriales = tutoriales;
    }

    public String getMessage() {
        return message;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    // gestion
    public String tutorialesIns() {
         tutorialesMapper.tutorialesIns(tutoriales);

        if (message == null) {
            return "/index?faces-redirect=true";
        } else {
            return "/tutorialesIns";
        }
    }

    public String tutorialesDel() {
        List<Integer> list_ids = DeString.ids(ids);
        
        if (list_ids != null) {
            
            tutorialesMapper.tutorialesDel(ids); 

            //mensaje es de tipo String
        } else {
            //message = "IDs Incorrectos o no envíados";
        }

        return "/index";
    }

    public String tutorialesGet() {
        tutoriales = tutorialesMapper.tutorialesGet(tutoriales.getIdtutorial());

        if (tutoriales != null) {
            return "/tutorialesUpd";
        } else {
            //message = tutorialesMapper.getMessage();
            return "/index";
        }
    }

    public String tutorialesUpd() {
        mensaje = tutorialesMapper.tutorialesUpd(tutoriales);

        if (mensaje == 1) {
            return "/index?faces-redirect=true";
        } else {
            return "/tutorialesUpd";
        }
    }
}

