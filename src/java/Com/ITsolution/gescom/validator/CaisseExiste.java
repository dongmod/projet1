/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.validator;

import Com.ITsolution.gescom.Bean.Session;
import Com.ITsolution.gescom.EJB.AgenceFacadeLocal;
import Com.ITsolution.gescom.EJB.CaisseFacadeLocal;
import Com.ITsolution.gescom.Exception.DAOException;
import Com.ITsolution.gescom.JPA.Agence;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
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
 * @author TONLIO
 */
@ManagedBean
@RequestScoped
public class CaisseExiste  implements Validator {

    @EJB
    private AgenceFacadeLocal agenceFacade;

    @EJB
    private CaisseFacadeLocal caisseFacade;
    
    
   private static final String CAISSE_CREER = "cette caisse existe deja dans cette agence ";
   

    
    
    
    
    public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException {
            /* Récupération de la valeur à traiter depuis le paramètre
            value */
          
          String libelle=(String) value; 
          String userc=Session.renvoirSession().toString();
         
         
//         Logger.getGlobal().info(libelle);
//         Logger.getGlobal().info(userc);
//         Logger.getGlobal().info(nom_agence);
        try {
            if ( caisseFacade.trouver( userc,libelle ) != null ) {
                /*
                * Si une adresse est retournée, alors on envoie une exception
                * propre à JSF, qu'on initialise avec un FacesMessage de
                * gravité "Erreur" et contenant le message d'explication. Le
                * framework va alors gérer lui-même cette exception et s'en
                * servir pour afficher le message d'erreur à l'utilisateur.
                */
            throw new ValidatorException(
        new FacesMessage(FacesMessage.SEVERITY_ERROR, CAISSE_CREER, null ) );
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

