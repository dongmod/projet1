/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.validator;

import Com.ITsolution.gescom.Bean.Session;
import Com.ITsolution.gescom.EJB.ArticleFacadeLocal;
import Com.ITsolution.gescom.EJB.ArtstockFacadeLocal;
import Com.ITsolution.gescom.Exception.DAOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author SERGE
 */
@ManagedBean
@RequestScoped
public class ArticleExiste implements Validator {

    @EJB
    private ArticleFacadeLocal articleFacade;

   
    
 private static final String AGENCE_EXISTE_DEJA = "Cette reference  existe déjà ";
    
    
    
    public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException {
            /* Récupération de la valeur à traiter depuis le paramètre
            value */
          String ref = (String) value;
          String login = Session.renvoirSession().toString();
        try {
            if ( articleFacade.trouver( ref,login ) != null ) {
                /*
                * Si une adresse est retournée, alors on envoie une exception
                * propre à JSF, qu'on initialise avec un FacesMessage de
                * gravité "Erreur" et contenant le message d'explication. Le
                * framework va alors gérer lui-même cette exception et s'en
                * servir pour afficher le message d'erreur à l'utilisateur.
                */
            throw new ValidatorException(
        new FacesMessage(FacesMessage.SEVERITY_ERROR, AGENCE_EXISTE_DEJA, null ) );
    }
        } catch ( DAOException e ) {
                /*
                * En cas d'erreur imprévue émanant de la BDD, on prépare un message
                * d'erreur contenant l'exception retournée, pour l'afficher à
                * l'utilisateur ensuite.
                */
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null );
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage( component.getClientId(facesContext ), message );
            }
        }
    }

