/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDInterface;

import ResPwAEntities.*;
import ResPwAEntities.Controllers.*;
import ResPwAEntities.EmotionalEntities.EmotionAxisConf;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

/**
 *
 * @author juans
 */
public class RESPwABDInterface {

    private static final String EMF = "ResPwAEntitiesPU";

    public static PerfilPwa getProfile(String cedula) {
        PerfilPwaJpaController pjc = new PerfilPwaJpaController(Persistence.createEntityManagerFactory(EMF));
        return pjc.findPerfilPwa(cedula);
    }

    public static void updateProfile(PerfilPwa PerfilPwa) {
        try {
            PerfilPwaJpaController pjc = new PerfilPwaJpaController(Persistence.createEntityManagerFactory(EMF));
            pjc.edit(PerfilPwa);
        } catch (Exception ex) {
            Logger.getLogger(RESPwABDInterface.class.getName()).log(Level.SEVERE, null, ex);
        
    }}

    public static void createProfile(PerfilPwa p) {
        try {
            PerfilPwaJpaController pjc = new PerfilPwaJpaController(Persistence.createEntityManagerFactory(EMF));
            pjc.create(p);
        } catch (Exception ex) {
            Logger.getLogger(RESPwABDInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Cuidador getCarer(String s) {
        CuidadorJpaController cjc = new CuidadorJpaController(Persistence.createEntityManagerFactory(EMF));
        return cjc.findCuidador(s);

    }

    public static void createCarer(Cuidador c) {
        CuidadorJpaController cjc = new CuidadorJpaController(Persistence.createEntityManagerFactory(EMF));
        try {
            cjc.create(c);
        } catch (Exception ex) {
            Logger.getLogger(RESPwABDInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateCarer(Cuidador c) {
        try {
            CuidadorJpaController cjc = new CuidadorJpaController(Persistence.createEntityManagerFactory(EMF));
            cjc.edit(c);
        } catch (Exception ex) {
            Logger.getLogger(RESPwABDInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateCancion(Cancion c) {
        try {
            CancionJpaController cjc = new CancionJpaController(Persistence.createEntityManagerFactory(EMF));
            cjc.edit(c);
        } catch (Exception ex) {
            Logger.getLogger(RESPwABDInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateCuento(Cuento c) {
        try {
            CuentoJpaController cjc = new CuentoJpaController(Persistence.createEntityManagerFactory(EMF));
            cjc.edit(c);
        } catch (Exception ex) {
            Logger.getLogger(RESPwABDInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateActXPref(ActXPreferencia axp) {
        try {
            ActXPreferenciaJpaController axpc = new ActXPreferenciaJpaController(Persistence.createEntityManagerFactory(EMF));
            axpc.edit(axp);
        } catch (Exception ex) {
            Logger.getLogger(RESPwABDInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updatePrefXBaile(PreferenciaXBaile axp) {
        try {
            PreferenciaXBaileJpaController axpc = new PreferenciaXBaileJpaController(Persistence.createEntityManagerFactory(EMF));
            axpc.edit(axp);
        } catch (Exception ex) {
            Logger.getLogger(RESPwABDInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updatePrefXCuento(PreferenciaXCuento axp) {
        try {
            PreferenciaXCuentoJpaController axpc = new PreferenciaXCuentoJpaController(Persistence.createEntityManagerFactory(EMF));
            axpc.edit(axp);
        } catch (Exception ex) {
            Logger.getLogger(RESPwABDInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void updatePrefXCancion(PreferenciaXCancion pxc) {
        try {
            PreferenciaXCancionJpaController pxcc = new PreferenciaXCancionJpaController(Persistence.createEntityManagerFactory(EMF));
            pxcc.edit(pxc);
        } catch (Exception ex) {
            Logger.getLogger(RESPwABDInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    

    public static List<Cuento> getCuentos() {
        CuentoJpaController cjp = new CuentoJpaController(Persistence.createEntityManagerFactory(EMF));
        return cjp.findCuentoEntities();

    }

    public static List<Cancion> getCancion() {
        CancionJpaController cjp = new CancionJpaController(Persistence.createEntityManagerFactory(EMF));
        return cjp.findCancionEntities();

    }

    public static List<ActividadPwa> getActivities() {
        ActividadPwaJpaController ajp = new ActividadPwaJpaController(Persistence.createEntityManagerFactory(EMF));
        return ajp.findActividadPwaEntities();

    }

    public static List<Antecedente> getActecedents() {
        AntecedenteJpaController ajp = new AntecedenteJpaController(Persistence.createEntityManagerFactory(EMF));
        return ajp.findAntecedenteEntities();
    }

    public static List<Regla> getRules() {
        ReglaJpaController ajp = new ReglaJpaController(Persistence.createEntityManagerFactory(EMF));
        return ajp.findReglaEntities();
    }

    public static void createRegistroAct(RegistroActividad ra) {
        try {
            RegistroActividadJpaController rapc = new RegistroActividadJpaController(Persistence.createEntityManagerFactory(EMF));
            rapc.create(ra);
        } catch (Exception ex) {
            Logger.getLogger(RESPwABDInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    public static List<EmotionAxisConf> getEmotionalAxisConfig() {
        EmotionAxisConfJpaController eapc = new EmotionAxisConfJpaController(Persistence.createEntityManagerFactory(EMF));
        return eapc.findEmotionAxisConfEntities();
    }

   

    public static List<Emocion> getEmociones() {
        EmocionJpaController ejc = new EmocionJpaController(Persistence.createEntityManagerFactory(EMF));
        return ejc.findEmocionEntities();
    }

}
